package com.enpr.controller;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.enpr.dao.EleveRepository;
import com.enpr.dao.ImageRepository;
import com.enpr.model.ApiResponse;
import com.enpr.model.Eleve;
import com.enpr.model.Group;
import com.enpr.model.ImageModel;
import com.enpr.model.Section;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/image")
public class ImageUploadController {


	@Autowired
	ImageRepository imageRepository;
	@Autowired
	EleveRepository eleveRepository;
	@PostMapping("/upload")
	public   ApiResponse<ImageModel> uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		
		System.out.println("hhhhhhgggggg : " +file.getOriginalFilename());
		int v = eleveRepository.updateEleveSetImgForId( file.getBytes(),Long.valueOf(file.getOriginalFilename()));
		/*byte[] bb= file.getBytes();
		System.out.println("byte  : " +bb);
		System.out.println("mmmmmm : " +v);*/
		System.out.println("mmmmmm : " +file.getBytes());
			System.out.println("Original Image Byte Size - " + file.getBytes().length);
	/*ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),file.getBytes());
		return new ApiResponse<>(HttpStatus.OK.value(), "Conge saved successfully.",
			imageRepository.save(img));*/
		return new ApiResponse<>(HttpStatus.OK.value(), "image saved successfully.",	null);
		
	}
	@GetMapping(path = { "/get/{id}" })
	public ApiResponse<ImageModel> getImage(@PathVariable("id") long id) throws IOException {

	//	final Optional<ImageModel> retrievedImage = imageRepository.findById(id);
		 Optional<ImageModel> retrievedImage = imageRepository.findById(id);
		
		if(!retrievedImage.isEmpty()) {
		//ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(), decompressBytes(retrievedImage.get().getPicByte()));
			ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(), retrievedImage.get().getPicByte());
			return new ApiResponse<>(HttpStatus.OK.value(), "imageRepository  fetched successfully", img);
		//return img;
		}
		else {
			return new ApiResponse<>(HttpStatus.OK.value(), "imageRepository  fetched successfully", null);
		}
		
	}

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
}