package com.yc.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ibm.icu.util.Calendar;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class RegWin {

	protected Shell shell;
	private Text textName;
	private Text textPwd;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RegWin window = new RegWin();
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
		shell.setSize(450, 390);
		shell.setText("注册");

		Label label = new Label(shell, SWT.NONE);
		label.setBounds(39, 20, 61, 17);
		label.setText("姓名:");

		textName = new Text(shell, SWT.BORDER);
		textName.setBounds(106, 17, 183, 23);

		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(39, 52, 61, 17);
		label_1.setText("密码:");

		textPwd = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		textPwd.setBounds(106, 49, 183, 23);

		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(39, 86, 61, 17);
		label_2.setText("性别:");

		Button rb1 = new Button(shell, SWT.RADIO); // 单选框样式
		rb1.setBounds(106, 86, 80, 17);
		rb1.setText("男");

		Button rb2 = new Button(shell, SWT.RADIO);
		rb2.setBounds(192, 86, 97, 17);
		rb2.setText("女");

		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(39, 119, 61, 17);
		label_3.setText("爱好:");

		Button cb1 = new Button(shell, SWT.CHECK);
		cb1.setBounds(106, 119, 51, 17);
		cb1.setText("篮球");

		Button cb2 = new Button(shell, SWT.CHECK);
		cb2.setText("看书");
		cb2.setBounds(163, 119, 51, 17);

		Button cb3 = new Button(shell, SWT.CHECK);
		cb3.setText("电影");
		cb3.setBounds(220, 119, 51, 17);

		Button cb4 = new Button(shell, SWT.CHECK);
		cb4.setText("街舞");
		cb4.setBounds(277, 119, 51, 17);

		Combo comboEdu = new Combo(shell, SWT.NONE);
		comboEdu.setItems(new String[] { "初中", "高中", "大专", "本科", "研究生" });
		comboEdu.setBounds(106, 150, 183, 25);

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(39, 153, 61, 17);
		lblNewLabel.setText("学历:");

		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(39, 192, 61, 17);
		label_4.setText("年龄:");

		Spinner spinnerAge = new Spinner(shell, SWT.BORDER);
		spinnerAge.setMaximum(200);
		spinnerAge.setBounds(106, 189, 183, 23);

		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setBounds(39, 231, 61, 17);
		label_5.setText("生日:");

		DateTime dtBirthday = new DateTime(shell, SWT.BORDER);
		dtBirthday.setBounds(106, 224, 183, 24);

		ProgressBar pbScore = new ProgressBar(shell, SWT.NONE);
		pbScore.setSelection(50);
		pbScore.setBounds(106, 264, 183, 17);

		Label label_6 = new Label(shell, SWT.NONE);
		label_6.setBounds(39, 264, 61, 17);
		label_6.setText("积分:");

		Label label_7 = new Label(shell, SWT.BORDER);
		label_7.setImage(SWTResourceManager.getImage(RegWin.class, "/com/yc/swt/程序员.jpg"));
		label_7.setBounds(317, 10, 97, 103);

		Button button = new Button(shell, SWT.NONE);

		/**
		 * 系统自动生成的, 处理事件的函数调用
		 */
		// 父类(接口)指向子类对象
		// SelectionAdapter ==> 匿名类写法 (事件监听的常用写法)
		// 添加一个事件监听器对象
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 获取用户信息的输入值, 写入到用户对象中
				UserInfo ui = new UserInfo(textName.getText(), textPwd.getText());
				// 性别 rb1, rb2 getSelection 判断是否选中
				if (rb1.getSelection()) {
					ui.setSex('男');
				} else if (rb2.getSelection()) {
					ui.setSex('女');
				}
				// 爱好
				ui.setLikes(new ArrayList<>());
				Button[] cbSeies = { cb1, cb3, cb3, cb4 };
				for (Button cb : cbSeies) {
					if (cb.getSelection()) {
						ui.getLikes().add(cb.getText());
					}
				}
				// 学历
				if(comboEdu.getSelectionIndex() > -1) {
					String edu = comboEdu.getItem(comboEdu.getSelectionIndex());
					ui.setEdu(edu);
				}
				// 年龄
				int age = Integer.valueOf(spinnerAge.getText());
				ui.setAge(age);
				// 生日
				Calendar c = Calendar.getInstance();
				c.set(Calendar.YEAR, dtBirthday.getYear());
				c.set(Calendar.MONTH, dtBirthday.getMonth());
				c.set(Calendar.DAY_OF_MONTH, dtBirthday.getDay());
				Date date = c.getTime();
				ui.setBirthday(date);
				// 积分
				ui.setScore(pbScore.getSelection());
				// 打印
				System.out.println(ui);
			}
		});

		button.setBounds(106, 303, 80, 27);
		button.setText("注册");

		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setBounds(248, 303, 80, 27);
		button_1.setText("放弃");

	}
}
