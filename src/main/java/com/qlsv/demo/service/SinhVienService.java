package com.qlsv.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlsv.demo.model.SinhVien;
import com.qlsv.demo.repository.SinhVienRepository;

public interface SinhVienService {

	public List<SinhVien> findAll();

	public Optional<SinhVien> findById(Long id);

	public List<SinhVien> searchByHoTen(String keyword);

	public SinhVien save(SinhVien sinhVien);

	public void deleteById(Long id);

}

@Service
class SinhVienServiceIml implements SinhVienService {
	@Autowired
	private SinhVienRepository sinhVienRepository;

	public List<SinhVien> findAll() {
		return sinhVienRepository.findAll();
	}

	public Optional<SinhVien> findById(Long id) {
		return sinhVienRepository.findById(id);
	}

	public List<SinhVien> searchByHoTen(String keyword) {
		return sinhVienRepository.searchByKeyword(keyword);
	}

	public SinhVien save(SinhVien sinhVien) {
		return sinhVienRepository.save(sinhVien);
	}

	public void deleteById(Long id) {
		sinhVienRepository.deleteById(id);
	}

}