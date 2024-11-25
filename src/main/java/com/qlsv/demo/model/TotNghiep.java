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
@Data
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
	@JoinColumn(name = "chuyen_nganh_id")
	private Nganh chuyenNganh;

	private String tenCongTy;
	private String maCongTy;
	private Integer thoiGianLamViec;

}
