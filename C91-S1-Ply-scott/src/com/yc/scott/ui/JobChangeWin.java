package com.yc.scott.ui;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.yc.scott.bean.JobChange;
import com.yc.scott.biz.BizException;
import com.yc.scott.biz.JobChangeBiz;
import com.yc.scott.util.SwtHelper;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class JobChangeWin extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text textEmpno;
	private Text textOldJob;
	private Text textNewJob;
	private Text textOldSal;
	private Text textNewSal;
	private Text textCause;
	private Text textAllow;
	
	/**
	 * 岗位调整业务对象
	 */
	private JobChangeBiz jbiz = new JobChangeBiz();

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public JobChangeWin(Shell parent, int style) {
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
		shell.setSize(426, 387);
		shell.setText("岗位调整");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(64, 46, 61, 17);
		label.setText("员工编号:");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(64, 79, 61, 17);
		label_1.setText("原岗位:");
		
		Label label_1_1 = new Label(shell, SWT.NONE);
		label_1_1.setText("新岗位:");
		label_1_1.setBounds(64, 114, 61, 17);
		
		Label label_1_2 = new Label(shell, SWT.NONE);
		label_1_2.setText("原工资:");
		label_1_2.setBounds(64, 151, 61, 17);
		
		Label label_1_1_1 = new Label(shell, SWT.NONE);
		label_1_1_1.setText("新工资:");
		label_1_1_1.setBounds(64, 186, 61, 17);
		
		Label label_1_1_1_1 = new Label(shell, SWT.NONE);
		label_1_1_1_1.setText("审核人:");
		label_1_1_1_1.setBounds(64, 257, 61, 17);
		
		Label label_1_2_1 = new Label(shell, SWT.NONE);
		label_1_2_1.setText("调整原因:");
		label_1_2_1.setBounds(64, 222, 61, 17);
		
		textEmpno = new Text(shell, SWT.BORDER);
		textEmpno.setBounds(131, 43, 221, 23);
		
		textOldJob = new Text(shell, SWT.BORDER);
		textOldJob.setBounds(131, 79, 221, 23);
		
		textNewJob = new Text(shell, SWT.BORDER);
		textNewJob.setBounds(131, 114, 221, 23);
		
		textOldSal = new Text(shell, SWT.BORDER);
		textOldSal.setBounds(131, 151, 221, 23);
		
		textNewSal = new Text(shell, SWT.BORDER);
		textNewSal.setBounds(131, 186, 221, 23);
		
		textCause = new Text(shell, SWT.BORDER);
		textCause.setBounds(131, 222, 221, 23);
		
		textAllow = new Text(shell, SWT.BORDER);
		textAllow.setBounds(131, 257, 221, 23);
		
		Button buttonCancel = new Button(shell, SWT.NONE);
		buttonCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		buttonCancel.setBounds(272, 307, 80, 27);
		buttonCancel.setText("放弃");
		
		Button buttonCommit = new Button(shell, SWT.NONE);
		buttonCommit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				JobChange jc = new JobChange();
				// 从界面元素取值设置到 jc 中
				/**
				 * 这里要对用户输入的值进行一个判断
				 */
				jc.setEmpno(Integer.parseInt(textEmpno.getText()));
				jc.setOldjob(textOldJob.getText());
				jc.setNewjob(textNewJob.getText());
				jc.setOldsal(Float.parseFloat(textOldSal.getText()));
				jc.setNewsal(Float.parseFloat(textNewSal.getText()));
				jc.setCause(textCause.getText());
				jc.setAllow(Integer.parseInt(textAllow.getText()));
				try {
					jbiz.create(jc);
					SwtHelper.mssage("岗位调整成功!", shell);
					shell.dispose();
				} catch (BizException e1) {
					SwtHelper.mssage(e1.getMessage(), shell);
				}
			}
		});
		buttonCommit.setText("提交");
		buttonCommit.setBounds(176, 307, 80, 27);

	}
}
