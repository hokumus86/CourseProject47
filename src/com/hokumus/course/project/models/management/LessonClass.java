package com.hokumus.course.project.models.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hokumus.course.project.models.base.BaseEntity;

@Entity
@Table(name = "room")
public class LessonClass extends BaseEntity{

    private Long id;
    private String adi;
    private String kod;
    private int kapasite;

    @Id
    @SequenceGenerator(name = "seq_room", allocationSize = 1, sequenceName = "seq_room")
    @GeneratedValue(generator = "seq_room", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", length = 50)
    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    @Column(name = "capacity")
    public int getKapasite() {
        return kapasite;
    }

    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
    }

    @Column(name = "room_code", length = 20)
    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }
    
    @Override
    public String toString() {
    	return id+"-" + adi;
    }

}

