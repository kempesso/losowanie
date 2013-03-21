import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class phoneNumber {
	private
		NumberType type;
		long number;
	
	public phoneNumber() {};
	public phoneNumber(NumberType type, long number) {
		this.setType(type);
		this.setNumber(number);
	}

	public NumberType getType() {
		return type;
	}
	@XmlAttribute
	public void setType(NumberType type) {
		this.type = type;
	}
	
	public long getNumber() {
		return number;
	}
	
	public void setNumber(long number) {
		this.number = number;
	}
	
}
