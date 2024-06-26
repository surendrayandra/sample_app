//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.05.30 at 03:09:20 PM IST 
//


package com.lca.ddt.delivery.report.input;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResultType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ResultType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DISCLIMR"/>
 *     &lt;enumeration value="DISCLIMER1"/>
 *     &lt;enumeration value="DISCLIMER2"/>
 *     &lt;enumeration value="DISCLIMER3"/>
 *     &lt;enumeration value="DISCLIMRPHONE"/>
 *     &lt;enumeration value="BOOLEAN"/>
 *     &lt;enumeration value="CELLSPERUL"/>
 *     &lt;enumeration value="PERCENTAGE"/>
 *     &lt;enumeration value="STRING"/>
 *     &lt;enumeration value="TEXT"/>
 *     &lt;enumeration value="LITERAL"/>
 *     &lt;enumeration value="NUMERIC"/>
 *     &lt;enumeration value="FINDINGS"/>
 *     &lt;enumeration value="RATIO"/>
 *     &lt;enumeration value="REFERENCERANGE"/>
 *     &lt;enumeration value="PDF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ResultType")
@XmlEnum
public enum ResultType {

    DISCLIMR("DISCLIMR"),
    @XmlEnumValue("DISCLIMER1")
    DISCLIMER_1("DISCLIMER1"),
    @XmlEnumValue("DISCLIMER2")
    DISCLIMER_2("DISCLIMER2"),
    @XmlEnumValue("DISCLIMER3")
    DISCLIMER_3("DISCLIMER3"),
    DISCLIMRPHONE("DISCLIMRPHONE"),
    BOOLEAN("BOOLEAN"),
    CELLSPERUL("CELLSPERUL"),
    PERCENTAGE("PERCENTAGE"),
    STRING("STRING"),
    TEXT("TEXT"),
    LITERAL("LITERAL"),
    NUMERIC("NUMERIC"),
    FINDINGS("FINDINGS"),
    RATIO("RATIO"),
    REFERENCERANGE("REFERENCERANGE"),
    PDF("PDF");
    private final String value;

    ResultType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ResultType fromValue(String v) {
        for (ResultType c: ResultType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
