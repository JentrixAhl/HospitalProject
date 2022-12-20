package com.company.HospitalProject;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class PatientList {

	ArrayList<Patient> patientList = new ArrayList<>();
	
	public PatientList() {
		patientList.add(new Patient("Mary", "102030",30));
		patientList.add(new Patient("Tom", "121050",10));
		patientList.add(new Patient("Oscar", "200110",2));
		patientList.add(new Patient("Chris", "701522",70));
		patientList.add(new Patient("Lisa", "960505",20));
	}

	public Patient getPatientByPersonalNumber(String personalNumber) {
		for(Patient patient : patientList) {
			if (patient.getPersonalNumber().equals(personalNumber)) {
				return patient;
			}
		}
		 
		return null;
	}

	public Patient[] getPatientsAsArray() {
		Patient[] patientArray = new Patient[patientList.size()];
		for(int i = 0; i < patientArray.length; i++) {
			patientArray[i] = patientList.get(i); 
		}
		return patientArray;
	}

	public void add(Patient patient) {
		patientList.add(patient);
	}

	public boolean changeName(String personalNumber, String newName) {
		for(Patient patient : patientList) {
			if (patient.getPersonalNumber().equals(personalNumber)) {
				patient.setName(newName);
				return true;
			}
		}
		return false;
	}

	public boolean deletePatient(String personalNumber) {
		Patient patientToDelete = null;
		for(Patient patient : patientList) {
			if (patient.getPersonalNumber().equals(personalNumber)) {
				patientToDelete = patient;
				break;
			}
		}
		if (patientToDelete != null) {
			patientList.remove(patientToDelete);
			return true;
		}
		return false;

	}

}
