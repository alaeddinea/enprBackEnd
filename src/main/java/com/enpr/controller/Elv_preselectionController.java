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

import com.enpr.dao.Elv_preselectionRepository;

import com.enpr.model.ApiResponse;
import com.enpr.model.Eleve;
import com.enpr.model.ElvPreselection;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/elvpreselection")
public class Elv_preselectionController {
	@Autowired
	private Elv_preselectionRepository elv_preselectionRepository ;


	@GetMapping("/all")
	public ApiResponse<List<ElvPreselection>> listElv_preselection() {
		
		return new ApiResponse<>(HttpStatus.OK.value(), "elv_preselection  list fetched successfully.",
				elv_preselectionRepository.findAll());
		
	}

	@GetMapping("/getone/{id}")
	public ApiResponse<ElvPreselection> getElv_preselectionById(@PathVariable("id") long id) {
		Optional<ElvPreselection> Elv_preselectionData = elv_preselectionRepository.findById(id);

		if (Elv_preselectionData.isPresent()) {
			return new ApiResponse<>(HttpStatus.OK.value(), "elv_preselection  fetched successfully", elv_preselectionRepository.findById(id));
		} else {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "elv_preselection  Not Found.", null);
		}

	}

	@PostMapping("/add")
	public ApiResponse<ElvPreselection> save(@RequestBody ElvPreselection elv_preselection) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "elv_preselection  saved successfully.",
					elv_preselectionRepository.save(elv_preselection));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "elv_preselection not Saved", null);
		}

	}

	@PutMapping("/update")
	public ApiResponse<ElvPreselection> update(@RequestBody ElvPreselection elv_preselection) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "elv_preselection  updated successfully.",
					elv_preselectionRepository.save(elv_preselection));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "elv_preselection not Saved", null);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> delete(@PathVariable("id") long id) {
		try {
			System.out.println("id = "+id);
			elv_preselectionRepository.deleteById(id);
		
			return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "elv_preselection  Deleted", null);
		} catch (Exception e) {
			System.out.println("Exception = "+e);
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "elv_preselection not Deleted", null);
		}
	}

}
