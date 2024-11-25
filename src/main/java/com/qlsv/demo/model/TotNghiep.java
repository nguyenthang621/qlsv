package com.qlsv.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
public class TotNghiep {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "sinhvien_id")
	private SinhVien sinhVien;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngayTotNghiep;

	@ManyToOne
	@JoinColumn(name = "nganh_id")
	private Nganh chuyenNganh;

	private String tenCongTy;
	private String maCongTy;
	private Integer thoiGianLamViec;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public SinhVien getSinhVien() {
		return sinhVien;
	}
	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}
	public LocalDate getNgayTotNghiep() {
		return ngayTotNghiep;
	}
	public void setNgayTotNghiep(LocalDate ngayTotNghiep) {
		this.ngayTotNghiep = ngayTotNghiep;
	}
	public Nganh getChuyenNganh() {
		return chuyenNganh;
	}
	public void setChuyenNganh(Nganh chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}
	public String getTenCongTy() {
		return tenCongTy;
	}
	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}
	public String getMaCongTy() {
		return maCongTy;
	}
	public void setMaCongTy(String maCongTy) {
		this.maCongTy = maCongTy;
	}
	public Integer getThoiGianLamViec() {
		return thoiGianLamViec;
	}
	public void setThoiGianLamViec(Integer thoiGianLamViec) {
		this.thoiGianLamViec = thoiGianLamViec;
	}

}
