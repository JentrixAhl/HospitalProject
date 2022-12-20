package com.company.HospitalProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
	
		Patient patient = new Patient("Mary", "102030", 30);
		
		@Autowired
		PatientList patientList;
		
		@GetMapping("/Mary")
		public String getPatient() {
			return patient.toString();
		}
		
		@GetMapping("/patient")
		public Patient getPatient(String personalNumber) {
			return patientList.getPatientByPersonalNumber(personalNumber);
		}
		
		@GetMapping("/patients")
		public Patient[] getPatientArray() {
			return patientList.getPatientsAsArray();
		}
		
		@PostMapping("patient")
		public String addPatient(Patient patient) {
			patientList.add(patient);
			return "Patient is admitted successfully!";
		}
		
		@PutMapping("patient")
		public ResponseEntity<String> changeName(String personalNumber, String newName) {
			boolean success = patientList.changeName(personalNumber, newName);
			if (success) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).body("The patient´s name is successfully changed!");
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Patient with such information is not found");
		}
		
		@DeleteMapping("patient")
		public ResponseEntity<String> deletePatient(String personalNumber) {
			boolean success = patientList.deletePatient(personalNumber);
			if (success) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).body("You have released a patient!");
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Patient with such information is not found");
		}
		
	

}
