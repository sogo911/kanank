package com.kabank.web.serviceImpl;

import java.util.Random;
import java.util.Scanner;

public class AccountServiceImpl {
	private String name;
	private int accountNum;
	
	public void setName(String name) {
		this. name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setAccountNum() {
	//	this.accountNum;
		Random r = new Random();
	//	int accountNo = 0;
		boolean flag = true;
		while(flag) {
			int temp = r.nextInt(1000000);
			if(temp >= 100000) {
				flag = false;
				accountNum = temp;
	//			accountNo = temp;
			}else {
				flag = true;
			}
		}
	}
	public int getAccountNum() {
		return this.accountNum;
	}
}
