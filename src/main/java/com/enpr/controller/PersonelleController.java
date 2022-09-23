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

import com.enpr.dao.PersonelleRepository;
import com.enpr.model.ApiResponse;
import com.enpr.model.Eleve;
import com.enpr.model.Personelle;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/personelle")
public class PersonelleController {
	@Autowired
	private PersonelleRepository personelleRepository  ;

	@GetMapping("/all")
	public ApiResponse<List<Personelle>> listConge() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Conge  list fetched successfully.",
				personelleRepository.findAll());
	}
	@GetMapping("/getone/{id}")
	public ApiResponse<Personelle> getCongeById(@PathVariable("id") long id) {
		System.out.println(id);
		Personelle personelletData = personelleRepository.findByMatricule( id);
		System.out.println(personelletData);
		if (personelletData!= null) {
			return new ApiResponse<>(HttpStatus.OK.value(), "Personelle fetched suucessfully", personelletData);
		}
		else
		{
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Personelle Not FOund", null);
		}

	}

	@PostMapping("/add")
	public ApiResponse<Personelle> save(@RequestBody Personelle personelle) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge saved successfully.",
					personelleRepository.save(personelle));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Saved", null);
		}

	}
	@PutMapping("/update")
	public ApiResponse<Personelle> update(@RequestBody  Personelle personelle) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge updated successfully.",
					personelleRepository.save(personelle));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge not Saved", null);
		}

	}
	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> delete(@PathVariable("id") long id) {
		try {
			personelleRepository.deleteById(id);
			return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Conge  Deleted", null);
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Deleted", null);
		}
	}
	
	/*@GetMapping("/PersonelleRepository/{id}")
	public ApiResponse<List<Eleve>> findAllEleveByCin(@PathVariable("id") String matricule) {
		
		List<Personelle> personelles = personelleRepository.findAllPersonelleByCnrps(matricule);
		
		if (!personelles.isEmpty() ) {
			return new ApiResponse<>(HttpStatus.OK.value(), "personelles fetched suucessfully", personelles);
		}
		else
		{
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "personelles Not FOund", null);
		}
	}*/
}




