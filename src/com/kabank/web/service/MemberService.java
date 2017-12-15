package com.kabank.web.service;

import java.util.ArrayList;
import java.util.List;

import com.kabank.web.bean.MemberBean;

public interface MemberService {
	public int createCustomNum();
	public String findGender(String ssn);
	public int findAge(String ssn);
	public void setCount(int count);
	public int getCount();
	public void addMember(MemberBean member);
	public List<MemberBean> list();
	public int count();
	public void delMembersAll();
	public void delMembers(String id);
	public MemberBean findById(String Id);
	public String login(MemberBean member);
	public ArrayList<MemberBean> findByName(String name);
}