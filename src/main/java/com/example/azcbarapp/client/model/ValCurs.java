package com.example.azcbarapp.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.tomcat.jni.Local;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ValCurs implements Serializable {
    @XmlAttribute(name = "Date")
    public LocalDate date;
    @XmlAttribute(name = "Name")
    public String Name;
    @XmlAttribute(name = "Description")
    public String Description;

    public List<ValType> ValType;
}
