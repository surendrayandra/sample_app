//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.04.29 at 06:09:43 PM IST 
//


package com.lca.ddt.delivery.report.inspire.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for signedByType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="signedByType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="degree" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{}nameType"/>
 *         &lt;element name="revision" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="revisionSequence" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="electronicSignature" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="dateTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="eSignatureComment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "signedByType", propOrder = {
    "degree",
    "name",
    "revision",
    "revisionSequence",
    "electronicSignature",
    "dateTime",
    "eSignatureComment"
})
public class SignedByType {

    @XmlElement(required = true)
    protected String degree;
    @XmlElement(required = true)
    protected NameType name;
    @XmlElement(required = true)
    protected String revision;
    @XmlElement(required = true)
    protected String revisionSequence;
    protected byte[] electronicSignature;
    @XmlElement(required = true)
    protected String dateTime;
    @XmlElement(required = true)
    protected String eSignatureComment;

    /**
     * Gets the value of the degree property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDegree() {
        return degree;
    }

    /**
     * Sets the value of the degree property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDegree(String value) {
        this.degree = value;
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
     * Gets the value of the revision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevision() {
        return revision;
    }

    /**
     * Sets the value of the revision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevision(String value) {
        this.revision = value;
    }

    /**
     * Gets the value of the revisionSequence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevisionSequence() {
        return revisionSequence;
    }

    /**
     * Sets the value of the revisionSequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevisionSequence(String value) {
        this.revisionSequence = value;
    }

    /**
     * Gets the value of the electronicSignature property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getElectronicSignature() {
        return electronicSignature;
    }

    /**
     * Sets the value of the electronicSignature property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setElectronicSignature(byte[] value) {
        this.electronicSignature = value;
    }

    /**
     * Gets the value of the dateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * Sets the value of the dateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateTime(String value) {
        this.dateTime = value;
    }

    /**
     * Gets the value of the eSignatureComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getESignatureComment() {
        return eSignatureComment;
    }

    /**
     * Sets the value of the eSignatureComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setESignatureComment(String value) {
        this.eSignatureComment = value;
    }

}
