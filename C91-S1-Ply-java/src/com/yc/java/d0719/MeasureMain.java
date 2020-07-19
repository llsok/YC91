package com.yc.java.d0719;

/**
 * 测量工具案例, 接口 
 * 
 * 定义被测量的类 : 人
 * 创建 N 个人的对象: 姓名, 身高, 体重, 收入, 食品支出 ...
 * 
 * 统计: BMI(肥胖指数), eg(恩格尔系数)  最大值, 最小值, 平均值
 * 
 * 先不使用接口实现 ==> 发现问题 ==> 接口解决问题
 * 
 * 多态: 解决是灵活扩展的问题
 */
public class MeasureMain {
	// 存放被测量对象的数组
	private Object[] objects = new Object[100];
	private Object maxObj = null;
	private Object minObj = null;
	private double avg = 0;// 平均
	// 测量工具接口对象
	private Measure measure;

	public static void main(String[] args) {
		MeasureMain mm = new MeasureMain();
		mm.addObject(new Person("武松", 1.8, 92, 5, 1));
		mm.addObject(new Person("李逵", 1.75, 102, 2, 1.5));
		mm.addObject(new Person("宋江", 1.58, 70, 10, 2.5));
		mm.addObject(new Person("武大郎", 1.25, 60, 1, 0.7));
		mm.addObject(new Person("扈三娘", 1.78, 58, 8, 1.8));
		
		// 在测量之前将测量工具设置好
		System.out.println("==============BMI指数=============");
		mm.setMeasure(new BmiMeasure());
		mm.measure();
		Person max = (Person) mm.getMax();
		System.out.println("最胖的是: " + max.getName());
		System.out.println("最瘦的是: " + ( (Person) mm.getMin() ).getName());
		System.out.println("平均值是: " + mm.getAvg());
		
		System.out.println("==============恩格尔系数=============");
		mm.setMeasure(new EgMeasure()); // 替换测量工具
		mm.measure();
		max = (Person) mm.getMax();
		System.out.println("最穷的是: " + max.getName());
		System.out.println("最富的是: " + ( (Person) mm.getMin() ).getName());
		System.out.println("平均值是: " + mm.getAvg());
	}

	// 添加被测量对象 [null,null,null,null,null,null... 100 个元素]
	public void addObject(Object object) {
		for (int i = 0; i < objects.length; i++) {
			if (objects[i] == null) {
				objects[i] = object;
				break;
			}
		}
	}

	// 测试所有被测量对象
	public void measure() {
		double max = 0;
		double min = 1000;
		double sum = 0;// 总和
		double cnt = 0;// 总被测量对象个数
		for (Object o : objects) {
			if (o != null) {
				// Type mismatch: cannot convert
				// from Object to Person
				// 父 转 子 要强转 ==> 成功秘密是 o 本身就是 Person 对象
				//Person p = (Person) o;
				// 体质指数（BMI）计算公式等于：体重（千克）除以身高（平方米）
				//double bmi = p.getWeight() / (p.getHeight() * p.getHeight());
				//double bmi = 接口对象.方法(p);
				double bmi = measure.measure(o);
				sum += bmi;
				cnt++;
				if (max < bmi) {
					max = bmi;
					maxObj = o;
				}
				if (min > bmi) {
					min = bmi;
					minObj = o;
				}
			}
		}
		avg = sum / cnt;
	}

	// 返回最大值的对象
	public Object getMax() {
		return maxObj;
	}

	// 返回最小值的对象
	public Object getMin() {
		return minObj;
	}

	// 返回平均值
	public double getAvg() {
		return avg;
	}

	public void setMeasure(Measure measure) {
		this.measure = measure;
	}
	
}

// 测量接口
interface Measure {
	/**
	 * 对 object 进行测量
	 * @param object
	 * @return
	 */
	double measure(Object object);
}

/**
 * BMI 指数测量的实现类, 实现了 Measure 接口
 * @author 廖彦
 *
 */
class BmiMeasure implements Measure{
	public double measure(Object object) {
		Person p = (Person) object;
		double bmi = p.getWeight() / (p.getHeight() * p.getHeight());
		return bmi;
	}
}


class EgMeasure implements Measure{
	public double measure(Object object) {
		Person p = (Person) object;
		double eg = p.getFoodpay() / p.getIncome();
		return eg;
	}
}


class Person {
	private String name;
	private double height;
	private double weight;
	private double income;
	private double foodpay;

	public Person(String name, double height, double weight, double income, double foodpay) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.income = income;
		this.foodpay = foodpay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public double getFoodpay() {
		return foodpay;
	}

	public void setFoodpay(double foodpay) {
		this.foodpay = foodpay;
	}
}
