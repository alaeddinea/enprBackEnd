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

import com.enpr.dao.GroupRepository;
import com.enpr.dao.SessionRepository;
import com.enpr.model.ApiResponse;
import com.enpr.model.Delegation;
import com.enpr.model.Group;
import com.enpr.model.Session;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/group")
public class GroupController {
	@Autowired
	private GroupRepository groupRepository;

	@GetMapping("/all")
	public ApiResponse<List<Group>> listConge() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Conge  list fetched successfully.",
				groupRepository.findAll());
	}
	@GetMapping("/getone/{id}")
	public ApiResponse<Group> getCongeById(@PathVariable("id") long id) {
		Optional<Group> congeData = groupRepository.findById(id);

		if (congeData.isPresent()) {
			return new ApiResponse<>(HttpStatus.OK.value(), "Conge  fetched successfully", groupRepository.findById(id));
		} else {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge  Not Found.", null);
		}

	}

	@PostMapping("/add")
	public ApiResponse<Group> save(@RequestBody Group group) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge saved successfully.",
					groupRepository.save(group));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Saved", null);
		}

	}
	@PutMapping("/update")
	public ApiResponse<Group> update(@RequestBody  Group group) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Conge updated successfully.",
					groupRepository.save(group));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Conge not Saved", null);
		}

	}
	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> delete(@PathVariable("id") long id) {
		try {
			groupRepository.deleteById(id);
			return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Conge  Deleted", null);
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Conge not Deleted", null);
		}
	}
	@GetMapping("/findAllSonByMother/{id}")
	public ApiResponse<List<Group>> findAllSonByMother(@PathVariable("id") long id) {
		
		List<Group> groups = groupRepository.findAllSonByMother(id);
		 System.out.println(groups.toString());
		if (!groups.isEmpty() ) {
			return new ApiResponse<>(HttpStatus.OK.value(), "groups fetched suucessfully", groups);
		}
		else
		{
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "groups Not FOund", null);
		}
	}
}
