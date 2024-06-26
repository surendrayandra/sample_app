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
 * <p>Java class for TestingReportingSiteDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TestingReportingSiteDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="medicalDirFName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="medicalDirMName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="medicalDirLName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="medicalDirDegree" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mdAddr" type="{http://www.labcorp.com/iris/messages}Address" minOccurs="0"/>
 *         &lt;element name="mdCliaNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TestingReportingSiteDetails", propOrder = {
    "medicalDirFName",
    "medicalDirMName",
    "medicalDirLName",
    "medicalDirDegree",
    "mdAddr",
    "mdCliaNum"
})
public class TestingReportingSiteDetails {

    protected String medicalDirFName;
    protected String medicalDirMName;
    protected String medicalDirLName;
    protected String medicalDirDegree;
    protected Address mdAddr;
    protected String mdCliaNum;

    /**
     * Gets the value of the medicalDirFName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedicalDirFName() {
        return medicalDirFName;
    }

    /**
     * Sets the value of the medicalDirFName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedicalDirFName(String value) {
        this.medicalDirFName = value;
    }

    /**
     * Gets the value of the medicalDirMName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedicalDirMName() {
        return medicalDirMName;
    }

    /**
     * Sets the value of the medicalDirMName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedicalDirMName(String value) {
        this.medicalDirMName = value;
    }

    /**
     * Gets the value of the medicalDirLName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedicalDirLName() {
        return medicalDirLName;
    }

    /**
     * Sets the value of the medicalDirLName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedicalDirLName(String value) {
        this.medicalDirLName = value;
    }

    /**
     * Gets the value of the medicalDirDegree property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedicalDirDegree() {
        return medicalDirDegree;
    }

    /**
     * Sets the value of the medicalDirDegree property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedicalDirDegree(String value) {
        this.medicalDirDegree = value;
    }

    /**
     * Gets the value of the mdAddr property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getMdAddr() {
        return mdAddr;
    }

    /**
     * Sets the value of the mdAddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setMdAddr(Address value) {
        this.mdAddr = value;
    }

    /**
     * Gets the value of the mdCliaNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMdCliaNum() {
        return mdCliaNum;
    }

    /**
     * Sets the value of the mdCliaNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMdCliaNum(String value) {
        this.mdCliaNum = value;
    }

}
