package com.xoriant.poc2.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.xoriant.poc2.client.GreetingService;
import com.xoriant.poc2.shared.DTO;
import com.xoriant.poc2.shared.Product;
import com.xoriant.poc2.shared.ProductDTO;

/**
 * The server-side implementation of the RPC service.
 */

@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	Set<Product> set;

	ProductDTO productDTO = new ProductDTO();

	double price1, price2, unitPrice;

	Date toDate, dateFrom, sinceAvailable;

	Product product = new Product();

	public GreetingServiceImpl() {
		super();

	}

	public GreetingServiceImpl(Object delegate) {
		super(delegate);
	}

	@Override
	public List<Product> searchProduct(ProductDTO productDTO) throws IllegalArgumentException {

		System.out.println("-------------------------------------------------------------------");
		System.out.println(productDTO);
		System.out.println("------------------------------------------------------------");

		set = new HashSet<Product>();

		try {
			Connection conn = DataBaseConfig.getConnection();
			Statement st = conn.createStatement();
			String queury = "select * from products";
			ResultSet rs = st.executeQuery(queury);
			while (rs.next()) {

				Product product = new Product();
				product.setProductName(rs.getString(1));
				product.setCategoryId(rs.getString(2));
				product.setCategoryName(rs.getString(3));
				product.setUnitPrice(rs.getString(4));
				product.setStatus(rs.getString(5));
				product.setAvailableSince(rs.getString(6));

				if (productDTO.getSearchText().toString().equals(product.getProductName())
						|| productDTO.getSearchText().toString().equals(product.getCategoryId())
						|| productDTO.getSearchText().toString().equals(product.getCategoryName())
						|| productDTO.getSearchText().toString().equals(product.getStatus())) {
					set.add(product);
				}

				if (TestForNullOrEmpty(productDTO.getPrice_range1())) {
					price1 = Double.parseDouble(productDTO.getPrice_range1());
				}

				if (TestForNullOrEmpty(productDTO.getPrice_range2())) {
					price2 = Double.parseDouble(productDTO.getPrice_range2());
				}

				if (TestForNullOrEmpty(product.getUnitPrice())) {
					unitPrice = Double.parseDouble(product.getUnitPrice());
				}

				if (price1 <= unitPrice && unitPrice <= price2) {
					set.add(product);
				}

				if (productDTO.getAvailableStatus().toString().equals(product.getStatus())) {
					set.add(product);
				}

				String from_Date = productDTO.getDateFrom();
				String to_Date = productDTO.getToDate();
				String available_Since = product.getAvailableSince();
				System.out.println("========== UI Sides Entered =========");
				System.out.println("Form DATE ::" + from_Date);
				System.out.println("available Since ::" + available_Since);
				System.out.println("to DATE ::" + to_Date);

				SimpleDateFormat dateformatter = new SimpleDateFormat("MM/dd/yyyy");
				try {

					if (TestForNullOrEmpty(productDTO.getDateFrom()) && TestForNullOrEmpty(productDTO.getToDate())
							&& TestForNullOrEmpty(product.getAvailableSince())) {

						dateFrom = dateformatter.parse(productDTO.getDateFrom());
						toDate = dateformatter.parse(productDTO.getToDate());
						sinceAvailable = dateformatter.parse(product.getAvailableSince());

						System.out.println("===========Date and Time Format =========");
						System.out.println("Form DATE ::" + dateFrom);
						System.out.println("available Since ::" + sinceAvailable);
						System.out.println("to DATE ::" + toDate);

						if (dateFrom.compareTo(toDate) < 0) {
							if (sinceAvailable.compareTo(toDate) < 0 && dateFrom.compareTo(sinceAvailable) < 0) {
								set.add(product);
							} else {
								System.out.println("===== Not Present between the Entered Date =====");
							}
						} else {
							System.out.println("================== No result found =================");
						}
					}

				} catch (Exception e) {

					e.printStackTrace();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Product>(set);
	}

	private boolean TestForNullOrEmpty(String price_range1) {
		if (price_range1.toString() != null && !price_range1.toString().trim().isEmpty())
			return true;
		else
			return false;
	}

	@Override
	public Boolean clear() throws IllegalArgumentException {
		set.clear();
		if (set.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	// List<Product> PRODUCT = Arrays.asList(new Product("Baking Pan", "3",
	// "kitchen", "10.99", "Available", "10/26/2013"),
	// new Product("Bath Rug", "1", "Bath", "24.50", "Available", "07/10/2014"),
	// new Product("Blanket", "2", "Bedding", "60.00", "Available",
	// "08/22/2015"),
	// new Product("Coffee Maker", "3", "Kitchen", "49.39", "Discontinued", "
	// "),
	// new Product("Knife set", "3", "Kitchen", "70.00", "Available",
	// "10/10/2020"));

	@Override
	public Product addNewProduct(DTO dto) throws IllegalArgumentException {
		set = new HashSet<Product>();

		try {

			Connection conn = DataBaseConfig.getConnection();
			String queury = "insert into products values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(queury);
			ps.setString(1, dto.getProductName());
			ps.setString(2, dto.getCategoryId());
			ps.setString(3, dto.getCategoryName());
			ps.setString(4, dto.getUnitPrice());
			ps.setString(5, dto.getProductStatus());
			ps.setString(6, dto.getAvailableSince());
			int res = ps.executeUpdate();

			if (res != 0) {
				System.out.println("New Product Added Succesfully ");

			} else {
				System.out.println("============== Record not saved ====================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
}

// Set<Product> getProducts;
//
// double price1, price2, unitPrice;
// // Integer dateFrom, toDate, availableSince;
// Product product = new Product();
//
// Date dateFrom, toDate, availableSince;
//
// ProductDTO productDTO=new ProductDTO();
//
// public GreetingServiceImpl() {
// super();
//
// }
//
// public GreetingServiceImpl(Object delegate) {
// super(delegate);
// }
//
// @Override
// public List<Product> searchProduct(ProductDTO productDTO) throws
// IllegalArgumentException {
//
// System.out.println(
// "------------------------------------------------------------------------------------------------");
// System.out.println(productDTO);
// System.out.println(
// "------------------------------------------------------------------------------------------------");
//
// // TO Avoid repeating Records
// getProducts = new HashSet<Product>();
// // for (Product product : PRODUCT)
// try {
// Connection con = DataBaseConfig.getConnection();
// Statement stmt = con.createStatement();
// String s = "SELECT * FROM products";
// ResultSet rs = stmt.executeQuery(s);
// while (rs.next()) {
//
// if (TestForNullOrEmpty(productDTO.getPrice_range1()))
// price1 = Double.parseDouble(productDTO.getPrice_range1());
//
// if (TestForNullOrEmpty(productDTO.getPrice_range2()))
// price2 = Double.parseDouble(productDTO.getPrice_range2());
//
// if (TestForNullOrEmpty(product.getUnitPrice()))
// unitPrice = Double.parseDouble(product.getUnitPrice());
// //
// // if (TestForNullOrEmpty(productDTO.getDateFrom()))
// // unitPrice = Double.parseDouble(productDTO.getDateFrom());
// //
// // if (TestForNullOrEmpty(productDTO.getToDate()))
// // unitPrice = Double.parseDouble(productDTO.getToDate());
// //
// // if (TestForNullOrEmpty(product.getAvailableSince()))
// // unitPrice = Double.parseDouble(product.getAvailableSince());
//
// if
// (productDTO.getSearchText().toString().equals(product.getProductName())
// || productDTO.getSearchText().toString().equals(product.getCategoryId())
// ||
// productDTO.getSearchText().toString().equals(product.getCategoryName())
// || productDTO.getSearchText().toString().equals(product.getStatus()))
// getProducts.add(product);
//
// if
// (productDTO.getAvailableStatus().toString().equals(product.getStatus()))
// {
//
// getProducts.add(product);
// }
//
// if (price1 <= unitPrice && unitPrice <= price2) {
//
// getProducts.add(product);
//
// }
//
// String dateFrom_ = productDTO.getDateFrom(), toDate_ =
// productDTO.getToDate(),
// availableSince_ = product.getAvailableSince();
//
// System.out.println("===============String Dates--------------------");
//
// System.out.println("DateFrom====" + dateFrom_);
// System.out.println("toDate====" + toDate_);
// System.out.println("availableSince ====" + availableSince_);
//
// // dateFrom=10/01/2020; False
//
// try {
// SimpleDateFormat dateFormatCasting = new SimpleDateFormat("MM/dd/yyyy");
//
// if ((TestForNullOrEmpty(productDTO.getDateFrom()) &&
// TestForNullOrEmpty(productDTO.getToDate())
// && TestForNullOrEmpty(product.getAvailableSince())))
//
// {
// dateFrom = dateFormatCasting.parse(productDTO.getDateFrom());
// toDate = dateFormatCasting.parse(productDTO.getToDate());
// availableSince = dateFormatCasting.parse(product.getAvailableSince());
//
// System.out.println("===============Dates type
// Dates--------------------");
//
// System.out.println("DateFrom====" + dateFrom);
// System.out.println("toDate====" + toDate);
// System.out.println("availableSince ====" + availableSince);
//
// if (dateFrom.compareTo(toDate) < 0) {
// if (availableSince.compareTo(toDate) < 0 &&
// dateFrom.compareTo(availableSince) < 0) {
// System.out.println("==============Dates matches-----..=====");
//
// getProducts.add(product);
// System.out.println("DateFrom====" + dateFrom);
//
// System.out.println("availableSince ====" + availableSince);
//
// System.out.println("toDate====" + toDate);
//
// System.out.println("==============Dates STATUS=====");
//
// } else
// System.out.println("==============Dates NOT match..=====");
//
// } else
// System.out.println("==============outer dates NOT match..=====");
//
// // date1--------------date2---------------------date3
//
// // if(date1.compareTo(date3) < 0)
// // {
// // if(date2.compareTo(date3) < 0&&
// // date1.compareTo(date2) <
// // 0)
// // {
// //
// // System.out.println("Date2 is between date 1 and date
// // 3");
// //
// // }
// //
// // }
//
// }
//
// }
//
// catch (Exception e) {
// e.printStackTrace();
// }
// // if (dateFrom <= availableSince && availableSince <= toDate) {
// //
// // getProducts.add(product);
// //
// // }
// }
// } catch (Exception e) {
// e.printStackTrace();
// }
//
// return new ArrayList<Product>(getProducts);
//
// }
//
// private boolean TestForNullOrEmpty(String price_range1) {
// if (price_range1.toString() != null &&
// !price_range1.toString().trim().isEmpty())
// return true;
// else
// return false;
// }
//
// @Override
// public Boolean clear() throws IllegalArgumentException {
// getProducts.clear();
// if (getProducts.size() == 0) {
// return true;
// } else {
// return false;
// }
// }
//
//
