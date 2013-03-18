import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RandomDataGenerator {
	private
		static final String NamesFile = "names.txt";
		static final String SurnamesFile = "surnames.txt";
	
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
		ArrayList<String> names = readFile(RandomDataGenerator.NamesFile); 
		ArrayList<String> surnames = readFile(RandomDataGenerator.SurnamesFile);
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
		short pesel[] = new short[11];
		String date = ""+birth_year;
		if (birth_month<10)
			date += "0";
		date+= birth_month;
		if (birth_day<10)
			date+= "0";
		date+= birth_day;
		pesel[0] = (short) Integer.parseInt(date.substring(2, 3));
		pesel[1] = (short) Integer.parseInt(date.substring(3, 4));
		pesel[2] = (short) Integer.parseInt(date.substring(4, 5));
		pesel[3] = (short) Integer.parseInt(date.substring(5, 6));
		pesel[4] = (short) Integer.parseInt(date.substring(6, 7));
		pesel[5] = (short) Integer.parseInt(date.substring(7, 8));
		pesel[6] = (short) randomer.nextInt(10);
		pesel[7] = (short) randomer.nextInt(10);
		pesel[8] = (short) randomer.nextInt(10);
		if (name.endsWith("a")) 
				while((pesel[9] = (short)  randomer.nextInt(10)) % 2 == 1);
		else
				while((pesel[9] = (short) randomer.nextInt(10)) % 2 == 0);
		/*cyfra kontrolna*/
		pesel[10] =(short) ( 10 - ( (pesel[0]*1 + pesel[1]*3 + pesel[2]*7 + pesel[3]*9
				+ pesel[4]*1 + pesel[5]*3 + pesel[6]*7 + pesel[7]*9
				+ pesel[8]*1 + pesel[9]*3) % 10));
		person.setPesel(pesel);
		
		return person;
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
