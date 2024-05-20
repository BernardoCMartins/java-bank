package util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Util {

	static NumberFormat valoresFormatados = new DecimalFormat("R$ #,##0.00");
	
	public static String doubleToString(Double valor) {
		return valoresFormatados.format(valor);
	}
	
	
}
