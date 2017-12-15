package com.kabank.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javax.security.sasl.SaslClient;
import javax.swing.JOptionPane;

import com.kabank.web.bean.MemberBean;
import com.kabank.web.serviceImpl.AccountServiceImpl;
import com.kabank.web.serviceImpl.MemberServiceImpl;

public class Portal {
	public static void main(String[] args) {
		MemberServiceImpl memberService = new MemberServiceImpl();
		MemberBean member = null;
		
		while(true) {
		switch (JOptionPane.showInputDialog("[MENU] 0.종료\n "
				+ "1.회원가입 2.계좌개설 3.총회원\n "
				+ "4.회원목록 5.로그인 6.회원검색 "
				+ "7.이름검색 8.비번수정 9.회원탈퇴 \n"
				+ "10.회원전체삭제")) {
		case "0" : 
			JOptionPane.showMessageDialog(null, "종료");
				return;
		case "1" : 
			member = new MemberBean();
			String spec = JOptionPane.showInputDialog("이름/주민번호/ID/PASS");  
		//	String[] arr = spec.split("/");	 "/"가 입력되면 다음 입력으로 인식.
			String[] dummy = {
					"홍길동/800101-1234567/hong/1",
					"김유신/900203-1334567/kim/1",
					"김유신/950303-1315666/gim/1",
					"이이/920102-1444567/lee/1",
					"유관순/850506-2234567/you/1",
					"신사임당/950101-2734567/shin/1"
			};
			for(int i = 0 ; i < dummy.length; i++) {
				member = new MemberBean();
				String[] arr = dummy[i].split("/");
				member.setName(arr[0]);
				member.setSsn(arr[1]);
				member.setId(arr[2]);
				member.setPass(arr[3]);
				member.setCustomNum(memberService.createCustomNum());
				member.setGender(memberService.findGender(member.getSsn()));
				member.setAge(memberService.findAge(member.getSsn()));
				memberService.addMember(member);
			}
			break;
		case "2" :
			AccountServiceImpl accountService = new AccountServiceImpl();
			JOptionPane.showInputDialog("이름을 입력하세요");
		//	accountService.setName(scanner.next());
			accountService.setAccountNum();
			JOptionPane.showMessageDialog(null,
					"[이름]"+accountService.getName()
					+"[계좌번호]"+accountService.getAccountNum());
			break;
		case "3":
			JOptionPane.showMessageDialog(null,"총 회원수 : "+ memberService.count());
			break;
		case "4":
			List<MemberBean> members = memberService.list();
			JOptionPane.showMessageDialog(null, 
					memberService.list());
			break;
		case "5": 
			String[] arr = JOptionPane.showInputDialog(
					"ENTER ID & PASS").split("/");
			member = new MemberBean();
			member.setId(arr[0]);
			member.setPass(arr[1]);
			JOptionPane.showMessageDialog(null,
					memberService.login(member));
			break;
		case "6":
			member = memberService.findById(
			JOptionPane.showInputDialog(
					"ENTER ID").toString());
			JOptionPane.showMessageDialog(null,member);
			break;
		case "7":
			JOptionPane.showMessageDialog(null, memberService.findByName(
					JOptionPane.showInputDialog("ENTER Name")));
			break;
		case "8":
			break;
		case "9":
			JOptionPane.showInputDialog("탈퇴하실 ID를 적어주세요");
			break;
		case "10":
			
			break;
			}
		}
	}
}
