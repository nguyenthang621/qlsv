package com.qlsv.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlsv.demo.model.TotNghiep;

@Repository
public interface TotNghiepRepository extends JpaRepository<TotNghiep, Long> {
}