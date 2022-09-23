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

import com.enpr.dao.SessionRepository;
import com.enpr.model.ApiResponse;
import com.enpr.model.Section;
import com.enpr.model.Session;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/session")
public class SessionContoroller {
	@Autowired
	private SessionRepository sessionRepository;

	@GetMapping("/all")
	public ApiResponse<List<Session>> listConge() {
		System.out.print(sessionRepository.findAll());
		return new ApiResponse<>(HttpStatus.OK.value(), "Conge  list fetched successfully.",
				sessionRepository.findAll());
		
	}
	@GetMapping("/getone/{id}")
	public ApiResponse<Session> getCongeById(@PathVariable("id") long id) {
		Optional<Session> congeData = sessionRepository.findById(id);

		if (congeData.isPresent()) {
			return new ApiResponse<>(HttpStatus.OK.value(), "Conge  fetched successfully", sessionRepository.findById(id));
		} else {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge  Not Found.", null);
		}

	}

	@PostMapping("/add")
	public ApiResponse<Session> save(@RequestBody Session session) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge saved successfully.",
					sessionRepository.save(session));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Saved", null);
		}

	}
	@PutMapping("/update")
	public ApiResponse<Session> update(@RequestBody  Session session) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge updated successfully.",
					sessionRepository.save(session));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge not Saved", null);
		}

	}
	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> delete(@PathVariable("id") long id) {
		try {
			sessionRepository.deleteById(id);
			return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Conge  Deleted", null);
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Deleted", null);
		}
	}
	
	@GetMapping("/findAllActiveSession/{etat}")
	public ApiResponse<List<Session>> findAllActiveSession(@PathVariable("etat") String etat) {
		
		List<Session> sessions = sessionRepository.findAllActiveSession(etat);
		 System.out.println(sessions.toString());
		if (!sessions.isEmpty() ) {
			return new ApiResponse<>(HttpStatus.OK.value(), "groups fetched suucessfully", sessions);
		}
		else
		{
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "groups Not FOund", null);
		}
	}
}
