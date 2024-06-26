//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.05.30 at 03:09:20 PM IST 
//


package com.lca.ddt.delivery.report.input;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Slide complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Slide">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="slideNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="speicmenBarCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="blockBarCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="slideBarCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specimenTest" type="{http://www.labcorp.com/iris/messages}SpecimenTest" minOccurs="0"/>
 *         &lt;element name="positiveControlInd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="negativeControlInd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="recutInd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="specialInstructions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resolution" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="issue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stainerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastUpdatedUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastUpdatedDateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vantageTestCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vantageTestName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="otherStainerTestCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="otherStainerTestName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clientId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Slide", propOrder = {
    "slideNumber",
    "speicmenBarCode",
    "blockBarCode",
    "slideBarCode",
    "specimenTest",
    "positiveControlInd",
    "negativeControlInd",
    "recutInd",
    "specialInstructions",
    "resolution",
    "issue",
    "stainerName",
    "status",
    "lastUpdatedUser",
    "lastUpdatedDateTime",
    "vantageTestCode",
    "vantageTestName",
    "otherStainerTestCode",
    "otherStainerTestName",
    "clientId"
})
public class Slide {

    protected Integer slideNumber;
    protected String speicmenBarCode;
    protected String blockBarCode;
    protected String slideBarCode;
    protected SpecimenTest specimenTest;
    protected Boolean positiveControlInd;
    protected Boolean negativeControlInd;
    protected Boolean recutInd;
    protected String specialInstructions;
    protected String resolution;
    protected String issue;
    protected String stainerName;
    protected String status;
    protected String lastUpdatedUser;
    protected String lastUpdatedDateTime;
    protected String vantageTestCode;
    protected String vantageTestName;
    protected String otherStainerTestCode;
    protected String otherStainerTestName;
    protected String clientId;

    /**
     * Gets the value of the slideNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSlideNumber() {
        return slideNumber;
    }

    /**
     * Sets the value of the slideNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSlideNumber(Integer value) {
        this.slideNumber = value;
    }

    /**
     * Gets the value of the speicmenBarCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpeicmenBarCode() {
        return speicmenBarCode;
    }

    /**
     * Sets the value of the speicmenBarCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpeicmenBarCode(String value) {
        this.speicmenBarCode = value;
    }

    /**
     * Gets the value of the blockBarCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlockBarCode() {
        return blockBarCode;
    }

    /**
     * Sets the value of the blockBarCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlockBarCode(String value) {
        this.blockBarCode = value;
    }

    /**
     * Gets the value of the slideBarCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSlideBarCode() {
        return slideBarCode;
    }

    /**
     * Sets the value of the slideBarCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSlideBarCode(String value) {
        this.slideBarCode = value;
    }

    /**
     * Gets the value of the specimenTest property.
     * 
     * @return
     *     possible object is
     *     {@link SpecimenTest }
     *     
     */
    public SpecimenTest getSpecimenTest() {
        return specimenTest;
    }

    /**
     * Sets the value of the specimenTest property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecimenTest }
     *     
     */
    public void setSpecimenTest(SpecimenTest value) {
        this.specimenTest = value;
    }

    /**
     * Gets the value of the positiveControlInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPositiveControlInd() {
        return positiveControlInd;
    }

    /**
     * Sets the value of the positiveControlInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPositiveControlInd(Boolean value) {
        this.positiveControlInd = value;
    }

    /**
     * Gets the value of the negativeControlInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNegativeControlInd() {
        return negativeControlInd;
    }

    /**
     * Sets the value of the negativeControlInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNegativeControlInd(Boolean value) {
        this.negativeControlInd = value;
    }

    /**
     * Gets the value of the recutInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRecutInd() {
        return recutInd;
    }

    /**
     * Sets the value of the recutInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRecutInd(Boolean value) {
        this.recutInd = value;
    }

    /**
     * Gets the value of the specialInstructions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialInstructions() {
        return specialInstructions;
    }

    /**
     * Sets the value of the specialInstructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialInstructions(String value) {
        this.specialInstructions = value;
    }

    /**
     * Gets the value of the resolution property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * Sets the value of the resolution property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResolution(String value) {
        this.resolution = value;
    }

    /**
     * Gets the value of the issue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssue() {
        return issue;
    }

    /**
     * Sets the value of the issue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssue(String value) {
        this.issue = value;
    }

    /**
     * Gets the value of the stainerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStainerName() {
        return stainerName;
    }

    /**
     * Sets the value of the stainerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStainerName(String value) {
        this.stainerName = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the lastUpdatedUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastUpdatedUser() {
        return lastUpdatedUser;
    }

    /**
     * Sets the value of the lastUpdatedUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastUpdatedUser(String value) {
        this.lastUpdatedUser = value;
    }

    /**
     * Gets the value of the lastUpdatedDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastUpdatedDateTime() {
        return lastUpdatedDateTime;
    }

    /**
     * Sets the value of the lastUpdatedDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastUpdatedDateTime(String value) {
        this.lastUpdatedDateTime = value;
    }

    /**
     * Gets the value of the vantageTestCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVantageTestCode() {
        return vantageTestCode;
    }

    /**
     * Sets the value of the vantageTestCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVantageTestCode(String value) {
        this.vantageTestCode = value;
    }

    /**
     * Gets the value of the vantageTestName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVantageTestName() {
        return vantageTestName;
    }

    /**
     * Sets the value of the vantageTestName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVantageTestName(String value) {
        this.vantageTestName = value;
    }

    /**
     * Gets the value of the otherStainerTestCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherStainerTestCode() {
        return otherStainerTestCode;
    }

    /**
     * Sets the value of the otherStainerTestCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherStainerTestCode(String value) {
        this.otherStainerTestCode = value;
    }

    /**
     * Gets the value of the otherStainerTestName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherStainerTestName() {
        return otherStainerTestName;
    }

    /**
     * Sets the value of the otherStainerTestName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherStainerTestName(String value) {
        this.otherStainerTestName = value;
    }

    /**
     * Gets the value of the clientId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Sets the value of the clientId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientId(String value) {
        this.clientId = value;
    }

}
