package com.yc.scott.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class LoginWin {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LoginWin window = new LoginWin();
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
		shell.setSize(378, 208);
		shell.setText("登录窗口");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(59, 36, 61, 17);
		lblNewLabel.setText("用户名:");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(138, 33, 167, 23);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(138, 73, 167, 23);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setText("用户名:");
		lblNewLabel_1.setBounds(59, 76, 61, 17);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(225, 114, 80, 27);
		btnNewButton.setText("取消");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 关闭当前窗口
				LoginWin.this.shell.dispose();
				// 打开主窗口
				new MainWin().open();
			}
		});
		btnNewButton_1.setText("登录");
		btnNewButton_1.setBounds(126, 114, 80, 27);

	}
}
