package Excercicio2e3;



public class EnglishFormatter implements FormatterAbstractFactory {
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
	
	
	public void formatAddress(Address add) {
		add.set_DisplayFormat ( add.get_Number() + " " + add.get_Street() + ",\nZip Code:" + add.get_Zipcode() + "\n" + add.get_City() + ", " + add.get_State()  + "\n");
	}
	public void formatDate(Date date) {
		date.set_DisplayFormat( date.get_Month() + "/" + date.get_Day() + "/" + date.get_Year() );
	}
	public void formatGreetings() {
		_letterBuilder.setGreetings("Dear");
	}
	public void formatBody() {
		_letterBuilder.setBody("Write your message here");
	}
	public void formatConclusion() {
		_letterBuilder.setConclusion("Sincerely");
	}
	
	
   
    public void writeSender() {
    	_letterBuilder.setSender(_letterSender);
    }
    public void writeDest() {
    	_letterBuilder.setDestinatary(_letterDestinatary);
    }
    public void writeSenAddress() {
    	formatAddress(_letterSenderAddress);
    	_letterBuilder.setSenderAddress(_letterSenderAddress);
    }
    public void writeDestAddress() {
    	formatAddress(_letterDestinataryAddress);
    	_letterBuilder.setDestinataryAddress(_letterDestinataryAddress);
    }
    public void writeDate() {
    	formatDate(_letterDate);
    	_letterBuilder.setDate(_letterDate);
    }
    

    public void constructLetter() {
    	writeSender();
    	writeDest();
    	writeSenAddress();
    	writeDestAddress();
    	writeDate();
    	formatGreetings();
    	formatBody();
    	formatConclusion();
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
