//package com.idstar.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.Where;
//
//@Entity
//@Table(name = "barang")
//@Where(clause = "deleted_date is null")
//public class Barang implements Serializable {
//
//	@Id
//	@Column(name = "id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	@Column(name = "nama", nullable = false, length = 45)
//	private String nama;
//
//	@Column(name = "stok", nullable = false, length = 11)
//	private int stok;
//
//	@Column(name = "satuan", nullable = false, length = 45)
//	private String satuan;
//
//	@Column(name = "harga", nullable = false, length = 11)
//	private Double harga;
//}
