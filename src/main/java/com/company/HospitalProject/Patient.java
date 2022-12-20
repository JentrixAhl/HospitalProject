package com.company.HospitalProject;

import java.util.Objects;

public class Patient {
		private String name;
		private String personalNumber;
		private int age;
		public Patient(String name, String personalNumber, int age) {
			super();
			this.name = name;
			this.personalNumber = personalNumber;
			this.age = age;
		}
		@Override
		public String toString() {
			return "Patient [name=" + name + ", personalNumber=" + personalNumber + ", age=" + age + "]";
		}
		@Override
		public int hashCode() {
			return Objects.hash(age, name, personalNumber);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Patient other = (Patient) obj;
			return age == other.age && Objects.equals(name, other.name)
					&& Objects.equals(personalNumber, other.personalNumber);
		}
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
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
	}



