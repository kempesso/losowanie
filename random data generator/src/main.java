
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
		Society employee = new Society();
		employee.generateSociety(amount);
		//employee.printAll();
		
		employee.removePerson(3);
		employee.printAmount(5);
		
	}

}
