package com.qlsv.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qlsv.demo.dto.TotNghiepSinhVienDTO;
import com.qlsv.demo.model.SinhVien;
import com.qlsv.demo.model.TotNghiep;

@Repository
public interface TotNghiepRepository extends JpaRepository<TotNghiep, Long> {

	List<TotNghiep> findByNgayTotNghiepAndTenCongTy(String ngayTotNghiep, String tenCongTy);

	List<TotNghiep> findByTenCongTy(String tenCongTy);

	List<TotNghiep> findByMaCongTy(String maCongTy);

	List<TotNghiep> findBySinhVien(SinhVien sinhVien);

	@Query("SELECT new com.qlsv.demo.dto.TotNghiepSinhVienDTO( "
		       + "t.maCongTy, t.tenCongTy, t.ngayTotNghiep, s.hoTen, s.email, "
		       + "t.chuyenNganh.tenNganh) "  // Lấy tên ngành từ đối tượng chuyenNganh
		       + "FROM TotNghiep t "
		       + "JOIN t.sinhVien s "
		       + "LEFT JOIN t.chuyenNganh c "  // Thêm LEFT JOIN nếu chuyenNganh là một đối tượng
		       + "WHERE (:maCongTy IS NULL OR t.maCongTy LIKE CONCAT('%', :maCongTy, '%')) "
		       + "AND (:tenCongTy IS NULL OR t.tenCongTy LIKE CONCAT('%', :tenCongTy, '%')) "
		       + "AND (:chuyenNganh IS NULL OR t.chuyenNganh.tenNganh LIKE CONCAT('%', :chuyenNganh, '%')) "
		       + "AND (:ngayTotNghiep IS NULL OR t.ngayTotNghiep = :ngayTotNghiep)")
		List<TotNghiepSinhVienDTO> searchTotNghiep(
		       @Param("maCongTy") String maCongTy,
		       @Param("tenCongTy") String tenCongTy,
		       @Param("chuyenNganh") String chuyenNganh,
		       @Param("ngayTotNghiep") LocalDate ngayTotNghiep);


}