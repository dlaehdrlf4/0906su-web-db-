package test;

import dao.UserDao;
import dao.UserDaoImpl;
import vo.FMember;

public class Main {

	public static void main(String[] args) {
		UserDao userDao = UserDaoImpl.sharedInstance();
		FMember member = new FMember();
		member.setEmail("ddd@naver.com");
		member.setPw("234234");
		member.setName("gil");
		member.setPhone("ddd@naver.com");
		member.setAddress("ddd@naver.com");
		member.setAge(15);
		member.setEmail("ddd@naver.com");
		
		boolean r = userDao.registerMember(member);
	System.out.println(r);	

	}

}
