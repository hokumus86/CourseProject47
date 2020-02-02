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
public class Salary extends BaseEntity {
	private Long id;
	private String ogretmen_maas;
	private String ogretmen_sec;
	private BigDecimal personel_maas;
	private String personel_sec;
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
	public String getOgretmen_maas() {
		return ogretmen_maas;
	}
	public void setOgretmen_maas(String ogretmen_maas) {
		this.ogretmen_maas = ogretmen_maas;
	}
	@Column(name = "selected_teacher",length = 50)
	public String getOgretmen_sec() {
		return ogretmen_sec;
	}
	public void setOgretmen_sec(String ogretmen_sec) {
		this.ogretmen_sec = ogretmen_sec;
	}
	@Column(name = "employees_salary")
	public BigDecimal getPersonel_maas() {
		return personel_maas;
	}
	public void setPersonel_maas(BigDecimal personel_maas) {
		this.personel_maas = personel_maas;
	}
	@Column(name = "selected_employee")
	public String getPersonel_sec() {
		return personel_sec;
	}
	public void setPersonel_sec(String personel_sec) {
		this.personel_sec = personel_sec;
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
		return "Salary [id=" + id + ", ogretmen_maas=" + ogretmen_maas + ", ogretmen_sec=" + ogretmen_sec
				+ ", personel_maas=" + personel_maas + ", personel_sec=" + personel_sec + ", tarih2=" + tarih2 + "]";
	}
	
	
	

}
