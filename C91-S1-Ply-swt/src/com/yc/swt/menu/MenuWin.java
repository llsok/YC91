package com.yc.swt.menu;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.yc.swt.table.TableWin;
import com.yc.swt.window.DialogWin;

import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MenuWin {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MenuWin window = new MenuWin();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem menuItem = new MenuItem(menu, SWT.CASCADE);
		menuItem.setText("文件");
		
		Menu menu_1 = new Menu(menuItem);
		menuItem.setMenu(menu_1);
		
		MenuItem menuItem_1 = new MenuItem(menu_1, SWT.NONE);
		menuItem_1.setText("新建");
		
		MenuItem menuItem_2 = new MenuItem(menu_1, SWT.NONE);
		/**
		 * "打开"菜单的点击事件处理函数
		 */
		menuItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableWin window = new TableWin();
				window.open();
			}
		});
		menuItem_2.setText("打开...");
		
		MenuItem menuItem_3 = new MenuItem(menu_1, SWT.NONE);
		menuItem_3.setText("保存...");
		
		new MenuItem(menu_1, SWT.SEPARATOR);
		
		MenuItem menuItem_4 = new MenuItem(menu_1, SWT.NONE);
		menuItem_4.setText("页面设置");
		
		MenuItem menuItem_5 = new MenuItem(menu_1, SWT.SEPARATOR);
		menuItem_5.setText("aaa");
		
		MenuItem menuItem_6 = new MenuItem(menu_1, SWT.NONE);
		menuItem_6.setText("退出");
		
		MenuItem menuItem_10 = new MenuItem(menu, SWT.CASCADE);
		menuItem_10.setText("窗口操作");
		
		Menu menu_3 = new Menu(menuItem_10);
		menuItem_10.setMenu(menu_3);
		
		MenuItem menuItem_11 = new MenuItem(menu_3, SWT.NONE);
		menuItem_11.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DialogWin dw = new DialogWin(shell,SWT.NONE);
				System.out.println("========== 开始 =========");
				Object result = dw.open();
				// open之后, 在窗口关闭之前, 后面的代码不会执行
				System.out.println("========== " + result + " =========");
			}
		});
		menuItem_11.setText("模态弹窗");
		
		Menu menu_2 = new Menu(shell);
		shell.setMenu(menu_2);
		
		MenuItem menuItem_7 = new MenuItem(menu_2, SWT.NONE);
		menuItem_7.setText("测试");
		
		MenuItem menuItem_8 = new MenuItem(menu_2, SWT.NONE);
		menuItem_8.setText("运行");
		
		MenuItem menuItem_9 = new MenuItem(menu_2, SWT.NONE);
		menuItem_9.setText("发布");

	}
}
