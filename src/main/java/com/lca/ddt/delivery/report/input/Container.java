//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.05.30 at 03:09:20 PM IST 
//


package com.lca.ddt.delivery.report.input;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Container complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Container">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="containerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="containerTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="externalId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parentContainer" type="{http://www.labcorp.com/iris/messages}ParentContainer" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uomCode" type="{http://www.labcorp.com/iris/messages}UnitOfMeasure" minOccurs="0"/>
 *         &lt;element name="usedForTest" type="{http://www.labcorp.com/iris/messages}SpecimenTest" minOccurs="0"/>
 *         &lt;element name="volume" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Container", propOrder = {
    "id",
    "containerId",
    "containerTypeCd",
    "externalId",
    "parentContainer",
    "status",
    "uomCode",
    "usedForTest",
    "volume"
})
public class Container {

    protected Integer id;
    protected String containerId;
    @XmlElement(required = true)
    protected String containerTypeCd;
    protected String externalId;
    protected ParentContainer parentContainer;
    protected String status;
    @XmlSchemaType(name = "string")
    protected UnitOfMeasure uomCode;
    protected SpecimenTest usedForTest;
    protected Double volume;

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
     * Gets the value of the containerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContainerId() {
        return containerId;
    }

    /**
     * Sets the value of the containerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContainerId(String value) {
        this.containerId = value;
    }

    /**
     * Gets the value of the containerTypeCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContainerTypeCd() {
        return containerTypeCd;
    }

    /**
     * Sets the value of the containerTypeCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContainerTypeCd(String value) {
        this.containerTypeCd = value;
    }

    /**
     * Gets the value of the externalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalId() {
        return externalId;
    }

    /**
     * Sets the value of the externalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalId(String value) {
        this.externalId = value;
    }

    /**
     * Gets the value of the parentContainer property.
     * 
     * @return
     *     possible object is
     *     {@link ParentContainer }
     *     
     */
    public ParentContainer getParentContainer() {
        return parentContainer;
    }

    /**
     * Sets the value of the parentContainer property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParentContainer }
     *     
     */
    public void setParentContainer(ParentContainer value) {
        this.parentContainer = value;
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
     * Gets the value of the uomCode property.
     * 
     * @return
     *     possible object is
     *     {@link UnitOfMeasure }
     *     
     */
    public UnitOfMeasure getUomCode() {
        return uomCode;
    }

    /**
     * Sets the value of the uomCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitOfMeasure }
     *     
     */
    public void setUomCode(UnitOfMeasure value) {
        this.uomCode = value;
    }

    /**
     * Gets the value of the usedForTest property.
     * 
     * @return
     *     possible object is
     *     {@link SpecimenTest }
     *     
     */
    public SpecimenTest getUsedForTest() {
        return usedForTest;
    }

    /**
     * Sets the value of the usedForTest property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecimenTest }
     *     
     */
    public void setUsedForTest(SpecimenTest value) {
        this.usedForTest = value;
    }

    /**
     * Gets the value of the volume property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getVolume() {
        return volume;
    }

    /**
     * Sets the value of the volume property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setVolume(Double value) {
        this.volume = value;
    }

}
