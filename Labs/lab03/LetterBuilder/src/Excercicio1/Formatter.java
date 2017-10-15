package Excercicio1;
/**Director**/
public class Formatter {
	private LetterBuilder _letterBuilder;
	private Person _letterSender;
	private Person _letterDestinatary;
	private Address _letterSenderAddress;
	private Address _letterDestinataryAddress;
	private Date _letterDate;
	
    public void setLetterBuilder(LetterBuilder lb) {
        _letterBuilder = lb;
    }
    public void setLetterSender(Person sender) {
    	_letterSender = sender;
	}
	public void setLetterDestinatary(Person destinatary) {
		_letterDestinatary = destinatary;
	}
	public void setLetterSenderAddress(Address addressSender) {
		_letterSenderAddress = addressSender;
	}
	public void setLetterDestinataryAddress(Address addressDestiny) {
		_letterDestinataryAddress = addressDestiny;
	}
	public void setLetterDate(Date date) {
		this._letterDate = date;
	}
   
    private void writeSender() {
    	_letterBuilder.setSender(_letterSender);
    }
    private void writeDest() {
    	_letterBuilder.setDestinatary(_letterDestinatary);
    }
    private void writeSenAddress() {
    	_letterBuilder.setSenderAddress(_letterSenderAddress);
    }
    private void writeDestAddress() {
    	_letterBuilder.setDestinataryAddress(_letterDestinataryAddress);
    }
    private void writeDate() {
    	_letterBuilder.setDate(_letterDate);
    }
    

    public void constructLetter() {
    	writeSender();
    	writeDest();
    	writeSenAddress();
    	writeDestAddress();
    	writeDate();
        _letterBuilder.Header();
        _letterBuilder.Greetings();
        _letterBuilder.Body();
        _letterBuilder.Conclusion();
        _letterBuilder.Signature();
    }
    
    public String getLetter() {
        return _letterBuilder.model();
    }
	
}


