package test;

import org.junit.Test;

import dao.UserDao;
import dao.UserDaoImpl;
import vo.FMember;

public class TestCase {
	@Test
	public void sampleTest() {
		UserDao userDao = UserDaoImpl.sharedInstance();
		System.out.println(userDao.emailCheck("dddd@naver.com"));

	}
}
