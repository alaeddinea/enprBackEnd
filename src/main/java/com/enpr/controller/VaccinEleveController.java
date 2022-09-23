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


import com.enpr.dao.VaccinEleveRepository;

import com.enpr.model.ApiResponse;
import com.enpr.model.PenaliteEleve;
import com.enpr.model.VaccinEleve;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/vaccineleve")
public class VaccinEleveController {
	@Autowired
	private VaccinEleveRepository vaccinEleveRepository ;

	@GetMapping("/all")
	public ApiResponse<List<VaccinEleve>> listConge() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Conge  list fetched successfully.",
				vaccinEleveRepository.findAll());
	}
	@GetMapping("/getone/{id}")
	public ApiResponse<VaccinEleve> getCongeById(@PathVariable("id") long id) {
		Optional<VaccinEleve> congeData = vaccinEleveRepository.findById(id);

		if (congeData.isPresent()) {
			return new ApiResponse<>(HttpStatus.OK.value(), "Conge  fetched successfully", vaccinEleveRepository.findById(id));
		} else {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge  Not Found.", null);
		}

	}

	@PostMapping("/add")
	public ApiResponse<VaccinEleve> save(@RequestBody VaccinEleve vaccinEleve) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge saved successfully.",
					vaccinEleveRepository.save(vaccinEleve));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Saved", null);
		}

	}
	@PutMapping("/update")
	public ApiResponse<VaccinEleve> update(@RequestBody  VaccinEleve vaccinEleve) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge updated successfully.",
					vaccinEleveRepository.save(vaccinEleve));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge not Saved", null);
		}

	}
	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> delete(@PathVariable("id") long id) {
		try {
			vaccinEleveRepository.deleteById(id);
			return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Conge  Deleted", null);
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Deleted", null);
		}
	}
	
	@GetMapping("/findAllSonByMother/{id}")
	public ApiResponse<List<VaccinEleve>> findAllSonByMother(@PathVariable("id") long id) {
		
		List<VaccinEleve> VaccinEleves = vaccinEleveRepository.findAllSonByMother(id);
		 
		if (!VaccinEleves.isEmpty() ) {
			return new ApiResponse<>(HttpStatus.OK.value(), "groups fetched suucessfully", VaccinEleves);
		}
		else
		{
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "groups Not FOund", null);
		}
	}
}


