package com.qlsv.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlsv.demo.model.Truong;

@Repository
public interface TruongRepository extends JpaRepository<Truong, String> {
	List<Truong> findByTenTruongContaining(String keyword);

	Truong findByMaTruong(String matruong);
}