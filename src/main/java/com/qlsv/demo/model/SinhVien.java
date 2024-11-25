package com.qlsv.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class SinhVien {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String hoTen;
	private String email;
	private String phone;
	private String diaChi;
	private String soCMND;

	@ManyToOne
	@JoinColumn(name = "maTruong", referencedColumnName = "maTruong")
	private Truong truong;

	@ManyToOne
	@JoinColumn(name = "nganh_id", referencedColumnName = "id")
	private Nganh nganh;

}