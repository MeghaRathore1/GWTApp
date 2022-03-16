package com.xoriant.poc2.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.xoriant.poc2.shared.DTO;
import com.xoriant.poc2.shared.Product;
import com.xoriant.poc2.shared.ProductDTO;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {

	// void greetServer(String input, AsyncCallback<String> callback) throws
	// IllegalArgumentException;

	void searchProduct(ProductDTO productDTO, AsyncCallback<List<Product>> callback) throws IllegalArgumentException;

	void clear(AsyncCallback<Boolean> callback) throws IllegalArgumentException;

	void addNewProduct(DTO dto,AsyncCallback<Product> callback) throws IllegalArgumentException;
}

