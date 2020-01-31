package com.hokumus.course.project.models.accounting;

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
	
	private long id;
	private byte faturalar;
	
	@Id
	@SequenceGenerator(name = "seq_bill",allocationSize = 1,sequenceName = "seq_bill")
	@GeneratedValue(generator = "seq_bill",strategy = GenerationType.SEQUENCE)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "bills")
	public byte getFaturalar() {
		return faturalar;
	}
	public void setFaturalar(byte faturalar) {
		this.faturalar = faturalar;
	}
	@Override
	public String toString() {
		return "Bill [id=" + id + ", faturalar=" + faturalar + "]";
	}

}
