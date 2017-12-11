/*
 * @(#)WithdrawalDto.java 1.0 9 de dez de 2017
 *
 * Copyright (c) 2017, Mult-e
 */
package br.com.atm.model.dto;

/**
 * <p>
 * The class <code>WithdrawalDto.java</code>
 * </p>
 *
 * @author Mult-e
 * @since 9 de dez de 2017
 * @version 1.0 9 de dez de 2017
 */
public class WithdrawalDto {

	private int one;
	private int two;
	private int five;
	private int ten;
	private int twenty;
	private int fifty;
	private int hundred;

	public WithdrawalDto(double value) {
		getCash(value);
	}

	private void getCash(double value) {
		
		int cash[] = new int[]{100,50,20,10,5,2,1};
		int countCash[] = new int[]{0,0,0,0,0,0,0};
		
		for (int cashElement = 0; cashElement < cash.length; cashElement++) {
			if (value >= cash[cashElement]) {
				value-=cash[cashElement];
				countCash[cashElement]++;
				
				cashElement--;
			}
		}
		
		int pos = 0;
		this.hundred = countCash[pos++];
		this.fifty = countCash[pos++];
		this.twenty = countCash[pos++];
		this.ten = countCash[pos++];
		this.five = countCash[pos++];
		this.two = countCash[pos++];
		this.one = countCash[pos];
	}

	public int getOne() {
		return one;
	}

	public int getTwo() {
		return two;
	}

	public int getFive() {
		return five;
	}

	public int getTen() {
		return ten;
	}

	public int getTwenty() {
		return twenty;
	}

	public int getFifty() {
		return fifty;
	}

	public int getHundred() {
		return hundred;
	}
}
