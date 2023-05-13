package com.idstar.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "karyawan")
public class Karyawan extends BaseObject {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
   
    @Column(name = "nama")
    private String nama;

    @Column(name = "dob")
    private Date dob;
    
    @Column(name = "alamat")
    private String alamat;
    
    @Column(name = "status")
    private String status;
    
    @OneToOne
    @JoinColumn(name = "detail_karyawan", referencedColumnName = "id")
    private DetailKaryawan detailKaryawan;
}
