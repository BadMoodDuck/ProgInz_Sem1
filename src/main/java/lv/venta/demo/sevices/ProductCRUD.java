package lv.venta.demo.sevices;

import java.util.ArrayList;

import lv.venta.demo.models.Product;

public interface ProductCRUD {
	
	public abstract boolean createNewProduct(Product product);
	
	public abstract ArrayList<Product> readAllProducts();
	
	public abstract Product readProductById(int id) throws Exception;
	
	public abstract boolean updateProductById (int id, Product product);
	
	public abstract boolean deleteProductById(int id);
	
	
	
}
