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
@Table(name = "income")
public class Incomings extends BaseEntity{

    private Long id;
    private IncomeType tanim;
    private BigDecimal miktar;
    private Date tarih;
//    private StudentPayments StudentPayments;

    @Id
    @SequenceGenerator(name = "seq_income", allocationSize = 1, sequenceName = "seq_income")
    @GeneratedValue(generator = "seq_income", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "subject",length = 100)
    public IncomeType getTanim() {
		return tanim;
	}

	public void setTanim(IncomeType tanim) {
		this.tanim = tanim;
	}
    
    
    @Column(name = "quantity",precision = 14,scale = 2)
    public BigDecimal getMiktar() {
        return miktar;
    }

	public void setMiktar(BigDecimal miktar) {
        this.miktar = miktar;
    }

    @Column(name = "date")
    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

//    @ManyToOne
//    @JoinColumn(name = "student_payment_id")
//    public StudentPayments getStudentPayments() {
//        return StudentPayments;
//    }
//
//    public void setStudentPayments(StudentPayments StudentPayments) {
//        this.StudentPayments = StudentPayments;
//    }


    @Override
	public String toString() {
		return "Incomings [id=" + id + ", tanim=" + tanim + ", miktar=" + miktar + ", tarih=" + tarih + "]";
	}
    

    
       
}

