package com.qlsv.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
public class Nganh {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String tenNganh;

	@OneToMany(mappedBy = "nganh", cascade = CascadeType.ALL)
	private List<SinhVien> sinhViens;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTenNganh() {
		return tenNganh;
	}

	public void setTenNganh(String tenNganh) {
		this.tenNganh = tenNganh;
	}

	public List<SinhVien> getSinhViens() {
		return sinhViens;
	}

	public void setSinhViens(List<SinhVien> sinhViens) {
		this.sinhViens = sinhViens;
	}

}
