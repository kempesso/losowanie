import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Society {
	private ArrayList<Person> person = new ArrayList<Person>();
	
	public void generateSociety(int amount) {
		RandomDataGenerator generator = new RandomDataGenerator();
		person = generator.generateSociety(amount);
	}
	
	public void printAll() {
	
		for (Person p : person) {
			System.out.print(p.getId() + ";");
			System.out.print(p.getName() + ";" + p.getSurname() + ";" +
					p.getBirth_day() + "-" + p.getBirth_month() + "-" + p.getBirth_year()
					); 
			System.out.print(";"+p.getPesel());
			System.out.print(";"+p.getSalary());
			for (NumberType type : NumberType.values())
				System.out.print(";" + p.getNumber(type));
			System.out.println("");
		}
	}
	public void printAmount(int amount) {
		int count=0;
		for (Person p : person) {
			if (count++<amount) {
				System.out.print(p.getId() + ";");
				System.out.print(p.getName() + ";" + p.getSurname() + ";" +
						p.getBirth_day() + "-" + p.getBirth_month() + "-" + p.getBirth_year()
						); 
				System.out.print(";"+p.getPesel());
				System.out.print(";"+p.getSalary());
				for (NumberType type : NumberType.values())
					System.out.print(";" + p.getNumber(type));
				System.out.println("");
			}
			else
				break;
		}
	}

	public void clearAll() {
		person.clear();
	}
	public void removePerson(int id) {
		for (Person p: person)
			if (p.getId() == id) {
				person.remove(p);
				break;
			}
	}
	
	public void saveToXml(String fileName) {
		XML_FileManagement XmlManager = new XML_FileManagement();
		XmlManager.saveSocietyToFile(this, fileName);
	}
	public void personToXml(int id, String fileName) {
		for (Person p: person)
			if (p.getId() == id) {
				XML_FileManagement XmlManager = new XML_FileManagement();
				XmlManager.savePersonToFile(p, fileName);
				break;
			}
	}
	public void saveToCsv(String fileName) {
		CSV_FileManagement CsvManager = new CSV_FileManagement();
		CsvManager.saveSocietyToFile(this, fileName);
	}
	public void personToCsv(int id, String fileName) {
		for (Person p: person)
			if (p.getId() == id) {
				CSV_FileManagement CsvManager = new CSV_FileManagement();
				CsvManager.savePersonToFile(p, fileName);
				break;
			}
	}
	public ArrayList<Person> getPerson() {
		return person;
	}
	public void setPerson(ArrayList<Person> ludzie) {
		this.person= ludzie;
	}
}
