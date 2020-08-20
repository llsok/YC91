package com.yc.swt.comp;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.SWT;

public class InfoWin {

	protected Shell shell;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			InfoWin window = new InfoWin();
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
		shell.setSize(515, 300);
		shell.setText("SWT Application");
		shell.setLayout(new RowLayout(SWT.HORIZONTAL));

		new InfoComp(shell, SWT.NONE, "e:/O1CN01gXdkOw1FSd5rdUZVe_!!0-item_pic.jpg_430x430q90.jpg", "促销", "降价酬宾");
		new InfoComp(shell, SWT.NONE, "e:/O1CN01gXdkOw1FSd5rdUZVe_!!0-item_pic.jpg_430x430q90.jpg", "促销", "降价酬宾");
		new InfoComp(shell, SWT.NONE, "e:/O1CN01lPGIEs29lVuB8S9Fl_!!0-item_pic.jpg_430x430q90.jpg", "促销", "降价酬宾");
		new InfoComp(shell, SWT.NONE, "e:/O1CN01lPGIEs29lVuB8S9Fl_!!0-item_pic.jpg_430x430q90.jpg", "促销", "降价酬宾");
		new InfoComp(shell, SWT.NONE, "e:/O1CN01lPGIEs29lVuB8S9Fl_!!0-item_pic.jpg_430x430q90.jpg", "促销", "降价酬宾");

	}

}
