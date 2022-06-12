package com.example.azcbarapp.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "Valute")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Valute  {

    @XmlAttribute(name = "Code")
    private String code;
    @XmlElement(name = "Nominal")
    private String nominal;
    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "Value")
    private BigDecimal value;
}
