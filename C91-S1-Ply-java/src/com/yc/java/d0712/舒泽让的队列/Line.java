package com.yc.java.d0712.舒泽让的队列;

public class Line {

	//利用数组先把数字存下来
	int []arr=new int [5];
	//定义一个指针
	int index=0;
	//入队
	public void push(int s){
		// 队列扩容
		
		arr[index]=s;
		index++;//下标+1
	}
	//出队
	public int pop(){
		/*int ret=arr[arr.length-index];
		index--;
		return ret;*/
		// 保存第一个元素值
		int ret = arr[0];
		// 将剩下数组元素想队首移动一格 数组的高级复制
		System.arraycopy(arr, 1, arr, 0, arr.length - 1);
		// 最后一个元素设置为 0
		arr[arr.length - 1] = 0;
		//下标-1
		index --;
		return ret;
	}
	//求队列中的元素个数
	public void size(){
		System.out.println("队列现在的长度为："+index);
	}
	//判断队列是否为空
	public void nullor(){
		if(index==0){
			System.out.println("该队列为空");
		}else{
			System.out.println("该队列不为空");
		}
	}
	//获取首元素
	public int Firstone(){
		//return arr[arr.length-index];
		return arr[0];
	}
}
