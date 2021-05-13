package com.company;

import java.math.BigDecimal;

public class PowerOfTen {

	public static void main(String[] args) {

		System.out.println(isPowerOfTen2(100000000));
	}

	boolean isPowerOfTen(int n){

		if( n == 1)
			return true;

		String num = String.valueOf(n);

		return num.charAt(0) == '1' && Integer.parseInt(num.substring(1)) == 0;
	}

	public static boolean isPowerOfTen2(long value) {
		// updated answer - check for precision in if statement
		if (value >= 1e14) {
			try {
				return isPowerOfTen2(BigDecimal.valueOf(value)
						.divide(BigDecimal.valueOf(1e14)).longValueExact());
			} catch (ArithmeticException e) {
				return false;
			}
		}
		double power = Math.log10(value);
		return Double.isFinite(power) && Math.round(power) == power;
	}
}
