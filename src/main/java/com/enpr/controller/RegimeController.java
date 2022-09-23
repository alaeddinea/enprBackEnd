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


import com.enpr.dao.RegimeRepository;

import com.enpr.model.ApiResponse;
import com.enpr.model.Regime;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/regime")
public class RegimeController {
	@Autowired
	private RegimeRepository regimeRepository ;

	@GetMapping("/all")
	public ApiResponse<List<Regime>> listConge() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Conge  list fetched successfully.",
				regimeRepository.findAll());
	}
	@GetMapping("/getone/{id}")
	public ApiResponse<Regime> getCongeById(@PathVariable("id") long id) {
		Optional<Regime> congeData = regimeRepository.findById(id);

		if (congeData.isPresent()) {
			return new ApiResponse<>(HttpStatus.OK.value(), "Conge  fetched successfully", regimeRepository.findById(id));
		} else {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge  Not Found.", null);
		}

	}

	@PostMapping("/add")
	public ApiResponse<Regime> save(@RequestBody Regime regime) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge saved successfully.",
					regimeRepository.save(regime));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Saved", null);
		}

	}
	@PutMapping("/update")
	public ApiResponse<Regime> update(@RequestBody  Regime regime) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge updated successfully.",
					regimeRepository.save(regime));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge not Saved", null);
		}

	}
	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> delete(@PathVariable("id") long id) {
		try {
			regimeRepository.deleteById(id);
			return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Conge  Deleted", null);
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Deleted", null);
		}
	}
	
	
}


