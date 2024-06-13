package com.lca.ddt.delivery.report.inspire.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resultType", propOrder = { "number", "name", "abbrev", "category", "abnorm", "dateTime",
		"dateTimeString", "forceBold", "lab", "noFlag", "procClass", "result", "resultType", "status", "units", "chart",
		"resultsWithHistory", "isReflex", "referenceRange", "comments", "images", "referenceLevel",
		"footnotesSequence" })
public class ResultType {

	protected String number;
	@XmlElement(required = true)
	protected String name;
	protected String abbrev;
	protected String category;
	protected String abnorm;
	@XmlSchemaType(name = "dateTime")
	protected String dateTime;
	protected String dateTimeString;
	protected Boolean forceBold;
	protected String lab;
	protected Boolean noFlag;
	@XmlElement(required = true)
	protected String procClass;
	protected AdvancedStringType result;
	protected String resultType; // NOSONAR
	@XmlElement(required = true)
	protected String status;
	protected String units;
	protected Boolean isReflex;
	@XmlElement(name = "ReferenceRange")
	protected List<ResultType.ReferenceRange> referenceRange;
	@XmlElement(name = "Comments")
	protected List<CommentType> comments;
	@XmlElement(name = "Images")
	protected List<ImageType> images;
	protected String referenceLevel;
	protected List<String> footnotesSequence;
	protected Chart chart;

	public ResultType() {
		// empty
	}

	public ResultType(String name, String procClass, String status) {
		this.name = name;
		this.procClass = procClass;
		this.status = status;
	}

	public Chart getChart() {
		return chart;
	}

	public void setChart(Chart chart) {
		this.chart = chart;
	}

	

	/**
	 * Gets the value of the number property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Sets the value of the number property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setNumber(String value) {
		this.number = value;
	}

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the abbrev property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAbbrev() {
		return abbrev;
	}

	/**
	 * Sets the value of the abbrev property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setAbbrev(String value) {
		this.abbrev = value;
	}

	/**
	 * Gets the value of the category property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets the value of the category property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setCategory(String value) {
		this.category = value;
	}

	/**
	 * Gets the value of the abnorm property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAbnorm() {
		return abnorm;
	}

	/**
	 * Sets the value of the abnorm property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setAbnorm(String value) {
		this.abnorm = value;
	}

	/**
	 * Gets the value of the dateTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * Sets the value of the dateTime property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDateTime(String value) {
		this.dateTime = value;
	}

	/**
	 * Gets the value of the dateTimeString property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDateTimeString() {
		return dateTimeString;
	}

	/**
	 * Sets the value of the dateTimeString property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDateTimeString(String value) {
		this.dateTimeString = value;
	}

	/**
	 * Gets the value of the forceBold property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isForceBold() {
		return forceBold;
	}

	/**
	 * Sets the value of the forceBold property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 * 
	 */
	public void setForceBold(Boolean value) {
		this.forceBold = value;
	}

	/**
	 * Gets the value of the lab property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLab() {
		return lab;
	}

	/**
	 * Sets the value of the lab property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setLab(String value) {
		this.lab = value;
	}

	/**
	 * Gets the value of the noFlag property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isNoFlag() {
		return noFlag;
	}

	/**
	 * Sets the value of the noFlag property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 * 
	 */
	public void setNoFlag(Boolean value) {
		this.noFlag = value;
	}

	/**
	 * Gets the value of the procClass property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProcClass() {
		return procClass;
	}

	/**
	 * Sets the value of the procClass property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setProcClass(String value) {
		this.procClass = value;
	}

	/**
	 * Gets the value of the result property.
	 * 
	 * @return possible object is {@link AdvancedStringType }
	 * 
	 */
	public AdvancedStringType getResult() {
		return result;
	}

	/**
	 * Sets the value of the result property.
	 * 
	 * @param value allowed object is {@link AdvancedStringType }
	 * 
	 */
	public void setResult(AdvancedStringType value) {
		this.result = value;
	}

	/**
	 * Gets the value of the resultType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getResultType() {
		return resultType;
	}

	/**
	 * Sets the value of the resultType property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setResultType(String value) {
		this.resultType = value;
	}

	/**
	 * Gets the value of the status property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the value of the status property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStatus(String value) {
		this.status = value;
	}

	/**
	 * Gets the value of the units property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUnits() {
		return units;
	}

	/**
	 * Sets the value of the units property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setUnits(String value) {
		this.units = value;
	}

	/**
	 * Gets the value of the isReflex property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isIsReflex() {
		return isReflex;
	}

	/**
	 * Sets the value of the isReflex property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 * 
	 */
	public void setIsReflex(Boolean value) {
		this.isReflex = value;
	}

	/**
	 * Gets the value of the referenceRange property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the referenceRange property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getReferenceRange().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link ResultType.ReferenceRange }
	 * 
	 * 
	 */
	public List<ResultType.ReferenceRange> getReferenceRange() {
		if (referenceRange == null) {
			referenceRange = new ArrayList<>();
		}
		return this.referenceRange;
	}

	/**
	 * Gets the value of the comments property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the comments property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getComments().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link CommentType }
	 * 
	 * 
	 */
	public List<CommentType> getComments() {
		if (comments == null) {
			comments = new ArrayList<>();
		}
		return this.comments;
	}

	/**
	 * Gets the value of the images property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the images property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getImages().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link ImageType }
	 * 
	 * 
	 */
	public List<ImageType> getImages() {
		if (images == null) {
			images = new ArrayList<>();
		}
		return this.images;
	}

	/**
	 * Gets the value of the referenceLevel property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReferenceLevel() {
		return referenceLevel;
	}

	/**
	 * Sets the value of the referenceLevel property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setReferenceLevel(String value) {
		this.referenceLevel = value;
	}

	/**
	 * Gets the value of the footnotesSequence property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the footnotesSequence property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getFootnotesSequence().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public List<String> getFootnotesSequence() {
		if (footnotesSequence == null) {
			footnotesSequence = new ArrayList<>();
		}
		return this.footnotesSequence;
	}

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * 
	 * <p>
	 * The following schema fragment specifies the expected content contained within
	 * this class.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="observationRange" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *         &lt;element name="notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "observationRange", "text", "notes" })
	public static class ReferenceRange {

		@XmlElement(required = true)
		protected String observationRange;
		protected String text;
		protected String notes;

		/**
		 * Gets the value of the observationRange property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getObservationRange() {
			return observationRange;
		}

		/**
		 * Sets the value of the observationRange property.
		 * 
		 * @param value allowed object is {@link String }
		 * 
		 */
		public void setObservationRange(String value) {
			this.observationRange = value;
		}

		/**
		 * Gets the value of the text property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getText() {
			return text;
		}

		/**
		 * Sets the value of the text property.
		 * 
		 * @param value allowed object is {@link String }
		 * 
		 */
		public void setText(String value) {
			this.text = value;
		}

		/**
		 * Gets the value of the notes property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getNotes() {
			return notes;
		}

		/**
		 * Sets the value of the notes property.
		 * 
		 * @param value allowed object is {@link String }
		 * 
		 */
		public void setNotes(String value) {
			this.notes = value;
		}

	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "property" })
	public static class Chart {

		public Chart() {
			// empty
		}

		

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "result" })
	public static class ResultsWithHistory {

		protected List<ResultsWithHistory.Result> result;

		public ResultsWithHistory() {
			// empty
		}

		public ResultsWithHistory(List<ResultsWithHistory.Result> result) {
			this.result = result;
		}

		public List<ResultsWithHistory.Result> getResult() {
			if (result == null) {
				result = new ArrayList<>();
			}
			return this.result;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "specimenNumber", "collectionDate", "value" })
		public static class Result {

			@XmlElement(required = true)
			protected String specimenNumber;
			@XmlElement(required = true)
			protected String collectionDate;
			@XmlElement(required = true)
			protected String value;

			public Result() {
				// empty
			}

			public Result(String specimenNumber, String collectionDate, String value) {
				this.specimenNumber = specimenNumber;
				this.collectionDate = collectionDate;
				this.value = value;
			}

			public String getSpecimenNumber() {
				return specimenNumber;
			}

			public void setSpecimenNumber(String value) {
				this.specimenNumber = value;
			}

			public String getCollectionDate() {
				return collectionDate;
			}

			public void setCollectionDate(String value) {
				this.collectionDate = value;
			}

			public String getValue() {
				return value;
			}

			public void setValue(String value) {
				this.value = value;
			}
		}
	}
	}
}
