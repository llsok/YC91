package com.yc.java.d0705;

/**
 * 	栈结构
 */
public class Stack {
	
	// 存放元素的数组
	private int[] array = new int[10];
	// 指向栈最上空元素的位置指针, 又表示元素的个数
	private int index = 0; 
	
	// 行为
	/**
	 * 	压栈
	 * @param num  压入的元素
	 */
	public void push(int num) {
		//判断栈元素是否已满
		if(index == array.length) {
			// 重新给数组赋值, 创建一个更大的数组
			int[] newArray = new int[ array.length * 2 ];
			// 将原数组的元素赋值过来
			System.arraycopy(array, 0, newArray, 0, array.length);
			// 将新数组赋值给原数组
			array = newArray;
		}
		array[index] = num;
		index ++; // 元素下标加一
	}
	
	/**
	 * 	出栈
	 * @return
	 */
	public int pop() {
		index --;
		// 取出最后一元素的值
		int ret = array[index];
		// 将最后一个元素置为 0 
		array[index] = 0;
		return ret;
	}
	
	/**
	 * 	返回栈内的元素个数
	 * @return
	 */
	public int size() {
		return index;
	}
	
	public static void main(String[] args) {
		
		/**
		 * 	测试优先
		 */
		Stack stack = new Stack();
		
		stack.push(1); // 如何确保可以压入第11个元素,( 自动扩容)
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(10);
		stack.push(15);
		stack.push(20);
		
		System.out.println("应该是 10 , 实际是: " + stack.size()); //==> 3
		System.out.println("应该是 20 , 实际是: " + stack.pop()); // ==> 20
		System.out.println("应该是 15 实际是: " + stack.pop()); // ==> 15
		System.out.println("应该是 10 , 实际是: " + stack.pop()); // ==> 10
		System.out.println("应该是 7, 实际是: " + stack.size()); //==> 0
		
	}
	
/**
 * 	课后作业: 请实现一个队列结构
 * 	要求: 
 * 	1. 实现入队与出队方法
 * 	2.可以获取队列的长度
 * 	3.实现自动扩容
 * 	4.队列的元素类型是  char 类型
 */

}
