package com.lca.ddt.delivery.report.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.util.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.lca.ddt.delivery.report.input.AccessionSpecimen;
import com.lca.ddt.delivery.report.input.Address;
import com.lca.ddt.delivery.report.input.ConcurrentCase;
import com.lca.ddt.delivery.report.input.Image;
import com.lca.ddt.delivery.report.input.IrisResultsMessage;
import com.lca.ddt.delivery.report.input.Panel;
import com.lca.ddt.delivery.report.input.PanelResult;
import com.lca.ddt.delivery.report.input.PertinentPriorTestResults;
import com.lca.ddt.delivery.report.input.PlaceOfService;
import com.lca.ddt.delivery.report.input.PriorReport;
import com.lca.ddt.delivery.report.input.ReagentsUsed;
import com.lca.ddt.delivery.report.input.Report;
import com.lca.ddt.delivery.report.input.ReportHeader;
import com.lca.ddt.delivery.report.input.ReportText;
import com.lca.ddt.delivery.report.input.SpecimenTest;
import com.lca.ddt.delivery.report.input.SpecimenTestText;
import com.lca.ddt.delivery.report.input.SpecimenText;
import com.lca.ddt.delivery.report.input.TestResultValue;
import com.lca.ddt.delivery.report.input.TestingReportingSiteDetails;
import com.lca.ddt.delivery.report.inspire.model.AccountType;
import com.lca.ddt.delivery.report.inspire.model.AddressType;
import com.lca.ddt.delivery.report.inspire.model.AdvancedStringType;
import com.lca.ddt.delivery.report.inspire.model.CommentType;
import com.lca.ddt.delivery.report.inspire.model.FixativeType;
import com.lca.ddt.delivery.report.inspire.model.ImageType;
import com.lca.ddt.delivery.report.inspire.model.Inspire;
import com.lca.ddt.delivery.report.inspire.model.Inspire.Accessions.PreviousEncounters;
import com.lca.ddt.delivery.report.inspire.model.LabType;
import com.lca.ddt.delivery.report.inspire.model.LabType.Director;
import com.lca.ddt.delivery.report.inspire.model.NameType;
import com.lca.ddt.delivery.report.inspire.model.OrderItemType;
import com.lca.ddt.delivery.report.inspire.model.OrderType;
import com.lca.ddt.delivery.report.inspire.model.PatientType;
import com.lca.ddt.delivery.report.inspire.model.PhysicianType;
import com.lca.ddt.delivery.report.inspire.model.ReportType;
import com.lca.ddt.delivery.report.inspire.model.ResultType;
import com.lca.ddt.delivery.report.inspire.model.SignedByType;
import com.lca.ddt.delivery.report.inspire.model.SpecialtyType;
import com.lca.ddt.delivery.report.inspire.model.SpecimenType;
import com.lca.ddt.delivery.report.util.DateConverter;

public class InspireRequestGenerator {

	public Inspire generateInspirePayload(IrisResultsMessage irisInputMessage) {

		Inspire.Accessions accession = new Inspire.Accessions();
		Inspire inspire = new Inspire();
		ReportType reportType = new ReportType();

		Report report = Optional.ofNullable(irisInputMessage).map(IrisResultsMessage::getReport).orElse(null);

		List<ReportText> reportTexts = Optional.ofNullable(report).map(Report::getReportTexts).orElse(null);

		Optional<ReportText> reportText = Optional.ofNullable(reportTexts).stream().flatMap(List::stream)
				.filter(d -> "DISCLIMRPHONE".equals(d.getKey())).findFirst();

		reportType.setDateTime(null);

		reportText.ifPresent(text -> reportType.setDisclaimerPhone(text.getValue()));

		reportType.setIsColor(true);

		Optional.ofNullable(irisInputMessage).map(IrisResultsMessage::getReportSpecimen)
				.filter(specimens -> specimens != null && !specimens.isEmpty())
				.flatMap(specimens -> specimens.stream().findFirst())
				.map(AccessionSpecimen::getSpecimenCollectedDateTime).ifPresent(reportType::setReceivedDate);

		reportType.setStatus(reportType.getStatus());

		Optional<String> reportTypeValueOpt = Optional.ofNullable(report).map(Report::getReportType)
				.filter(StringUtils::hasText);

		String reportTypeValue = reportTypeValueOpt.orElse("SEND");

		AdvancedStringType advancedStringType = new AdvancedStringType();
		advancedStringType.setValue(reportTypeValue);
		reportType.setType(advancedStringType);
		accession.setReport(reportType);
		reportType.setNumber("1");

		AccountType accountType = Optional.ofNullable(irisInputMessage).map(IrisResultsMessage::getReport)
				.map(Report::getReportHeader).map(this::builldAccountType).orElse(new AccountType());

		accession.setAccount(accountType);

		PhysicianType physicianType = Optional.ofNullable(irisInputMessage).map(IrisResultsMessage::getReport)
				.map(Report::getReportHeader).map(this::builldPhysicianAccountType).orElse(null);

		accountType.setPhysician(physicianType);
		accession.setResponsibleLab(buildLabType(irisInputMessage));
		accession.setPatient(buildPatient(irisInputMessage));
		accession.getAttachedImages().addAll(buildAttachedImageTypes(irisInputMessage));

		accession.getSpecialty().add(setSpeciality(irisInputMessage, new TemplateIdentifierMap()));

		accession.getPreviousEncounters().addAll(buildPreviousEncouters(irisInputMessage));

		inspire.getAccessions().add(accession);

		return inspire;

	}

	/*private List<SpecialtyType> buildSpecialty(IrisResultsMessage irisInputMessage) {
		List<SpecialtyType> specialtyTypes = new ArrayList<SpecialtyType>();

		List<String> revisionReasons = new ArrayList<>();
		for (ReportText reportTexts : irisInputMessage.getReport().getReportTexts()) {
			if ("REVISIONREASON".equals(reportTexts.getKey())
					&& ("CORRECTED".equals(reportTexts.getValue()) || "AMENDED".equals(reportTexts.getValue())
							|| "ADDENDED".equals(reportTexts.getValue()) || "REVISE".equals(reportTexts.getValue())
							|| "OPEN".equals(reportTexts.getValue()) || "WAIVED".equals(reportTexts.getValue()))) {
				revisionReasons.add(reportTexts.getValue());
			}
		}

		List<String> priorReportsRevisionReasons = new ArrayList<>();
		List<PriorReport> priorReports = irisInputMessage.getReport().getPriorReports();
		for (PriorReport priorReport : priorReports) {
			if (!"0".equals(priorReport.getVersionNum())) {
				priorReportsRevisionReasons.add(priorReport.getRevisionReason());
			}
		}

		List<String> reportTextKeys = List.of("METHDOLGYDISCLIMR", "IMAGESDISCLIMR", "INTENDEDDISCLIMR",
				"PERFORMLOCDISCLIMR", "TESTCATDISCLIMR", "FOOTERDISCLIMR", "REPORTRSTDISCLIMR", "REPORTDISCLIMR1",
				"REPORTDISCLIMR2", "REPORTDISCLIMR3", "CCVDISCLIMR", "CCVHISTDISCLIMR", "PROGNOSTICDISCLIMR",
				"CPTCODEDISCLAIMER", "COMPLAINTPHONENUM");
		List<ReportText> reportTexts = irisInputMessage.getReport().getReportTexts();
		List<String> reportTextValues = new ArrayList<>();
		for (String key : reportTextKeys) {
			for (ReportText text : reportTexts) {
				if (key.equals(text.getKey())) {
					reportTextValues.add(text.getValue());
					break;
				}
			}
		}

		List<TestingReportingSiteDetails> professionalComponents = irisInputMessage.getReport()
				.getTestingAndReportingSites().getProfessionalComponent();
		List<TestingReportingSiteDetails> technicalComponents = irisInputMessage.getReport()
				.getTestingAndReportingSites().getTechnicalComponent();
		List<OrderItemType> orderItemTypes = generateAllOrderItems(irisInputMessage, new TemplateIdentifierMap());

		// Remaining sections omitted for brevity

		// Use the extracted values as needed in further processing or output

		return specialtyTypes;

	}
*/
	private List<ImageType> buildAttachedImageTypes(IrisResultsMessage irisInputMessage) {

		return irisInputMessage.getAttachedPDF().stream().filter(Objects::nonNull) // Filter out null elements
				.map(attachedPDF -> {
					ImageType imageType = new ImageType();
					imageType.setValue(attachedPDF != null ? attachedPDF.getValue() : null);
					return imageType;
				}).collect(Collectors.toList());
	}

	private PatientType buildPatient(IrisResultsMessage irisInputMessage) {
		PatientType patient = new PatientType();
		if (irisInputMessage.getAccessionNum().length() == 11) {
			String accessionNum = irisInputMessage.getAccessionNum();
			patient.setAccessionId(accessionNum.substring(0, 3) + "-" + accessionNum.substring(3, 6) + "-"
					+ accessionNum.substring(6, 11));
		} else {
			patient.setAccessionId(irisInputMessage.getAccessionNum());
		}
		// ReqNum
		if (StringUtils.hasText(irisInputMessage.getReport().getReportHeader().getControlId())) {
			patient.setReqNum(irisInputMessage.getReport().getReportHeader().getControlId());
		}

		// MRN
		if (StringUtils.hasText(irisInputMessage.getReport().getReportHeader().getMRN())) {
			patient.setMRN(irisInputMessage.getReport().getReportHeader().getMRN());
		}

		// SSN
		if (StringUtils.hasText(irisInputMessage.getReport().getReportHeader().getPSSN())) {
			String pssn = irisInputMessage.getReport().getReportHeader().getPSSN();
			patient.setSSN("***-**-" + pssn.substring(6, 10));
		}

		// CollectDateTime
		if (irisInputMessage.getReport().getReportHeader().getServiceTmstp() != null) {
			// patient.setCollectDateTime(irisInputMessage.getReport().getReportHeader().getServiceTmstp());
		}

		// OrderDateTime
		if (irisInputMessage.getReport().getReportHeader().getAccessionTmstp() != null) {
			patient.setOrderDateTime(irisInputMessage.getReport().getReportHeader().getAccessionTmstp());
		}

		// Name
		NameType name = new NameType();
		if (StringUtils.hasText(irisInputMessage.getReport().getReportHeader().getPFirstName())) {
			name.setFirst(irisInputMessage.getReport().getReportHeader().getPFirstName());
		}
		if (StringUtils.hasText((irisInputMessage.getReport().getReportHeader().getPMiddleName()))) {
			name.setMiddle(irisInputMessage.getReport().getReportHeader().getPMiddleName());
		}
		name.setLast(getAdvanceStringType(irisInputMessage.getReport().getReportHeader().getPLastName()));
		patient.setName(name);

		// Address
		AddressType address = new AddressType();
		if (StringUtils.hasText(irisInputMessage.getReport().getReportHeader().getPAddr().getAdress1())) {
			address.setStreet(irisInputMessage.getReport().getReportHeader().getPAddr().getAdress1());
		}
		if (StringUtils.hasText(irisInputMessage.getReport().getReportHeader().getPAddr().getAddress2())) {
			address.setStreet2(irisInputMessage.getReport().getReportHeader().getPAddr().getAddress2());
		}
		address.setCity(irisInputMessage.getReport().getReportHeader().getPAddr().getCity());
		address.setState(irisInputMessage.getReport().getReportHeader().getPAddr().getStateCd());
		if (StringUtils.hasText(irisInputMessage.getReport().getReportHeader().getPAddr().getZip())) {
			String zip = irisInputMessage.getReport().getReportHeader().getPAddr().getZip();
			if (zip.length() == 5) {
				address.setZip(zip);
			} else if (zip.length() == 9) {
				address.setZip(zip.substring(0, 5) + "-" + zip.substring(0, 10));
			} else {
				address.setZip(zip);
			}
		}
		patient.setAddress(address);

		// Phone
		if (StringUtils.hasText((irisInputMessage.getReport().getReportHeader().getPPhone()))) {
			String phone = irisInputMessage.getReport().getReportHeader().getPPhone();
			if (phone.length() == 10) {
				patient.setPhone(
						("(" + phone.substring(0, 3) + ")" + phone.substring(3, 7) + "-" + phone.substring(6, 10)));
			} else if (phone.length() == 7) {
				patient.setPhone(("(" + phone.substring(0, 3) + ")" + phone.substring(3, 7)));
			} else {
				patient.setPhone(phone);
			}
		}

		// ClinicalHistory
		List<CommentType> commentTypes = new ArrayList<CommentType>();
		for (ReportText reportTexts : irisInputMessage.getReport().getReportTexts()) {
			if ("CLINICALHISTORY".equals(reportTexts.getKey())) {
				CommentType commentType = new CommentType();
				commentType.setName(reportTexts.getValue());
				commentTypes.add(commentType);
			}
		}

		// Gender
		if (StringUtils.hasText(irisInputMessage.getReport().getReportHeader().getPGender())) {
			patient.setGender(irisInputMessage.getReport().getReportHeader().getPGender());
		} else {
			patient.setGender("--");
		}

		// DateOfBirth
		if (irisInputMessage.getReport().getReportHeader().getPDob() != null) {
			patient.setDateOfBirth(irisInputMessage.getReport().getReportHeader().getPDob());
		}

		// Age
		PatientType.Age age = new PatientType.Age();
		age.setYears(String.valueOf(irisInputMessage.getReport().getReportHeader().getPAge().getYear()));
		if (irisInputMessage.getReport().getReportHeader().getPAge().getMonth() != null) {
			age.setMonths(String.valueOf(irisInputMessage.getReport().getReportHeader().getPAge().getMonth()));
		}
		if (irisInputMessage.getReport().getReportHeader().getPAge().getDay() != null) {
			age.setDays(String.valueOf(irisInputMessage.getReport().getReportHeader().getPAge().getDay()));
		}
		patient.setAge(age);

		// Printing XML
		return patient;
	}

	public LabType buildLabType(IrisResultsMessage irisInputMessage) {
		LabType responsibleLab = new LabType();
		Report report = irisInputMessage.getReport();
		if (report != null) {
			if (report.getMdAddr() != null && StringUtils.hasText(report.getMdAddr().getLabCode())) {
				responsibleLab.setCode(report.getMdAddr().getLabCode());
			}
			// Determine the address
			AddressType address = new AddressType();
			Address orderFacAddr = irisInputMessage.getReport().getReportHeader().getAccountAddr();
			Address mdAddr = irisInputMessage.getReport().getMdAddr();

			if (orderFacAddr != null && StringUtils.hasText(orderFacAddr.getAdress1())) {
				address.setStreet(orderFacAddr.getAdress1());
				if (StringUtils.hasText(orderFacAddr.getAddress2())) {
					address.setStreet2(orderFacAddr.getAddress2());
				}

				if (StringUtils.hasText(orderFacAddr.getCity())) {
					address.setCity(orderFacAddr.getCity());
				}

				if (StringUtils.hasText(orderFacAddr.getStateCd())) {
					address.setState(orderFacAddr.getStateCd());
				}
				String zip = orderFacAddr.getZip();
				if (StringUtils.hasText(zip)) {
					if (zip.length() == 5) {
						address.setZip(zip);
					} else if (zip.length() == 9) {
						address.setZip(zip.substring(0, 5) + "-" + zip.substring(5));
					} else {
						address.setZip(zip);
					}
				}
			} else {
				if (mdAddr.getAdress1() != null && StringUtils.hasText(mdAddr.getAdress1())) {
					address.setStreet(mdAddr.getAdress1());

					if (StringUtils.hasText(mdAddr.getAddress2())) {
						address.setStreet2(mdAddr.getAddress2());
					}

					if (StringUtils.hasText(mdAddr.getCity())) {
						address.setCity(mdAddr.getCity());
					}

					if (StringUtils.hasText(mdAddr.getStateCd())) {
						address.setState(mdAddr.getStateCd());
					}

					String zip = mdAddr.getZip();
					if (StringUtils.hasText(zip)) {
						if (zip.length() == 5) {
							address.setZip(zip);
						} else if (zip.length() == 9) {
							address.setZip(zip.substring(0, 5) + "-" + zip.substring(5));
						} else {
							address.setZip(zip);
						}
					}
				}
			}

			responsibleLab.setAddress(address);

			// Set the CLIA Id
			String cliaId = irisInputMessage.getReport().getMdCliaNum();
			if (StringUtils.hasText(cliaId)) {
				responsibleLab.setCLIAId(cliaId);
			}

			// Set the name
			String signedLocation = irisInputMessage.getReport().getSignedLocation();
			responsibleLab.setName(signedLocation);

			// Set the director information
			String medicalDirLName = irisInputMessage.getReport().getMedicalDirLName();
			String medicalDirDegree = irisInputMessage.getReport().getMedicalDirDegree();
			String medicalDirFName = irisInputMessage.getReport().getMedicalDirFName();

			if ((medicalDirLName != null && !medicalDirLName.isEmpty())
					|| (medicalDirDegree != null && !medicalDirDegree.isEmpty())
					|| (medicalDirFName != null && !medicalDirFName.isEmpty())) {

				Director director = new Director();
				director.setDegree(medicalDirDegree);

				NameType nameType = new NameType();
				nameType.setFirst(medicalDirFName);
				AdvancedStringType advancedStringType = new AdvancedStringType();
				advancedStringType.setValue(medicalDirLName);
				nameType.setLast(advancedStringType);
				director.setName(nameType);

				responsibleLab.setDirector(director);
			}
		}
		return responsibleLab;
	}

	public PhysicianType builldPhysicianAccountType(ReportHeader reportHeader) {
		PhysicianType physicianType = new PhysicianType();
		if (reportHeader.getReferPhyName() != null) {
			NameType nameType = new NameType();
			AdvancedStringType advancedStringType = new AdvancedStringType();
			advancedStringType.setValue(reportHeader.getReferPhyName());
			nameType.setLast(advancedStringType);
			physicianType.setNPI(reportHeader.getReferPhyNPI());
			physicianType.setName(nameType);
		}
		return physicianType;
	}

	public AccountType builldAccountType(ReportHeader reportHeader) {
		AccountType account = new AccountType();
		if (reportHeader.getAccountName() != null) {
			reportHeader.setAccountNum(reportHeader.getAccountNum());
		}
		// Setting address
		if (reportHeader.getAccountAddr() != null) {
			AddressType address = new AddressType();
			Address accountAddr = reportHeader.getAccountAddr();
			address.setStreet(accountAddr.getAdress1());
			address.setStreet2(accountAddr.getAddress2());
			address.setCity(accountAddr.getCity());
			address.setState(accountAddr.getStateCd());
			if (address.getZip() != null) {
				String formattedZip = address.getZip();
				if (formattedZip.length() == 9) {
					formattedZip = formattedZip.substring(0, 5) + "-" + formattedZip.substring(5);
				}
				address.setZip(formattedZip);
			}
			account.setAddress(address);
		}
		if (StringUtils.hasText(reportHeader.getAccountFax())) {
			account.setFax(reportHeader.getAccountFax());
		}
		if (StringUtils.hasText(reportHeader.getAccountName())) {
			account.setName1(reportHeader.getAccountName());
		}

		if (StringUtils.hasText((reportHeader.getAccountPhone()))) {
			account.setPhone(reportHeader.getAccountPhone());
		}

		// Setting physician
		PhysicianType physician = new PhysicianType();
		if (List.of(reportHeader.getOrderingPhyFName(), reportHeader.getOrderingPhyMName(),
				reportHeader.getOrderingPhyLName()).stream().anyMatch(str -> str != null && !str.isEmpty())) {
			NameType phyName = new NameType();
			phyName.setFirst(reportHeader.getOrderingPhyFName());
			phyName.setMiddle(reportHeader.getPMiddleName());
			phyName.setFirst(reportHeader.getOrderingPhyFName());

			if (reportHeader.getOrderingPhyLName() != null) {
				AdvancedStringType advancedStringType = new AdvancedStringType();
				advancedStringType.setValue(reportHeader.getOrderingPhyLName());
				phyName.setLast(advancedStringType);
			}
			physician.setName(phyName);
		}

		if (StringUtils.hasText(reportHeader.getPhysicianId())) {
			physician.setID(reportHeader.getPhysicianId());
		}
		if (StringUtils.hasText(reportHeader.getNpi())) {

			physician.setNPI(reportHeader.getNpi());
		}

		account.setPhysician(physician);

		return account;
	}

	public static void main(String[] args) throws JsonProcessingException {

		InspireRequestGenerator inspireRequestGenerator = new InspireRequestGenerator();

	}

	public AdvancedStringType getAdvanceStringType(String text) {
		AdvancedStringType advancedStringType = new AdvancedStringType();
		advancedStringType.setValue(text);
		return advancedStringType;
	}

	private String getCirculatingTumorCellAssayName(String value) {
		switch (value) {
		case "PROSTATE":
			return "Circulating Tumor Cell Assay: Prostate Carcinoma";
		case "BREAST":
			return "Circulating Tumor Cell Assay: Breast Carcinoma";
		case "COLORECTAL":
			return "Circulating Tumor Cell Assay: Colorectal Carcinoma";
		case "DUAL":
			return "Circulating Tumor Cell Assay";
		default:
			return "Circulating Tumor Cell Assay";
		}
	}

	public SpecialtyType setSpeciality(IrisResultsMessage requestMessage, TemplateIdentifierMap templateIdentifierMap) {
		SpecialtyType specialty = new SpecialtyType();

		String templateId = requestMessage.getReport().getTemplateId();
		String labInfoSystemCd = requestMessage.getReport().getLabInfoSystemCd();
		String reportTitle = requestMessage.getReport().getReportTitle();
		String reportNum = requestMessage.getReportNum();
		String MRN = requestMessage.getReport().getReportHeader().getMRN();

		specialty.setTemplateId(templateId);
		specialty.setBrand(labInfoSystemCd.isEmpty() ? "Integrated Oncology" : labInfoSystemCd);

		// Set title based on complex conditions
		if (!reportTitle.isEmpty()) {
			specialty.setTitle(reportTitle);
		} else if ("CirculatingTumor".equals(templateId)) {
			setTitleForCirculatingTumor(specialty, requestMessage.getReport().getReportTexts());
		} else {
			String titleFromMap = templateIdentifierMap.getTitleByTemplateId(templateId.trim());
			specialty.setTitle(titleFromMap);
		}

		if (!reportNum.isEmpty()) {
			specialty.setSpecialtyReportNumber(reportNum);
		}

		if (!MRN.isEmpty()) {
			specialty.setClientLabID(MRN);
		}

		// Add revisions
		addRevisions(specialty, requestMessage.getReport().getReportTexts());

		// Add signedBy
		addSignedBy(specialty, requestMessage);

		// Add disclaimers
		addDisclaimers(specialty, requestMessage.getReport().getReportTexts());

		// Add attached images
		addAttachedImages(specialty, requestMessage.getReport().getReportImages());

		// Add comments
		addComments(specialty, requestMessage.getReport().getReportTexts(), requestMessage);

		specialty.getOrderItems().addAll(generateAllOrderItems(requestMessage, templateIdentifierMap));

		specialty.getOrders().addAll(buildDisclaimerOrder(requestMessage));

		specialty.getOrders().addAll(buildOrderWithCancelPanel(requestMessage));

		specialty.getOrders().addAll(buildReportSpecimenOrder(requestMessage));

		specialty.getOrders().addAll(buildConcurentCaseOrder(requestMessage, new TemplateIdentifierMap()));

		if (specialty.getOrders().isEmpty()) {
			specialty.getOrders().add(buildOrderWithPanel(requestMessage));
		}

		specialty.getLabs().add(bildLAbType(requestMessage));

		return specialty;
	}

	private static void setTitleForCirculatingTumor(SpecialtyType specialty, List<ReportText> reportTexts) {
		for (ReportText reportText : reportTexts) {
			if (reportText.getKey().equals("CTCRPTTITLE")) {
				switch (reportText.getValue()) {
				case "PROSTATE":
					specialty.setTitle("Circulating Tumor Cell Assay: Prostate Carcinoma");
					break;
				case "BREAST":
					specialty.setTitle("Circulating Tumor Cell Assay: Breast Carcinoma");
					break;
				case "COLORECTAL":
					specialty.setTitle("Circulating Tumor Cell Assay: Colorectal Carcinoma");
					break;
				case "DUAL":
					specialty.setTitle("Circulating Tumor Cell Assay");
					break;
				default:
					specialty.setTitle("Circulating Tumor Cell Assay");
					break;
				}
				return;
			}
		}
	}

	private void addRevisions(SpecialtyType specialty, List<ReportText> reportTexts) {
		for (ReportText reportText : reportTexts) {
			if (reportText.getKey().equals("REVISIONREASON")
					&& List.of("CORRECTED", "AMENDED", "ADDENDED", "REVISE", "OPEN", "WAIVED")
							.contains(reportText.getValue())) {
				CommentType revision = new CommentType();
				revision.setName(reportText.getValue());
				revision.setText(getAdvanceStringType(reportText.getValue())); //
				// revision.setSequence(reportText.()); // this need to check
				specialty.getComments().add(revision);
			}
		}
	}

	private void addSignedBy(SpecialtyType specialty, IrisResultsMessage requestMessage) {
		for (PriorReport priorReport : requestMessage.getReport().getPriorReports()) {
			String[] signedData = priorReport.getSignedByLine().split("~");
			SignedByType signedBy = new SignedByType();
			NameType nameType = new NameType();
			if (signedData.length > 0) {
				nameType.setFirst(signedData[0]);
			}
			if (signedData.length > 1) {
				nameType.setMiddle(signedData[1]);
			}
			if (signedData.length > 2) {
				nameType.setLast(getAdvanceStringType(signedData[2]));
			}
			if (signedData.length > 3) {
				nameType.setSuffix(signedData[3]);
			}
			if (signedData.length > 4) {
				nameType.setTitle(signedData[5]);
			}

			signedBy.setRevision(priorReport.getRevisionReason());
			signedBy.setRevisionSequence(String.valueOf(priorReport.getVersionNum()));
			signedBy.setDateTime(DateConverter.getStringDate());
			signedBy.setESignatureComment(priorReport.getESignatureComment());
			specialty.getSignedBy().add(signedBy);
		}

	}

	private void addDisclaimers(SpecialtyType specialty, List<ReportText> reportTexts) {
		List<String> disclaimerKeys = List.of("METHDOLGYDISCLIMR", "IMAGESDISCLIMR", "INTENDEDDISCLIMR",
				"PERFORMLOCDISCLIMR", "TESTCATDISCLIMR", "FOOTERDISCLIMR", "REPORTRSTDISCLIMR", "REPORTDISCLIMR1",
				"REPORTDISCLIMR2", "REPORTDISCLIMR3", "CCVDISCLIMR", "CCVHISTDISCLIMR", "PROGNOSTICDISCLIMR",
				"CPTCODEDISCLAIMER", "COMPLAINTPHONENUM");

		for (ReportText reportText : reportTexts) {
			if (disclaimerKeys.contains(reportText.getKey())) {
				CommentType disclaimer = new CommentType();
				disclaimer.setName(reportText.getKey().name());
				disclaimer.setText(getAdvanceStringType(reportText.getValue()));
				specialty.getDisclaimers().add(disclaimer);
			}
		}
	}

	private void addAttachedImages(SpecialtyType specialty, List<Image> reportImages) {
		for (Image reportImage : reportImages) {
			if (reportImage.getImageValue() != null) {
				ImageType attachedImage = new ImageType();
				attachedImage.setCaption(reportImage.getImageCaption());
				attachedImage.setValue(new String(reportImage.getImageValue()));
				attachedImage.setImageComment(reportImage.getImageComment());
				specialty.getAttachedImages().add(attachedImage);
			}
		}
	}

	private void addComments(SpecialtyType specialty, List<ReportText> reportTexts, IrisResultsMessage requestMessage) {

		for (ReportText reportText : reportTexts) {
			CommentType comment = new CommentType();
			if ("GROSSDESCRIPTION".equals(reportText.getKey().name())) {
				comment.setName("GROSSDISC");
			} else {
				comment.setName(reportText.getKey().name());
			}
			comment.setText(getAdvanceStringType(reportText.getValue()));
			specialty.getComments().add(comment);
		}

		for (TestingReportingSiteDetails testingReportingSiteDetails : requestMessage.getReport()
				.getTestingAndReportingSites().getProfessionalComponent()) {
			CommentType comment = new CommentType();
			comment.setName("professionalComponent");
			comment.setText(getAdvanceStringType(buildProfessionalComponent(testingReportingSiteDetails)));
			specialty.getComments().add(comment);
		}

	}

	private String buildProfessionalComponent(TestingReportingSiteDetails testingReportingSiteDetails) {

		Address mdAddr = testingReportingSiteDetails.getMdAddr();
		String space = " ";

		String address1 = mdAddr.getAdress1().isEmpty() ? "" : mdAddr.getAdress1();
		String address2 = mdAddr.getAddress2().isEmpty() ? "" : space + mdAddr.getAddress2();
		String city = mdAddr.getCity().isEmpty() ? "" : mdAddr.getCity() + ",";
		String stateCd = mdAddr.getStateCd().isEmpty() ? "" : mdAddr.getStateCd();
		String zip = mdAddr.getZip().isEmpty() ? "" : mdAddr.getZip();
		String medicalDirFName = testingReportingSiteDetails.getMedicalDirFName().isEmpty() ? ""
				: testingReportingSiteDetails.getMedicalDirFName() + space;
		String medicalDirMName = testingReportingSiteDetails.getMedicalDirMName().isEmpty() ? ""
				: (testingReportingSiteDetails.getMedicalDirMName().length() == 1
						? testingReportingSiteDetails.getMedicalDirMName() + "." + space
						: testingReportingSiteDetails.getMedicalDirMName() + space);
		String medicalDirLName = testingReportingSiteDetails.getMedicalDirLName().isEmpty() ? ""
				: testingReportingSiteDetails.getMedicalDirLName().trim() + space;
		String medicalDirDegree = testingReportingSiteDetails.getMedicalDirDegree().isEmpty() ? ""
				: testingReportingSiteDetails.getMedicalDirDegree().trim();
		String mdCliaNum = testingReportingSiteDetails.getMdCliaNum().isEmpty() ? ""
				: testingReportingSiteDetails.getMdCliaNum();

		return address1 + address2 + "," + space + city + space + stateCd + space + zip + space + space + "CLIA#"
				+ space + mdCliaNum + space + space + medicalDirFName + medicalDirMName + medicalDirLName
				+ medicalDirDegree;

	}

	private static List<OrderItemType> generateAllOrderItems(IrisResultsMessage irisInputMessage,
			TemplateIdentifierMap templateIdentifierMap) {
		List<OrderItemType> orderItemTypes = new ArrayList<>();
		if (StringUtils.hasText(irisInputMessage.getPanel().getPanelName())) {
			OrderItemType orderItemType = new OrderItemType();
			orderItemType.setName(irisInputMessage.getPanel().getPanelName());
			orderItemTypes.add(orderItemType);
		}
		for (AccessionSpecimen accessionSpecimen : irisInputMessage.getReportSpecimen()) {
			for (SpecimenTest specimenTest : accessionSpecimen.getSpecimenTests()) {
				if (StringUtils.hasText(specimenTest.getTestName())) {
					OrderItemType orderItemType = new OrderItemType();
					if (StringUtils.hasText(specimenTest.getCloneName())) {
						orderItemType.setName(specimenTest.getTestName() + " (" + specimenTest.getCloneName() + ")");
					} else {
						orderItemType.setName(specimenTest.getTestName());
					}
					orderItemTypes.add(orderItemType);
				}
			}

			Identifier identifier = new Identifier();
			identifier.setTitle("Title");
			identifier.setTemplateId("TemplateId");

			List<Identifier> identifiers = new ArrayList<>();
			identifiers.add(identifier);
			templateIdentifierMap.setIdentifiers(identifiers);

			// Iterate over cancelledPanel and create OrderItems
			for (Panel cancelledPanel : irisInputMessage.getCancelledPanel()) {
				for (Identifier identifi : templateIdentifierMap.getIdentifiers()) {
					if (cancelledPanel.getTemplateId() != null && !cancelledPanel.getTemplateId().isEmpty()
							&& identifier.getTemplateId() != null
							&& identifier.getTemplateId().equals(cancelledPanel.getTemplateId().trim())) {
						OrderItemType orderItems = new OrderItemType();
						orderItems.setName(identifier.getTitle());
						orderItemTypes.add(orderItems);
					}
				}
			}

		}
		return orderItemTypes;
	}

	public List<OrderType> buildDisclaimerOrder(IrisResultsMessage requestMessage) {
		List<OrderType> ordersList = new ArrayList<>();

		for (PanelResult panelResults : requestMessage.getPanel().getPanelResults()) {
			if (!panelResults.getParamName().equals("Disclaimers")) {
				OrderType order = new OrderType();

				if (!panelResults.getDisplayName().isEmpty()) {
					order.setNumber(panelResults.getDisplayName());
				}
				order.setName(panelResults.getParamName());
				if (!requestMessage.getPanel().getCaseNum().isEmpty()) {
					order.setCaseId(requestMessage.getPanel().getCaseNum());
				}

				// Set values for other fields

				// Processing $signedBy
				String signedByLine = requestMessage.getReport().getSignedByLine();
				String[] signed = signedByLine.split("~");
				SignedByType signedBy = new SignedByType();
				signedBy.setDegree(signed[4]);
				NameType name = new NameType();
				if (!signed[0].isEmpty()) {
					name.setFirst(signed[0]);
				}
				if (!signed[1].isEmpty()) {
					name.setMiddle(signed[1]);
				}
				name.setLast(getAdvanceStringType(signed[2]));
				if (!signed[3].isEmpty()) {
					name.setSuffix(signed[3]);
				}
				if (!signed[5].isEmpty()) {
					name.setTitle(signed[5]);
				}
				signedBy.setName(name);

				signedBy.setRevisionSequence(String.valueOf(requestMessage.getReport().getVersionNum()));
				signedBy.setDateTime(
						DateConverter.getStringDateTime(requestMessage.getReport().getSignedDateTime(), "YYY-MM-DD"));
				signedBy.setESignatureComment(requestMessage.getReport().getESignatureComment());

				order.getSignedBy().add(signedBy);
				// Processing status
				if (panelResults.isWasSubmitted()) {
					order.setStatus("WAS SUBMITTED");
				} else {
					order.setStatus("WAS NOT SUBMITTED");
				}

				// Processing Disclaimers
				List<CommentType> disclaimersList = new ArrayList<>();
				for (PanelResult panelResults1 : requestMessage.getPanel().getPanelResults()) {
					if (panelResults1.getParamName().equals("Disclaimers")) {
						for (TestResultValue testResultValues : panelResults1.getTestResultValues()) {
							CommentType disclaimer = new CommentType();
							disclaimer.setName(testResultValues.getKey());
							disclaimer.setText(getAdvanceStringType(testResultValues.getValue()));
							disclaimersList.add(disclaimer);
						}
						break; // Assuming only the first occurrence of Disclaimers is processed
					}
				}
				order.getDisclaimers().addAll(disclaimersList);

				// Processing Reagents Used
				List<CommentType> reagentsUsedList = new ArrayList<>();
				for (ReagentsUsed reagentsUsed : requestMessage.getPanel().getReagentsUsed()) {
					if (reagentsUsed.isIsBill() && !reagentsUsed.getTestName().isEmpty()) {
						CommentType reagent = new CommentType();
						reagent.setName("Reagents Used");
						reagent.setText(getAdvanceStringType(reagentsUsed.getTestName()));
						reagentsUsedList.add(reagent);
						break; // Assuming only the first occurrence is processed
					}
				}
				order.getComments().addAll(reagentsUsedList);

				// Processing Results
				List<ResultType> resultsList = new ArrayList<>();
				if (panelResults.getTestResultValues() != null) {
					for (TestResultValue testResultValues : panelResults.getTestResultValues()) {
						if (!testResultValues.getKey().equals("DISCLIMRLGND") && !testResultValues.getKey().isEmpty()) {
							ResultType result = new ResultType();
							if (!requestMessage.getPanel().getLabCorpTestCode().isEmpty()) {
								result.setNumber(requestMessage.getPanel().getLabCorpTestCode());
							}
							result.setName(testResultValues.getKey());
							// Set other fields of ResultType
							resultsList.add(result);
						} else if (testResultValues.getKey().equals("DISCLIMRLGND")) {
							CommentType comment = new CommentType();
							comment.setName(testResultValues.getKey());
							comment.setText(getAdvanceStringType(testResultValues.getValue()));
							order.getComments().add(comment);
						}
					}
				}
				List<SpecimenType> specimensList = new ArrayList<>();
				// Processing other spcimen
				for (AccessionSpecimen reportSpecimen : requestMessage.getReportSpecimen()) {

					SpecimenType specimen = new SpecimenType();
					if (!requestMessage.getReportSpecimen().isEmpty()) {
						specimen.setName(reportSpecimen.getSpecimenType());
					}
					if (!reportSpecimen.getSpecimenId().isEmpty()) {
						specimen.setNumber(reportSpecimen.getSpecimenId());
					}
					if (!reportSpecimen.getSpecimenDescr().isEmpty()) {
						specimen.setDesc(getAdvanceStringType(reportSpecimen.getSpecimenDescr()));
					}
					if (!reportSpecimen.getSpecimenSiteCd().isEmpty()) {
						specimen.setBodySiteCode(reportSpecimen.getSpecimenSiteCd());
					}
					if (!reportSpecimen.getSpecimenSiteDescr().isEmpty()) {
						specimen.setBodySiteDesc(reportSpecimen.getSpecimenSiteDescr());
					}
					if (!reportSpecimen.getClientSpecimenID().isEmpty()) {
						specimen.setClientSpecimenID(reportSpecimen.getClientSpecimenID());
					}
					if (!reportSpecimen.getSpecimenTransportDescr().isEmpty()) {
						specimen.setTransportDesc(reportSpecimen.getSpecimenTransportDescr());
					}

					// Processing fixative
					FixativeType fixative = new FixativeType();
					if (!reportSpecimen.getTypeOfFixative().isEmpty()) {
						fixative.setFixativeType(reportSpecimen.getTypeOfFixative());
					}
					if (reportSpecimen.getTimeToFixationKey().equalsIgnoreCase("General")
							|| reportSpecimen.getTimeToFixationKey().equalsIgnoreCase("SPECIFIC")) {
						String timeToFixation = "";
						if (reportSpecimen.getTimeToFixationHH() != null
								&& !reportSpecimen.getTimeToFixationHH().equals("0")) {
							timeToFixation += reportSpecimen.getTimeToFixationHH() + " Hr. ";
						}
						if (reportSpecimen.getTimeToFixationMM() != null
								&& !reportSpecimen.getTimeToFixationMM().equals("0")) {
							timeToFixation += reportSpecimen.getTimeToFixationMM() + " Min.";
						}
						if (!timeToFixation.isEmpty()) {
							fixative.setTimeToFixation(timeToFixation);
						} else {
							fixative.setTimeToFixation("Not Provided");
						}
					}
					if (reportSpecimen.getDurationOfFixativeKey().equalsIgnoreCase("General")
							|| reportSpecimen.getDurationOfFixativeKey().equalsIgnoreCase("SPECIFIC")) {
						String fixativeDuration = "";
						if (reportSpecimen.getFixativeDurationHH() != null
								&& !reportSpecimen.getFixativeDurationHH().equals("0")) {
							fixativeDuration += reportSpecimen.getFixativeDurationHH() + " Hr. ";
						}
						if (reportSpecimen.getFixativeDurationMM() != null
								&& !reportSpecimen.getFixativeDurationMM().equals("0")) {
							fixativeDuration += reportSpecimen.getFixativeDurationMM() + " Min.";
						}
						if (!fixativeDuration.isEmpty()) {
							fixative.setFixativeDuration(fixativeDuration);
						} else {
							fixative.setFixativeDuration("Not Provided");
						}
					}
					// Processing fixativeDisclaimer
					for (SpecimenText specimenText : reportSpecimen.getSpecimenText()) {
						if (specimenText.getKey().equals("FIXATIVEDISCLAIMER")) {
							fixative.setFixativeDisclaimer(specimenText.getValue());
							break; // Assuming only one disclaimer is processed
						}
					}
					specimen.setFixative(fixative);
					if (!fixative.getFixativeType().isEmpty() || !fixative.getTimeToFixation().isEmpty()
							|| !fixative.getFixativeDuration().isEmpty() || fixative.getFixativeDisclaimer() != null) {
						specimensList.add(specimen);
					}

					specimen.setLabCorpSpecimenID(reportSpecimen.getLabCorpSpecimenId());
					order.getSpecimens().add(specimen);

					ordersList.add(order);
				}
			}

		}
		return ordersList;
	}

	public List<OrderType> buildOrderWithCancelPanel(IrisResultsMessage requestMessage) {
		List<OrderType> ordersList = new ArrayList<>();

		Map<String, Identifier> templateIdentifierMap = new HashMap<String, Identifier>();

		for (Panel cancelledPanel : requestMessage.getCancelledPanel()) {
			OrderType orders = new OrderType();

			// Processing labCorpTestCode
			if (!cancelledPanel.getLabCorpTestCode().isEmpty()) {
				orders.setNumber(cancelledPanel.getLabCorpTestCode());
			}

			// Processing templateId
			if ("CirculatingTumor".equalsIgnoreCase(cancelledPanel.getTemplateId().trim())) {
				if (requestMessage.getReport().getReportTexts() != null) {
					for (ReportText reportText : requestMessage.getReport().getReportTexts()) {
						if ("CTCRPTTITLE".equals(reportText.getKey())) {
							String name = getCirculatingTumorCellAssayName(reportText.getValue());
							orders.setName(name);
						}
					}
				} else {
					orders.setName("Circulating Tumor Cell Assay");
				}
			} else {
				// Map templateId to its corresponding title
				Identifier identifier = templateIdentifierMap.get(cancelledPanel.getTemplateId().trim());
				if (identifier != null) {
					orders.setName(identifier.getTitle());
				}
			}

			// Processing caseNum
			if (!cancelledPanel.getCaseNum().isEmpty()) {
				orders.setCaseId(cancelledPanel.getCaseNum());
			}

			// Set status to IsReportCancelled
			orders.setStatus("IsReportCancelled");

			// Processing cancel reason
			if (requestMessage.getReport().getReportTexts() != null) {
				for (ReportText reportText : requestMessage.getReport().getReportTexts()) {
					if ("CANCELREASON".equals(reportText.getKey())) {
						CommentType commentType = new CommentType();
						commentType.setName("CancelledReason");
						commentType.setText(getAdvanceStringType(reportText.getValue()));
						orders.getComments().add(commentType);
					}
				}
			}

			// Processing results

			// Processing reportSpecimen
			List<SpecimenType> specimensList = new ArrayList<>();
			for (AccessionSpecimen reportSpecimen : cancelledPanel.getReportSpecimen()) {
				SpecimenType specimens = new SpecimenType();
				if (!reportSpecimen.getSpecimenType().isEmpty()) {
					specimens.setName(reportSpecimen.getSpecimenType());
				}
				if (!reportSpecimen.getSpecimenId().isEmpty()) {
					specimens.setNumber(reportSpecimen.getSpecimenId());
				}
				if (!reportSpecimen.getSpecimenDescr().isEmpty()) {
					specimens.setDesc(getAdvanceStringType(reportSpecimen.getSpecimenDescr()));
				}
				if (!reportSpecimen.getSpecimenSiteCd().isEmpty()) {
					specimens.setBodySiteCode(reportSpecimen.getSpecimenSiteCd());
				}
				if (!reportSpecimen.getSpecimenSiteDescr().isEmpty()) {
					specimens.setBodySiteDesc(reportSpecimen.getSpecimenSiteDescr());
				}
				if (!reportSpecimen.getClientSpecimenID().isEmpty()) {
					specimens.setClientSpecimenID(reportSpecimen.getClientSpecimenID());
				}
				if (!reportSpecimen.getSpecimenTransportDescr().isEmpty()) {
					specimens.setTransportDesc(reportSpecimen.getSpecimenTransportDescr());
				}

				// Processing fixative information
				FixativeType fixative = new FixativeType();
				if (!reportSpecimen.getTypeOfFixative().isEmpty()) {
					fixative.setFixativeType(reportSpecimen.getTypeOfFixative());
				}
				if ("General".equalsIgnoreCase(reportSpecimen.getTimeToFixationKey())
						|| "SPECIFIC".equalsIgnoreCase(reportSpecimen.getTimeToFixationKey())) {
					String timeToFixation = "";
					if (reportSpecimen.getTimeToFixationHH() != null
							&& !reportSpecimen.getTimeToFixationHH().equals("0")) {
						timeToFixation += reportSpecimen.getTimeToFixationHH() + " Hr. ";
					}
					if (reportSpecimen.getTimeToFixationMM() != null
							&& !reportSpecimen.getTimeToFixationMM().equals("0")) {
						timeToFixation += reportSpecimen.getTimeToFixationMM() + " Min.";
					}
					if (!timeToFixation.isEmpty()) {
						fixative.setTimeToFixation(timeToFixation);
					} else {
						fixative.setTimeToFixation("Not Provided");
					}
				}
				if ("General".equalsIgnoreCase(reportSpecimen.getDurationOfFixativeKey())
						|| "SPECIFIC".equalsIgnoreCase(reportSpecimen.getDurationOfFixativeKey())) {
					String fixativeDuration = "";
					if (reportSpecimen.getFixativeDurationHH() != null
							&& !reportSpecimen.getFixativeDurationHH().equals("0")) {
						fixativeDuration += reportSpecimen.getFixativeDurationHH() + " Hr. ";
					}
					if (reportSpecimen.getFixativeDurationMM() != null
							&& !reportSpecimen.getFixativeDurationMM().equals("0")) {
						fixativeDuration += reportSpecimen.getFixativeDurationMM() + " Min.";
					}
					if (!fixativeDuration.isEmpty()) {
						fixative.setFixativeDuration(fixativeDuration);
					} else {
						fixative.setFixativeDuration("Not Provided");
					}
				}

				// Processing fixativeDisclaimer
				String fixativeDisclaimer = "";
				for (SpecimenText specimenText : reportSpecimen.getSpecimenText()) {
					if ("FIXATIVEDISCLAIMER".equals(specimenText.getKey())) {
						fixativeDisclaimer = specimenText.getValue();
						break;
					}
				}
				fixative.setFixativeDisclaimer(fixativeDisclaimer);
				specimens.setFixative(fixative);

				if (!specimens.getName().isEmpty() || !specimens.getNumber().isEmpty() || specimens.getDesc() != null
						|| !specimens.getBodySiteCode().isEmpty() || !specimens.getBodySiteDesc().isEmpty()
						|| !specimens.getClientSpecimenID().isEmpty() || !specimens.getTransportDesc().isEmpty()
						|| fixative != null) {
					specimensList.add(specimens);
				}
			}

			orders.getSpecimens().addAll(specimensList);

			ordersList.add(orders);
		}

		return ordersList;
	}

	public List<OrderType> buildReportSpecimenOrder(IrisResultsMessage requestMessage) {
		List<OrderType> ordersList = new ArrayList<>();

		for (AccessionSpecimen reportSpecimen : requestMessage.getReportSpecimen()) {
			OrderType orders = new OrderType();

			// Setting name from specimen tests and clone name
			for (SpecimenTest specimenTests : reportSpecimen.getSpecimenTests()) {
				String name = "";
				if (!specimenTests.getCloneName().isEmpty()) {
					name = specimenTests.getTestName() + " (" + specimenTests.getCloneName() + ")";
				} else {
					name = specimenTests.getTestName();
				}
				orders.setName(name);
			}

			// Setting status from specimen tests
			orders.setStatus(reportSpecimen.getSpecimenTests().get(0).getStatus().value());

			// Adding attached images
			for (Image testImage : reportSpecimen.getSpecimenTests().get(0).getTestImage()) {
				ImageType attachedImages = new ImageType();
				if (!testImage.getImageCaption().isEmpty()) {
					attachedImages.setCaption(testImage.getImageCaption());
				}
				attachedImages.setValue(String.valueOf(testImage.getImageValue()));
				if (!testImage.getImageComment().isEmpty()) {
					attachedImages.setImageComment(testImage.getImageComment());
				}
				orders.getAttachedImages().add(attachedImages);
			}

			// Adding test result values
			for (TestResultValue testResultValues : reportSpecimen.getSpecimenTests().get(0).getTestResultValues()) {
				CommentType comments = new CommentType();
				comments.setName(testResultValues.getKey());
				comments.setText(getAdvanceStringType(testResultValues.getValue()));
				orders.getComments().add(comments);
			}

			// Adding results
			ResultType results = new ResultType();
			for (SpecimenTestText specimenTestText : reportSpecimen.getSpecimenTests().get(0).getSpecimenTestText()) {
				if (specimenTestText.getKey() != null) {
					results.setNumber(specimenTestText.getKey().value());
				}
				results.setName(specimenTestText.getKey().name());
				if (!specimenTestText.getValue().isEmpty()) {
					results.setResult(getAdvanceStringType(specimenTestText.getValue()));
				}
			}
			orders.getResults().add(results);

			// Adding specimens
			SpecimenType specimens = new SpecimenType();
			if (!reportSpecimen.getSpecimenType().isEmpty()) {
				specimens.setName(reportSpecimen.getSpecimenType());
			}
			if (!reportSpecimen.getSpecimenId().isEmpty()) {
				specimens.setNumber(reportSpecimen.getSpecimenId());
			}
			if (!reportSpecimen.getSpecimenDescr().isEmpty()) {
				specimens.setDesc(getAdvanceStringType(reportSpecimen.getSpecimenDescr()));
			}
			if (!reportSpecimen.getSpecimenSiteCd().isEmpty()) {
				specimens.setBodySiteCode(reportSpecimen.getSpecimenSiteCd());
			}
			if (!reportSpecimen.getSpecimenSiteDescr().isEmpty()) {
				specimens.setBodySiteDesc(reportSpecimen.getSpecimenSiteDescr());
			}
			if (!reportSpecimen.getClientSpecimenID().isEmpty()) {
				specimens.setClientSpecimenID(reportSpecimen.getClientSpecimenID());
			}
			if (!reportSpecimen.getSpecimenTransportDescr().isEmpty()) {
				specimens.setTransportDesc(reportSpecimen.getSpecimenTransportDescr());
			}

			// Adding fixative information
			FixativeType fixative = new FixativeType();
			if (!reportSpecimen.getTypeOfFixative().isEmpty()) {
				fixative.setFixativeType(reportSpecimen.getTypeOfFixative());
			}
			if ("General".equalsIgnoreCase(reportSpecimen.getTimeToFixationKey())
					|| "GENERAL".equalsIgnoreCase(reportSpecimen.getTimeToFixationKey())) {
				fixative.setTimeToFixation(reportSpecimen.getTimeToFixGeneralText());
			} else if ("SPECIFIC".equalsIgnoreCase(reportSpecimen.getTimeToFixationKey())) {
				if (reportSpecimen.getTimeToFixationHH() != null && !"0".equals(reportSpecimen.getTimeToFixationHH())) {
					fixative.setTimeToFixation(reportSpecimen.getTimeToFixationHH() + " Hr. "
							+ reportSpecimen.getTimeToFixationMM() + " Min.");
				} else if (reportSpecimen.getTimeToFixationHH() != null
						&& !"0".equals(reportSpecimen.getTimeToFixationMM())) {
					fixative.setTimeToFixation(reportSpecimen.getTimeToFixationMM() + " Min.");
				}
			} else {
				fixative.setTimeToFixation("Not Provided");
			}
			if (reportSpecimen.getDurationOfFixativeKey() != null) {
				fixative.setFixativeDuration(reportSpecimen.getDurationOfFixativeKey());
			} else {
				fixative.setFixativeDuration("Not Provided");
			}
			specimens.setFixative(fixative);

			if (!reportSpecimen.getLabCorpSpecimenId().isEmpty()) {
				specimens.setLabCorpSpecimenID(reportSpecimen.getLabCorpSpecimenId());
			}

			orders.getSpecimens().add(specimens);
			ordersList.add(orders);
		}

		return ordersList;
	}

	public List<OrderType> buildConcurentCaseOrder(IrisResultsMessage irisResultsMessage,
			TemplateIdentifierMap templateIdentifierMap) {

		List<OrderType> ordersList = new ArrayList<>();

		for (ConcurrentCase concurrentCases : irisResultsMessage.getConcurrentCases()) {
			// Processing number field
			OrderType orders = new OrderType();
			orders.setNumber("");

			// Processing name field
			if (!concurrentCases.getTemplateId().isEmpty()) {
				/*
				 * String name =
				 * trimAndSerialize(templateIdentifierMap.getInformant().getIdentifiers()
				 * .stream() .filter(identifier ->
				 * identifier.getTemplateId().equals(trim(concurrentCases.getTemplateId())))
				 * .map(TemplateIdentifierMap::getTitle) .findFirst() .orElse(""));
				 */
				// orders.setName(name);
			} else if (!concurrentCases.getCategoryName().isEmpty()) {
				orders.setName(concurrentCases.getCategoryName());
			} else {
				orders.setName("");
			}

			// Processing caseId field
			if (!concurrentCases.getReportNumber().isEmpty()) {
				orders.setCaseId(concurrentCases.getReportNumber());
			} else {
				orders.setCaseId("");
			}

			// Processing signedBy field
			if (concurrentCases.getReportSignedLoginId() != null
					&& !concurrentCases.getReportSignedLoginId().isEmpty()) {
				String[] signed = concurrentCases.getReportSignedLoginId().split("~");
				SignedByType signedBy = new SignedByType();
				signedBy.setDegree(signed.length > 5 ? signed[5] : "");
				NameType name = new NameType();
				name.setFirst(signed.length > 1 ? signed[1] : "");
				name.setMiddle(signed.length > 2 ? signed[2] : "");
				name.setLast(getAdvanceStringType(signed.length > 3 ? signed[3] : ""));
				name.setSuffix(signed.length > 4 ? signed[4] : "");
				name.setTitle(signed.length > 6 ? signed[6] : "");
				signedBy.setName(name);
				signedBy.setRevision("");
				signedBy.setRevisionSequence("");
				signedBy.setDateTime(concurrentCases.getReportSignedTimestamp());
				signedBy.setESignatureComment("");
				orders.getSignedBy().add(signedBy);
			}

			// Processing status field
			if (concurrentCases.getRptStatus().equalsIgnoreCase("Cancelled") && concurrentCases.isIsReport()) {
				orders.setStatus("IsReportCancelled");
			} else {
				orders.setStatus(concurrentCases.getRptStatus());
			}

			// Processing Comments field
			if (!concurrentCases.getCancelReason().isEmpty()) {
				CommentType comments = new CommentType();
				comments.setName("CancelledReason");
				comments.setText(getAdvanceStringType(concurrentCases.getCancelReason()));
				orders.getComments().add(comments);
			}

			// Processing Results field
			ResultType results = new ResultType();
			if (!concurrentCases.getTemplateId().isEmpty()) {
				/*
				 * results.setName(trimAndSerialize(templateIdentifierMap.getInformant().
				 * getIdentifiers() .stream() .filter(identifier ->
				 * identifier.getTemplateId().equals(trim(concurrentCases.getTemplateId())))
				 * .map(TemplateIdentifier::getTitle) .findFirst() .orElse("")));
				 */
			} else if (!concurrentCases.getCategoryName().isEmpty()) {
				results.setName(concurrentCases.getCategoryName());
			} else {
				results.setName("");
			}
			results.setProcClass("");

			// Processing Specimens field
			if (!concurrentCases.getSpecimenType().isEmpty()) {
				SpecimenType specimens = new SpecimenType();
				specimens.setName(concurrentCases.getSpecimenType());
				orders.getSpecimens().add(specimens);
			}
			ordersList.add(orders);

		}

		return ordersList;
	}

	// when orders empty
	public OrderType buildOrderWithPanel(IrisResultsMessage requestMessage) {
		OrderType orders = new OrderType();

		// Processing Reagents Used Comments
		List<CommentType> commentsList = new ArrayList<>();
		for (ReagentsUsed reagentsUsed : requestMessage.getPanel().getReagentsUsed()) {
			if (reagentsUsed.isIsBill() && !reagentsUsed.getTestName().isEmpty()) {
				CommentType comments = new CommentType();
				comments.setName("Reagents Used");
				comments.setText(getAdvanceStringType(reagentsUsed.getTestName()));
				commentsList.add(comments);
			}
		}
		orders.getComments().addAll(commentsList);

		// Processing Specimens
		List<SpecimenType> specimensList = new ArrayList<>();
		for (AccessionSpecimen reportSpecimen : requestMessage.getReportSpecimen()) {
			SpecimenType specimens = new SpecimenType();
			if (!reportSpecimen.getSpecimenType().isEmpty()) {
				specimens.setName(reportSpecimen.getSpecimenType());
			} else {
				specimens.setName("");
			}
			if (!reportSpecimen.getSpecimenId().isEmpty()) {
				specimens.setNumber(reportSpecimen.getSpecimenId());
			} else {
				specimens.setNumber("");
			}
			if (!reportSpecimen.getSpecimenDescr().isEmpty()) {
				specimens.setDesc(getAdvanceStringType(reportSpecimen.getSpecimenDescr()));
			}
			if (!reportSpecimen.getSpecimenSiteCd().isEmpty()) {
				specimens.setBodySiteCode(reportSpecimen.getSpecimenSiteCd());
			}
			if (!reportSpecimen.getSpecimenSiteDescr().isEmpty()) {
				specimens.setBodySiteDesc(reportSpecimen.getSpecimenSiteDescr());
			}
			if (!reportSpecimen.getClientSpecimenID().isEmpty()) {
				specimens.setClientSpecimenID(reportSpecimen.getClientSpecimenID());
			}
			if (!reportSpecimen.getSpecimenTransportDescr().isEmpty()) {
				specimens.setTransportDesc(reportSpecimen.getSpecimenTransportDescr());
			}

			// Process Fixative and Disclaimer
			if (reportSpecimen.getTypeOfFixative() != null) {
				FixativeType fixative = new FixativeType();
				if (!reportSpecimen.getTypeOfFixative().isEmpty()) {
					fixative.setFixativeType(reportSpecimen.getTypeOfFixative());
				} else {
					fixative.setFixativeType("");
				}
				if (reportSpecimen.getTimeToFixationKey().equalsIgnoreCase("General")
						|| reportSpecimen.getTimeToFixationKey().equalsIgnoreCase("GENERAL")) {
					fixative.setTimeToFixation(reportSpecimen.getTimeToFixGeneralText());
				} else if (reportSpecimen.getTimeToFixationKey().equalsIgnoreCase("SPECIFIC")) {
					if (reportSpecimen.getTimeToFixationHH() != null
							&& !reportSpecimen.getTimeToFixationHH().equals("0")
							&& reportSpecimen.getTimeToFixationMM() != null
							&& !reportSpecimen.getTimeToFixationMM().equals("0")) {
						fixative.setTimeToFixation(reportSpecimen.getTimeToFixationHH() + " Hr. "
								+ reportSpecimen.getTimeToFixationMM() + " Min.");
					} else if (reportSpecimen.getTimeToFixationHH() != null
							&& !reportSpecimen.getTimeToFixationHH().equals("0")) {
						fixative.setTimeToFixation(reportSpecimen.getTimeToFixationHH() + " Hr.");
					} else if (reportSpecimen.getTimeToFixationMM() != null
							&& !reportSpecimen.getTimeToFixationMM().equals("0")) {
						fixative.setTimeToFixation(reportSpecimen.getTimeToFixationMM() + " Min.");
					} else {
						fixative.setTimeToFixation("");
					}
				} else if (reportSpecimen.getTimeToFixationKey().equalsIgnoreCase("NOT_PROVIDED")) {
					fixative.setTimeToFixation("Not Provided");
				}
				if (!reportSpecimen.getDurationOfFixativeKey().isEmpty()) {
					if (reportSpecimen.getDurationOfFixativeKey().equalsIgnoreCase("General")
							|| reportSpecimen.getDurationOfFixativeKey().equalsIgnoreCase("GENERAL")) {
						fixative.setFixativeDuration(reportSpecimen.getDurationOfFixGeneralText());
					} else if (reportSpecimen.getDurationOfFixativeKey().equalsIgnoreCase("SPECIFIC")) {
						if (reportSpecimen.getFixativeDurationHH() != null
								&& !reportSpecimen.getFixativeDurationHH().equals("0")
								&& reportSpecimen.getFixativeDurationMM() != null
								&& !reportSpecimen.getFixativeDurationMM().equals("0")) {
							fixative.setFixativeDuration(reportSpecimen.getFixativeDurationHH() + " Hr. "
									+ reportSpecimen.getFixativeDurationMM() + " Min.");
						} else if (reportSpecimen.getFixativeDurationHH() != null
								&& !reportSpecimen.getFixativeDurationHH().equals("0")) {
							fixative.setFixativeDuration(reportSpecimen.getFixativeDurationHH() + " Hr.");
						} else if (reportSpecimen.getFixativeDurationMM() != null
								&& !reportSpecimen.getFixativeDurationMM().equals("0")) {
							fixative.setFixativeDuration(reportSpecimen.getFixativeDurationMM() + " Min.");
						} else {
							fixative.setFixativeDuration("");
						}
					} else if (reportSpecimen.getDurationOfFixativeKey().equalsIgnoreCase("NOT_PROVIDED")) {
						fixative.setFixativeDuration("Not Provided");
					}
				}
				if (!reportSpecimen.getSpecimenText().isEmpty()) {
					for (SpecimenText specimenText : reportSpecimen.getSpecimenText()) {
						if (specimenText.getKey().name().equalsIgnoreCase("FIXATIVEDISCLAIMER")) {
							fixative.setFixativeDisclaimer(specimenText.getValue());
						}
					}
				}
				specimens.setFixative(fixative);
			}

			if (!reportSpecimen.getLabCorpSpecimenId().isEmpty()) {
				specimens.setLabCorpSpecimenID(reportSpecimen.getLabCorpSpecimenId());
			} else {
				specimens.setLabCorpSpecimenID("");
			}

			specimensList.add(specimens);
		}
		orders.getSpecimens().addAll(specimensList);

		return orders;
	}

	public LabType bildLAbType(IrisResultsMessage requestMessage) {
		LabType labs = new LabType();

		// Extract Lab Code
		labs.setCode(requestMessage.getReport().getReportHeader().getPerfLabAddr().getLabCode());

		// Extract Address Information
		if (!requestMessage.getReport().getSignedByAddr().getAdress1().isEmpty()) {
			AddressType signedByAddress = new AddressType();
			signedByAddress.setStreet(requestMessage.getReport().getSignedByAddr().getAdress1());
			if (!requestMessage.getReport().getSignedByAddr().getAddress2().isEmpty()) {
				signedByAddress.setStreet2(requestMessage.getReport().getSignedByAddr().getAddress2());
			}
			if (!requestMessage.getReport().getSignedByAddr().getCity().isEmpty()) {
				signedByAddress.setCity(requestMessage.getReport().getSignedByAddr().getCity());
			}
			if (!requestMessage.getReport().getSignedByAddr().getStateCd().isEmpty()) {
				signedByAddress.setState(requestMessage.getReport().getSignedByAddr().getStateCd());
			}
			if (!requestMessage.getReport().getSignedByAddr().getZip().isEmpty()) {
				signedByAddress.setZip(requestMessage.getReport().getSignedByAddr().getZip());
			}
			labs.setAddress(signedByAddress);
		} else {
			AddressType perfLabAddr = new AddressType();
			if (!requestMessage.getReport().getReportHeader().getPerfLabAddr().getAdress1().isEmpty()) {
				perfLabAddr.setStreet(requestMessage.getReport().getReportHeader().getPerfLabAddr().getAdress1());
			}
			if (!requestMessage.getReport().getReportHeader().getPerfLabAddr().getAddress2().isEmpty()) {
				perfLabAddr.setStreet2(requestMessage.getReport().getReportHeader().getPerfLabAddr().getAddress2());
			}
			if (!requestMessage.getReport().getReportHeader().getPerfLabAddr().getCity().isEmpty()) {
				perfLabAddr.setCity(requestMessage.getReport().getReportHeader().getPerfLabAddr().getCity());
			}
			if (!requestMessage.getReport().getReportHeader().getPerfLabAddr().getStateCd().isEmpty()) {
				perfLabAddr.setState(requestMessage.getReport().getReportHeader().getPerfLabAddr().getStateCd());
			}
			if (!requestMessage.getReport().getReportHeader().getPerfLabAddr().getZip().isEmpty()) {
				perfLabAddr.setZip(requestMessage.getReport().getReportHeader().getPerfLabAddr().getZip());
			}
			labs.setAddress(perfLabAddr);
		}

		// Extract CLIA Id
		labs.setCLIAId(requestMessage.getReport().getMdCliaNum());

		// Extract Lab Name
		String testPerfmdLoc = getTestPerfmdLoc(requestMessage);
		labs.setName(testPerfmdLoc);

		// Extract Director Information
		Director director = new Director();
		if (!requestMessage.getReport().getMedicalDirDegree().isEmpty()) {
			director.setDegree(requestMessage.getReport().getMedicalDirDegree());
		}
		NameType nameType = new NameType();
		if (!requestMessage.getReport().getMedicalDirFName().isEmpty()) {
			nameType.setFirst(requestMessage.getReport().getMedicalDirFName());
		}
		nameType.setLast(getAdvanceStringType(requestMessage.getReport().getMedicalDirLName()));
		labs.setDirector(director);

		return labs;
	}

	private String getTestPerfmdLoc(IrisResultsMessage requestMessage) {
		if (!requestMessage.getPanel().getTestPerfmdLoc().isEmpty()) {
			return requestMessage.getPanel().getTestPerfmdLoc();
		} else if (!requestMessage.getCancelledPanel().get(0).getTestPerfmdLoc().isEmpty()) {
			return requestMessage.getCancelledPanel().get(0).getTestPerfmdLoc();
		} else if (!requestMessage.getReport().getSignedLocation().isEmpty()) {
			return requestMessage.getReport().getSignedLocation();
		} else if (!requestMessage.getReportSpecimen().get(0).getSpecimenTests().get(0).getTestPerfmdLoc().isEmpty()) {
			return requestMessage.getReportSpecimen().get(0).getSpecimenTests().get(0).getTestPerfmdLoc();
		} else {
			return "";
		}
	}

	public void buildPlaceofService(IrisResultsMessage irisResultsMessage) {

		for (PlaceOfService placeOfServiceData : irisResultsMessage.getReport().getPlacesOfService()
				.getPlaceOfService()) {
			PlaceOfService placeOfService = new PlaceOfService();
			placeOfService.setTestPerformed(placeOfServiceData.getTestPerformed());
			placeOfService.setComponentType(placeOfServiceData.getComponentType());
			placeOfService.setPerformedLocation(placeOfServiceData.getPerformedLocation());
			placeOfService.setMedicalDirector(placeOfServiceData.getMedicalDirector());
			// placesOfService.addPlaceOfService(placeOfService);
		}
	}

	public List<PreviousEncounters> buildPreviousEncouters(IrisResultsMessage requestMessage) {
		List<PreviousEncounters> previousEncountersList = new ArrayList<>();

		// Process pertinentPriorTestResults
		for (PertinentPriorTestResults pertinentPriorTestResults : requestMessage.getReport()
				.getPertinentPriorTestResults()) {
			PreviousEncounters previousEncounters = new PreviousEncounters();

			ReportType report = new ReportType();
			report.setDateTime(DateConverter.getCurrentDate());
			report.setDisclaimerPhone("");
			report.setNumber(pertinentPriorTestResults.getReportNum());
			if (pertinentPriorTestResults.getReceivedDate() != null) {
				// report.setReceivedDate("concat(fn:substring(data($pertinentPriorTestResults/receivedDate),1,10),'T','00:00:00+00:00')");
			}

			previousEncounters.setReport(report);

			AccountType account = new AccountType();
			previousEncounters.setAccount(account);

			LabType responsibleLab = new LabType();
			previousEncounters.setResponsibleLab(responsibleLab);

			PatientType patient = new PatientType();
			patient.setAccessionId(pertinentPriorTestResults.getAccessionNum());
			patient.setCollectDateTime("fn:current-dateTime()");
			patient.setOrderDateTime(DateConverter.getCurrentDate());
			previousEncounters.setPatient(patient);

			SpecialtyType specialty = new SpecialtyType();
			// Set templateId, brand, OrderItems, Orders, Labs here from
			// pertinentPriorTestResults
			previousEncounters.getSpecialty().add(specialty);

			previousEncountersList.add(previousEncounters);
		}
		return previousEncountersList;

	}

}
