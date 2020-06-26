package com.yc.java.d0626;

public class Demo2 {
	public static void main(String[] args) {
		// 类 => 数据类型
		User user1 = new User(); // User() 是构造方法(函数)
		// The field User.name is not visible  该属性不可访问
		//user1.name = "林冲";
		//user1.password = "123";
		//user1.password="456";
		
		user1.setName("林冲");
		user1.setPassword("123");
		
		user1.setName("武松");
		user1.setPassword("456");
		
		user1.setPhone("133");
		user1.setPhone("134");
		user1.setPhone("135");
		user1.setPhone("136");
		user1.setPhone("137");
		user1.setPhone("138");
		
		//System.out.println(user1.name);
		System.out.println(user1.getName());
		System.out.println(user1.getPassword());
		System.out.println(user1.getPhone());
		user1.show();

	}
}

// 淘宝账号
class User{
	// 属性定义可以使用访问修饰符 private 表示 私有
	private String name;   	// 用户名
	private String password;// 密码
	private String email;	// 邮箱
	private String phone;	// 电话
	private int count = 0;   // 修改电话的次数
	
	// 使用驼峰命名法
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return "*****";
	}
	
	// this 表示当前对象, 可以获取当前对象的属性和方法
	public void setName(String name) {
		if(this.name != null) {
			System.out.println("当前用户名已经设置了值,不能修改");
			return;
		}
		this.name = name;
	}
	
	public void setPassword(String password) {
		if(this.password != null) {
			System.out.println("当前密码已经设置了值,不能修改");
			return;
		}
		this.password = password;
	}
	
	void show() {
		System.out.println("用户名:" + name);
	}
	
	// 扩展, 请定义用户 邮箱 和 电话
	// 邮箱可以任意的修改,  电话只能修改3次
	
	public void setEmail(String email) {
		// 没有任何限制
		this.email = email;
	}
	
	public void setPhone(String phone) {
		if(this.count < 3) {
			this.phone = phone;
			this.count ++;
		} else {
			System.out.println("电话只能修改3次");
		}
	}
	
	public String getPhone() {
		return phone;
	}
	
}
