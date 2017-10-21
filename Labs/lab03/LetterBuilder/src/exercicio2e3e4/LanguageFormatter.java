package exercicio2e3e4;

public abstract class LanguageFormatter {
	AddressFormatter AF;
	DateFormatter DF;
	PhoneFormatter PF;
	NameFormatter NF;
	
	public void setAddressFormatter(AddressFormatter af) {
		AF = af;
	}
	
	public void setDateFormatter(DateFormatter df) {
		DF =  df;
	}
	
	public void setPhoneFormatter(PhoneFormatter pf) {
		PF =  pf;
	}
	
	public void setFormattedName(NameFormatter nf) {
		NF = nf;
	}
	
	public AddressFormatter getAddressFormatter() {
		return AF;
	}
	
	public DateFormatter getDateFormatter() {
		return DF;
	}
	
	public String getFormattedAddress(Address add) {
		return AF.formatAddress(add);
	}
	
	public String getFormattedDate(Date date) {
		return DF.formatDate(date);
	}
	
	public String getFormattedPhone(Phone phone) {
		return PF.formatPhone(phone);
	}
	
	public String getFormattedName(Person person) {
		return NF.formatName(person);
	}
	
}
