import java.util.*;

public class Person {
	private
		String name, surname;
		int birth_day, birth_month, birth_year;
		ArrayList<phoneNumber> phone= new ArrayList<phoneNumber>();
		Salary salary;
		int pesel[] = new int[11];
	
	public Person(String name, String surname) {
		this.setName(name);
		this.setSurname(surname);
	}
		
	public Person(String name, String surname, int birth_day, int birth_month, int birth_year) {
		this(name, surname);
		this.birth_day = birth_day;
		this.birth_month = birth_month;
		this.birth_year = birth_year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public int getBirth_day() {
		return birth_day;
	}
	
	public int getBirth_month() {
		return birth_month;
	}
	
	public int getBirth_year() {
		return birth_year;
	}
	/*
	public phoneNumber getNumber(NumberType type) {
		
	}
	*/
	public void printNumbers() {
		for (phoneNumber p : phone)
			System.out.println(p.getNumber() + " " + p.getType());
	}
	
	public long getNumber(NumberType type) {
		long num=0;
		for (phoneNumber p : phone)
			if (p.getType() == type) {
				num =  p.getNumber();
				break;
			}
		return num;
	}
	
	public void addNumber(NumberType type, long number) {
		boolean exists = false;
		for (phoneNumber p : phone) 
			if (p.getType() == type) {
				exists = true;
				break;
			}
		if (!exists)
			phone.add(new phoneNumber(type, number));
	}
	
	public void addNumber(phoneNumber number) {
		this.addNumber(number.getType(), number.getNumber());
	}
	
	public void editNumber(NumberType type, long number) {
		for (phoneNumber p : phone) 
			if (p.getType() == type) {
				p.setNumber(number);
				break;
			}
	}
	
	public void editNumber(phoneNumber number) {
		this.editNumber(number.getType(), number.getNumber());
	}
	
	public void removeNumber(long number) {
		for (phoneNumber p : phone) 
			if (p.getNumber() == number) {
				phone.remove(p);
				break;
			}
	}
	
	public void removeNumber(NumberType type) {
		for (phoneNumber p : phone) 
			if (p.getType() == type) {
				phone.remove(p);
				break;
			}
	}
	public void removeNumber(phoneNumber number) {
		this.removeNumber(number.getNumber());
	}
	
	public Salary getSalary() {
		return salary;
	}
	
	public void setSalary (Salary salary) {
		this.salary = salary;
	}
	
	public int[] getPesel() {
		return pesel;
	}
	
	public void setPesel(int[] pesel) {
		for (int i=0; i<11; i++) 
			this.pesel[i] = pesel[i];
	}
}
