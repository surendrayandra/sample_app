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
 * <p>Java class for SpecimenTestTextType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SpecimenTestTextType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DIAGNOSISVALUE"/>
 *     &lt;enumeration value="TESTCOMMENT"/>
 *     &lt;enumeration value="CUSTOMDIAGVALUE"/>
 *     &lt;enumeration value="INTENSITY"/>
 *     &lt;enumeration value="RESULTS"/>
 *     &lt;enumeration value="INTERPRATATION"/>
 *     &lt;enumeration value="METHDOLGYDISCLIMR"/>
 *     &lt;enumeration value="DISCLIMR"/>
 *     &lt;enumeration value="SLIDENUMBER"/>
 *     &lt;enumeration value="TESTGROUP"/>
 *     &lt;enumeration value="ISAUTOMATED"/>
 *     &lt;enumeration value="MICIHCCELLPOSITIVE"/>
 *     &lt;enumeration value="MICIHCLVLPOSITIVE"/>
 *     &lt;enumeration value="MICIHCLVLEXAMINED"/>
 *     &lt;enumeration value="DESCRIPTION"/>
 *     &lt;enumeration value="REFERENCELEVEL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SpecimenTestTextType")
@XmlEnum
public enum SpecimenTestTextType {

    DIAGNOSISVALUE,
    TESTCOMMENT,
    CUSTOMDIAGVALUE,
    INTENSITY,
    RESULTS,
    INTERPRATATION,
    METHDOLGYDISCLIMR,
    DISCLIMR,
    SLIDENUMBER,
    TESTGROUP,
    ISAUTOMATED,
    MICIHCCELLPOSITIVE,
    MICIHCLVLPOSITIVE,
    MICIHCLVLEXAMINED,
    DESCRIPTION,
    REFERENCELEVEL;

    public String value() {
        return name();
    }

    public static SpecimenTestTextType fromValue(String v) {
        return valueOf(v);
    }

}
