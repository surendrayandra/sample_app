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
 * <p>Java class for PathwaysSlideStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PathwaysSlideStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="caseNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="slideId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="thumbnail" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="legacyTestCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PathwaysSlideStatus", propOrder = {
    "caseNum",
    "slideId",
    "status",
    "thumbnail",
    "legacyTestCode"
})
public class PathwaysSlideStatus {

    protected String caseNum;
    protected String slideId;
    protected String status;
    protected byte[] thumbnail;
    protected String legacyTestCode;

    /**
     * Gets the value of the caseNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseNum() {
        return caseNum;
    }

    /**
     * Sets the value of the caseNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseNum(String value) {
        this.caseNum = value;
    }

    /**
     * Gets the value of the slideId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSlideId() {
        return slideId;
    }

    /**
     * Sets the value of the slideId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSlideId(String value) {
        this.slideId = value;
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
     * Gets the value of the thumbnail property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getThumbnail() {
        return thumbnail;
    }

    /**
     * Sets the value of the thumbnail property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setThumbnail(byte[] value) {
        this.thumbnail = value;
    }

    /**
     * Gets the value of the legacyTestCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegacyTestCode() {
        return legacyTestCode;
    }

    /**
     * Sets the value of the legacyTestCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegacyTestCode(String value) {
        this.legacyTestCode = value;
    }

}
