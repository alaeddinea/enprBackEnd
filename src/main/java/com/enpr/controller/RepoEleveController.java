package com.enpr.controller;

import java.sql.Date;
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

import com.enpr.dao.RepoEleveRepository;

import com.enpr.model.ApiResponse;

import com.enpr.model.RepoEleve;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/repoeleve")
public class RepoEleveController {
	@Autowired
	private RepoEleveRepository repoEleveRepository  ;

	@GetMapping("/all")
	public ApiResponse<List<RepoEleve>> listConge() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Conge  list fetched successfully.",
				repoEleveRepository.findAll());
	}
	@GetMapping("/getone/{id}")
	public ApiResponse<RepoEleve> getCongeById(@PathVariable("id") long id) {
		Optional<RepoEleve> congeData = repoEleveRepository.findById(id);

		if (congeData.isPresent()) {
			return new ApiResponse<>(HttpStatus.OK.value(), "Conge  fetched successfully", repoEleveRepository.findById(id));
		} else {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge  Not Found.", null);
		}

	}

	@PostMapping("/add")
	public ApiResponse<RepoEleve> save(@RequestBody RepoEleve repoEleve) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge saved successfully.",
					repoEleveRepository.save(repoEleve));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Saved", null);
		}

	}
	@PutMapping("/update")
	public ApiResponse<RepoEleve> update(@RequestBody  RepoEleve repoEleve) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge updated successfully.",
					repoEleveRepository.save(repoEleve));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge not Saved", null);
		}

	}
	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> delete(@PathVariable("id") long id) {
		try {
			repoEleveRepository.deleteById(id);
			return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Conge  Deleted", null);
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Deleted", null);
		}
	}
	@GetMapping("/findAllSonByMother/{id}")
	public ApiResponse<List<RepoEleve>> findAllSonByMother(@PathVariable("id") long id) {
		
		List<RepoEleve> repoEleves = repoEleveRepository.findAllSonByMother(id);
		 
		if (!repoEleves.isEmpty() ) {
			return new ApiResponse<>(HttpStatus.OK.value(), "groups fetched suucessfully", repoEleves);
		}
		else
		{
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "groups Not FOund", null);
		}
	}
	@GetMapping("/getExcelRepo/{dateD}")
	public ApiResponse<List<Object>> getExcelRepo( @PathVariable("dateD")  Date date){
		System.out.println("dateD "+ date);
		 List<Object> repoData  = repoEleveRepository.getExcelRepo(date);
		 System.out.println("repoData "+ repoData);
			if (!repoData.isEmpty() ) {
				return new ApiResponse<>(HttpStatus.OK.value(), "getExcelRepo fetched suucessfully", repoData);
			}
			else
			{
				return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "getExcelRepo Not FOund", null);
			}
	}
}


