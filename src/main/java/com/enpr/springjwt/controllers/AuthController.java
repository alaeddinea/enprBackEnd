package com.enpr.springjwt.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enpr.springjwt.models.ERole;
import com.enpr.springjwt.models.Role;
import com.enpr.springjwt.models.User;
import com.enpr.springjwt.payload.request.LoginRequest;
import com.enpr.springjwt.payload.request.SignupRequest;
import com.enpr.springjwt.payload.response.JwtResponse;
import com.enpr.springjwt.payload.response.MessageResponse;
import com.enpr.springjwt.repository.RoleRepository;
import com.enpr.springjwt.repository.UserRepository;
import com.enpr.springjwt.security.jwt.JwtUtils;
import com.enpr.springjwt.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
System.out.println("**********"+loginRequest.toString()+"***********");
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												  
												 roles,
												 userDetails.getPersonelle()
												));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		 

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
						  
							 encoder.encode(signUpRequest.getPassword()));
		user.setPersonelle(signUpRequest.getPersonelle());		
		//String strRoles = signUpRequest.getRole();
 		Set<String> strRoles = signUpRequest.getRole();
 		 
 		
		Set<Role> roles = new HashSet<>();

	
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "user":
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);

					break;
				case "manipulation":
					Role manipulationRole = roleRepository.findByName(ERole.ROLE_MANIPULATION)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(manipulationRole);

					break;
				case "recrutement":
					Role recrutementRole = roleRepository.findByName(ERole.ROLE_RECRUTEMENT)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(recrutementRole);

					break;
				case "sante":
					Role dirRole = roleRepository.findByName(ERole.ROLE_SANTE)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(dirRole);

					break;
				case "psycho":
					Role psychoRole = roleRepository.findByName(ERole.ROLE_PSYCHO)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(psychoRole);

					break;
				default:
					/*Role userRole = roleRepository.findByName(ERole.ROLE_RECRUTEMENT)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);*/
				}
			});
		

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
