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

import com.enpr.dao.SpecialiteRepository;
import com.enpr.model.ApiResponse;

import com.enpr.model.Specialite;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/specialite")
public class SpecialiteController {

@Autowired
private SpecialiteRepository specialiteRepository ;

@GetMapping("/all")
public ApiResponse<List<Specialite>> listGouvernorat() {
	return new ApiResponse<>(HttpStatus.OK.value(), "Gouvernorat  list fetched successfully.",
			specialiteRepository.findAll());
}

@GetMapping("/getone/{id}")
public ApiResponse<Specialite> getGouvernoratById(@PathVariable("id") long id) {
	Optional<Specialite> gouvernoratData = specialiteRepository.findById(id);

	if (gouvernoratData.isPresent()) {
		return new ApiResponse<>(HttpStatus.OK.value(), "Gouvernorat  fetched successfully", specialiteRepository.findById(id));
	} else {
		return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Gouvernorat  Not Found.", null);
	}

}

@PostMapping("/add")
public ApiResponse<Specialite> save(@RequestBody Specialite entity) {
	try {

		return new ApiResponse<>(HttpStatus.OK.value(), "Gouvernorat  saved successfully.",
				specialiteRepository.save(entity));
	} catch (Exception e) {
		return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Gouvernorat not Saved", null);
	}

}

@PutMapping("/update")
public ApiResponse<Specialite> update(@RequestBody Specialite entityt) {
	try {

		return new ApiResponse<>(HttpStatus.OK.value(), "Motif  updated successfully.",
				specialiteRepository.save(entityt));
	} catch (Exception e) {
		return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Gouvernorat not Saved", null);
	}

}

@DeleteMapping("/delete/{id}")
public ApiResponse<Void> delete(@PathVariable("id") long id) {
	try {
		specialiteRepository.deleteById(id);
		return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Gouvernorat  Deleted", null);
	} catch (Exception e) {
		return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Gouvernorat not Deleted", null);
	}
}
}
