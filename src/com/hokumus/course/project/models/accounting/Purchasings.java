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
@Table(name = "purchasing")
public class Purchasings extends BaseEntity {
	private long id;
	private String malzeme;
	private BigDecimal fiyat;
	private Date tarih;
	
	@Id
	@SequenceGenerator(name = "seq_purchasing",allocationSize = 1,sequenceName = "seq_purchasing")
	@GeneratedValue(generator = "seq_purchasing",strategy = GenerationType.SEQUENCE)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "material",length = 50)
	public String getMalzeme() {
		return malzeme;
	}
	public void setMalzeme(String malzeme) {
		this.malzeme = malzeme;
	}
	@Column(name = "price")
	public BigDecimal getFiyat() {
		return fiyat;
	}
	public void setFiyat(BigDecimal fiyat) {
		this.fiyat = fiyat;
	}
	@Column(name = "date")
	public Date getTarih() {
		return tarih;
	}
	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
	
	@Override
	public String toString() {
		return "Purchasing [id=" + id + ", malzeme=" + malzeme + ", fiyat=" + fiyat + ", tarih=" + tarih + "]";
	}
	
	
	
	
	
	

}
