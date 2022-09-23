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

import com.enpr.dao.ConsultationEleveRepository;

import com.enpr.model.ApiResponse;
import com.enpr.model.ConsultationEleve;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/consultationeleve")
public class ConsultationEleveController {
	@Autowired
	private ConsultationEleveRepository consultationEleveRepository   ;

	@GetMapping("/all")
	public ApiResponse<List<ConsultationEleve>> listConge() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Conge  list fetched successfully.",
				consultationEleveRepository.findAll());
	}
	@GetMapping("/getone/{id}")
	public ApiResponse<ConsultationEleve> getCongeById(@PathVariable("id") long id) {
		Optional<ConsultationEleve> congeData = consultationEleveRepository.findById(id);

		if (congeData.isPresent()) {
			return new ApiResponse<>(HttpStatus.OK.value(), "Conge  fetched successfully", consultationEleveRepository.findById(id));
		} else {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge  Not Found.", null);
		}

	}

	@PostMapping("/add")
	public ApiResponse<ConsultationEleve> save(@RequestBody ConsultationEleve consultationEleve) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge saved successfully.",
					consultationEleveRepository.save(consultationEleve));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Saved", null);
		}

	}
	@PutMapping("/update")
	public ApiResponse<ConsultationEleve> update(@RequestBody  ConsultationEleve consultationEleve) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge updated successfully.",
					consultationEleveRepository.save(consultationEleve));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge not Saved", null);
		}

	}
	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> delete(@PathVariable("id") long id) {
		try {
			consultationEleveRepository.deleteById(id);
			return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Conge  Deleted", null);
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Deleted", null);
		}
	}
	@GetMapping("/findAllSonByMother/{id}")
	public ApiResponse<List<ConsultationEleve>> findAllSonByMother(@PathVariable("id") long id) {
		
		List<ConsultationEleve> consultationEleves = consultationEleveRepository.findAllSonByMother(id);
		 
		if (!consultationEleves.isEmpty() ) {
			return new ApiResponse<>(HttpStatus.OK.value(), "groups fetched suucessfully", consultationEleves);
		}
		else
		{
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "groups Not FOund", null);
		}
	}
	
}


