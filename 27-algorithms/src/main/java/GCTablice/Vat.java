package GCTablice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Vat{

	private static final BigDecimal stawkaVat = BigDecimal.valueOf(0.23);

	public static void start() {

		List<BigDecimal> kwota = new ArrayList<>();
		List<BigDecimal> kwotaVat = new ArrayList<>();
		Random kwotaRandom = new Random();
		double kwotaZwracana;


		while (true) {
			kwotaZwracana = kwotaRandom.nextInt(2147483647);
			BigDecimal ammount = BigDecimal.valueOf(kwotaZwracana);
			kwota.add(ammount);
			kwotaVat.add(ammount.multiply(stawkaVat).setScale(2, RoundingMode.HALF_UP));
			//System.out.println("Kwota wynosi: " + kwota + " " + "Stawka Vat: " + kwotaVat);
			//Arrays.asList(kwota).stream().forEach(s -> System.out.println(s));
			kwotaVat.stream().forEach(System.out::println);
		}
		}

	public static void main(String[] args) {
		Vat.start();
	}
	}

