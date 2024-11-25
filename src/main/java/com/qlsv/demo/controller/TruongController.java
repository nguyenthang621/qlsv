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

import com.qlsv.demo.model.Truong;
import com.qlsv.demo.service.TruongService;

@Controller
@RequestMapping("/truong")
public class TruongController {

	@Autowired
	private TruongService truongService;

	// Danh sách trường
	@GetMapping
	public String listTruong(Model model) {
		List<Truong> truongList = truongService.findAll();
		model.addAttribute("truongList", truongList);
		return "truong/list";
	}

	// Hiển thị form thêm mới
	@GetMapping("/create")
	public String showCreateForm(Model model) {
		model.addAttribute("truong", new Truong());
		return "truong/form";
	}

	// Hiển thị form chỉnh sửa
	@GetMapping("/edit/{maTruong}")
	public String showEditForm(@PathVariable String maTruong, Model model) {
		Truong truong = truongService.findById(maTruong)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Truong ID: " + maTruong));
		model.addAttribute("truong", truong);
		return "truong/form";
	}

	// Lưu hoặc cập nhật thông tin trường
	@PostMapping("/save")
	public String saveTruong(@ModelAttribute Truong truong) {
		truongService.save(truong);
		return "redirect:/truong";
	}

	// Xóa trường
	@GetMapping("/delete/{maTruong}")
	public String deleteTruong(@PathVariable String maTruong) {
		truongService.deleteById(maTruong);
		return "redirect:/truong";
	}
}
