package com.yc.pushbox;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class PbWin {

	protected Shell shell;

	private Label[][] cells = new Label[20][20];

	private PbGame pg = new PbGame();

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PbWin window = new PbWin();
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
		shell.setSize(720, 660);
		shell.setText("SWT Application");
		shell.setLayout(new BorderLayout(0, 0));

		Composite compMap = new Composite(shell, SWT.NONE);
		compMap.setLayoutData(BorderLayout.CENTER);
		RowLayout rl_compMap = new RowLayout(SWT.HORIZONTAL);
		rl_compMap.justify = true;
		rl_compMap.spacing = 0;
		compMap.setLayout(rl_compMap);

		compMap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// 上 16777217 下 16777218
				// 左 16777219 右 16777220
				if (e.keyCode == 16777217) {
					pg.moveTop();
				} else if (e.keyCode == 16777218) {
					pg.moveDown();
				} else if (e.keyCode == 16777219) {
					pg.moveLeft();
				} else if (e.keyCode == 16777220) {
					pg.moveRight();
				}
				refresh();
			}
		});

		// 创建 400 个地图元素对象
		for (int y = 0; y < cells.length; y++) {
			for (int x = 0; x < cells[y].length; x++) {
				cells[y][x] = new Label(compMap, SWT.NONE);
			}
		}

		Composite compCtrl = new Composite(shell, SWT.NONE);
		compCtrl.setLayoutData(BorderLayout.EAST);
		RowLayout rl_compCtrl = new RowLayout(SWT.VERTICAL);
		rl_compCtrl.spacing = 10;
		rl_compCtrl.marginBottom = 10;
		rl_compCtrl.marginTop = 10;
		rl_compCtrl.marginRight = 10;
		rl_compCtrl.marginLeft = 10;
		compCtrl.setLayout(rl_compCtrl);

		Button btnNewButton = new Button(compCtrl, SWT.NONE);
		btnNewButton.setText("New Button");

		Button btnNewButton_1 = new Button(compCtrl, SWT.NONE);
		btnNewButton_1.setText("New Button");

		Button btnNewButton_2 = new Button(compCtrl, SWT.NONE);
		btnNewButton_2.setText("New Button");

		// 打开窗口刷新地图
		refresh();
	}

	// 刷新地图
	public void refresh() {
		for (int y = 0; y < cells.length; y++) {
			for (int x = 0; x < cells[y].length; x++) {
				char c = pg.getMap()[y][x];
				String path = "/com/yc/pushbox/imgs/" + c + ".GIF";
				cells[y][x].setImage(SWTResourceManager.getImage(PbWin.class, path));
			}
		}
	}
}
