//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.04.29 at 06:09:43 PM IST 
//


package com.lca.ddt.delivery.report.inspire.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for patientType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="patientType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accessionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isRegulated" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="correlationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reqNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MRN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="alternatePatientId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="alternateControlNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SSN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="confidCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="collectDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="collectDateTimeString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="orderDateTimeString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{}nameType"/>
 *         &lt;element name="address" type="{}addressType" minOccurs="0"/>
 *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClinInfo" type="{}commentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="collectionMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datesAndResults" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fasting" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LMPPrevTreat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="otherCytology" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specimenSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="dateOfBirthString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="age" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="years" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="months" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="days" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="height" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="units" type="{http://www.w3.org/2001/XMLSchema}string" default="inches" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="weight" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="units" type="{http://www.w3.org/2001/XMLSchema}string" default="ounces" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="race" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ethnicity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "patientType", propOrder = {
    "accessionId",
    "isRegulated",
    "correlationId",
    "reqNum",
    "mrn",
    "alternatePatientId",
    "alternateControlNum",
    "ssn",
    "confidCode",
    "collectDateTime",
    "collectDateTimeString",
    "orderDateTime",
    "orderDateTimeString",
    "name",
    "address",
    "phone",
    "clinInfo",
    "collectionMethod",
    "datesAndResults",
    "fasting",
    "lmpPrevTreat",
    "otherCytology",
    "specimenSource",
    "gender",
    "dateOfBirth",
    "dateOfBirthString",
    "age",
    "height",
    "weight",
    "race",
    "ethnicity"
})
public class PatientType {

    @XmlElement(required = true)
    protected String accessionId;
    protected Boolean isRegulated;
    protected String correlationId;
    protected String reqNum;
    @XmlElement(name = "MRN")
    protected String mrn;
    protected String alternatePatientId;
    protected String alternateControlNum;
    @XmlElement(name = "SSN")
    protected String ssn;
    protected String confidCode;
    @XmlSchemaType(name = "dateTime")
    protected String collectDateTime;
    protected String collectDateTimeString;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar orderDateTime;
    protected String orderDateTimeString;
    @XmlElement(required = true)
    protected NameType name;
    protected AddressType address;
    protected String phone;
    @XmlElement(name = "ClinInfo")
    protected List<CommentType> clinInfo;
    protected String collectionMethod;
    protected String datesAndResults;
    protected String fasting;
    @XmlElement(name = "LMPPrevTreat")
    protected String lmpPrevTreat;
    protected String otherCytology;
    protected String specimenSource;
    protected String gender;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOfBirth;
    protected String dateOfBirthString;
    protected PatientType.Age age;
    protected PatientType.Height height;
    protected PatientType.Weight weight;
    protected String race;
    protected String ethnicity;

    /**
     * Gets the value of the accessionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessionId() {
        return accessionId;
    }

    /**
     * Sets the value of the accessionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessionId(String value) {
        this.accessionId = value;
    }

    /**
     * Gets the value of the isRegulated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsRegulated() {
        return isRegulated;
    }

    /**
     * Sets the value of the isRegulated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsRegulated(Boolean value) {
        this.isRegulated = value;
    }

    /**
     * Gets the value of the correlationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelationId() {
        return correlationId;
    }

    /**
     * Sets the value of the correlationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelationId(String value) {
        this.correlationId = value;
    }

    /**
     * Gets the value of the reqNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqNum() {
        return reqNum;
    }

    /**
     * Sets the value of the reqNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqNum(String value) {
        this.reqNum = value;
    }

    /**
     * Gets the value of the mrn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMRN() {
        return mrn;
    }

    /**
     * Sets the value of the mrn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMRN(String value) {
        this.mrn = value;
    }

    /**
     * Gets the value of the alternatePatientId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlternatePatientId() {
        return alternatePatientId;
    }

    /**
     * Sets the value of the alternatePatientId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlternatePatientId(String value) {
        this.alternatePatientId = value;
    }

    /**
     * Gets the value of the alternateControlNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlternateControlNum() {
        return alternateControlNum;
    }

    /**
     * Sets the value of the alternateControlNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlternateControlNum(String value) {
        this.alternateControlNum = value;
    }

    /**
     * Gets the value of the ssn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSN() {
        return ssn;
    }

    /**
     * Sets the value of the ssn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSN(String value) {
        this.ssn = value;
    }

    /**
     * Gets the value of the confidCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfidCode() {
        return confidCode;
    }

    /**
     * Sets the value of the confidCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfidCode(String value) {
        this.confidCode = value;
    }

    /**
     * Gets the value of the collectDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public String getCollectDateTime() {
        return collectDateTime;
    }

    /**
     * Sets the value of the collectDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCollectDateTime(String value) {
        this.collectDateTime = value;
    }

    /**
     * Gets the value of the collectDateTimeString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollectDateTimeString() {
        return collectDateTimeString;
    }

    /**
     * Sets the value of the collectDateTimeString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollectDateTimeString(String value) {
        this.collectDateTimeString = value;
    }

    /**
     * Gets the value of the orderDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrderDateTime() {
        return orderDateTime;
    }

    /**
     * Sets the value of the orderDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrderDateTime(XMLGregorianCalendar value) {
        this.orderDateTime = value;
    }

    /**
     * Gets the value of the orderDateTimeString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderDateTimeString() {
        return orderDateTimeString;
    }

    /**
     * Sets the value of the orderDateTimeString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderDateTimeString(String value) {
        this.orderDateTimeString = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link NameType }
     *     
     */
    public NameType getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameType }
     *     
     */
    public void setName(NameType value) {
        this.name = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setAddress(AddressType value) {
        this.address = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    /**
     * Gets the value of the clinInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clinInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClinInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommentType }
     * 
     * 
     */
    public List<CommentType> getClinInfo() {
        if (clinInfo == null) {
            clinInfo = new ArrayList<>();
        }
        return this.clinInfo;
    }

    /**
     * Gets the value of the collectionMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollectionMethod() {
        return collectionMethod;
    }

    /**
     * Sets the value of the collectionMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollectionMethod(String value) {
        this.collectionMethod = value;
    }

    /**
     * Gets the value of the datesAndResults property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatesAndResults() {
        return datesAndResults;
    }

    /**
     * Sets the value of the datesAndResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatesAndResults(String value) {
        this.datesAndResults = value;
    }

    /**
     * Gets the value of the fasting property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFasting() {
        return fasting;
    }

    /**
     * Sets the value of the fasting property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFasting(String value) {
        this.fasting = value;
    }

    /**
     * Gets the value of the lmpPrevTreat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLMPPrevTreat() {
        return lmpPrevTreat;
    }

    /**
     * Sets the value of the lmpPrevTreat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLMPPrevTreat(String value) {
        this.lmpPrevTreat = value;
    }

    /**
     * Gets the value of the otherCytology property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherCytology() {
        return otherCytology;
    }

    /**
     * Sets the value of the otherCytology property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherCytology(String value) {
        this.otherCytology = value;
    }

    /**
     * Gets the value of the specimenSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecimenSource() {
        return specimenSource;
    }

    /**
     * Sets the value of the specimenSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecimenSource(String value) {
        this.specimenSource = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGender(String value) {
        this.gender = value;
    }

    /**
     * Gets the value of the dateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfBirth(XMLGregorianCalendar value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the dateOfBirthString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfBirthString() {
        return dateOfBirthString;
    }

    /**
     * Sets the value of the dateOfBirthString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfBirthString(String value) {
        this.dateOfBirthString = value;
    }

    /**
     * Gets the value of the age property.
     * 
     * @return
     *     possible object is
     *     {@link PatientType.Age }
     *     
     */
    public PatientType.Age getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     * @param value
     *     allowed object is
     *     {@link PatientType.Age }
     *     
     */
    public void setAge(PatientType.Age value) {
        this.age = value;
    }

    /**
     * Gets the value of the height property.
     * 
     * @return
     *     possible object is
     *     {@link PatientType.Height }
     *     
     */
    public PatientType.Height getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     * @param value
     *     allowed object is
     *     {@link PatientType.Height }
     *     
     */
    public void setHeight(PatientType.Height value) {
        this.height = value;
    }

    /**
     * Gets the value of the weight property.
     * 
     * @return
     *     possible object is
     *     {@link PatientType.Weight }
     *     
     */
    public PatientType.Weight getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     * 
     * @param value
     *     allowed object is
     *     {@link PatientType.Weight }
     *     
     */
    public void setWeight(PatientType.Weight value) {
        this.weight = value;
    }

    /**
     * Gets the value of the race property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRace() {
        return race;
    }

    /**
     * Sets the value of the race property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRace(String value) {
        this.race = value;
    }

    /**
     * Gets the value of the ethnicity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEthnicity() {
        return ethnicity;
    }

    /**
     * Sets the value of the ethnicity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEthnicity(String value) {
        this.ethnicity = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="years" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="months" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="days" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "years",
        "months",
        "days"
    })
    public static class Age {

        @XmlElement(required = true)
        protected String years;
        protected String months;
        protected String days;

        /**
         * Gets the value of the years property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getYears() {
            return years;
        }

        /**
         * Sets the value of the years property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setYears(String value) {
            this.years = value;
        }

        /**
         * Gets the value of the months property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMonths() {
            return months;
        }

        /**
         * Sets the value of the months property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMonths(String value) {
            this.months = value;
        }

        /**
         * Gets the value of the days property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDays() {
            return days;
        }

        /**
         * Sets the value of the days property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDays(String value) {
            this.days = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="units" type="{http://www.w3.org/2001/XMLSchema}string" default="inches" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Height {

        @XmlAttribute(name = "units")
        protected String units;

        /**
         * Gets the value of the units property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnits() {
            if (units == null) {
                return "inches";
            } else {
                return units;
            }
        }

        /**
         * Sets the value of the units property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnits(String value) {
            this.units = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="units" type="{http://www.w3.org/2001/XMLSchema}string" default="ounces" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Weight {

        @XmlAttribute(name = "units")
        protected String units;

        /**
         * Gets the value of the units property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnits() {
            if (units == null) {
                return "ounces";
            } else {
                return units;
            }
        }

        /**
         * Sets the value of the units property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnits(String value) {
            this.units = value;
        }

    }

}
