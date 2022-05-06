package lv.venta.demo.models;

public class Product {
	
	//id,title,description,quantity,price
	private int id;
	private String title;
	private String description;
	private int quantity;
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
