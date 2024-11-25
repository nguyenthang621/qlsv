package com.qlsv.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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

	private LocalDate ngayTotNghiep;

	private String tenCongTy;
	private String maCongTy;
	private Integer thoiGianLamViec;

}
