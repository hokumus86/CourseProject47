package com.hokumus.course.project.models.homeworks;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hokumus.course.project.models.base.BaseEntity;
import com.hokumus.course.project.models.management.Groups;
import com.hokumus.course.project.models.teacher.Teacher;
@Entity
@Table(name = "homeworks")
public class Odev extends BaseEntity {
	private Long id;
	private Groups groups;
	private Date bslngctarihi;
	private Date btstarihi;
	private String odev;
	

	@Id
	@SequenceGenerator(name = "seq_hmwrk", allocationSize = 1, sequenceName = "seq_hmwrk")
	@GeneratedValue(generator = "seq_hmwrk", strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name = "grup_id")
	public Groups getGroups() {
		return groups;
	}
	
	public void setGroups(Groups groups) {
		this.groups = groups;
	}
	@Column(name = "odev_baslangic", length = 50)
	public Date getBslngctarihi() {
		return bslngctarihi;
	}
	public void setBslngctarihi(Date bslngctarihi) {
		this.bslngctarihi = bslngctarihi;
	}
	@Column(name = "odev_bitis", length = 50)
	public Date getBtstarihi() {
		return btstarihi;
	}
	public void setBtstarihi(Date btstarihi) {
		this.btstarihi = btstarihi;
	}
	@Column(name = "odev_icerigi", length = 50)
	public String getOdev() {
		return odev;
	}
	public void setOdev(String odev) {
		this.odev = odev;
	}
	@Override
	public String toString() {
		return "Odev [id=" + id + ", groups=" + groups + ", bslngctarihi=" + bslngctarihi + ", btstarihi=" + btstarihi
				+ ", odev=" + odev + "]";
	}
	

}
