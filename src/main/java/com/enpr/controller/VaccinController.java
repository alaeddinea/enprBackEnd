package com.enpr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.enpr.dao.VaccinRepository;
import com.enpr.model.ApiResponse;

import com.enpr.model.Vaccin;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/vaccin")
public class VaccinController {
	@Autowired
	private VaccinRepository vaccinRepository   ;

	@GetMapping("/all")
	public ApiResponse<List<Vaccin>> listConge() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Conge  list fetched successfully.",
				vaccinRepository.findAll());
	}
	@GetMapping("/getone/{id}")
	public ApiResponse<Vaccin> getCongeById(@PathVariable("id") long id) {
		Optional<Vaccin> vaccinleData = vaccinRepository.findById(id);

		if (vaccinleData.isPresent()) {
			return new ApiResponse<>(HttpStatus.OK.value(), "Conge  fetched successfully", vaccinRepository.findById(id));
		} else {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge  Not Found.", null);
		}

	}

	@PostMapping("/add")
	public ApiResponse<Vaccin> save(@RequestBody Vaccin vaccin) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge saved successfully.",
					vaccinRepository.save(vaccin));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Saved", null);
		}

	}
	@PutMapping("/update")
	public ApiResponse<Vaccin> update(@RequestBody  Vaccin vaccin) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge updated successfully.",
					vaccinRepository.save(vaccin));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge not Saved", null);
		}

	}
	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> delete(@PathVariable("id") long id) {
		try {
			vaccinRepository.deleteById(id);
			return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Conge  Deleted", null);
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Deleted", null);
		}
	}
	
	
}

