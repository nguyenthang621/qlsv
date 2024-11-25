package com.qlsv.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qlsv.demo.model.SinhVien;
import com.qlsv.demo.model.TotNghiep;
import com.qlsv.demo.service.NganhService;
import com.qlsv.demo.service.SinhVienService;
import com.qlsv.demo.service.TotNghiepService;
import com.qlsv.demo.service.TruongService;

@Controller
@RequestMapping("/sinhvien")
public class SinhVienController {

	@Autowired
	private SinhVienService sinhVienService;

	@Autowired
	private TruongService truongService;

	@Autowired
	private NganhService nganhService;

	@Autowired
	private TotNghiepService totNghiepService;

	@GetMapping("/create")
	public String newSinhVien(Model model) {
		model.addAttribute("sinhVien", new SinhVien());
		model.addAttribute("totNghiep", new TotNghiep());
		model.addAttribute("truongList", truongService.findAll());
		model.addAttribute("nganhList", nganhService.findAll());
		return "sinhvien/form";
	}

	@PostMapping("/save")
	public String saveSinhVien(@ModelAttribute SinhVien sinhVien, @ModelAttribute TotNghiep totNghiep) {
		sinhVienService.save(sinhVien);

		totNghiep.setSinhVien(sinhVien);
		totNghiepService.save(totNghiep);

		return "redirect:/sinhvien";
	}

	@GetMapping
	public String listSinhVien(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
		List<SinhVien> sinhVienList;
		if (keyword != null && !keyword.trim().isEmpty()) {
			sinhVienList = sinhVienService.searchByHoTen(keyword.trim());
		} else {
			sinhVienList = sinhVienService.findAll();
		}

		for (SinhVien sinhVien : sinhVienList) {
			totNghiepService.findBySinhVien(sinhVien);
		}

		model.addAttribute("sinhVienList", sinhVienList);
		model.addAttribute("keyword", keyword);
		return "sinhvien/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteSinhVien(@PathVariable Long id) {
		sinhVienService.deleteById(id);
		return "redirect:/sinhvien";
	}

	@GetMapping("/search")
	public List<TotNghiep> searchTotNghiep(@RequestParam(required = false) String chuyenNganh,
			@RequestParam(required = false) String tenCongTy, @RequestParam(required = false) String maCongTy) {

		if (tenCongTy != null) {
			return totNghiepService.searchByTenCongTy(tenCongTy);
		} else if (maCongTy != null) {
			return totNghiepService.searchByMaCongTy(maCongTy);
		} else {
			return totNghiepService.getAllTotNghiep();
		}
	}

}
