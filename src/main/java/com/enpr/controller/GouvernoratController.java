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

import com.enpr.dao.GouvernoratRepository;
import com.enpr.model.ApiResponse;
import com.enpr.model.Delegation;
import com.enpr.model.Gouvernorat;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/gouvernorat")
public class GouvernoratController {
	
	@Autowired
	private GouvernoratRepository gouvernoratRepository;

	@GetMapping("/all")
	public ApiResponse<List<Gouvernorat>> listGouvernorat() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Gouvernorat  list fetched successfully.",
				gouvernoratRepository.findAll());
	}

	@GetMapping("/getone/{id}")
	public ApiResponse<Gouvernorat> getGouvernoratById(@PathVariable("id") long id) {
		Optional<Gouvernorat> gouvernoratData = gouvernoratRepository.findById(id);

		if (gouvernoratData.isPresent()) {
			return new ApiResponse<>(HttpStatus.OK.value(), "Gouvernorat  fetched successfully", gouvernoratRepository.findById(id));
		} else {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Gouvernorat  Not Found.", null);
		}

	}

	@PostMapping("/add")
	public ApiResponse<Gouvernorat> save(@RequestBody Gouvernorat gouvernorat) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Gouvernorat  saved successfully.",
					gouvernoratRepository.save(gouvernorat));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Gouvernorat not Saved", null);
		}

	}

	@PutMapping("/update")
	public ApiResponse<Gouvernorat> update(@RequestBody Gouvernorat gouvernorat) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Motif  updated successfully.",
					gouvernoratRepository.save(gouvernorat));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Gouvernorat not Saved", null);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> delete(@PathVariable("id") long id) {
		try {
			gouvernoratRepository.deleteById(id);
			return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Gouvernorat  Deleted", null);
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Gouvernorat not Deleted", null);
		}
	}
	

}
