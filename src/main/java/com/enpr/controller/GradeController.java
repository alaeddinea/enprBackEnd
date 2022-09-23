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

import com.enpr.dao.GradeRepository;
import com.enpr.model.ApiResponse;
import com.enpr.model.Grade;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/grade")
public class GradeController {
	
	@Autowired
	private GradeRepository gradeRepository;

	@GetMapping("/all")
	public ApiResponse<List<Grade>> listGrade() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Grade  list fetched successfully.",
				gradeRepository.findAll());
	}

	@GetMapping("/getone/{id}")
	public ApiResponse<Grade> getGouvernoratById(@PathVariable("id") long id) {
		Optional<Grade> gradetData = gradeRepository.findById(id);

		if (gradetData.isPresent()) {
			return new ApiResponse<>(HttpStatus.OK.value(), "Grade  fetched successfully", gradeRepository.findById(id));
		} else {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Grade  Not Found.", null);
		}

	}

	@PostMapping("/add")
	public ApiResponse<Grade> save(@RequestBody Grade grade) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Grade saved successfully.",
					gradeRepository.save(grade));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Grade not Saved", null);
		}

	}

	@PutMapping("/update")
	public ApiResponse<Grade> update(@RequestBody Grade grade) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Grade updated successfully.",
					gradeRepository.save(grade));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Grade not Saved", null);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> delete(@PathVariable("id") long id) {
		try {
			gradeRepository.deleteById(id);
			return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Grade  Deleted", null);
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Grade not Deleted", null);
		}
	}

}
