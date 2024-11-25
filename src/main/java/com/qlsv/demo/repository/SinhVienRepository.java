package com.qlsv.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qlsv.demo.model.SinhVien;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Long> {
	@Query(value = "SELECT * FROM sinh_vien WHERE " + "ho_ten LIKE %:keyword% OR " + "email LIKE %:keyword% OR "
			+ "phone LIKE %:keyword% OR " + "dia_chi LIKE %:keyword% OR "
			+ "socmnd LIKE %:keyword%", nativeQuery = true)
	List<SinhVien> searchByKeyword(@Param("keyword") String keyword);

}
