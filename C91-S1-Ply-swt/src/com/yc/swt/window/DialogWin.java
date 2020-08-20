package com.yc.swt.window;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/**
 * Dialog 窗口一般没有 main 方法
 * Dialog 窗口一定会有一个 result 的Object对象, 表示窗口关闭时返回的数据
 * Dialog 的open方法
 * 		1. 有一个result的返回值
 * 		2. open方法用于打开当前的窗口
 * 		3. open方法在没有执行完之前, 后面的代码不会执行
 */
public class DialogWin extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public DialogWin(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.PRIMARY_MODAL);
		shell.setSize(450, 300);
		shell.setText(getText());
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 20, SWT.BOLD));
		label.setBounds(10, 23, 424, 103);
		label.setText("这是我的弹窗, 使用模态方法打开");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(34, 132, 61, 17);
		label_1.setText("请输入姓名:");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(118, 129, 243, 23);
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 双击按钮可以自动生成响应事件
				result = text.getText();
				// 关闭窗口
				shell.dispose();
			}
		});
		button.setBounds(281, 177, 80, 27);
		button.setText("确定并返回");

	}

}
