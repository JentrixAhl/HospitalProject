
public class Patient {
	private String name;
	private String personalNumber;
	private long age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPersonalNumber() {
		return personalNumber;
	}
	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}
	
	public Patient(String name, String personalNumber, long age) {
		super();
		this.name = name;
		this.personalNumber = personalNumber;
		this.age = age;
	}
	
	
	public Patient() {
		
	}
	@Override
	public String toString() {
		return "Patient [name=" + name + ", personalNumber=" + personalNumber + ", age=" + age + "]";
	}
}
