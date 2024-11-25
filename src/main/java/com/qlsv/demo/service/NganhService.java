package com.qlsv.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlsv.demo.model.Nganh;
import com.qlsv.demo.repository.NganhRepository;

public interface NganhService {

	public List<Nganh> findAll();

	public List<Nganh> searchByTenNganh(String keyword);

	public Optional<Nganh> findById(Long id);

	public Nganh save(Nganh nganh);

	public void deleteById(Long id);

}

@Service
class NganhServiceIml implements NganhService {
	@Autowired
	private NganhRepository nganhRepository;

	public List<Nganh> findAll() {
		return nganhRepository.findAll();
	}

	public List<Nganh> searchByTenNganh(String keyword) {
		return nganhRepository.findByTenNganhContaining(keyword);
	}

	public Optional<Nganh> findById(Long id) {
		return nganhRepository.findById(id);
	}

	public Nganh save(Nganh nganh) {
		return nganhRepository.save(nganh);
	}

	public void deleteById(Long id) {
		nganhRepository.deleteById(id);
	}
}