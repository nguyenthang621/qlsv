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

import com.qlsv.demo.model.Nganh;
import com.qlsv.demo.service.NganhService;

@Controller
@RequestMapping("/nganh")
public class NganhController {
	@Autowired
	private NganhService nganhService;

	@GetMapping
	public String listNganh(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
		List<Nganh> nganhList;
		if (keyword != null)
			nganhList = (List<Nganh>) nganhService.searchByTenNganh(keyword);
		else
			nganhList = nganhService.findAll();
		model.addAttribute("nganhList", nganhList);
		model.addAttribute("keyword", keyword);
		return "nganh/list";
	}

	@GetMapping("/create")
	public String showCreateForm(Model model) {
		System.err.println(new Nganh());
		model.addAttribute("nganh", new Nganh());
		return "nganh/form";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		Nganh nganh = nganhService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Nganh ID: " + id));
		model.addAttribute("nganh", nganh);
		return "nganh/form";
	}

	@PostMapping("/save")
	public String saveNganh(@ModelAttribute Nganh nganh) {
		nganhService.save(nganh);
		return "redirect:/nganh";
	}

	@GetMapping("/delete/{id}")
	public String deleteNganh(@PathVariable Long id) {
		nganhService.deleteById(id);
		return "redirect:/nganh";
	}
}
