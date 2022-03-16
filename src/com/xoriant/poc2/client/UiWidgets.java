package com.xoriant.poc2.client;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;
import com.xoriant.poc2.shared.DTO;
import com.xoriant.poc2.shared.Product;
import com.xoriant.poc2.shared.ProductDTO;

public class UiWidgets {

	FlowPanel flowPanel = new FlowPanel();
	MyFlowPanel myFlowPanel = new MyFlowPanel();
	HorizontalPanel panel1;
	ProductDTO productDTO;
	ListBox lb1;
	TextBox textBox3;
	TextBox textBox1;
	TextBox textBox2;
	DateBox dateBox1;
	DateBox dateBox2;
	ListBox lb2;
	Button goButton;
	GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	CellTable<Product> table;
	HorizontalPanel panel4;

	TextBox productNameTextBox;
	BorderPanel1 borderPanelForAddProduct;
	FlowPanel flowPanelAddProduct;
	HorizontalPanel panel_1;
	HorizontalPanel panel_2;
	HorizontalPanel panel_3;
	HorizontalPanel panel_4;
	HorizontalPanel panel_5;
	HorizontalPanel panel_6;
	HorizontalPanel panel_7;
	DTO dto;
	DateTimeFormat dateTimeFormat;
	DateBox availableSince;
	Button clearButton1;

	public Widget getWidget1() {
		productDTO = new ProductDTO();
		panel1 = new HorizontalPanel();
		HTMLPanel lineBrakespace1 = new HTMLPanel("<br/><br/>");
		flowPanel.add(lineBrakespace1);

		Label label1 = new Label();
		label1.setText("Search by");
		panel1.setSpacing(10);
		panel1.add(label1);

		lb1 = new ListBox();
		HTMLPanel spacePanel4 = new HTMLPanel("&emsp;&emsp;");
		panel1.add(spacePanel4);

		lb1.addItem("Product Name");
		lb1.addItem("Category ID");
		lb1.addItem("Category Name");
		lb1.addItem("Status");
		lb1.setVisibleItemCount(1);
		panel1.add(lb1);

		flowPanel.add(panel1);
		myFlowPanel.add(flowPanel);
		return myFlowPanel;
	}

	public FlowPanel getFlowPanel1() {
		textBox3 = new TextBox();
		textBox3.setText("Search Text");
		panel1.add(textBox3);
		textBox3.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				textBox3.setText("");
			}
		});

		HTMLPanel lineBrakespace = new HTMLPanel("<br/>");
		panel1.add(lineBrakespace);

		flowPanel.add(panel1);
		myFlowPanel.add(flowPanel);
		return myFlowPanel;
	}

	public Widget getWidget2() {
		HorizontalPanel panel2 = new HorizontalPanel();

		Label label2 = new Label();
		label2.setText("Price ($):between");
		textBox1 = new TextBox();
		panel2.setSpacing(10);
		panel2.add(label2);
		panel2.add(textBox1);
		HTMLPanel spacePanel2 = new HTMLPanel("&nbsp");
		panel2.add(spacePanel2);
		Label label3 = new Label();
		label3.setText("and");
		textBox2 = new TextBox();
		panel2.add(label3);
		HTMLPanel spacePanel7 = new HTMLPanel("&nbsp");
		panel2.add(spacePanel7);
		panel2.add(textBox2);

		HTMLPanel lineBrakespace8 = new HTMLPanel("<br/><br/>");
		panel2.add(lineBrakespace8);

		flowPanel.add(panel2);

		HorizontalPanel panel3 = new HorizontalPanel();

		DateTimeFormat dateFormat = DateTimeFormat.getFormat("MM/dd/yyyy");

		Label label4 = new Label("First available: from");
		dateBox1 = new DateBox();
		dateBox1.setFormat(new DateBox.DefaultFormat(dateFormat));

		Label Label5 = new Label("to");
		dateBox2 = new DateBox();
		dateBox2.setFormat(new DateBox.DefaultFormat(dateFormat));

		panel3.setSpacing(10);
		panel3.add(label4);
		panel3.add(dateBox1);

		panel3.add(Label5);
		panel3.add(dateBox2);

		flowPanel.add(panel3);
		HTMLPanel lineBrakespace2 = new HTMLPanel("<br/><br/>");
		panel3.add(lineBrakespace2);

		flowPanel.add(panel3);

		panel4 = new HorizontalPanel();

		Label label6 = new Label();
		label6.setText("Product Status:");
		lb2 = new ListBox();
		panel4.setSpacing(10);
		lb2.addItem("Available");
		lb2.addItem("Discontinued");
		lb2.setVisibleItemCount(1);
		panel4.add(label6);

		panel4.add(lb2);
		flowPanel.add(panel4);
		myFlowPanel.add(flowPanel);
		return myFlowPanel;

	}

	public FlowPanel getFlowPanel2() {
		goButton = new Button();
		goButton.setText("Go");
		goButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				productDTO.setSearchBy(lb1.getSelectedItemText());
				productDTO.setSearchText(textBox3.getText());
				productDTO.setPrice_range1(textBox1.getValue());
				productDTO.setPrice_range2(textBox2.getValue());
				productDTO.setDateFrom(dateBox1.getTextBox().getText());
				productDTO.setToDate(dateBox2.getTextBox().getText());
				productDTO.setAvailableStatus(lb2.getSelectedItemText());

				greetingService.searchProduct(productDTO, new AsyncCallback<List<Product>>() {
					@Override
					public void onSuccess(List<Product> result) {
						table.setRowData(0, result);
						Window.alert("Fetch Products ::" + result);

					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert("Fail to fetch :: Product" + caught);
					}
				});
			}
		});

		panel4.add(goButton);

		HTMLPanel spacePanel1 = new HTMLPanel("&nbsp &nbsp");
		panel4.add(spacePanel1);

		Button clearButton = new Button();
		clearButton.setText("Clear");
		clearButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				textBox3.setText("");
				textBox1.setText("");
				textBox2.setText("");
				dateBox1.setValue(null);
				dateBox2.setValue(null);
				greetingService.clear(new AsyncCallback<Boolean>() {

					@Override
					public void onSuccess(Boolean result) {
						if (result == true)
							table.setRowCount(0);
					}

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Fail to clear the  data :" + caught);

					}
				});

			}
		});

		panel4.add(clearButton);

		flowPanel.add(panel4);
		myFlowPanel.add(flowPanel);
		return myFlowPanel;

	}

	public Widget getWidgets3() {
		HorizontalPanel panel5 = new HorizontalPanel();
		HTMLPanel htmlPanel = new HTMLPanel("<br/><br/><br/>");
		flowPanel.add(htmlPanel);
		table = new CellTable<Product>();

		TextColumn<Product> productNamecolumn = new TextColumn<Product>() {
			@Override
			public String getValue(Product product) {
				return product.productName;
			}
		};

		table.addColumn(productNamecolumn, "Product Name");

		TextColumn<Product> categoryIdcolumn = new TextColumn<Product>() {
			@Override
			public String getValue(Product product) {
				return product.categoryId;
			}
		};
		table.addColumn(categoryIdcolumn, "Category ID");

		TextColumn<Product> categoryNamecolumn = new TextColumn<Product>() {
			@Override
			public String getValue(Product product) {
				return product.categoryName;
			}
		};
		table.addColumn(categoryNamecolumn, "Category Name");

		TextColumn<Product> unitPricecolumn = new TextColumn<Product>() {
			@Override
			public String getValue(Product product) {
				return product.unitPrice;
			}
		};
		table.addColumn(unitPricecolumn, "Unit Price ($)");

		TextColumn<Product> statuscolumn = new TextColumn<Product>() {
			@Override
			public String getValue(Product product) {
				return product.status;
			}
		};
		table.addColumn(statuscolumn, "Status");

		TextColumn<Product> availablecolumn = new TextColumn<Product>() {
			@Override
			public String getValue(Product product) {
				return product.availableSince;
			}
		};
		table.addColumn(availablecolumn, "Available Since");

		panel5.add(table);

		flowPanel.add(panel5);
		myFlowPanel.add(flowPanel);
		return myFlowPanel;
	}

	public Widget insertProductName() {

		dto = new DTO();
		panel_1 = new HorizontalPanel();
		flowPanelAddProduct = new FlowPanel();
		borderPanelForAddProduct = new BorderPanel1();
		Label label1 = new Label();
		label1.setText("Product Name");
		panel_1.setSpacing(10);
		panel_1.add(label1);
		HTMLPanel spacePanel1 = new HTMLPanel("&nbsp");
		panel_1.add(spacePanel1);
		TextBox textBoxProduct1 = new TextBox();
		panel_1.add(textBoxProduct1);
		flowPanelAddProduct.add(panel_1);
		// =========================================================//

		panel_2 = new HorizontalPanel();
		Label label2 = new Label();
		label2.setText("Category Id");
		panel_2.add(label2);
		HTMLPanel spacePanel = new HTMLPanel("&nbsp &nbsp &nbsp");
		panel_2.add(spacePanel);
		TextBox textBoxProduct2 = new TextBox();
		panel_2.add(textBoxProduct2);
		panel_2.setSpacing(10);
		HTMLPanel lineBrake = new HTMLPanel("<br/>");
		flowPanelAddProduct.add(lineBrake);
		flowPanelAddProduct.add(panel_2);
		// =========================================================//

		// panel3 = new HorizontalPanel();
		Label label3 = new Label();
		label3.setText("Category Name");
		panel_2.add(label3);

		TextBox textBoxProduct3 = new TextBox();
		HTMLPanel spacePanel8 = new HTMLPanel("&nbsp");
		panel_2.add(spacePanel8);
		panel_2.add(textBoxProduct3);
		flowPanelAddProduct.add(panel_2);
		HTMLPanel lineBrake2 = new HTMLPanel("<br/>");
		flowPanelAddProduct.add(lineBrake2);

		// =========================================================//

		// panel1 = new HorizontalPanel();
		Label label4 = new Label();
		label4.setText("Unit Price");
		panel_1.add(label4);
		HTMLPanel spacePanel6 = new HTMLPanel("&emsp; &emsp; &nbsp");
		panel_1.add(spacePanel6);
		TextBox textBoxProduct4 = new TextBox();
		panel_1.add(textBoxProduct4);
		flowPanelAddProduct.add(panel_1);
		HTMLPanel lineBrake3 = new HTMLPanel("<br/>");
		flowPanelAddProduct.add(lineBrake3);

		// =========================================================//

		panel_5 = new HorizontalPanel();
		Label label5 = new Label();
		label5.setText("Product Status");
		panel_5.setSpacing(10);
		panel_5.add(label5);
		HTMLPanel spacePanel5 = new HTMLPanel("&nbsp");
		panel_5.add(spacePanel5);
		TextBox textBoxProduct5 = new TextBox();
		panel_5.add(textBoxProduct5);
		flowPanelAddProduct.add(panel_5);
		// HTMLPanel lineBrake4 = new HTMLPanel("<br/>");
		// flowPanelAddProduct.add(lineBrake4);

		// =========================================================//

		// panel6 = new HorizontalPanel();
		Label label6 = new Label();
		label6.setText("Available Since");
		panel_5.add(label6);
		dateTimeFormat = DateTimeFormat.getFormat("dd/MM/yyyy");
		availableSince = new DateBox();
		// availabelSince.getElement().getStyle().setWidth(150, Unit.PX);
		// availabelSince.getElement().getStyle().setHeight(15, Unit.PX);
		availableSince.setFormat(new DateBox.DefaultFormat(dateTimeFormat));

		// TextBox textBoxProduct6 = new TextBox();
		HTMLPanel spacePanel7 = new HTMLPanel("&nbsp");
		panel_5.add(spacePanel7);
		panel_5.add(availableSince);
		flowPanelAddProduct.add(panel_5);
		HTMLPanel lineBrake5 = new HTMLPanel("<br/>");
		flowPanelAddProduct.add(lineBrake5);

		// =============================================================//
		panel_7 = new HorizontalPanel();
		Button submitButton = new Button();
		submitButton.setText("Submit");
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				dto.setCategoryId(textBoxProduct2.getText());
				dto.setCategoryName(textBoxProduct3.getText());
				dto.setProductName(textBoxProduct1.getText());
				dto.setUnitPrice(textBoxProduct4.getText());
				dto.setProductStatus(textBoxProduct5.getText());
				dto.setAvailableSince(availableSince.getTextBox().getText());
				greetingService.addNewProduct(dto, new AsyncCallback<Product>() {

					@Override
					public void onSuccess(Product result) {
						// table.setRowData(0, result);
						Window.alert("Added New Product Succesfully !!!");
					}

					@Override
					public void onFailure(Throwable caught) {

						Window.alert("Failure " + caught);
					}
				});
			}
		});
		panel_7.add(submitButton);

		clearButton1 = new Button();
		clearButton1.setText("Clear");
		clearButton1.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				textBoxProduct2.setText("");
				textBoxProduct3.setText("");
				textBoxProduct1.setText("");
				textBoxProduct4.setText("");
				textBoxProduct5.setText("");
				availableSince.setValue(null);
				greetingService.clear(new AsyncCallback<Boolean>() {

					@Override
					public void onSuccess(Boolean result) {
						if (result == true){
							
				// 			table.setRowCount(0);
					}
					}

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Fail to clear the  data :" + caught);

					}
				});

			}
		});

		panel_7.add(clearButton1);
		flowPanelAddProduct.add(panel_7);

		borderPanelForAddProduct.add(flowPanelAddProduct);
		return borderPanelForAddProduct;
	}

}
