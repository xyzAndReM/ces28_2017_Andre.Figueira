package Excercicio2e3;



public interface FormatterAbstractFactory {
	public void setLetterBuilder(LetterBuilder lb) ;
    public void setLetterSender(Person sender) ;
	public void setLetterDestinatary(Person destinatary);
	public void setLetterSenderAddress(Address addressSender) ;
	public void setLetterDestinataryAddress(Address addressDestiny) ;
	public void setLetterDate(Date date) ;
	
	public void formatAddress(Address add);
	public void formatDate(Date date);
	
	
    public void writeSender();
    public void writeDest() ;
    public void writeSenAddress();
    public void writeDestAddress();
    public void writeDate() ;
    

    public void constructLetter() ;
    public String getLetter() ;
}
