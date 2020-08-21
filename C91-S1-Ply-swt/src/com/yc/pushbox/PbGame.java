package com.yc.pushbox;

import com.yc.pushbox.base.PushBoxBase;

/**
 * 推箱子游戏
 */
public class PbGame extends PushBoxBase{

	private static final long serialVersionUID = 1L;

	/**
	 * 向上移动
	 */
	public void moveTop() {
		move(0, -1, '8');
	}

	/**
	 * 向下移动
	 */
	public void moveDown() {
		move(0, 1, '5');
	}

	/**
	 * 向左移动
	 */
	public void moveLeft() {
		move(-1, 0, '6');
	}

	/**
	 * 向右移动
	 */
	public void moveRight() {
		move(1, 0, '7');
	}

	/**
	 * 下一关
	 */
	public void next() {
		level++;
		loadMap();
	}

	/**
	 * 重新开始
	 */
	public void restart() {
		loadMap();
	}

	@Override
	public void save() {
		
	}

}
