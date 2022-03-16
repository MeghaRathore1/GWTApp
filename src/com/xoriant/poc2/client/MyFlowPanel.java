package com.xoriant.poc2.client;

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;

public class MyFlowPanel extends FlowPanel {
	public MyFlowPanel() {
		super();
		getElement().getStyle().setMarginTop(-85, Unit.PX);
		getElement().getStyle().setMarginLeft(20, Unit.PX);
		getElement().getStyle().setMarginRight(700, Unit.PX);
		getElement().getStyle().setBorderColor("black");
		getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		getElement().getStyle().setBorderWidth(1, Unit.PX);
		getElement().getStyle().setHeight(250, Unit.PX);
	}
}

class BorderPanel1 extends FlowPanel {

	// ------------------------ Border Line ------------------------//
	public BorderPanel1() {
		super();
		getElement().getStyle().setMarginTop(-250, Unit.PX);
		getElement().getStyle().setMarginLeft(700, Unit.PX);
		getElement().getStyle().setMarginRight(20, Unit.PX);
		getElement().getStyle().setBorderColor("black");
		getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		getElement().getStyle().setBorderWidth(1, Unit.PX);
		getElement().getStyle().setHeight(250, Unit.PX);
	}

}
