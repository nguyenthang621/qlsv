package com.qlsv.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlsv.demo.model.Truong;
import com.qlsv.demo.repository.TruongRepository;

public interface TruongService {

	public List<Truong> findAll();

	public List<Truong> searchByTenTruong(String keyword);

	public Optional<Truong> findById(String id);

	public Truong save(Truong truong);

	public void deleteById(String id);

}

@Service
class TruongServiceIml implements TruongService {
	@Autowired
	private TruongRepository truongRepository;

	public List<Truong> findAll() {
		return truongRepository.findAll();
	}

	public List<Truong> searchByTenTruong(String keyword) {
		return truongRepository.findByTenTruongContaining(keyword);
	}

	public Optional<Truong> findById(String id) {
		return truongRepository.findById(id);
	}

	public Truong save(Truong truong) {
		return truongRepository.save(truong);
	}

	public void deleteById(String id) {
		truongRepository.deleteById(id);
	}

}