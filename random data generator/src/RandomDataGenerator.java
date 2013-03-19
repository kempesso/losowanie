import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RandomDataGenerator {
	static final String NamesFile = "names.txt";
	static final String SurnamesFile = "surnames.txt";
	static ArrayList<String> names = new ArrayList<String>();
	static ArrayList<String> surnames = new ArrayList<String>();
		
	public RandomDataGenerator() {

		this.refreshFiles();
	}
	
	public ArrayList<Person> generateSociety(int amount){
		ArrayList<Person> zbior = new ArrayList<Person>();

		for (int i = 0; i<amount; i++) {
			zbior.add(randomPerson());
		}
		return zbior;
	}
	private Person randomPerson() {
		Random randomer = new Random();
		
		/* random name from name and surname list files */
		String name = names.get(randomer.nextInt(names.size()));
		String surname = surnames.get(randomer.nextInt(surnames.size()));
		
		/* random date of birth from 01-01-1900 to 31-12-1999*/
		int birth_year = randomer.nextInt(100)+1900; // random year 1900-1999
		int birth_month = randomer.nextInt(12)+1; // random month 1-12
		int day_amount;
		if (birth_month == 1 || birth_month == 3 || birth_month == 5 || birth_month == 7 || birth_month == 8 || birth_month == 10 || birth_month == 12)
			day_amount=31;
		else if (birth_month == 2)
			if (czyPrzestepny(birth_year))
				day_amount=29;
			else 
				day_amount=28;
		else
			day_amount=30;
		int birth_day = randomer.nextInt(day_amount)+1;
		
		/*create new person*/
		Person person = new Person(name, surname, birth_day, birth_month, birth_year);
		
		/* each phone number contain 9 digits and starts with 1-9*/
		long mobile_number = randomer.nextInt(900000000)+100000000;
		long landline_number = randomer.nextInt(900000000)+100000000;
		long work_number = randomer.nextInt(900000000)+100000000;
		person.addNumber(NumberType.mobile, mobile_number);
		person.addNumber(NumberType.landline, landline_number);
		person.addNumber(NumberType.work, work_number);
		
		/*random Salary*/
		int result = randomer.nextInt(Salary.values().length);
		person.setSalary(Salary.values()[result]);
		
		/* "pesel" */
		String pesel;
		pesel = ""+birth_year;
		if (birth_month<10)
			pesel += "0";
		pesel+= birth_month;
		if (birth_day<10)
			pesel+= "0";
		pesel+= birth_day;
		pesel += randomer.nextInt(10);
		pesel += randomer.nextInt(10);
		pesel += randomer.nextInt(10);
		short gender;
		if (name.endsWith("a")) 
				while((gender = (short)  randomer.nextInt(10)) % 2 == 1);
		else
				while((gender = (short) randomer.nextInt(10)) % 2 == 0);
		pesel += gender;
		/*cyfra kontrolna*/
		pesel+=((10  
				- (Integer.parseInt(pesel.substring(0, 1))*1 
				+ Integer.parseInt(pesel.substring(1, 2))*3 + Integer.parseInt(pesel.substring(2, 3))*7 
				+ Integer.parseInt(pesel.substring(3, 4))*9 + Integer.parseInt(pesel.substring(4, 5))*1 
				+ Integer.parseInt(pesel.substring(5, 6))*3 + Integer.parseInt(pesel.substring(6, 7))*7 
				+ Integer.parseInt(pesel.substring(7, 8))*9 + Integer.parseInt(pesel.substring(8, 9))*1 
				+ Integer.parseInt(pesel.substring(9, 10))*3) 
				% 10));
		person.setPesel(pesel);
		
		return person;
	}
	
	public void refreshFiles() {
		names = readFile(RandomDataGenerator.NamesFile);
		surnames = readFile(RandomDataGenerator.SurnamesFile);
	}
	private ArrayList<String> readFile(String fileName){
		ArrayList<String> array = new ArrayList<String>();
		
		File file = new File(fileName);
	    Scanner in;
		try {
			in = new Scanner(file);
			while (in.hasNextLine())
		    	array.add(in.nextLine());
		    	
		    in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}
	
	private boolean czyPrzestepny(int rok)
	   {   
	       return ((rok%4 == 0 && rok%100 != 0) || rok%400 == 0);
	   }
}
