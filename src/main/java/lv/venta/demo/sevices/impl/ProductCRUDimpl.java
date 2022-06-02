package lv.venta.demo.sevices.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import lv.venta.demo.models.Product;
import lv.venta.demo.sevices.ProductCRUD;

@Service
public class ProductCRUDimpl implements ProductCRUD{
	
	private ArrayList<Product> allProducts = new ArrayList<>
    (Arrays.asList(new Product("abols", "garsigs", 10, 0.99f),
                    new Product("bumbieris", "zals", 2, 0.12f), 
                    new Product("arbuzs", "salds", 3, 1.99f)));
	
	@Override
	public boolean createNewProduct(Product product) {
		boolean isFound = false;
		for(Product pr: allProducts) 
		{
			if(pr.getTitle().equals(product.getTitle())&& 
					pr.getDescription().equals(product.getDescription())) 
					{
						isFound = true;
						break;
					}
		}
		if(!isFound) 
		{
			Product newProduct = new Product(product.getTitle(),
					product.getDescription(),product.getQuantity(),product.getPrice());
			allProducts.add(newProduct);
			return true;
		}
		else 
		{
			return false;
		}
	}

	@Override
	public ArrayList<Product> readAllProducts() {
		return allProducts;
	}

	@Override
	public Product readProductById(int id) throws Exception {
		for(Product temp: allProducts)
		{
			if(temp.getId()==id)
			{
				return temp;
			}
		}
		throw new Exception("Product does not exist");
	}

	@Override
	public boolean updateProductById(int id, Product product) {
		for(Product temp: allProducts)
		{
			if(temp.getId()==id)
			{
				temp.setTitle(product.getTitle());
				temp.setDescription(product.getDescription());
				temp.setPrice(product.getPrice());
				temp.setQuantity(product.getQuantity());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteProductById(int id) {
		
			for(Product temp: allProducts)
			{
				if(temp.getId()==id)
				{
					//4. delete product
					allProducts.remove(temp);
					return true;
				}
			}
			return false;
	}

}
