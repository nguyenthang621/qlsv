package com.qlsv.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data

public class Truong {

	@Id
	@Column(length = 20)
	private String maTruong;

	private String tenTruong;

	@OneToMany(mappedBy = "truong", cascade = CascadeType.ALL)
	private List<SinhVien> sinhViens;

}
