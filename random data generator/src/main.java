

//import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		BufferedReader bufin = new BufferedReader(new InputStreamReader(System.in));
		int amount=0;
		try {
			amount = Integer.parseInt(bufin.readLine());
		} catch (IOException e) {
			// TODO Auto2-generated catch block
			e.printStackTrace();
		}
		*/
		
		int amount = Integer.parseInt(args[0]);
		String outputFile = args[2];
		System.out.println("Saving output to: " + outputFile);
		
		Society employee = new Society();
		employee.generateSociety(amount);
		//employee.printAll();
		
		//employee.removePerson(3);
		//employee.printAmount(5);
		if (Integer.parseInt(args[1]) == 0)
			employee.saveToXml(outputFile);
		else
			employee.saveToCsv(outputFile);
		//Person golota = new Person("andrzej", "golota", 1,1,1993);
		
		
		
		
	}

}
