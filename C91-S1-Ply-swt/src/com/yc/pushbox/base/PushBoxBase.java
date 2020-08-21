package com.yc.pushbox.base;

import java.io.*;

/**
 * 推箱子游戏
 */
public abstract class PushBoxBase implements java.io.Serializable {

	// 序列化版本编号
	private static final long serialVersionUID = 1L;
	// 游戏地图
	protected char[][] map = new char[20][20];
	// 去掉箱子和人的空地图, 用于判断游戏是否结束, 以及移动小人后, 恢复地图显示
	protected char[][] mapEmpty = new char[20][20];
	// 关数
	protected int level = 0;

	/**
	 * 构造函数, 默认加载第一关地图
	 */
	public PushBoxBase() {
		// 第一创建游戏时, 加载地图
		next();
	}

	/**
	 * 加载当前关的地图
	 */
	public void loadMap() {
		// 读取地图文件
		String path = "maps/" + level + ".map";
		// 使用类对象读入工程里面的文件
		InputStream in = this.getClass().getResourceAsStream(path);
		// Stream : 字节流 Reader Writer: 字符流
		// 字节流转字符流(处理流)
		InputStreamReader isr = new InputStreamReader(in);
		// 字符流转成缓冲字符流(处理流) ==> 以行的方式读入
		BufferedReader br = new BufferedReader(isr);
		try {
			for (int i = 0; i < map.length; i++) {
				String line = br.readLine();
				map[i] = line.toCharArray();
				// 设置空地图
				mapEmpty[i] = line.toCharArray();
				for (int j = 0; j < mapEmpty.length; j++) {
					if (mapEmpty[i][j] == '3' || mapEmpty[i][j] == '5') {
						mapEmpty[i][j] = '2';
					} else if (mapEmpty[i][j] == '9') {
						mapEmpty[i][j] = '4';
					}
				}
			}
		} catch (IOException e) {
			// 异常转型
			throw new RuntimeException(e);
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * 查找小人的坐标 x,y
	 * 
	 * @return { x, y } 小人的的位置, x,y坐标
	 */
	protected int[] findMan() {
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map.length; x++) {
				if (map[y][x] >= '5' && map[y][x] <= '8') {
					return new int[] { x, y };
				}
			}
		}
		return null;
	}

	/**
	 * 指定移动方向, 移动小人 ox = -1, oy = 0 左移 ox = 1, oy = 0 右移 ox = 0, oy = -1 上移 ox = 0,
	 * oy = 1 下移
	 * 
	 * @param ox  移动的 x 值变化值 取值 : -1, 0 , 1
	 * @param oy  移动的 y 值变化值 取值 : -1, 0 , 1
	 * @param man 小人的方向, 5下, 6左, 7右, 8上
	 */
	public void move(int ox, int oy, char man) {
		int[] xy = findMan();
		// x ==> xy[0], y ==> xy[1] ===> 原因 { x, y }
		int x = xy[0];
		int y = xy[1];
		// 判断是否可以推动
		if (map[y + oy][x + ox] == '1') {
			// 前面是房子, 则退出
			return;
		} else if (map[y + oy][x + ox] == '3' || map[y + oy][x + ox] == '9') {
			// 前面是箱子, 则判断箱子前面是什么
			if (map[y + oy + oy][x + ox + ox] == '1' || map[y + oy + oy][x + ox + ox] == '3'
					|| map[y + oy + oy][x + ox + ox] == '9') {
				// 箱子前面是房子 1 ,箱子 3,压在目的地上的箱子 9 那么不能推动
				return;
			}
			// 移动箱子
			if (mapEmpty[y + oy + oy][x + ox + ox] == '4') {
				// 箱子后面是目的地
				map[y + oy + oy][x + ox + ox] = '9';
			} else {
				// 箱子后面不是目的地
				map[y + oy + oy][x + ox + ox] = '3';
			}
		}
		// 移动小人
		map[y + oy][x + ox] = man;
		// 恢复空地
		map[y][x] = mapEmpty[y][x];
	}

	/**
	 * 判断是否胜利
	 * 
	 * @return
	 */
	public boolean isYouWin() {
		for (int y = 0; y < mapEmpty.length; y++) {
			for (int x = 0; x < mapEmpty.length; x++) {
				if (mapEmpty[y][x] == '4' && map[y][x] != '9') {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 返回地图二维数组
	 * 
	 * @return
	 */
	public char[][] getMap() {
		return map;
	}

	/**
	 * 下一关
	 */
	public abstract void next();

	/**
	 * 保存进度
	 */
	public abstract void save();

	/**
	 * 重新开始
	 */
	public abstract void restart();

	/**
	 * 向上移动
	 */
	public abstract void moveTop();

	/**
	 * 向下移动
	 */
	public abstract void moveDown();

	/**
	 * 向左移动
	 */
	public abstract void moveLeft();

	/**
	 * 向右移动
	 */
	public abstract void moveRight();

}
