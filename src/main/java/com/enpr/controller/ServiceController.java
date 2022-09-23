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

import com.enpr.dao.AdministrationRepository;
import com.enpr.dao.ServiceRepository;
import com.enpr.model.Administration;
import com.enpr.model.ApiResponse;
import com.enpr.model.Service;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/service")
public class ServiceController {
	@Autowired
	private ServiceRepository serviceRepository  ;

	@GetMapping("/all")
	public ApiResponse<List<Service>> listConge() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Conge  list fetched successfully.",
				serviceRepository.findAll());
	}
	@GetMapping("/getone/{id}")
	public ApiResponse<Service> getCongeById(@PathVariable("id") long id) {
		Optional<Service> serviceData = serviceRepository.findById(id);

		if (serviceData.isPresent()) {
			return new ApiResponse<>(HttpStatus.OK.value(), "Conge  fetched successfully", serviceRepository.findById(id));
		} else {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge  Not Found.", null);
		}

	}

	@PostMapping("/add")
	public ApiResponse<Service> save(@RequestBody Service service) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge saved successfully.",
					serviceRepository.save(service));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Saved", null);
		}

	}
	@PutMapping("/update")
	public ApiResponse<Service> update(@RequestBody  Service service) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge updated successfully.",
					serviceRepository.save(service));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge not Saved", null);
		}

	}
	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> delete(@PathVariable("id") long id) {
		try {
			serviceRepository.deleteById(id);
			return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Conge  Deleted", null);
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Deleted", null);
		}
	}
	
	
}


