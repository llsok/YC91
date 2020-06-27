package com.yc.java.d0627;

/**
8、写以下类：
	飞机：	型号，最大座位数，最大航程。
	航班：	航班号，航空公司名称，航空公司代号，航班日期，出发地，目的地，起飞时间，
      		到达时间，里程，使用飞机，剩余座位，全价，折扣率。
			方法：setPlane(Plane  p);
	客户：	姓名，身份证号，帐户余额。
			方法：order(Flight  f);
 */
public class Demo4 {

	public static void main(String[] args) {

		Plane plane = new Plane();
		plane.model = "747";
		plane.seats = 300;
		plane.voyage = 5500;
		
		Plane plane1 = new Plane();
		plane1.model = "737";
		plane1.seats = 100;
		plane1.voyage = 5500;

		Flight flight = new Flight();
		flight.sn = "NH00001";
		flight.comany = "南航";
		flight.setPlane(plane1);
		
		Client c1 = new Client("武松","430403.......", 5000);
		Client c2 = new Client("燕青","430403.......", 6000);
		Client c3 = new Client("林冲","430403.......", 7000);
		
		c1.order(flight);
		c2.order(flight);
		c3.order(flight);
		
		System.out.println("剩余的座位数:" + flight.surplusSeats);
	}

}

// 飞机类
class Plane {
	String model; // 型号
	int seats;
	int voyage;
}

// 航班
class Flight {
	String sn; // 航班号
	String comany; // 公司
	// ....
	int surplusSeats; // 剩余座位
	Plane plane; // 使用飞机

	// 给航班设置飞机
	void setPlane(Plane plane) {
		this.plane = plane;
		this.surplusSeats = plane.seats;
	}

	/**
	 * 	添加一个乘客
	 * @param client 添加的乘客对象
	 */
	void commit(Client client) {
		// 判断当前的乘客数量是不是满员
		if (this.surplusSeats > 0) {
			// 则将乘客添加到乘客列表(数组)中
			this.surplusSeats--;
		} else {
			System.out.println("航班已经满员!");
		}
	}
}

class Client {
	String name;
	String id;
	double balance;

	public Client(String name, String id, double balance) {
		this.name = name;
		this.id = id;
		this.balance = balance;
	}

	void order(Flight flight) {
		// 如何定航班
		flight.commit(this);
	}
}
