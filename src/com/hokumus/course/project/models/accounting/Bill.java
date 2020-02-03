package com.hokumus.course.project.models.accounting;

import java.util.Arrays;
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
@Table(name = "bill")
public class Bill extends BaseEntity {
	
	private Long id;
	private byte[] faturalar;
	private Date tarih;
	
	@Id
	@SequenceGenerator(name = "seq_bill",allocationSize = 1,sequenceName = "seq_bill")
	@GeneratedValue(generator = "seq_bill",strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "bills")
	public byte[] getFaturalar() {
		return faturalar;
	}
	public void setFaturalar(byte[] faturalar) {
		this.faturalar = faturalar;
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
		return "Bill [id=" + id + ", faturalar=" + Arrays.toString(faturalar) + ", tarih=" + tarih + "]";
	}
	
	

}
