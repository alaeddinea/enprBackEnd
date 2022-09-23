package com.enpr.controller;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.enpr.ExporterPDF.EleveExporterPDF;
import com.enpr.dao.ConsultationEleveRepository;
import com.enpr.dao.EleveRepository;
import com.enpr.dao.PenaliteEleveRepository;
import com.enpr.dao.RepoEleveRepository;
import com.enpr.model.ApiResponse;

import com.enpr.model.Eleve;
import com.ibm.icu.text.ArabicShapingException;






@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/eleve")
public class EleveController {

	@Autowired
	private EleveRepository eleveRepository;
	
	@Autowired
	private RepoEleveRepository repoEleveRepository ;
	@Autowired
	private  ConsultationEleveRepository consultationEleveRepository;
	@Autowired
	private PenaliteEleveRepository penaliteEleveRepository;
	@GetMapping("/all")
	public ApiResponse<List<Eleve>> listGrade() {
		
		return new ApiResponse<>(HttpStatus.OK.value(), "eleve  list fetched successfully.",
				eleveRepository.findAll());
	}

	@GetMapping("/getone/{id}")
	public ApiResponse<Eleve> getGouvernoratById(@PathVariable("id") long id) {
		Optional<Eleve> gradetData = eleveRepository.findById(id);

		if (gradetData.isPresent()) {
			return new ApiResponse<>(HttpStatus.OK.value(), "Grade  fetched successfully", eleveRepository.findById(id));
		} else {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Grade  Not Found.", null);
		}

	}

	@PostMapping("/add")
	public ApiResponse<Eleve> save( @RequestBody Eleve eleve) {
		
		try {
					//eleve.setSection(new Section(30));
		
				System.out.println("eleveFinal");
				System.out.println(eleve);
				System.out.println("eleveFinal");
				
			return new ApiResponse<>(HttpStatus.OK.value(), "eleve saved successfully.",
					eleveRepository.save(eleve));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "eleve not Saved", null);
		}

	}

	@PutMapping("/update")
	public ApiResponse<Eleve> update(@RequestBody Eleve eleve) {
		try {

			return new ApiResponse<>(HttpStatus.OK.value(), "Grade updated successfully.",
					eleveRepository.save(eleve));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Grade not Saved", null);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> delete(@PathVariable("id") long id) {
		try {
			eleveRepository.deleteById(id);
			return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Grade  Deleted", null);
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Grade not Deleted", null);
		}
	}
	@GetMapping("/findAllEleveBySection/{id}")
	public ApiResponse<List<Eleve>> findAllEleveBySection(@PathVariable("id") long id) {
		
		List<Eleve> eleves = eleveRepository.findAllEleveBySection(id);
		
		if (!eleves.isEmpty() ) {
			return new ApiResponse<>(HttpStatus.OK.value(), "delegations fetched suucessfully", eleves);
		}
		else
		{
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "delegations Not FOund", null);
		}
	}
	@GetMapping("/findAllEleveByCompany/{id}")
	public ApiResponse<List<Eleve>> findAllEleveByCompany(@PathVariable("id") long id) {
		
		List<Eleve> eleves = eleveRepository.findAllEleveByCompany(id);
		
		if (!eleves.isEmpty() ) {
			return new ApiResponse<>(HttpStatus.OK.value(), "delegations fetched suucessfully", eleves);
		}
		else
		{
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "delegations Not FOund", null);
		}
	}
	@GetMapping("/findAllEleveByGroup/{id}")
	public ApiResponse<List<Eleve>> findAllEleveByGroup(@PathVariable("id") long id) {
		
		List<Eleve> eleves = eleveRepository.findAllEleveByGroup(id);
		
		if (!eleves.isEmpty() ) {
			return new ApiResponse<>(HttpStatus.OK.value(), "delegations fetched suucessfully", eleves);
		}
		else
		{
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "delegations Not FOund", null);
		}
	}
	@GetMapping("/findAllEleveBySession/{id}")
	public ApiResponse<List<Eleve>> findAllEleveBySession(@PathVariable("id") long id) {
		
		List<Eleve> eleves = eleveRepository.findAllEleveBySession(id);
		
		if (!eleves.isEmpty() ) {
			
			/*List<Eleve> resultat=eleves.stream().map(e ->{
				//Eleve el = new Eleve(e); // create new instance
				e.setImg(null);; // mutate its state
	            return e; // return mutated instance
	        }).collect(Collectors.toList());*/
			List<Eleve> resultat =new ArrayList<Eleve>();
			/*eleves.forEach(e->{ // create new instance
			e.setImg(null);; // mutate its state
			resultat.add(e);});*/
			for(int i=0 ; i <eleves.size();i++) {
				Eleve el = new Eleve(eleves.get(i));
				el.setImg(null);
				resultat.add(el);
			}
			return new ApiResponse<>(HttpStatus.OK.value(), "delegations fetched suucessfully", resultat);
		}
		else
		{
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "delegations Not FOund", null);
		}
	}
	
	@GetMapping("/findAllEleveByCin/{id}")
	public ApiResponse<List<Eleve>> findAllEleveByCin(@PathVariable("id") Long id) {
		
		List<Eleve> eleves = eleveRepository.findAllEleveByCin(id);
		
		if (!eleves.isEmpty() ) {
			return new ApiResponse<>(HttpStatus.OK.value(), "eleves fetched suucessfully", eleves);
		}
		else
		{
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "eleves Not FOund", null);
		}
	}
	
//	@GetMapping("/report/{id}")
//	public ApiResponse<List<Eleve>> generateReport(@PathVariable long id) throws FileNotFoundException, JRException {
//		 reportService.exportReportEleveBySection(id);
//		return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "okkkk", null);
//	}

	
  
	
	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}
	
	
	
    @GetMapping("/export/pdf/{id}")
    public ResponseEntity<InputStreamResource> exportToPDF(@PathVariable("id") long id) throws  IOException, java.io.IOException {
        
    	 Optional<Eleve>  eleveData = eleveRepository.findById(id);
         
       
        try {
        	
        	EleveExporterPDF eleveExporterPDF = new EleveExporterPDF( repoEleveRepository,consultationEleveRepository,penaliteEleveRepository);
        	 ByteArrayInputStream bais =	eleveExporterPDF.export(eleveData.get()/*,questionRepository.findAll(Sort.by("code").ascending())*/);
        	 HttpHeaders headers = new HttpHeaders();
        	 headers.add("Content-Disposition","inline; filename=enfnat.pdf");
        	 
			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bais) );
	 
		} catch (IOException e) {
		 System.out.println("error1");
			e.printStackTrace();
		} catch (ArabicShapingException e) {
			 System.out.println("error2");

			e.printStackTrace();
		} catch (com.itextpdf.text.DocumentException e) {
			// TODO Auto-generated catch block
			 System.out.println("error3");

			e.printStackTrace();
		}
		return (ResponseEntity<InputStreamResource>) ResponseEntity.status(444);
         
    }
}
