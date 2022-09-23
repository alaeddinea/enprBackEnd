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

import com.enpr.dao.DelegationRepository;

import com.enpr.model.ApiResponse;
import com.enpr.model.Delegation;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/delegation")
public class DelegationController {

	@Autowired
	private DelegationRepository delegationRepository;


	@GetMapping("/all")
	public ApiResponse<List<Delegation>> listGouvernorat() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Gouvernorat  list fetched successfully.",
				delegationRepository.findAll());
	}

	@GetMapping("/getone/{id}")
	public ApiResponse<Delegation> getGouvernoratById(@PathVariable("id") long id) {
		Optional<Delegation> gouvernoratData = delegationRepository.findById(id);

		if (gouvernoratData.isPresent()) {
			return new ApiResponse<>(HttpStatus.OK.value(), "Gouvernorat  fetched successfully", delegationRepository.findById(id));
		} else {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Gouvernorat  Not Found.", null);
		}

	}

	@PostMapping("/add")
	public ApiResponse<Delegation> save(@RequestBody Delegation delegation) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Gouvernorat  saved successfully.",
					delegationRepository.save(delegation));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Gouvernorat not Saved", null);
		}

	}

	@PutMapping("/update")
	public ApiResponse<Delegation> update(@RequestBody Delegation delegation) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Motif  updated successfully.",
					delegationRepository.save(delegation));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Gouvernorat not Saved", null);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> delete(@PathVariable("id") long id) {
		try {
			delegationRepository.deleteById(id);
			return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Gouvernorat  Deleted", null);
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Gouvernorat not Deleted", null);
		}
	}
	@GetMapping("/findAllSonByMother/{id}")
	public ApiResponse<List<Delegation>> findAllSonByMother(@PathVariable("id") long id) {
		
		List<Delegation> delegations = delegationRepository.findAllSonByMother(id);
		 System.out.println(delegations.toString());
		if (!delegations.isEmpty() ) {
			return new ApiResponse<>(HttpStatus.OK.value(), "delegations fetched suucessfully", delegations);
		}
		else
		{
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "delegations Not FOund", null);
		}
	}
	
}
