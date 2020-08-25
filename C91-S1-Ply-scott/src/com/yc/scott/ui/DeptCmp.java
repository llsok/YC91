package com.yc.scott.ui;

import org.eclipse.swt.widgets.Composite;
import swing2swt.layout.BorderLayout;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.yc.scott.bean.Dept;
import com.yc.scott.dao.DeptDao;
import com.yc.scott.util.SwtHelper;

import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DeptCmp extends Composite {
	private Text text;
	private Table table;

	// 部门Dao对象
	private DeptDao ddao = new DeptDao();
	private Text text_1;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public DeptCmp(Composite parent, int style) {
		super(parent, style);
		setLayout(new BorderLayout(0, 0));

		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayoutData(BorderLayout.NORTH);
		RowLayout rl_composite = new RowLayout(SWT.HORIZONTAL);
		rl_composite.center = true;
		composite.setLayout(rl_composite);

		Label label = new Label(composite, SWT.NONE);
		label.setText("部门名:");

		text = new Text(composite, SWT.BORDER);
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setText("地址:");
		
		text_1 = new Text(composite, SWT.BORDER);

		Button button = new Button(composite, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				query();
			}
		});
		button.setLayoutData(new RowData(53, SWT.DEFAULT));
		button.setText("查询");

		Button btnAdd = new Button(composite, SWT.NONE);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean res = (boolean) new DeptWin(getShell(), SWT.NONE).open();
				if (res) {
					query();
				}
			}
		});
		btnAdd.setLayoutData(new RowData(50, SWT.DEFAULT));
		btnAdd.setText("新增");

		Button btnMod = new Button(composite, SWT.NONE);
		btnMod.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				if (table.getSelectionCount() == 0) {
					SwtHelper.mssage("请选择要修改的记录", getShell());
					return;
				} else {
					// 获取中的记录
					TableItem ti = table.getSelection()[0];
					String deptno = ti.getText(0);
					String dname = ti.getText(1);
					String loc = ti.getText(2);
					int iDeptno = Integer.parseInt(deptno);
					// 创建实体对象, 传入表格当前选择行的数据
					Dept dept = new Dept(iDeptno, dname, loc);
					boolean res = (boolean) new DeptWin(getShell(), SWT.NONE, dept).open();
					if (res) {
						query();
					}
				}

			}
		});
		btnMod.setLayoutData(new RowData(51, SWT.DEFAULT));
		btnMod.setText("修改");

		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(BorderLayout.CENTER);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("部门编号");
		TableColumn tableColumn1 = new TableColumn(table, SWT.NONE);
		tableColumn1.setWidth(100);
		tableColumn1.setText("部门名称");
		TableColumn tableColumn2 = new TableColumn(table, SWT.NONE);
		tableColumn2.setWidth(100);
		tableColumn2.setText("部门地址");

		query();

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void query() {
		try {
			String dname = text.getText();
			String loc = text_1.getText();
			Dept d = new Dept(0, dname, loc);
			List<Map<String, Object>> list = ddao.selectByDept(d);
			// System.out.println(list.size());
			// System.out.println(list);
			// 参数表格中原有的数据
			table.removeAll();
			for (Map<String, Object> dept : list) {
				TableItem tableItem = new TableItem(table, SWT.NONE);
				tableItem.setText(
						new String[] { "" + dept.get("DEPTNO"), "" + dept.get("DNAME"), "" + dept.get("LOC") });
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
