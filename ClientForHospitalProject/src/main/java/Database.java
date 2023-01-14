import java.util.ArrayList;
import java.util.Scanner;


public class Database {
	CallerServer callerServer = new CallerServer();
	Scanner scanner = new Scanner(System.in);

	public Database() {
	}
	
	public void run() {
		
	}
	boolean exitHospitalMenu = true;{	
		System.out.println("Welcome to Ahl´s In/Out patient Hospital.");
    do{ 
		System.out.println("0. Get patients");
		System.out.println("1. Get patient");
		System.out.println("2. Admit patient");
		System.out.println("3. Update patient details");
		System.out.println("4. Release patient");
		System.out.println("5. Exit");
		String menu = scanner.nextLine();
    	System.out.println("My choice is :- ["+menu+"]");
		switch(menu)  {
		case "0" :
			System.out.println();
			try {
		
				getPatients();
				
			}
			catch (Exception e) {
				System.out.println("No patient list was found!");
			}
			break;
	
		case "1" :
			getPatient();
			break;
			
		case "2" :
			 admitPatient();
			break;
			
		case "3" :
		  updatePatientDetails();
		    break;
			
		case "4" :
		   ReleasePatient();
		    break;
		case "5":
			System.out.println("Thank you. You have successfully exited the Menu.");
			exitHospitalMenu = false;
			break;
	} 
    }while(exitHospitalMenu);
  
	scanner.close();	
	
	}
		private void getPatients() {
			ArrayList<Patient> patientList = callerServer.getAllPatients();
			for(Patient patient : patientList) {
				System.out.println(patient.toString());
			}
		}

		private void ReleasePatient() {
			System.out.println("Enter patient´s personalNumber");
			String personalNumber = scanner.nextLine();
			callerServer.releasePatient(personalNumber);
		}

		private void updatePatientDetails() {
			System.out.println("Enter patient´s personalNumber");
			String personalNumber = scanner.nextLine();
			System.out.println("Enter patient´s newName");
			String newName = scanner.nextLine();
			callerServer.updatePatientDetails(personalNumber, newName);
		}

		private void admitPatient() {
			System.out.println("Enter Patient´s name");
			String name = scanner.nextLine();
			System.out.println("Enter patient´s personalNumber");
			String personalNumber = scanner.nextLine();
			System.out.println("Enter patient´s age");
			String age = scanner.nextLine();
			callerServer.admitPatient(name,personalNumber,age);
		}

		private void getPatient() {
			System.out.println("Enter patient´s personalNumber");
			String personalNumber = scanner.nextLine();
			System.out.println("personalNumber ["+personalNumber+"]");
			Patient patient = callerServer.getPatientByPersonalNumber(personalNumber);
			if (patient != null) {
				System.out.println(patient);
			}
		}
		
}

