package pl.sdacademy.smartfon;

public class SmartfonMain {

	public static void main(String[] args) {
		Komputer komputer = new Smartfon();
		Telefon telefon = (Telefon) komputer;
		Smartfon smartfon = (Smartfon) komputer;

		//komputer.dzwonDO("234235234");
		telefon.dzwonDO("23234243");
		smartfon.przegladarka("google.com");
		smartfon.wyslijSMS("234234");
	}

}
