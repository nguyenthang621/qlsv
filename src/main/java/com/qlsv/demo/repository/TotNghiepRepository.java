package com.qlsv.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qlsv.demo.model.SinhVien;
import com.qlsv.demo.model.TotNghiep;

@Repository
public interface TotNghiepRepository extends JpaRepository<TotNghiep, Long> {

	List<TotNghiep> findByNgayTotNghiepAndTenCongTy(String ngayTotNghiep, String tenCongTy);

	List<TotNghiep> findByTenCongTy(String tenCongTy);

	List<TotNghiep> findByMaCongTy(String maCongTy);

	List<TotNghiep> findBySinhVien(SinhVien sinhVien);

	@Query("SELECT t FROM TotNghiep t " + "JOIN FETCH t.sinhVien s "
			+ "WHERE (:maCongTy IS NULL OR t.maCongTy LIKE CONCAT('%',:maCongTy,'%')) AND "
			+ "(:tenCongTy IS NULL OR t.tenCongTy LIKE CONCAT('%',:tenCongTy,'%')) AND "
			+ "(:chuyenNganh IS NULL OR t.chuyenNganh.tenNganh LIKE CONCAT('%',:chuyenNganh,'%')) AND "
			+ "(:ngayTotNghiep IS NULL OR FUNCTION('DATE', t.ngayTotNghiep) = FUNCTION('DATE', :ngayTotNghiep))")
	List<TotNghiep> searchTotNghiep(@Param("maCongTy") String maCongTy, @Param("tenCongTy") String tenCongTy,
			@Param("chuyenNganh") String chuyenNganh, @Param("ngayTotNghiep") LocalDate ngayTotNghiep);

}