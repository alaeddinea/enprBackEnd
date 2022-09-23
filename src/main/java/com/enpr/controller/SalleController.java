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


import com.enpr.dao.SalleRepository;

import com.enpr.model.ApiResponse;
import com.enpr.model.Salle;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/salle")
public class SalleController {
	@Autowired
	private SalleRepository salleRepository  ;

	@GetMapping("/all")
	public ApiResponse<List<Salle>> listConge() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Conge  list fetched successfully.",
				salleRepository.findAll());
	}
	@GetMapping("/getone/{id}")
	public ApiResponse<Salle> getCongeById(@PathVariable("id") long id) {
		Optional<Salle> congeData = salleRepository.findById(id);

		if (congeData.isPresent()) {
			return new ApiResponse<>(HttpStatus.OK.value(), "Conge  fetched successfully", salleRepository.findById(id));
		} else {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge  Not Found.", null);
		}

	}

	@PostMapping("/add")
	public ApiResponse<Salle> save(@RequestBody Salle salle) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge saved successfully.",
					salleRepository.save(salle));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Saved", null);
		}

	}
	@PutMapping("/update")
	public ApiResponse<Salle> update(@RequestBody  Salle salle) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge updated successfully.",
					salleRepository.save(salle));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge not Saved", null);
		}

	}
	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> delete(@PathVariable("id") long id) {
		try {
			salleRepository.deleteById(id);
			return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Conge  Deleted", null);
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Deleted", null);
		}
	}
	
	
}


