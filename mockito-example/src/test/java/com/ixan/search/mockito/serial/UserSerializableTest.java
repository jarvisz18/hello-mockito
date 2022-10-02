package com.ixan.search.mockito.serial;

import java.io.*;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 10/2/22 10:01 PM
 * @description UserSerializableTest
 */
public class UserSerializableTest {
	private static void serialize(User user) throws IOException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File((System.getProperty("java.io.tmpdir") + File.separator + User.class.getName()))));
		objectOutputStream.writeObject(user);
		objectOutputStream.close();
	}

	private static User deserialize() throws IOException, ClassNotFoundException {
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(System.getProperty("java.io.tmpdir") + File.separator + User.class.getName())));
		return (User) objectInputStream.readObject();
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		User user = new User();
		user.setName("jarvis");
		user.setAge(18);
		user.setSex("man");
		System.out.println("before serialize:" + user);

		serialize(user);

		User deserializeUser = deserialize();
		System.out.println("after serialize:" + deserializeUser);
	}
}
