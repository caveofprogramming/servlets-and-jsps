package test;

import beans.User;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User user = new User("john@caveofprogramming.com", "dlddfakl");
		
		if(user.validate()) {
			System.out.println("Bean validates OK.");
		}
		else {
			System.out.println(user.getMessage());
		}

	}

}
