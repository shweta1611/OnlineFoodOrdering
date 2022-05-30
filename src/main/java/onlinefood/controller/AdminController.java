package onlinefood.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import onlinefood.dao.AdminDao;
import onlinefood.model.Admin;
import onlinefood.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	private AdminService service;
	@Autowired
	private AdminDao ad;

	Logger logger = LoggerFactory.getLogger(AdminController.class);

	@PostMapping("/adminSignup")
	public ResponseEntity<Admin> adminSignup(@Valid @RequestBody Admin admin) {
		Admin ad = service.adminSignUp(admin);
		logger.info("Admin has " + ad);
		return new ResponseEntity<Admin>(ad, HttpStatus.CREATED);
	}

	@GetMapping("/adminlogin/{emailId}/{password}")
	public ResponseEntity<Admin> getLogin(@Valid @PathVariable("emailId") String emailId,
			@PathVariable("password") String password) {
		Admin admin = service.adminLogin(emailId, password);
		ad.save(admin);
		if (admin.getEmailId().equals(emailId) && admin.getPassword().equals(password)) {
			logger.info("Admin login successfully");
			return new ResponseEntity<Admin>(admin, HttpStatus.ACCEPTED);
		} else {
			logger.info("Admin not login successfully");
			return new ResponseEntity<Admin>(admin, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getAdminDetails/{emailId}")
	public ResponseEntity<Admin> getAdminDetaila(@Valid @PathVariable("emailId") String emailId) {
		Admin ad = service.getAdmin(emailId);
		if (ad.getEmailId().equals(emailId)) {
			return new ResponseEntity<Admin>(ad, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Admin>(ad, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(path = "/updateAdmin")
	public ResponseEntity<Admin> updateAdmin(@Valid @RequestBody Admin admin) {
		Admin ad = service.updateAdmin(admin);
		return new ResponseEntity<Admin>(ad, HttpStatus.OK);
	}

	@DeleteMapping("/deleteAdmin/{emailId}")
	public ResponseEntity<Admin> deleteAdmin(@Valid @RequestBody Admin admin) {
		Admin ad = service.deleteAdmin(admin);
		if (ad.getEmailId().equals(admin.getEmailId())) {
			return new ResponseEntity<Admin>(ad, HttpStatus.GONE);
		} else {
			return new ResponseEntity<Admin>(ad, HttpStatus.NOT_FOUND);
		}
	}
}
