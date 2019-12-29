package com.worldwidedev.donuts.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.worldwidedev.donuts.exceptions.DonutNotFoundException;
import com.worldwidedev.donuts.models.Donut;
import com.worldwidedev.donuts.repositories.DonutRepository;
@Service
public class DonutService {
	@Autowired
	private DonutRepository dRepo;
	
	private void validate(Donut donut) throws MethodArgumentNotValidException, NoSuchMethodException, SecurityException {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		SpringValidatorAdapter v = new SpringValidatorAdapter(validator);
		BeanPropertyBindingResult errors = new BeanPropertyBindingResult(donut, "donut");
		v.validate(donut, errors);
		if(errors.hasErrors()) {
			throw new MethodArgumentNotValidException(new MethodParameter(this.getClass().getDeclaredMethod("validate", Donut.class), 0), errors);
		}
//		Set<ConstraintViolation<Donut>> violations = validator.validate(donut);
//		if(!violations.isEmpty()) {
//			throw new ConstraintViolationException(violations);
//		}
	}
	
	public List<Donut> getDonuts() {
		return this.dRepo.findAll();
	}
	public Donut getDonut(Long id) {
		return this.dRepo.findById(id).orElseThrow(() -> new DonutNotFoundException(id));
	}
	
	public Donut updateDonut(Donut donut) {
		return this.dRepo.save(donut);
	}
	public Donut prepareUpdate(Long id, Map<String, Object> updates) throws MethodArgumentNotValidException, NoSuchMethodException, SecurityException {
		Donut d = this.dRepo.findById(id).orElseThrow(() -> new DonutNotFoundException(id));
		for (String key: updates.keySet()) {
			Object val = updates.get(key);
			switch(key) {
			case "name":
				d.setName((String)val);
				continue;
			case "description":
				d.setDescription((String)val);
				continue;
			}
		}
		this.validate(d);
		return d;
	}
	public void deleteDonut(Long id) {
		this.dRepo.deleteById(id);
	}
	public Donut createDonut(Donut donut) {
		return this.dRepo.save(donut);
	}
}
