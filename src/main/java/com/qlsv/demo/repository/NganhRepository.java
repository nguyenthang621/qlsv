package com.qlsv.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlsv.demo.model.Nganh;

@Repository
public interface NganhRepository extends JpaRepository<Nganh, Long> {
	List<Nganh> findByTenNganhContaining(String keyword);
}