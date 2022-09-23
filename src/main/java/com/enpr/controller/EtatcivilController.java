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

import com.enpr.dao.EtatcivilRepository;

import com.enpr.model.ApiResponse;
import com.enpr.model.Etatcivil;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/etatcivil")
public class EtatcivilController {

	@Autowired
	private EtatcivilRepository etatcivilRepository  ;

	@GetMapping("/all")
	public ApiResponse<List<Etatcivil>> listGouvernorat() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Gouvernorat  list fetched successfully.",
				etatcivilRepository.findAll());
	}

	@GetMapping("/getone/{id}")
	public ApiResponse<Etatcivil> getGouvernoratById(@PathVariable("id") long id) {
		Optional<Etatcivil> etatcivilData = etatcivilRepository.findById(id);

		if (etatcivilData.isPresent()) {
			return new ApiResponse<>(HttpStatus.OK.value(), "Gouvernorat  fetched successfully", etatcivilRepository.findById(id));
		} else {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Gouvernorat  Not Found.", null);
		}

	}

	@PostMapping("/add")
	public ApiResponse<Etatcivil> save(@RequestBody Etatcivil entity) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Gouvernorat  saved successfully.",
					etatcivilRepository.save(entity));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Gouvernorat not Saved", null);
		}

	}

	@PutMapping("/update")
	public ApiResponse<Etatcivil> update(@RequestBody Etatcivil entityt) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Motif  updated successfully.",
					etatcivilRepository.save(entityt));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Gouvernorat not Saved", null);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> delete(@PathVariable("id") long id) {
		try {
			etatcivilRepository.deleteById(id);
			return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Gouvernorat  Deleted", null);
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Gouvernorat not Deleted", null);
		}
	}
	

}

