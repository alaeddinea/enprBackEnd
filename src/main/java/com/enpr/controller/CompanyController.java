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

import com.enpr.dao.CompanyRepository;

import com.enpr.model.ApiResponse;
import com.enpr.model.Company;
import com.enpr.model.Group;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/company")
public class CompanyController {
	@Autowired
	private CompanyRepository companyRepository;

	@GetMapping("/all")
	public ApiResponse<List<Company>> listConge() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Conge  list fetched successfully.",
				companyRepository.findAll());
	}
	@GetMapping("/getone/{id}")
	public ApiResponse<Company> getCongeById(@PathVariable("id") long id) {
		Optional<Company> congeData = companyRepository.findById(id);

		if (congeData.isPresent()) {
			return new ApiResponse<>(HttpStatus.OK.value(), "Conge  fetched successfully", companyRepository.findById(id));
		} else {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge  Not Found.", null);
		}

	}

	@PostMapping("/add")
	public ApiResponse<Company> save(@RequestBody Company company) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge saved successfully.",
					companyRepository.save(company));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Saved", null);
		}

	}
	@PutMapping("/update")
	public ApiResponse<Company> update(@RequestBody  Company company) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge updated successfully.",
					companyRepository.save(company));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge not Saved", null);
		}

	}
	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> delete(@PathVariable("id") long id) {
		try {
			companyRepository.deleteById(id);
			return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Conge  Deleted", null);
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Deleted", null);
		}
	}
	@GetMapping("/findAllSonByMother/{id}")
	public ApiResponse<List<Company>> findAllSonByMother(@PathVariable("id") long id) {
		
		List<Company> companies = companyRepository.findAllSonByMother(id);
		 System.out.println(companies.toString());
		if (!companies.isEmpty() ) {
			return new ApiResponse<>(HttpStatus.OK.value(), "groups fetched suucessfully", companies);
		}
		else
		{
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "groups Not FOund", null);
		}
	}
}
