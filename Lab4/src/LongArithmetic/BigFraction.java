package LongArithmetic;

import java.math.BigInteger;

public class BigFraction {
	
	/** Поле числитель */
	public BigInteger numerator;
	/** Поле знаменатель */
	public BigInteger denominator; 
	
	/**
	* Конструктор принимающий параметры типа BigInteger.
	* @param numerator числитель 
	* @param denominator знаменатель
	* @see BigFraction#BigFraction(String, String)
	*/
	public BigFraction (BigInteger numerator, BigInteger denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	/**
	* Конструктор принимающий параметры типа String.
	* @param numerator числитель 
	* @param denominator знаменатель
	* @see BigFraction#BigFraction(BigInteger, BigInteger)
	*/
	public BigFraction (String numerator, String denominator) {
		this.numerator = new BigInteger(numerator);
		this.denominator = new BigInteger(denominator);
	}
	
	/**
	* Функция сложения {@link BigFraction#add}.
	* @param arg дробь 
	* @return Сумма дробей
	*/
	public BigFraction add(BigFraction arg) {
		return new BigFraction((numerator.multiply(arg.denominator)).add(arg.numerator.multiply(denominator)), denominator.multiply(arg.denominator));
	}
	
	/**
	* Функция вычитания {@link BigFraction#subtract}.
	* @param arg дробь 
	* @return Разность дробей
	*/
	public BigFraction subtract(BigFraction arg) {
		return new BigFraction((numerator.multiply(arg.denominator)).subtract(arg.numerator.multiply(denominator)), denominator.multiply(arg.denominator));
	}
	
	/**
	* Функция умножения {@link BigFraction#multiply}.
	* @param arg дробь 
	* @return Произведение дробей
	*/
	public BigFraction multiply(BigFraction arg) {
		return new BigFraction(numerator.multiply(arg.numerator), denominator.multiply(arg.denominator));
	}
	
	/**
	* Функция деления {@link BigFraction#divide}.
	* @param arg дробь 
	* @return Частное дробей
	*/
	public BigFraction divide(BigFraction arg) {
		return new BigFraction(numerator.multiply(arg.denominator), denominator.multiply(arg.numerator));
	}
	
	/**
	* Функция сокращения {@link BigFraction#reduction}.
	* @return Сокращенная дробь
	*/
	public BigFraction reduction() {
		BigInteger zero = BigInteger.valueOf(0);
		if (numerator.compareTo(zero) != 0) {
			BigInteger gcd = numerator.abs().gcd(denominator.abs());
	        numerator = numerator.divide(gcd);
	        denominator = denominator.divide(gcd);
		}
		return this;
	}
	
	/**
	* Переопределение метода toString {@link BigFraction#toString}.
	* @return представление экземпляра класса в строковом виде
	*/
	public String toString() {
		BigInteger zero = BigInteger.valueOf(0);
		BigInteger one = BigInteger.valueOf(1);
		if (numerator.compareTo(zero) == 0) {
			return "0";
		} else {
			if (denominator.compareTo(one) == 0) {
				return numerator + "";
			}	
		}
		return numerator + "/" + denominator;
	}
}