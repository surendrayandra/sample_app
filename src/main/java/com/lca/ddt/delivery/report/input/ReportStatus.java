//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.05.30 at 03:09:20 PM IST 
//


package com.lca.ddt.delivery.report.input;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReportStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ADDENDED"/>
 *     &lt;enumeration value="AMENDED"/>
 *     &lt;enumeration value="CORRECTED"/>
 *     &lt;enumeration value="FINAL"/>
 *     &lt;enumeration value="OPEN"/>
 *     &lt;enumeration value="REVISE"/>
 *     &lt;enumeration value="WAIVED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReportStatus")
@XmlEnum
public enum ReportStatus {

    ADDENDED,
    AMENDED,
    CORRECTED,
    FINAL,
    OPEN,
    REVISE,
    WAIVED;

    public String value() {
        return name();
    }

    public static ReportStatus fromValue(String v) {
        return valueOf(v);
    }

}
