
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader bufin = new BufferedReader(new InputStreamReader(System.in));
		int amount=0;
		try {
			amount = Integer.parseInt(bufin.readLine());
		} catch (IOException e) {
			// TODO Auto2-generated catch block
			e.printStackTrace();
		}
		System.out.println(amount);
		RandomDataGenerator generator = new RandomDataGenerator();
		ArrayList<Person> ludzie = new ArrayList<Person>();
		ludzie = generator.generateSociety(amount);
		for (Person p : ludzie) {
			System.out.print(p.getName() + " " + p.getSurname() + " " +
					p.getBirth_day() + "-" + p.getBirth_month() + "-" + p.getBirth_year() +
					" "); 
			for (int i=0; i<11; i++)
				System.out.print(p.getPesel()[i]);
			System.out.println("");
		}
	}

}
