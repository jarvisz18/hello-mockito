package com.ixan.example.test.serial;

import java.io.Serializable;

/**
 * @author stackzhang@126.com
 * @version 1.0
 * @date Created in 10/2/22 9:59 PM
 * @description User
 * <p>
 * 实现了Serializable接口的类，需要增加固定的serialVersionUID，防止反序列失败
 * 被static修饰的属性不会被反序列化
 * 被transient修饰的属性不会被序列化和反序列化
 */
public class User implements Serializable {

	private static final long serialVersionUID = 4539710529579624784L;
	private String name;
	private Integer age;
	private transient String sex;

	private static String sign = "我的眼中只有你!";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public static String getSign() {
		return sign;
	}

	public static void setSign(String sign) {
		User.sign = sign;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("User{");
		sb.append("name='").append(name).append('\'');
		sb.append(", age=").append(age);
		sb.append(", sex='").append(sex).append('\'');
		sb.append(", sign='").append(sign).append("\'");
		sb.append('}');
		return sb.toString();
	}
}
