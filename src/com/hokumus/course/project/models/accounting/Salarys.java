package com.hokumus.course.project.models.accounting;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hokumus.course.project.models.base.BaseEntity;

@Entity
@Table(name = "salary")
public class Salarys extends BaseEntity {
	private Long id;
	private BigDecimal ogretmen_maas;
	private String ogretmen;
	private BigDecimal personel_maas;
	private String personel;
	private Date tarih2;
	
	
	
	@Id
	@SequenceGenerator(name = "seq_salary",allocationSize = 1,sequenceName = "seq_salary")
	@GeneratedValue(generator = "seq_salary",strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "teachers_salary",length = 50)
	public BigDecimal getOgretmen_maas() {
		return ogretmen_maas;
	}
	public void setOgretmen_maas(BigDecimal ogretmen_maas) {
		this.ogretmen_maas = ogretmen_maas;
	}
	@Column(name = "selected_teacher",length = 50)
	public String getOgretmen() {
		return ogretmen;
	}
	
	public void setOgretmen(String ogretmen) {
		this.ogretmen = ogretmen;
	}
	@Column(name = "employees_salary")
	public BigDecimal getPersonel_maas() {
		return personel_maas;
	}
	public void setPersonel_maas(BigDecimal personel_maas) {
		this.personel_maas = personel_maas;
	}
	@Column(name = "selected_employee")
	public String getPersonel() {
		return personel;
	}
	public void setPersonel(String personel) {
		this.personel = personel;
	}
	@Column(name = "date")
	public Date getTarih2() {
		return tarih2;
	}
	public void setTarih2(Date tarih2) {
		this.tarih2 = tarih2;
	}
	@Override
	public String toString() {
		return "Salarys [id=" + id + ", ogretmen_maas=" + ogretmen_maas + ", ogretmen=" + ogretmen + ", personel_maas="
				+ personel_maas + ", personel=" + personel + ", tarih2=" + tarih2 + "]";
	}
	
	
	
	

}
