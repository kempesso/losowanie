
import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


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
	 
		      } catch (JAXBException e) {
			e.printStackTrace();
		      }
	}

	@Override
	public Society recoverSocietyFromFile(String fileName) {
		// TODO Auto-generated method stub
		Society society=null;
		File file = new File(fileName);
		if (!file.exists())
			return null;
		else {
			try {
				
				JAXBContext jaxbContext = JAXBContext.newInstance(Society.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		 
				// output pretty printed
				society =  (Society) jaxbUnmarshaller.unmarshal(file);
	
			      } catch (JAXBException e) {
			    	  e.printStackTrace();
			      } 
			return society;
		}
	}

	@Override
	public Person recoverPersonFromFile( String fileName) {
		// TODO Auto-generated method stub
		return null;
		
	}
	
}
