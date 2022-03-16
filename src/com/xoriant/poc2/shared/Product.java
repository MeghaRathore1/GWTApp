package com.xoriant.poc2.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Product implements IsSerializable {

	public String productName;

	public String categoryId;

	public String categoryName;

	public String unitPrice;

	public String status;

	public String availableSince;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productName, String categoryId, String categoryName, String unitPrice, String status,
			String availableSince) {
		super();
		this.productName = productName;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.unitPrice = unitPrice;
		this.status = status;
		this.availableSince = availableSince;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAvailableSince() {
		return availableSince;
	}

	public void setAvailableSince(String availableSince) {
		this.availableSince = availableSince;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", categoryId=" + categoryId + ", categoryName=" + categoryName
				+ ", unitPrice=" + unitPrice + ", status=" + status + ", availableSince=" + availableSince + "]";
	}


}
