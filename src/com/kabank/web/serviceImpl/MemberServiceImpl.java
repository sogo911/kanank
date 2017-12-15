package com.kabank.web.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.kabank.web.bean.MemberBean;
import com.kabank.web.service.MemberService;

public class MemberServiceImpl implements MemberService {
	
	private List<MemberBean> members;
	
	public MemberServiceImpl() {
		members = new ArrayList<MemberBean>();
	}
	
	@Override
	public int createCustomNum() {
		int foo = 0;
		return foo;	
	} 
	@Override
	public String findGender(String ssn) {
		String foo = "";
		char ch = ssn.charAt(7);
		if (ch == '1' || ch == '3') {
			foo = "남";
		} else if (ch == '2' || ch == '4') {
			foo = "여";
		} else if (ch == '5' || ch == '6') {
			foo = "외국인";
		} else {
			foo = "다시 입력해주세요.";
		}
		return foo;
	}
	@Override
	public int findAge(String ssn) {
		int foo = 0;
		char ch = ssn.charAt(0);
		foo = ch;
		
		return foo ;
	}
	@Override
	public void addMember(MemberBean member) {
		members.add(member);
	}
	@Override
	public List<MemberBean> list(){
		return members;
	}
	@Override
	public int count() {
		return members.size();
	}

	@Override
	public void setCount(int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delMembersAll() {
		members.clear();
		
	}

	@Override
	public void delMembers(String id) {
		Iterator<MemberBean> iterator = members.iterator();
		while (iterator.hasNext()) {
			
			iterator.remove();
			
		}
	}
	@Override
	public String login(MemberBean member) {
		String res = "아이디가 존재하지 않습니다.";
		for(int i = 0 ; i < members.size(); i++) {
			if(member.getId().equals(members.get(i).getId())) {
				res = (member.getPass().equals
						(members.get(i).getPass()))? "로그인 성공" : "비밀번호 틀림";
					//  ()?:; 삼항연산자
				return res;
			}
		}
		return res;
	}
	@Override
	public MemberBean findById(String id) {
		MemberBean findId = new MemberBean();
		for(int i = 0 ; i < members.size(); i++) {
			if(id.equals(members.get(i).getId())) {
				findId = members.get(i);
			}
		}
		
		return findId;
	}
	@Override
	public ArrayList<MemberBean> findByName(String name) {
		ArrayList<MemberBean> temp = new ArrayList<>();
		for(int i = 0 ; i < members.size(); i++) {
			if(name.equals(members.get(i).getName())) {
				temp.add(members.get(i));
			}
		}
		return temp;
	}

	
}
