package com.yc.scott.ui;

import org.eclipse.swt.widgets.Composite;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.RowData;

public class DeptCmp extends Composite {
	private Text text;
	private Table table;

	/**
	 * Create the composite.
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
		label.setText("部门名");
		
		text = new Text(composite, SWT.BORDER);
		
		Button button = new Button(composite, SWT.NONE);
		button.setLayoutData(new RowData(53, SWT.DEFAULT));
		button.setText("查询");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(BorderLayout.CENTER);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("部门名称");
		
		TableItem tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText("财务");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
