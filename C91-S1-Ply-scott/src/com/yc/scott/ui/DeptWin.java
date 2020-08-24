package com.yc.scott.ui;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Text;

import com.yc.scott.bean.Dept;
import com.yc.scott.biz.BizException;
import com.yc.scott.biz.DeptBiz;
import com.yc.scott.util.SwtHelper;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DeptWin extends Dialog {

	protected Object result = false;
	protected Shell shell;
	private Text text;
	private Label lblNewLabel;
	private Text text_1;
	private Label label_1;
	private Text text_2;

	private DeptBiz dbiz = new DeptBiz();

	/**
	 * 定义一个对象接收被修改的部门 ==> 实体对象 (C语言结构体)
	 */
	private Dept dept;

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */
	/**
	 * 新增部门的构造方法
	 * @param parent
	 * @param style
	 */
	public DeptWin(Shell parent, int style) {
		super(parent, style);
	}

	/**
	 * 修改部门的构造方法
	 * @param parent
	 * @param style
	 * @param dept
	 */
	public DeptWin(Shell parent, int style, Dept dept) {
		super(parent, style);
		this.dept = dept;
	}

	/**
	 * Open the dialog.
	 * 
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
		shell.setSize(356, 272);
		shell.setText("部门信息编辑");
		shell.setLayout(new FormLayout());
		// 居中
		SwtHelper.center(shell);

		Label label = new Label(shell, SWT.NONE);
		FormData fd_label = new FormData();
		fd_label.top = new FormAttachment(0, 41);
		fd_label.left = new FormAttachment(0, 30);
		label.setLayoutData(fd_label);
		label.setText("部门编号:");

		text = new Text(shell, SWT.BORDER);
		FormData fd_text = new FormData();
		fd_text.left = new FormAttachment(label, 14);
		fd_text.top = new FormAttachment(0, 38);
		fd_text.right = new FormAttachment(100, -43);
		text.setLayoutData(fd_text);

		lblNewLabel = new Label(shell, SWT.NONE);
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.top = new FormAttachment(label, 30);
		fd_lblNewLabel.left = new FormAttachment(label, 0, SWT.LEFT);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setText("部门名称:");

		text_1 = new Text(shell, SWT.BORDER);
		FormData fd_text_1 = new FormData();
		fd_text_1.top = new FormAttachment(lblNewLabel, -3, SWT.TOP);
		fd_text_1.right = new FormAttachment(text, 0, SWT.RIGHT);
		fd_text_1.left = new FormAttachment(text, 0, SWT.LEFT);
		text_1.setLayoutData(fd_text_1);

		label_1 = new Label(shell, SWT.NONE);
		FormData fd_label_1 = new FormData();
		fd_label_1.top = new FormAttachment(lblNewLabel, 27);
		fd_label_1.right = new FormAttachment(label, 0, SWT.RIGHT);
		label_1.setLayoutData(fd_label_1);
		label_1.setText("部门地址:");

		text_2 = new Text(shell, SWT.BORDER);
		FormData fd_text_2 = new FormData();
		fd_text_2.right = new FormAttachment(text, 0, SWT.RIGHT);
		fd_text_2.top = new FormAttachment(text_1, 21);
		fd_text_2.left = new FormAttachment(text, 0, SWT.LEFT);
		text_2.setLayoutData(fd_text_2);

		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String deptno = text.getText();
				String dname = text_1.getText();
				String loc = text_2.getText();
				try {
					if(dept == null) {
						dbiz.create(deptno, dname, loc);
						SwtHelper.mssage("部门添加成功!", shell);
					} else {
						dbiz.modify(deptno, dname, loc);
						SwtHelper.mssage("部门修改成功!", shell);
					}
					shell.dispose();
					// 设置返回值
					result = true;
				} catch (BizException e1) {
					e1.printStackTrace();
					SwtHelper.mssage(e1.getMessage(), shell);
				}
			}
		});
		FormData fd_button = new FormData();
		fd_button.top = new FormAttachment(text_2, 29);
		button.setLayoutData(fd_button);
		button.setText("保存");

		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		fd_button.right = new FormAttachment(button_1, -20);
		fd_button.left = new FormAttachment(button_1, -98, SWT.LEFT);
		FormData fd_button_1 = new FormData();
		fd_button_1.left = new FormAttachment(100, -118);
		fd_button_1.top = new FormAttachment(text_2, 29);
		fd_button_1.right = new FormAttachment(100, -43);
		button_1.setLayoutData(fd_button_1);
		button_1.setText("放弃");
		
		if(dept != null) {
			text.setText(""+dept.getDeptno());
			text_1.setText(""+dept.getDname());
			text_2.setText(""+dept.getLoc());
		}
		
	}
}
