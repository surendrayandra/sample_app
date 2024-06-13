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
 * <p>Java class for Image complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Image">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="imageCaption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="imageComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="imageValue" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="imageInd" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="seqNum" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Image", propOrder = {
    "id",
    "imageCaption",
    "imageComment",
    "imageValue",
    "imageInd",
    "seqNum"
})
public class Image {

    protected Integer id;
    protected String imageCaption;
    protected String imageComment;
    protected byte[] imageValue;
    protected Integer imageInd;
    protected Integer seqNum;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the imageCaption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageCaption() {
        return imageCaption;
    }

    /**
     * Sets the value of the imageCaption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageCaption(String value) {
        this.imageCaption = value;
    }

    /**
     * Gets the value of the imageComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageComment() {
        return imageComment;
    }

    /**
     * Sets the value of the imageComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageComment(String value) {
        this.imageComment = value;
    }

    /**
     * Gets the value of the imageValue property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getImageValue() {
        return imageValue;
    }

    /**
     * Sets the value of the imageValue property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setImageValue(byte[] value) {
        this.imageValue = value;
    }

    /**
     * Gets the value of the imageInd property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getImageInd() {
        return imageInd;
    }

    /**
     * Sets the value of the imageInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setImageInd(Integer value) {
        this.imageInd = value;
    }

    /**
     * Gets the value of the seqNum property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSeqNum() {
        return seqNum;
    }

    /**
     * Sets the value of the seqNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSeqNum(Integer value) {
        this.seqNum = value;
    }

}
