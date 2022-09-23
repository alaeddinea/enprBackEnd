package com.enpr.controller;

import java.io.FileNotFoundException;
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


import com.enpr.dao.PenaliteEleveRepository;
import com.enpr.model.ApiResponse;
import com.enpr.model.Delegation;

import com.enpr.model.PenaliteEleve;
import com.enpr.model.Section;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/penaliteeleve")
public class PenaliteEleveController {

	@Autowired
	private PenaliteEleveRepository penaliteEleveRepository;
	


	@GetMapping("/all")
	public ApiResponse<List<PenaliteEleve>> listGouvernorat() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Gouvernorat  list fetched successfully.",
				penaliteEleveRepository.findAll());
	}

	@GetMapping("/getone/{id}")
	public ApiResponse<PenaliteEleve> getGouvernoratById(@PathVariable("id") long id) {
		Optional<PenaliteEleve> penaliteElevetData = penaliteEleveRepository.findById(id);

		if (penaliteElevetData.isPresent()) {
			return new ApiResponse<>(HttpStatus.OK.value(), "Gouvernorat  fetched successfully", penaliteEleveRepository.findById(id));
		} else {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Gouvernorat  Not Found.", null);
		}

	}

	@PostMapping("/add")
	public ApiResponse<PenaliteEleve> save(@RequestBody PenaliteEleve penaliteEleve) {
		try {
System.out.println(penaliteEleve);
			return new ApiResponse<>(HttpStatus.OK.value(), "Gouvernorat  saved successfully.",
					penaliteEleveRepository.save(penaliteEleve));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Gouvernorat not Saved", null);
		}

	}

	@PutMapping("/update")
	public ApiResponse<PenaliteEleve> update(@RequestBody PenaliteEleve penaliteEleve) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Motif  updated successfully.",
					penaliteEleveRepository.save(penaliteEleve));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Gouvernorat not Saved", null);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> delete(@PathVariable("id") long id) {
		try {
			penaliteEleveRepository.deleteById(id);
			return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Gouvernorat  Deleted", null);
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Gouvernorat not Deleted", null);
		}
	}
	@GetMapping("/findAllSonByMother/{id}")
	public ApiResponse<List<PenaliteEleve>> findAllSonByMother(@PathVariable("id") long id) {
		
		List<PenaliteEleve> penaliteEleves = penaliteEleveRepository.findAllSonByMother(id);
		 
		if (!penaliteEleves.isEmpty() ) {
			return new ApiResponse<>(HttpStatus.OK.value(), "groups fetched suucessfully", penaliteEleves);
		}
		else
		{
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "groups Not FOund", null);
		}
	}


}
