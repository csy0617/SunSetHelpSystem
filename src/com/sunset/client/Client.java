package com.sunset.client;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.sunset.entity.Administrator;
import com.sunset.entity.AlreadyHelpList;
import com.sunset.entity.Help;
import com.sunset.entity.Old;
import com.sunset.entity.OldUserHelp;
import com.sunset.entity.User;
import com.sunset.service.AdminService;
import com.sunset.service.UserService;
import com.sunset.service.impl.AdminServiceImpl;
import com.sunset.service.impl.UserServiceImpl;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		AdminService adminService = new AdminServiceImpl();
		UserService userService = new UserServiceImpl();
		System.out.println("**********欢迎进入SunSet夕阳帮扶系统**********");
		while (true) {
			menu(scanner, adminService, userService);
		}
	}

	private static void menu(Scanner scanner, AdminService adminService, UserService userService) {
		// TODO Auto-generated method stub
		System.out.println("1.管理员");
		System.out.println("2.用户");
		System.out.println("请输入您的选择：");
		int choice = Integer.parseInt(scanner.nextLine().trim());
		switch (choice) {
		case 1:
			adminSuperMenu(scanner, adminService, userService);
			break;
		case 2:
			userSuperMenu(scanner, adminService, userService);
			break;
		case 3:
			System.exit(0);
			break;

		default:
			System.out.println("您输入的不正确！");
			break;
		}
	}

	private static void userSuperMenu(Scanner scanner, AdminService adminService, UserService userService) {
		while (true) {
			System.out.println("1.登陆");
			System.out.println("2.注册");
			System.out.println("请输入您的选择：");
			int choice = Integer.parseInt(scanner.nextLine().trim());
			switch (choice) {
			case 1:
				System.out.println("请输入用户名:");
				String name = scanner.nextLine().trim();
				System.out.println("请输入密码：");
				String pwd = scanner.nextLine().trim();
				StringBuilder str = new StringBuilder();
				Random random = new Random();
				for (int i = 0; i < 6; i++) {
					str.append(random.nextInt(10));
				}
				String correctcode = str.toString();
				System.out.print("请输入验证码(6位数字)：");
				System.out.println(correctcode);
				String usercode = scanner.nextLine().trim();
				if (usercode.equals(correctcode)) {
					User user = userService.userLogin(name, pwd);
					if (user != null) {
						userMenu(scanner,userService, user);
					} else {
						System.out.println("账户名或密码错误！");
					}
				}else {
					System.out.println("验证码输入错误！");
				}
				
				break;
			case 2:
				System.out.println("请输入用户名:");
				name = scanner.nextLine().trim();
				System.out.println("请输入密码：");
				pwd = scanner.nextLine().trim();
				System.out.println("请输入真实姓名：");
				String realname = scanner.nextLine().trim();
				System.out.println("请输入年龄：");
				int age = Integer.parseInt(scanner.nextLine().trim());
				System.out.println("请输入性别：");
				String sex = scanner.nextLine().trim();
				System.out.println("请输入联系方式：");
				int phone = Integer.parseInt(scanner.nextLine().trim());
				boolean flag = userService.userRegister(new User(name, realname, pwd, sex, age, phone));
				if (flag) {
					System.out.println("注册成功！");
				} else {
					System.out.println("注册失败！");
				}
				break;
			default:
				break;
			}
		}
	}

	private static void userMenu(Scanner scanner, UserService userService, User user) {
		while (true) {
			System.out.println("1.查看需要帮扶的老人信息");
			System.out.println("2.帮扶老人");
			System.out.println("3.记录帮扶事件");
			System.out.println("4.查看自己的帮扶事件");
			System.out.println("5.退出");
			System.out.println("请输入您的选择：");
			int choice = Integer.parseInt(scanner.nextLine().trim());
			switch (choice) {
			case 1:
				System.out.println("需要帮助的老人列表：");
				List<Old> oldsneedshelp = userService.showOldNeedHelp();
				for (Old old : oldsneedshelp) {
					System.out.println(old);
				}
				break;
			case 2:
				System.out.println("请输入想要帮扶的老人ID：");
				int oldid = Integer.parseInt(scanner.nextLine().trim());
				boolean flag = userService.helpOld(user, oldid);
				if (flag) {
					System.out.println("添加帮扶老人成功！");
				} else {
					System.out.println("添加帮扶此老人失败！");
				}
				break;
			case 3:
				System.out.println("您帮扶的老人有：");
				System.out.println("ID号\t姓名");
				List<OldUserHelp> oldUserHelps = userService.showOldUserHelp(user);
				for (OldUserHelp oldUserHelp : oldUserHelps) {
					System.out.println(oldUserHelp);
				}
				System.out.println("选择需要帮扶老人的ID号：");
				int id = Integer.parseInt(scanner.nextLine().trim());
				System.out.println("请输入帮扶的事件详情：");
				String helpDescription = scanner.nextLine().trim();
				boolean ifflag = false;
				for (OldUserHelp olduserHelp : oldUserHelps) {
					if (olduserHelp.getOldID() == id) {
						Help help = new Help(id, user.getId(), helpDescription);
						flag = userService.addHelpDes(help);
						if (flag) {
							System.out.println("添加成功！");
						} else {
							System.out.println("添加失败！");
						}
						ifflag = true;
					}
				}
				if (ifflag) {
					break;
				}else {
					System.out.println("请输入您所帮扶的老人编号！");
					break;
				}
			case 4:
				List<AlreadyHelpList> helpList = userService.showListHelpByUser(user);
				System.out.println("老人姓名\t帮扶的事件\t时间");
				for (AlreadyHelpList alreadyHelpList : helpList) {
					System.out.println(alreadyHelpList);
				}
				break;
			case 5:
				System.exit(0);
				break;

			default:
				System.out.println("您输入的不正确！");
				break;
			}
		}

	}

	private static void adminSuperMenu(Scanner scanner, AdminService adminService, UserService userService) {
		while (true) {
			System.out.println("1.登陆");
			System.out.println("2.注册");
			System.out.println("请输入您的选择：");
			int choice = Integer.parseInt(scanner.nextLine().trim());
			switch (choice) {
			case 1:
				System.out.println("请输入管理员名:");
				String name = scanner.nextLine().trim();
				System.out.println("请输入密码：");
				String pwd = scanner.nextLine().trim();
				StringBuilder str = new StringBuilder();
				Random random = new Random();
				for (int i = 0; i < 6; i++) {
					str.append(random.nextInt(10));
				}
				String correctcode = str.toString();
				System.out.print("请输入验证码(6位数字)：");
				System.out.println(correctcode);
				String usercode = scanner.nextLine().trim();
				if (usercode.equals(correctcode)) {
					Administrator admin = adminService.adminLogin(name, pwd);
					if (admin != null) {
						adminMenu(scanner, adminService);
					} else {
						System.out.println("账户名或密码错误！");
					}
				}else {
					System.out.println("验证码输入错误！");
				}
				break;
			case 2:
				String correctname = "^[a-zA-Z][a-zA-Z0-9]*$";
				String correctpwd = "^[a-zA-Z0-9_]{8,}$";
				System.out.println("请输入管理员名(必须是英文字符和数字,不能以数字开头)：");
				name = scanner.nextLine().trim();
				System.out.println("请输入密码(长度不低于8位,英文字母,数字,以及_组成)：");
				pwd = scanner.nextLine().trim();
				if (name.matches(correctname) && pwd.matches(correctpwd)) {
					boolean flag = adminService.adminRegister(new Administrator(name, pwd));
					if (flag) {
						System.out.println("注册成功！");
					} else {
						System.out.println("注册失败！");
					}

				} else {
					System.out.println("您输入的格式不正确！");
				}
				break;
			default:
				System.out.println("您输入的不正确！");
				break;
			}
		}
	}

	private static void adminMenu(Scanner scanner, AdminService adminService) {
		while (true) {
			System.out.println("1.录入老人信息");
			System.out.println("2.查看老人信息");
			System.out.println("3.删除老人信息");
			System.out.println("4.修改老人信息");
			System.out.println("5.退出");
			System.out.println("请输入您的选择");
			int choice = Integer.parseInt(scanner.nextLine().trim());
			switch (choice) {
			case 1:
				System.out.println("请输入老人的姓名：");
				String oldname = scanner.nextLine().trim();
				System.out.println("请输入老人的年龄：");
				int oldage = Integer.parseInt(scanner.nextLine().trim());
				System.out.println("请输入老人的地址：");
				String oldaddress = scanner.nextLine().trim();
				System.out.println("请输入老人的性别：");
				String oldsex = scanner.nextLine().trim();
				System.out.println("请输入老人的联系方式：");
				String oldcontact = scanner.nextLine().trim();
				Old old = new Old(oldname, oldsex, oldage, oldaddress, oldcontact);
				boolean flag = adminService.addOld(old);
				if (flag) {
					System.out.println("添加成功！");
				} else {
					System.out.println("添加失败！");
				}
				break;
			case 2:
				System.out.println("老人列表：");
				System.out.println("老人姓名\t性别\t年龄\t地址\t联系方式");
				List<Old> olds = adminService.showAllOlds();
				for (Old old2 : olds) {
					System.out.println(old2);
				}
				break;
			case 3:
				System.out.println("请输入删除老人的ID号：");
				int oldid = Integer.parseInt(scanner.nextLine().trim());
				flag = adminService.deleteOld(oldid);
				if (flag) {
					System.out.println("删除成功！");
				} else {
					System.out.println("删除失败！");
				}
				break;
			case 4:
				System.out.println("请输入修改老人的ID号：");
				oldid = Integer.parseInt(scanner.nextLine().trim());
				old = adminService.findOldById(oldid);
				if (old != null) {
					System.out.println("是否修改年龄（Y/N）：");
					String decide = scanner.nextLine().trim();
					if (decide.equals("Y") || decide.equals("y")) {
						System.out.println("请输入新的年龄：");
						int newage = Integer.parseInt(scanner.nextLine().trim());
						old.setOldAge(newage);
					}
					System.out.println("是否修改地址（Y/N）：");
					decide = scanner.nextLine().trim();
					if (decide.equals("Y") || decide.equals("y")) {
						System.out.println("请输入新的地址：");
						String newaddress = scanner.nextLine().trim();
						old.setAddress(newaddress);
					}
					System.out.println("是否修改联系方式（Y/N）：");
					decide = scanner.nextLine().trim();
					if (decide.equals("Y") || decide.equals("y")) {
						System.out.println("请输入新的联系方式：");
						String newcontact = scanner.nextLine().trim();
						old.setContact(newcontact);
					}
					flag = adminService.updateOld(old);
					if (flag) {
						System.out.println("修改成功！");
					} else {
						System.out.println("修改失败！");
					}
				} else {
					System.out.println("没有找到该老人！");
				}
				break;
			case 5:
				System.exit(0);
				break;

			default:
				System.out.println("您输入的不正确！");
				break;
			}
		}
	}
}
