package com.qlsv.demo.dto;

import java.time.LocalDate;

public class TotNghiepSinhVienDTO {

	private String maCongTy;
	private String tenCongTy;
	private LocalDate ngayTotNghiep;
	private String hoTenSinhVien;
	private String emailSinhVien;

	// Constructor
	public TotNghiepSinhVienDTO(String maCongTy, String tenCongTy, LocalDate ngayTotNghiep, String hoTenSinhVien,
			String emailSinhVien) {
		this.maCongTy = maCongTy;
		this.tenCongTy = tenCongTy;
		this.ngayTotNghiep = ngayTotNghiep;
		this.hoTenSinhVien = hoTenSinhVien;
		this.emailSinhVien = emailSinhVien;
	}

	// Getters và Setters
	public String getMaCongTy() {
		return maCongTy;
	}

	public void setMaCongTy(String maCongTy) {
		this.maCongTy = maCongTy;
	}

	public String getTenCongTy() {
		return tenCongTy;
	}

	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}

	public LocalDate getNgayTotNghiep() {
		return ngayTotNghiep;
	}

	public void setNgayTotNghiep(LocalDate ngayTotNghiep) {
		this.ngayTotNghiep = ngayTotNghiep;
	}

	public String getHoTenSinhVien() {
		return hoTenSinhVien;
	}

	public void setHoTenSinhVien(String hoTenSinhVien) {
		this.hoTenSinhVien = hoTenSinhVien;
	}

	public String getEmailSinhVien() {
		return emailSinhVien;
	}

	public void setEmailSinhVien(String emailSinhVien) {
		this.emailSinhVien = emailSinhVien;
	}
}
