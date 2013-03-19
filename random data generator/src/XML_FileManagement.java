
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class XML_FileManagement implements FilesManagement{

	@Override
	public void savePersonToFile(Person person, String fileName) {
		// TODO Auto-generated method stub
		try {
			 
			File file = new File(fileName);
			JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 
			jaxbMarshaller.marshal(person, file);
			jaxbMarshaller.marshal(person, System.out);
	 
		      } catch (JAXBException e) {
			e.printStackTrace();
		      }
	}
	
	@Override
	public void saveSocietyToFile(Society society, String fileName) {
		// TODO Auto-generated method stub
		try {
			 
			File file = new File(fileName);
			JAXBContext jaxbContext = JAXBContext.newInstance(Society.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 
			jaxbMarshaller.marshal(society, file);
			jaxbMarshaller.marshal(society, System.out);
	 
		      } catch (JAXBException e) {
			e.printStackTrace();
		      }
	}
	
}
