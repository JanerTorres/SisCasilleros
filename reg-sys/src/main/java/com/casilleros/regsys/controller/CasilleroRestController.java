package com.casilleros.regsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casilleros.regsys.model.Casillero;
import com.casilleros.regsys.service.api.CasilleroServiceAPI;


@RestController
@RequestMapping(value = "/api/v1/")
@CrossOrigin("*")
public class CasilleroRestController {
	
	@Autowired
	private CasilleroServiceAPI casilleroServiceAPI;
	
	@GetMapping(value = "/all")
	public List<Casillero> getAll(){
		return casilleroServiceAPI.getAll();
	}
	
	@GetMapping(value = "/find/{id}")
	public Casillero find(@PathVariable String id) {
		return casilleroServiceAPI.get(id);
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<Casillero> save(@RequestBody Casillero casillero){
		Casillero obj = casilleroServiceAPI.save(casillero);
		return new ResponseEntity<Casillero>(obj, HttpStatus.OK);
	}
	
	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Casillero> delete(@PathVariable String id){
		Casillero casillero = casilleroServiceAPI.get(id);
		if(casillero != null) {
			casilleroServiceAPI.delete(id);
		}
		else {
			return new ResponseEntity<Casillero>(casillero, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Casillero>(casillero, HttpStatus.OK);
	}
	
}