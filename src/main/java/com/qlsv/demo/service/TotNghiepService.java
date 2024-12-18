package com.qlsv.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlsv.demo.dto.TotNghiepSinhVienDTO;
import com.qlsv.demo.model.SinhVien;
import com.qlsv.demo.model.TotNghiep;
import com.qlsv.demo.repository.TotNghiepRepository;

public interface TotNghiepService {
	public List<TotNghiep> findAll();

	public Optional<TotNghiep> findById(Long id);

	public TotNghiep save(TotNghiep totNghiep);

	public void deleteById(Long id);

	public boolean existsBySinhVienId(Long sinhVienId);

	public List<TotNghiep> findBySinhVien(SinhVien sinhVien);



	public List<TotNghiepSinhVienDTO> searchTotNghiep(String maCongTy, String tenCongTy, String chuyenNganh,
			LocalDate ngayTotNghiep);

}

@Service
class TotNghiepServiceImp implements TotNghiepService {

	@Autowired
	private TotNghiepRepository totNghiepRepository;

	public List<TotNghiep> findAll() {
		return totNghiepRepository.findAll();
	}

	public Optional<TotNghiep> findById(Long id) {
		return totNghiepRepository.findById(id);
	}

	public TotNghiep save(TotNghiep totNghiep) {
		return totNghiepRepository.save(totNghiep);
	}

	public void deleteById(Long id) {
		totNghiepRepository.deleteById(id);
	}

	public boolean existsBySinhVienId(Long sinhVienId) {
		return totNghiepRepository.existsById(sinhVienId);
	}



	public List<TotNghiep> findBySinhVien(SinhVien sinhVien) {
		return totNghiepRepository.findBySinhVien(sinhVien);
	}

	public List<TotNghiepSinhVienDTO> searchTotNghiep(String maCongTy, String tenCongTy, String chuyenNganh,
			LocalDate ngayTotNghiep) {
		return totNghiepRepository.searchTotNghiep(maCongTy, tenCongTy, chuyenNganh, ngayTotNghiep);
	}

}
