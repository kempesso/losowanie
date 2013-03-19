import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class CSV_FileManagement implements FilesManagement{

	@Override
	public void savePersonToFile(Person person, String fileName) {
		// TODO Auto-generated method stub
		try {
			PrintWriter zapis = new PrintWriter(fileName);
			zapis.print(personToString(person));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void saveSocietyToFile(Society society, String fileName) {
		String result = "";
		for (Person person : society.getPerson()) {
			result += personToString(person);
			result += System.getProperty("line.separator");
		}
		try {
			PrintWriter zapis = new PrintWriter(fileName);
			zapis.print(result);
			zapis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String personToString(Person person) {
		String result="";
		result+= person.getId() + ";";
		result+= person.getName() + ";" + person.getSurname() + ";" +
				 person.getBirth_day() + "-" + person.getBirth_month() + "-" 
				 + person.getBirth_year(); 
		result+= ";"+person.getPesel();
		result+= ";"+person.getSalary();
		for (NumberType type : NumberType.values())
			result+= ";" + person.getNumber(type);
		return result;
	}

}
