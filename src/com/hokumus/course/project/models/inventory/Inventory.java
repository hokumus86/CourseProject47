package com.hokumus.course.project.models.inventory;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "inventory")
public class Inventory {

    private Long id;
    private String tanim;
    private BigDecimal garanti;
    private Date garantiBaslamaTarihi;
    private Date garantiBitisTarihi;
    private String expenses;
    private String Kullaným;

   
	

	

	@Id
    @SequenceGenerator(name = "seq_inventory", allocationSize = 1, sequenceName = "seq_inventory")
    @GeneratedValue(generator = "seq_inventory", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "caption", length = 100)
    public String getTanim() {
        return tanim;
    }

    public void setTanim(String tanim) {
        this.tanim = tanim;
    }

    @Column(name = "warranty")
    public BigDecimal getGaranti() {
        return garanti;
    }

    public void setGaranti(BigDecimal garanti) {
        this.garanti = garanti;
    }

    @Column(name = "warranty_start_date")
    public Date getGarantiBaslamaTarihi() {
        return garantiBaslamaTarihi;
    }

    public void setGarantiBaslamaTarihi(Date garantiBaslamaTarihi) {
        this.garantiBaslamaTarihi = garantiBaslamaTarihi;
    }

    @Column(name = "warranty_end_date")
    public Date getGarantiBitisTarihi() {
        return garantiBitisTarihi;
    }

    public void setGarantiBitisTarihi(Date garantiBitisTarihi) {
        this.garantiBitisTarihi = garantiBitisTarihi;
    }
    
    @Column(name = "Place Of Use")
    public String getKullaným() {
		return Kullaným;
	}

	public void setKullaným(String kullaným) {
		Kullaným = kullaným;
	}

    @ManyToOne
    @JoinColumn(name = "exspense_id")
    public String getExpenses() {
		return expenses;
	}

	public void setExpenses(String expenses) {
		this.expenses = expenses;
	}
  

    @Override
    public String toString() {
        return  "tanimi = "+tanim+ " id = "+id;
    }
    

}

