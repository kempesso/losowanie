import java.util.ArrayList;


public class Society {
	private
		ArrayList<Person> ludzie = new ArrayList<Person>();
	public void generateSociety(int amount) {
		RandomDataGenerator generator = new RandomDataGenerator();
		ludzie = generator.generateSociety(amount);
	}
	
	public void printAll() {
	
		for (Person p : ludzie) {
			System.out.print(p.getId() + ";");
			System.out.print(p.getName() + ";" + p.getSurname() + ";" +
					p.getBirth_day() + "-" + p.getBirth_month() + "-" + p.getBirth_year() +
					";"); 
			for (int i=0; i<11; i++)
				System.out.print(p.getPesel()[i]);
			System.out.print(";"+p.getSalary());
			for (NumberType type : NumberType.values())
				System.out.print(";" + p.getNumber(type));
			System.out.println("");
		}
	}
	public void printAmount(int amount) {
		int count=0;
		for (Person p : ludzie) {
			if (count++<amount) {
				System.out.print(p.getId() + ";");
				System.out.print(p.getName() + ";" + p.getSurname() + ";" +
						p.getBirth_day() + "-" + p.getBirth_month() + "-" + p.getBirth_year() +
						";"); 
				for (int i=0; i<11; i++)
					System.out.print(p.getPesel()[i]);
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
		ludzie.clear();
	}
	public void removePerson(int id) {
		for (Person p: ludzie)
			if (p.getId() == id) {
				ludzie.remove(p);
				break;
			}
	}
	

}
