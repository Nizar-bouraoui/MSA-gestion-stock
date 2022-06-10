package com.nbouraoui.controllers;

import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nbouraoui.entities.User;
import com.nbouraoui.entities.Response;
import com.nbouraoui.services.AccessTokenManager;
import com.nbouraoui.services.AuthenticationManager;
import com.nbouraoui.services.SmsManager;
import com.nbouraoui.services.UserService;
@CrossOrigin
@RequestMapping("api/users")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	SmsManager smsManager;
	@Autowired
	AccessTokenManager accessTokenManager;
	
	
	HttpResponse<String> sentMessageResponse;
	JSONObject sentMessageResponseBody;
	@PostMapping
	public ResponseEntity<Response> save(@RequestBody User user) {
		if (userService.checkUserExtistenceByPhoneNumber(user)) {
			user.setId(userService.findByPhoneNumber(user.getPhoneNumber()).getId());
		}
		
		
		String verifacationCode =authenticationManager.generateConfirmationCode() ;
		sentMessageResponse =  smsManager.sendMessage("+21653923179", user.getPhoneNumber(), verifacationCode, accessTokenManager.generateAccessToken("Wgr5kPhqaR8GAAT9ygZHfwtneuAqAoD1","PcUc1sgmizhx5Bh9"));
		if (HttpStatus.valueOf(sentMessageResponse.statusCode()).is2xxSuccessful()) {
			user.setVerificationCode(verifacationCode);
			user.setVerified(false);
			return ResponseEntity.ok(
					Response.builder()
					.timeStamp(LocalDateTime.now())
					.data(Map.of("user",userService.save(user)))
					.message("user created successfully")
					.status(HttpStatus.valueOf(sentMessageResponse.statusCode()))
					.statusCode(sentMessageResponse.statusCode())
					.build()
					);
		}
		sentMessageResponseBody = new JSONObject(sentMessageResponse.body().toString());
		return ResponseEntity.ok(
				Response.builder()
				.timeStamp(LocalDateTime.now())
				.data(Map.of("user",user))
				.status(HttpStatus.valueOf(sentMessageResponse.statusCode()))
				.statusCode(sentMessageResponse.statusCode())
				.reason(sentMessageResponseBody.getString("message"))
				.description(sentMessageResponseBody.getString("description"))
				.build()
				);
		
		
	}
	@PutMapping
	public ResponseEntity<Response> verifyUser(@RequestBody User user) {
		User unverifiedUser = userService.findByPhoneNumber(user.getPhoneNumber());
		if (user.getVerificationCode().equals(unverifiedUser.getVerificationCode())) {
			unverifiedUser.setVerified(true);
		}
		return ResponseEntity.ok(
				Response.builder()
				.timeStamp(LocalDateTime.now())
				.data(Map.of("user",userService.save(unverifiedUser)))
				.message("user verified successfully")
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.build()
				);
	}
	
	@GetMapping
	public ResponseEntity<Response> findAll() {
		return ResponseEntity.ok(
				Response.builder()
				.timeStamp(LocalDateTime.now())
				.data(Map.of("user",userService.findAll()))
				.message("users retrieved successfully")
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.build()
				);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Response> findById(@PathVariable Long id) {
		return ResponseEntity.ok(
				Response.builder()
				.timeStamp(LocalDateTime.now())
				.data(Map.of("user",userService.findById(id)))
				.message("user retrieved successfully")
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.build()
				);
	}
	@DeleteMapping
	public ResponseEntity<Response> delete(@RequestBody User user) {
		userService.delete(user);
		return ResponseEntity.ok(
				Response.builder()
				.timeStamp(LocalDateTime.now())
				.data(Map.of("user",user))
				.message("user deleted successfully")
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.build()
				);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Response> delete(@PathVariable Long id) {
		userService.deleteById(id);
		return ResponseEntity.ok(
				Response.builder()
				.timeStamp(LocalDateTime.now())
				.data(Map.of("user id : ",id))
				.message("user deleted successfully")
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.build()
				);
		
	}

}
