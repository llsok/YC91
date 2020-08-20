package com.yc.swt.comp;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import com.yc.swt.SwtLabelPaintListner;

public class InfoComp extends Composite {

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public InfoComp(Composite parent, int style, String img, String title, String desc) {
		super(parent, style);

		Label label = new Label(this, SWT.BORDER);
		label.setImage(SWTResourceManager.getImage(img));
		label.setBounds(24, 54, 90, 99);

		Label labTitle = new Label(this, SWT.NONE);
		labTitle.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		labTitle.setBounds(24, 10, 74, 23);
		labTitle.setText(title);

		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBounds(34, 32, 81, 17);
		label_1.setText(desc);

		label.addPaintListener(new SwtLabelPaintListner());

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
