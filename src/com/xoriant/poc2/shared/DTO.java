package com.xoriant.poc2.shared;

import java.io.Serializable;

public class DTO implements Serializable {

	private String categoryId;

	private String categoryName;

	private String productName;

	private String unitPrice;

	private String productStatus;

	private String availableSince;

	public DTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTO(String categoryId, String categoryName, String productName, String unitPrice, String productStatus,
			String availableSince) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.productStatus = productStatus;
		this.availableSince = availableSince;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public String getAvailableSince() {
		return availableSince;
	}

	public void setAvailableSince(String availableSince) {
		this.availableSince = availableSince;
	}

	@Override
	public String toString() {
		return "DTO [categoryId=" + categoryId + ", categoryName=" + categoryName + ", productName=" + productName
				+ ", unitPrice=" + unitPrice + ", productStatus=" + productStatus + ", availableSince=" + availableSince
				+ "]";
	}

}
