package com.yc.swt.layout;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Text;
import swing2swt.layout.BoxLayout;
import swing2swt.layout.BorderLayout;

public class DemoWin {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DemoWin window = new DemoWin();
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
		shell.setSize(749, 507);
		shell.setText("SWT Application");
		shell.setLayout(new GridLayout(2, false));
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new RowLayout(SWT.HORIZONTAL));
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_composite.heightHint = 212;
		gd_composite.widthHint = 335;
		composite.setLayoutData(gd_composite);
		
		Label lblrowlayout = new Label(composite, SWT.BORDER);
		lblrowlayout.setText("行布局RowLayout");
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.setText("New Button");
		
		Button btnNewButton_1 = new Button(composite, SWT.NONE);
		btnNewButton_1.setText("New Button");
		
		Button btnNewButton_2 = new Button(composite, SWT.NONE);
		btnNewButton_2.setText("New Button");
		
		Composite composite_1 = new Composite(shell, SWT.NONE);
		StackLayout sl = new StackLayout();
		composite_1.setLayout(sl);
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_composite_1.widthHint = 362;
		composite_1.setLayoutData(gd_composite_1);
		
		Button btnStacklayout = new Button(composite_1, SWT.NONE);
		btnStacklayout.setText("卡片布局 StackLayout");
		
		Button btnTest = new Button(composite_1, SWT.NONE);
		btnTest.setText("test");
		
		// 设置开篇布局的顶层控件
		sl.topControl = btnStacklayout;
		
		Composite composite_2 = new Composite(shell, SWT.NONE);
		composite_2.setLayout(new FormLayout());
		GridData gd_composite_2 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_composite_2.heightHint = 234;
		composite_2.setLayoutData(gd_composite_2);
		
		Label lblNewLabel = new Label(composite_2, SWT.NONE);
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.top = new FormAttachment(0, 47);
		fd_lblNewLabel.left = new FormAttachment(0, 52);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setText("用户名:");
		
		text = new Text(composite_2, SWT.BORDER);
		FormData fd_text = new FormData();
		fd_text.right = new FormAttachment(lblNewLabel, 210, SWT.RIGHT);
		fd_text.top = new FormAttachment(0, 44);
		fd_text.left = new FormAttachment(lblNewLabel, 6);
		text.setLayoutData(fd_text);
		
		Button btnNewButton_3 = new Button(composite_2, SWT.NONE);
		FormData fd_btnNewButton_3 = new FormData();
		fd_btnNewButton_3.bottom = new FormAttachment(100, -10);
		fd_btnNewButton_3.right = new FormAttachment(100, -10);
		btnNewButton_3.setLayoutData(fd_btnNewButton_3);
		btnNewButton_3.setText("New Button");
		
		Composite composite_3 = new Composite(shell, SWT.NONE);
		composite_3.setLayout(new BorderLayout(0, 0));
		GridData gd_composite_3 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_composite_3.widthHint = 299;
		composite_3.setLayoutData(gd_composite_3);
		
		Button btnNewButton_4 = new Button(composite_3, SWT.NONE);
		btnNewButton_4.setLayoutData(BorderLayout.NORTH);
		btnNewButton_4.setText("New Button");
		
		Button btnNewButton_5 = new Button(composite_3, SWT.NONE);
		btnNewButton_5.setLayoutData(BorderLayout.EAST);
		btnNewButton_5.setText("New Button");
		
		Button btnNewButton_6 = new Button(composite_3, SWT.NONE);
		btnNewButton_6.setLayoutData(BorderLayout.WEST);
		btnNewButton_6.setText("New Button");
		
		Button btnNewButton_7 = new Button(composite_3, SWT.NONE);
		btnNewButton_7.setLayoutData(BorderLayout.SOUTH);
		btnNewButton_7.setText("New Button");
		
		Button btnNewButton_8 = new Button(composite_3, SWT.NONE);
		btnNewButton_8.setLayoutData(BorderLayout.CENTER);
		btnNewButton_8.setText("New Button");

	}
}
