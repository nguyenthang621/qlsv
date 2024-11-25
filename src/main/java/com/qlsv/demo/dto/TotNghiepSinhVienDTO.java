package com.qlsv.demo.dto;

import java.time.LocalDate;

public class TotNghiepSinhVienDTO {
    private String maCongTy;
    private String tenCongTy;
    private LocalDate ngayTotNghiep;
    private String hoTen;
    private String email;
    private String chuyenNganh;  

    public TotNghiepSinhVienDTO(String maCongTy, String tenCongTy, LocalDate ngayTotNghiep, String hoTen, String email, String chuyenNganh) {
        this.maCongTy = maCongTy;
        this.tenCongTy = tenCongTy;
        this.ngayTotNghiep = ngayTotNghiep;
        this.hoTen = hoTen;
        this.email = email;
        this.chuyenNganh = chuyenNganh;
    }

    // Getters and setters
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

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }
}
