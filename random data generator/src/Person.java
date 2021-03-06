

import java.util.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"name", "surname", "birth_day", "birth_month", 
		"birth_year", "pesel", "salary", "phone"})
@XmlRootElement
public class Person {
	private int id;
	private	static int amount_created=0;
	private	String name, surname;
	private	int birth_day, birth_month, birth_year;
	private	ArrayList<phoneNumber> phone= new ArrayList<phoneNumber>();
	private	Salary salary;
	private	String pesel;
	
	public Person() {}
	public Person(String name, String surname) {
		this.setName(name);
		this.setSurname(surname);
		setId(++amount_created);
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
	@XmlElement
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
	public void setBirth_day(int birth_day) {
		this.birth_day = birth_day;
	}
	public int getBirth_month() {
		return birth_month;
	}
	public void setBirth_month(int birth_month) {
		this.birth_month = birth_month;
	}
	public int getBirth_year() {
		return birth_year;
	}
	public void setBirth_year(int birth_year) {
		this.birth_year = birth_year;
	}
	
	public void printNumbers() {
		for (phoneNumber p : phone)
			System.out.println(p.getNumber() + " " + p.getType());
	}
	
	public ArrayList<phoneNumber> getPhone() {
		return phone;
	}
	@XmlElement
	public void setPhone(ArrayList<phoneNumber> phone) {
		this.phone = phone;
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
	
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		for (int i=0; i<11; i++) 
			this.pesel = pesel;
	}

	
	public int getId() {
		return id;
	}
	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
}
