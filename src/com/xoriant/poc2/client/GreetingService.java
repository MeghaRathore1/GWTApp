package com.xoriant.poc2.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.xoriant.poc2.shared.DTO;
import com.xoriant.poc2.shared.Product;
import com.xoriant.poc2.shared.ProductDTO;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	// String greetServer(String name) throws IllegalArgumentException;

	List<Product> searchProduct(ProductDTO productDTO) throws IllegalArgumentException;

	Boolean clear() throws IllegalArgumentException;

	Product addNewProduct(DTO dto) throws IllegalArgumentException;

}
