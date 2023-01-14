import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class CallerServer {
	public Patient getPatientByPersonalNumber(String personalNumber) {
		
		try {
			URL url = new URL("http://localhost:8080/patient?personalNumber=" + personalNumber); 
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			
			int code = connection.getResponseCode();
			System.out.println("Code "+code);
			if (code > 199 && code < 300) {
				InputStream inputStream = connection.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader in = new BufferedReader(inputStreamReader);
				
				
				String jsonString = "";
				
				String inputLine = in.readLine();
				while (inputLine != null) {
					jsonString += inputLine;
					inputLine = in.readLine();
				}
				
				if(jsonString == "") {
					return null;
				}
				
				
				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);
				
				Patient patient = new Patient();
				patient.setName((String)jsonObject.get("name"));
				patient.setPersonalNumber((String)jsonObject.get("personalNumber"));
				patient.setAge((long)jsonObject.get("age"));
				System.out.println("Patient");
				return patient;
			}
			else {
				System.out.println("An error has occured. Error code: " + code);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	public void admitPatient(String name, String personalNumber, String age) {
		try {
			Integer.parseInt(age);
		}
		catch(Exception e) {
			System.out.println("Enter age as a number");
			return;
		}
		
		try {
			URL url = new URL("http://localhost:8080/patient?name="+ name +"&personalNumber="+ personalNumber +"&age="+ age );
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.connect();
			
			int code = connection.getResponseCode();
			if (code == 200) {
				System.out.println(name + " added to database!");
			}
			else if (code == 412) {
				System.out.println("Bad request!");
			}
			else {
				System.out.println("An error has occured. Error code: " + code);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void updatePatientDetails(String personalNumber, String newName) {
		try {
			URL url = new URL("http://localhost:8080/patient?personalNumber="+ personalNumber + "&newName=" + newName);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("PUT");
			connection.connect();
			
			int code = connection.getResponseCode();
			if (code == 202) {
				System.out.println("You have successfully changed the patient´s name!");
			}
			else if (code == 404) {
				System.out.println("There is no patient with that personalNumber.");
			}
			else {
				System.out.println("An error has occured. Error code: " + code);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void releasePatient(String personalNumber) {
		try {
			URL url = new URL("http://localhost:8080/patient?personalNumber="+ personalNumber);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("DELETE");
			connection.connect();
			
			int code = connection.getResponseCode();
			if (code == 202) {
				System.out.println("You have successfully released a patient!");
			}
			else if (code == 400) {
				System.out.println("There is no patient with that personalNumber");
			}
			else {
				System.out.println("An error has occured. Error code: " + code);
			}
			}
			catch(Exception e) {
			System.out.println(e);
			}
		
	}

	public ArrayList<Patient> getAllPatients() {
		try {
			URL url = new URL("http://localhost:8080/patients");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			
			int code = connection.getResponseCode();
			if (code > 199 && code < 300) {
				InputStream inputStream = connection.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader in = new BufferedReader(inputStreamReader);
				
				String inputLine = in.readLine();
				
				String jsonString = "";
				
				while (inputLine != null) {
					jsonString += inputLine;
					inputLine = in.readLine();
				}
				
				JSONParser jsonParser = new JSONParser();
				JSONArray jsonArrayObject = (JSONArray) jsonParser.parse(jsonString);
				
				ArrayList<Patient> listofallpatients = new ArrayList<>();
				
				
				
				for(Object object : jsonArrayObject) {
					JSONObject jsonObject = (JSONObject)object;
					
					Patient patient = new Patient("Mary", "102030", 30);
					patient.setName((String)jsonObject.get("name"));
					patient.setPersonalNumber((String)jsonObject.get("personalNumber"));
					patient.setAge((long)jsonObject.get("age"));
					
					listofallpatients.add(patient);
					
					
				}
				return listofallpatients;
			}
			else {
				System.out.println("An error has occured. Error code: " + code);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
}

