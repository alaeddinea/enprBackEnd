package com.enpr.controller;

import java.sql.Date;
import java.util.Calendar;
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


import com.enpr.dao.RendezvousEleveRepository;
import com.enpr.model.ApiResponse;
import com.enpr.model.RendezvousEleve;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/rendezvouseleve")
public class RendezvousEleveController {
	@Autowired
	private RendezvousEleveRepository rendezvousEleveRepository    ;

	@GetMapping("/all")
	public ApiResponse<List<RendezvousEleve>> listConge() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Conge  list fetched successfully.",
				rendezvousEleveRepository.findAll());
	}
	@GetMapping("/getone/{id}")
	public ApiResponse<RendezvousEleve> getCongeById(@PathVariable("id") long id) {
		Optional<RendezvousEleve> congeData = rendezvousEleveRepository.findById(id);

		if (congeData.isPresent()) {
			return new ApiResponse<>(HttpStatus.OK.value(), "Conge  fetched successfully", rendezvousEleveRepository.findById(id));
		} else {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge  Not Found.", null);
		}

	}

	@PostMapping("/add")
	public ApiResponse<RendezvousEleve> save(@RequestBody RendezvousEleve entity) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge saved successfully.",
					rendezvousEleveRepository.save(entity));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Saved", null);
		}

	}
	@PutMapping("/update")
	public ApiResponse<RendezvousEleve> update(@RequestBody  RendezvousEleve entity) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge updated successfully.",
					rendezvousEleveRepository.save(entity));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge not Saved", null);
		}

	}
	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> delete(@PathVariable("id") long id) {
		try {
			rendezvousEleveRepository.deleteById(id);
			return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Conge  Deleted", null);
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Deleted", null);
		}
	}
	@GetMapping("/findAllSonByMother/{id}")
	public ApiResponse<List<RendezvousEleve>> findAllSonByMother(@PathVariable("id") long id) {
		
		List<RendezvousEleve> rendezvousEleves = rendezvousEleveRepository.findAllSonByMother(id);
		 
		if (!rendezvousEleves.isEmpty() ) {
			return new ApiResponse<>(HttpStatus.OK.value(), "groups fetched suucessfully", rendezvousEleves);
		}
		else
		{
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "groups Not FOund", null);
		}
	}
	
	@GetMapping("/findAllRendezvousbetween/{dated}/{datef}")
	public ApiResponse<List<RendezvousEleve>> findAllRendezvousbetween(@PathVariable("dated") Date dated,@PathVariable("datef") Date datef) {
		java.util.Date dd =this.addDays(dated,-1);
		java.util.Date df =this.addDays(datef,1);
		List<RendezvousEleve> rendezvousEleves = rendezvousEleveRepository.findByDateRendezvousBetween(dd,df);
		System.out.println(rendezvousEleves);
		 
		if (!rendezvousEleves.isEmpty() ) {
			return new ApiResponse<>(HttpStatus.OK.value(), "groups fetched suucessfully", rendezvousEleves);
		}
		else
		{
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "groups Not FOund", null);
		}
	}
	  public  java.util.Date addDays(Date date, int days)
	    {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.DATE, days); //minus number would decrement the days
	        return  cal.getTime();
	    }
}


