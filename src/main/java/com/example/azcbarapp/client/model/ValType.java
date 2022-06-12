package com.example.azcbarapp.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "ValType")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ValType  {

    @XmlAttribute(name = "Type")
    private String type;

    public List<Valute> Valute;
}
