package com.qlsv.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlsv.demo.model.SinhVien;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Long> {
	List<SinhVien> findByHoTenContaining(String keyword);
}