package com.casilleros.regsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.casilleros.regsys.model.Casillero;
import com.casilleros.regsys.service.api.CasilleroServiceAPI;

@Controller
public class CasilleroController {
	
	@Autowired
	private CasilleroServiceAPI casilleroServiceAPI;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", casilleroServiceAPI.getAll());
		return "index";
	}
	
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") String id, Model model) {
		if(id != null && Integer.parseInt(id) != 0){
			model.addAttribute("casillero", casilleroServiceAPI.get(id));
		}else {
			model.addAttribute("casillero", new Casillero());
		}
		return "save";
	}
	
	@PostMapping("/save")
	public String save(Casillero casillero, Model model) {
		casilleroServiceAPI.save(casillero);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id, Model model) {
		casilleroServiceAPI.delete(id);
		return "redirect:/";
	}
	
	
}

