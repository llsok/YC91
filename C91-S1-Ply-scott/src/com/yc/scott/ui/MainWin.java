package com.yc.scott.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MainWin {

	protected Shell shell;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWin window = new MainWin();
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
		shell.setSize(524, 383);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));

		/**
		 * 将tab容器定义剪切到这里
		 */
		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);

		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		MenuItem menuItem = new MenuItem(menu, SWT.CASCADE);
		menuItem.setText("系统");

		Menu menu_1 = new Menu(menuItem);
		menuItem.setMenu(menu_1);

		MenuItem menuItem_1 = new MenuItem(menu_1, SWT.NONE);
		menuItem_1.setText("数据备份");

		MenuItem menuItem_2 = new MenuItem(menu_1, SWT.NONE);
		menuItem_2.setText("数据恢复");

		new MenuItem(menu_1, SWT.SEPARATOR);

		MenuItem menuItem_3 = new MenuItem(menu_1, SWT.NONE);
		menuItem_3.setText("退出");

		MenuItem menuItem_4 = new MenuItem(menu, SWT.CASCADE);
		menuItem_4.setText("基础数据");

		Menu menu_2 = new Menu(menuItem_4);
		menuItem_4.setMenu(menu_2);

		MenuItem menuItem_5 = new MenuItem(menu_2, SWT.NONE);
		menuItem_5.setText("员工管理");

		MenuItem menuItem_6 = new MenuItem(menu_2, SWT.NONE);

		/**
		 * 部门管理的菜单事件
		 */
		menuItem_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 判断是否已经打开
				for( TabItem ti : tabFolder.getItems()) {
					if("部门管理".equals(ti.getText())){
						// 如果已开, 那么就选中该页
						tabFolder.setSelection(ti);
						return;
					}
				}
				// 如果未开, 则新建
				TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
				tabItem.setText("部门管理");
				DeptCmp dc = new DeptCmp(tabFolder, SWT.NONE);
				tabItem.setControl(dc);
				tabFolder.setSelection(tabItem);
			}
		});

		menuItem_6.setText("部门管理");

		MenuItem menuItem_7 = new MenuItem(menu, SWT.CASCADE);
		menuItem_7.setText("管理功能");

		Menu menu_3 = new Menu(menuItem_7);
		menuItem_7.setMenu(menu_3);

		MenuItem menuItem_8 = new MenuItem(menu_3, SWT.NONE);
		menuItem_8.setText("岗位调整");

		MenuItem menuItem_9 = new MenuItem(menu_3, SWT.NONE);
		menuItem_9.setText("员工加薪");

		MenuItem menuItem_10 = new MenuItem(menu_3, SWT.NONE);
		menuItem_10.setText("部门调整");

		TabItem tabItem_1 = new TabItem(tabFolder, SWT.NONE);
		tabItem_1.setText("员工管理");

		Label label_1 = new Label(tabFolder, SWT.NONE);
		tabItem_1.setControl(label_1);
		label_1.setText("员工");

	}
}
