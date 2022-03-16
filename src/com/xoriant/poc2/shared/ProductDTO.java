package com.xoriant.poc2.shared;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class ProductDTO implements Serializable {

	private String searchBy;

	private String searchText;

	@Digits(fraction = 2, integer = 6, message = "Must Be value")
	@Min(value = 0)
	private String price_range1;

	@Digits(fraction = 2, integer = 6, message = "Must Be value")
	@Max(value = 6)
	private String price_range2;
	
	

	private String dateFrom;

	private String toDate;

	private String availableStatus;

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(String searchBy, String searchText, String price_range1, String price_range2, String dateFrom,
			String toDate, String availableStatus) {
		super();
		this.searchBy = searchBy;
		this.searchText = searchText;
		this.price_range1 = price_range1;
		this.price_range2 = price_range2;
		this.dateFrom = dateFrom;
		this.toDate = toDate;
		this.availableStatus = availableStatus;
	}

	public String getSearchBy() {
		return searchBy;
	}

	public void setSearchBy(String searchBy) {
		if (searchBy instanceof String) {

		}
		this.searchBy = searchBy;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getPrice_range1() {
		return price_range1;
	}

	public void setPrice_range1(String price_range1) {
		this.price_range1 = price_range1;
	}

	public String getPrice_range2() {
		return price_range2;
	}

	public void setPrice_range2(String price_range2) {
		this.price_range2 = price_range2;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getAvailableStatus() {
		return availableStatus;
	}

	public void setAvailableStatus(String availableStatus) {
		this.availableStatus = availableStatus;
	}

	@Override
	public String toString() {
		return "ProductDTO [searchBy=" + searchBy + ", searchText=" + searchText + ", price_range1=" + price_range1
				+ ", price_range2=" + price_range2 + ", dateFrom=" + dateFrom + ", toDate=" + toDate
				+ ", availableStatus=" + availableStatus + "]";
	} 

}
