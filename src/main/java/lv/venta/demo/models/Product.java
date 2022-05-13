package lv.venta.demo.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Product {
	
	//id,title,description,quantity,price
	private int id;
	
	@Size(min=4, max=20)
	@Pattern(regexp="[A-Z]{1}[a-z]+")
	private String title;
	
	@Size(min=5, max=20)
	@Pattern(regexp="[A-Z]{1}[a-z\\s]+")
	private String description;
	
	@Min(value=1)
	@Max(value=1000)
	private int quantity;
	
	@Min(value=0)
	@Max(value=10000)
	private float price;
	
	
	public static int counter = 1;
	
	//getters
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public float getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getDescription() {
		return description;
	}
	
	//setters
	public void setId() {
		this.id = counter;
		counter++;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	//constructors arg/no arg
	public Product() {
		
	}
	
	public Product(String title, String description, int quantity, float price) {
		
		setId();
		setTitle(title);
        setDescription(description);
        setQuantity(quantity);
        setPrice(price);
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
	
	//toString
	
}
