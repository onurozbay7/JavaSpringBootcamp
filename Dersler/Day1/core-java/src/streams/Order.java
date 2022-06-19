package streams;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

	LocalDateTime createdDate = LocalDateTime.now();
	List<Product> productList;

	public Order(List<Product> productList) {
		this.productList = productList;
	}

}
