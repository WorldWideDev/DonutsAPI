package com.worldwidedev.donuts.controllers;

import java.net.URI;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.worldwidedev.donuts.models.Donut;
import com.worldwidedev.donuts.services.DonutService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {
	@Autowired
	private DonutService dService;
	
	
	@GetMapping("/")
	@ResponseBody
	public List<Donut> index() {
		return this.dService.getDonuts();
	}
	@PostMapping("/")
	public Donut create(@Valid @RequestBody Donut donut) {
		return this.dService.createDonut(donut);
	}
	@GetMapping("/{id}")
	public Donut show(@PathVariable("id") Long id) {
		return this.dService.getDonut(id);
		
	}
	@PatchMapping("/{id}")
	public Donut update(@RequestBody Map<String, Object> updates, @PathVariable("id") Long id) throws MethodArgumentNotValidException, NoSuchMethodException, SecurityException {
		Donut toUpdate;
		toUpdate = this.dService.prepareUpdate(id, updates);
		return this.dService.updateDonut(toUpdate);
		// TODO: Validate toUpdate, make sure proper exceptions are triggered
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.dService.deleteDonut(id);
	}
}
