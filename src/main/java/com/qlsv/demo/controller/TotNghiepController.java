package com.qlsv.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qlsv.demo.dto.TotNghiepSinhVienDTO;
import com.qlsv.demo.service.TotNghiepService;

@Controller
@RequestMapping("/totnghiep")
public class TotNghiepController {
	@Autowired
	private TotNghiepService totNghiepService;

	@RequestMapping("/search")
	public String showSearchForm() {
		return "timkiem/searchForm";
	}

	@GetMapping("/excute-search")
	public String searchTotNghiep(Model model, @RequestParam(value = "tenCongTy", required = false) String tenCongTy,
			@RequestParam(value = "maCongTy", required = false) String maCongTy,
			@RequestParam(value = "chuyenNganh", required = false) String chuyenNganh,
			@RequestParam(value = "ngayTotNghiep", required = false) String ngayTotNghiepStr) {

		LocalDate ngayTotNghiep = null;
		if (ngayTotNghiepStr != null && !ngayTotNghiepStr.isEmpty()) {
			ngayTotNghiep = LocalDate.parse(ngayTotNghiepStr);
		}

		List<TotNghiepSinhVienDTO> totNghieps = totNghiepService.searchTotNghiep(maCongTy, tenCongTy, chuyenNganh,
				ngayTotNghiep);
		System.out.println(totNghieps.toString());
		model.addAttribute("totNghieps", totNghieps);
		return "timkiem/searchResult";
	}

}
