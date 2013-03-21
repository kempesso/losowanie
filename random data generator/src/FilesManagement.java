
public interface FilesManagement {
	public void savePersonToFile(Person person, String fileName);
	public void saveSocietyToFile(Society society, String fileName);
	public Society recoverSocietyFromFile(String fileName);
	public Person recoverPersonFromFile(String fileName);
}
