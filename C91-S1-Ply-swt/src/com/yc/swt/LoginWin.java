package com.yc.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

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
		shell.setSize(391, 229);
		shell.setText("登录窗口");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(48, 49, 61, 17);	// 大小和位置
		label.setText("用户名:");				// 文本内容
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(129, 46, 187, 23);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(48, 81, 61, 17);
		label_1.setText("密码:");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(129, 78, 187, 23);
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(129, 118, 80, 27);
		button.setText("登录");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(235, 118, 80, 27);
		btnNewButton.setText("取消");

	}
}
