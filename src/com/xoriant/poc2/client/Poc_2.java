package com.xoriant.poc2.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.xoriant.poc2.shared.Product;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Poc_2 implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private CellTable<Product> table;

	public void onModuleLoad() {

		UiWidgets uiWidgets = new UiWidgets();
		RootPanel.get().add(uiWidgets.getWidget1());
		RootPanel.get().add(uiWidgets.getFlowPanel1());
		RootPanel.get().add(uiWidgets.getWidget2());
		RootPanel.get().add(uiWidgets.getFlowPanel2());
		RootPanel.get().add(uiWidgets.getWidgets3());

		RootPanel.get().add(uiWidgets.insertProductName());
		//
		// ProductDTO productDTO = new ProductDTO();
		//
		// final GreetingServiceAsync greetingService =
		// GWT.create(GreetingService.class);
		//
		// FlowPanel panel = new FlowPanel();
		//
		// MyFlowPanel flowPanel = new MyFlowPanel();
		//
		// // =========================================//
		//
		// HorizontalPanel panel1 = new HorizontalPanel();
		// HTMLPanel lineBrakespace1 = new HTMLPanel("<br/><br/>");
		// panel.add(lineBrakespace1);
		//
		// Label label1 = new Label();
		// label1.setText("Search by");
		// panel1.setSpacing(10);
		// panel1.add(label1);
		//
		// ListBox lb1 = new ListBox();
		// HTMLPanel spacePanel4 = new HTMLPanel("&emsp;&emsp;");
		// panel1.add(spacePanel4);
		//
		// lb1.addItem("Product Name");
		// lb1.addItem("Category ID");
		// lb1.addItem("Category Name");
		// lb1.addItem("Status");
		// lb1.setVisibleItemCount(1);
		// panel1.add(lb1);
		//
		// panel.add(panel1);
		//
		// HTMLPanel spacePanel = new HTMLPanel("&emsp;&emsp;&emsp;&emsp;");
		//
		// panel1.add(spacePanel);
		// TextBox textBox3 = new TextBox();
		// textBox3.setText("Search Text");
		// panel1.add(textBox3);
		// textBox3.addClickHandler(new ClickHandler() {
		//
		// @Override
		// public void onClick(ClickEvent event) {
		// // TODO Auto-generated method stub
		// textBox3.setText("");
		// }
		// });
		//
		// HTMLPanel lineBrakespace = new HTMLPanel("<br/>");
		// panel1.add(lineBrakespace);
		//
		// panel.add(panel1);
		//
		// // =========================================//
		//
		// HorizontalPanel panel2 = new HorizontalPanel();
		//
		// Label label2 = new Label();
		// label2.setText("Price ($):between");
		// TextBox textBox1 = new TextBox();
		// panel2.setSpacing(10);
		// panel2.add(label2);
		// panel2.add(textBox1);
		// HTMLPanel spacePanel2 = new HTMLPanel("&nbsp");
		// panel2.add(spacePanel2);
		// Label label3 = new Label();
		// label3.setText("and");
		// TextBox textBox2 = new TextBox();
		// panel2.add(label3);
		// HTMLPanel spacePanel7 = new HTMLPanel("&nbsp");
		// panel2.add(spacePanel7);
		// panel2.add(textBox2);
		//
		// HTMLPanel lineBrakespace8 = new HTMLPanel("<br/><br/>");
		// panel2.add(lineBrakespace8);
		//
		// panel.add(panel2);
		//
		// // =========================================//
		//
		// HorizontalPanel panel3 = new HorizontalPanel();
		//
		// DateTimeFormat dateFormat = DateTimeFormat.getFormat("MM/dd/yyyy");
		//
		// Label label4 = new Label("First available: from");
		// DateBox dateBox1 = new DateBox();
		// dateBox1.setFormat(new DateBox.DefaultFormat(dateFormat));
		//
		// Label Label5 = new Label("to");
		// DateBox dateBox2 = new DateBox();
		// dateBox2.setFormat(new DateBox.DefaultFormat(dateFormat));
		//
		// panel3.setSpacing(10);
		// panel3.add(label4);
		// panel3.add(dateBox1);
		//
		// panel3.add(Label5);
		// panel3.add(dateBox2);
		//
		// HTMLPanel lineBrakespace2 = new HTMLPanel("<br/><br/>");
		// panel3.add(lineBrakespace2);
		//
		// panel.add(panel3);
		//
		// // =========================================//
		//
		// HorizontalPanel panel4 = new HorizontalPanel();
		//
		// Label label6 = new Label();
		// label6.setText("Product Status:");
		// ListBox lb2 = new ListBox();
		// panel4.setSpacing(10);
		// lb2.addItem("Available");
		// lb2.addItem("Discontinued");
		// lb2.setVisibleItemCount(1);
		// panel4.add(label6);
		//
		// panel4.add(lb2);
		//
		// // =========================================//
		//
		// HTMLPanel spacePanel6 = new HTMLPanel("&emsp;&emsp;");
		// panel4.add(spacePanel6);
		//
		// Button goButton = new Button();
		// goButton.setText("Go");
		// goButton.addClickHandler(new ClickHandler() {
		//
		// @Override
		// public void onClick(ClickEvent event) {
		//
		// productDTO.setSearchBy(lb1.getSelectedItemText());
		// productDTO.setSearchText(textBox3.getText());
		// productDTO.setPrice_range1(textBox1.getValue());
		// productDTO.setPrice_range2(textBox2.getValue());
		// productDTO.setDateFrom(dateBox1.getTextBox().getText());
		// productDTO.setToDate(dateBox2.getTextBox().getText());
		// productDTO.setAvailableStatus(lb2.getSelectedItemText());
		//
		// greetingService.searchProduct(productDTO, new
		// AsyncCallback<List<Product>>() {
		// @Override
		// public void onSuccess(List<Product> result) {
		// table.setRowData(0, result);
		// Window.alert("Fetch Products ::" + result);
		//
		// }
		//
		// @Override
		// public void onFailure(Throwable caught) {
		// // TODO Auto-generated method stub
		// Window.alert("Fail to fetch :: Product" + caught);
		// }
		// });
		// }
		// });
		//
		// panel4.add(goButton);
		//
		// HTMLPanel spacePanel1 = new HTMLPanel("&nbsp &nbsp");
		// panel4.add(spacePanel1);
		//
		// Button clearButton = new Button();
		// clearButton.setText("Clear");
		// clearButton.addClickHandler(new ClickHandler() {
		//
		// @Override
		// public void onClick(ClickEvent event) {
		// // TODO Auto-generated method stub
		// textBox3.setText("");
		// textBox1.setText("");
		// textBox2.setText("");
		// dateBox1.setValue(null);
		// dateBox2.setValue(null);
		// greetingService.clear(new AsyncCallback<Boolean>() {
		//
		// @Override
		// public void onSuccess(Boolean result) {
		// if (result == true)
		// table.setRowCount(0);
		// }
		//
		// @Override
		// public void onFailure(Throwable caught) {
		// Window.alert("Fail to clear the data :" + caught);
		//
		// }
		// });
		//
		// }
		// });
		//
		// panel4.add(clearButton);
		//
		// panel.add(panel4);
		//
		// // =========================================//
		//
		// table = new CellTable<Product>();
		//
		// TextColumn<Product> productNamecolumn = new TextColumn<Product>() {
		// @Override
		// public String getValue(Product product) {
		// return product.productName;
		// }
		// };
		//
		// table.addColumn(productNamecolumn, "Product Name");
		//
		// TextColumn<Product> categoryIdcolumn = new TextColumn<Product>() {
		// @Override
		// public String getValue(Product product) {
		// return product.categoryId;
		// }
		// };
		// table.addColumn(categoryIdcolumn, "Category ID");
		//
		// TextColumn<Product> categoryNamecolumn = new TextColumn<Product>() {
		// @Override
		// public String getValue(Product product) {
		// return product.categoryName;
		// }
		// };
		// table.addColumn(categoryNamecolumn, "Category Name");
		//
		// TextColumn<Product> unitPricecolumn = new TextColumn<Product>() {
		// @Override
		// public String getValue(Product product) {
		// return product.unitPrice;
		// }
		// };
		// table.addColumn(unitPricecolumn, "Unit Price ($)");
		//
		// TextColumn<Product> statuscolumn = new TextColumn<Product>() {
		// @Override
		// public String getValue(Product product) {
		// return product.status;
		// }
		// };
		// table.addColumn(statuscolumn, "Status");
		//
		// TextColumn<Product> availablecolumn = new TextColumn<Product>() {
		// @Override
		// public String getValue(Product product) {
		// return product.availableSince;
		// }
		// };
		// table.addColumn(availablecolumn, "Available Since");
		//
		// // =========================================//
		//
		// flowPanel.add(panel);
		// RootPanel.get().add(flowPanel);
		// HTMLPanel htmlPanel = new HTMLPanel("<br/><br/>");
		// RootPanel.get().add(htmlPanel);
		// RootPanel.get().add(table);
		// }
	}
}