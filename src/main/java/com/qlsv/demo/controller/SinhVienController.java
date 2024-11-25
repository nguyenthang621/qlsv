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
import com.qlsv.demo.service.NganhService;
import com.qlsv.demo.service.SinhVienService;
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

	// Danh sách sinh viên + tìm kiếm
	@GetMapping
	public String listSinhVien(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
		List<SinhVien> sinhVienList;
		if (keyword != null && !keyword.isEmpty()) {
			sinhVienList = sinhVienService.searchByHoTen(keyword);
		} else {
			sinhVienList = sinhVienService.findAll();
		}
		model.addAttribute("sinhVienList", sinhVienList);
		model.addAttribute("keyword", keyword);
		return "sinhvien/list";
	}

	// Hiển thị form thêm sinh viên
	@GetMapping("/create")
	public String showCreateForm(Model model) {
		model.addAttribute("sinhVien", new SinhVien());
		model.addAttribute("truongList", truongService.findAll());
		model.addAttribute("nganhList", nganhService.findAll());
		return "sinhvien/form";
	}

	// Hiển thị form chỉnh sửa sinh viên
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		SinhVien sinhVien = sinhVienService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid SinhVien ID: " + id));
		model.addAttribute("sinhVien", sinhVien);
		model.addAttribute("truongList", truongService.findAll());
		model.addAttribute("nganhList", nganhService.findAll());
		return "sinhvien/form";
	}

	// Lưu hoặc cập nhật sinh viên
	@PostMapping("/save")
	public String saveSinhVien(@ModelAttribute SinhVien sinhVien) {
		sinhVienService.save(sinhVien);
		return "redirect:/sinhvien";
	}

	// Xóa sinh viên
	@GetMapping("/delete/{id}")
	public String deleteSinhVien(@PathVariable Long id) {
		sinhVienService.deleteById(id);
		return "redirect:/sinhvien";
	}
}
