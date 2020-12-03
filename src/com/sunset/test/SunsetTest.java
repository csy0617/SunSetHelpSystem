package com.sunset.test;

import org.junit.Test;

import com.sunset.dao.AdministratorDao;
import com.sunset.dao.HelpDao;
import com.sunset.dao.OldDao;
import com.sunset.dao.UserDao;
import com.sunset.dao.impl.AdministratorDaoImpl;
import com.sunset.dao.impl.HelpDaoImpl;
import com.sunset.dao.impl.OldDaoImpl;
import com.sunset.dao.impl.UserDaoImpl;
import com.sunset.entity.Administrator;
import com.sunset.entity.Help;
import com.sunset.entity.Old;
import com.sunset.entity.User;

public class SunsetTest {
	private AdministratorDao admindao = new AdministratorDaoImpl();
	private UserDao userdao = new UserDaoImpl();
	private OldDao olddao = new OldDaoImpl();
	private HelpDao helpdao = new HelpDaoImpl();
	@Test
	public void test1() {
		Administrator administrator = new Administrator("Admin", "123");
		System.out.println(admindao.insertAdmin(administrator));
	}
	
	@Test
	public void test2() {
		System.out.println(admindao.loginAdmin("Mercy", "123"));
	}
	@Test
	public void test3() {
		User user = new User(null, "陈同学", "陈舒怡", "123", "女", 18, 1234567);
		System.out.println(userdao.insertUser(user));
	}
	@Test
	public void test4() {
		System.out.println(userdao.loginUser("陈同学", "123"));
	}
	@Test
	public void test5() {
		Old old = new Old("唐某", "女", 80, "苏州中心", "180123");
		System.out.println(olddao.insertOld(old));
	}
	@Test
	public void test6() {
		System.out.println(olddao.selectByOldId(1));
	}
	@Test
	public void test7() {
		Old old = olddao.selectByOldId(1);
		System.out.println(olddao.selectByOldId(1));
		old.setAddress("苏州中心旁");
		olddao.updateOld(old);
		System.out.println(olddao.selectByOldId(1));
	}
	@Test
	public void test8() {
		System.out.println(olddao.selectAllOlds());
	}
	@Test
	public void test9() {
		System.out.println(olddao.deleteOldById(2));
	}
	@Test
	public void test10() {
		Help help = new Help(1, 1,"洗衣服");
		System.out.println(helpdao.addHelpDescriptionById(help));
	}
	@Test
	public void test11() {
		User user = userdao.loginUser("陈同学", "123");
		System.out.println(helpdao.selectHelpsByUser(user));
	}
}
