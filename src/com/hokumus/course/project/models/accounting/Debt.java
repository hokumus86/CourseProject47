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
@Table(name = "debt")
public class Debt extends BaseEntity{
	private Long id;
	private String ad;
	private String soyad;
	private BigDecimal alinan;
	private BigDecimal kalan;
	private Date tarih1;
	
	@Id
	@SequenceGenerator(name = "seq_debt",allocationSize = 1,sequenceName = "seq_debt")
	@GeneratedValue(generator = "seq_debt",strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "name",length = 50)
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	@Column(name = "surname",length = 50)
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	@Column(name = "received")
	public BigDecimal getAlinan() {
		return alinan;
	}
	public void setAlinan(BigDecimal alinan) {
		this.alinan = alinan;
	}
	@Column(name = "remaining")
	public BigDecimal getKalan() {
		return kalan;
	}
	public void setKalan(BigDecimal kalan) {
		this.kalan = kalan;
	}
	public Date getTarih1() {
		return tarih1;
	}
	public void setTarih1(Date tarih1) {
		this.tarih1 = tarih1;
	}
	@Override
	public String toString() {
		return "Debt [id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", alinan=" + alinan + ", kalan=" + kalan
				+ ", tarih1=" + tarih1 + "]";
	}
	
	
	

	
	
	

}
