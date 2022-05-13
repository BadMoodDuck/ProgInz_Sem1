package lv.venta.demo.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.demo.models.Product;
import lv.venta.demo.sevices.ProductCRUD;

@Controller
public class MyFirstController {
	
	@Autowired
	private ProductCRUD productCRUDService;

	@GetMapping("/home")// url - localhost:8080/home
	public String getHomePage()
	{
		System.out.println("My home controller has worked!");
		return "home"; //paradis home.html
	}

	@GetMapping("/send")//localhost:8080/send
	public String getSend(Model model) 
	{
		model.addAttribute("msg", "message to frontend");
		model.addAttribute("msg1", "Hello");
		model.addAttribute("msg2", "How are you?");
		return "msg-page";//Parada msg-page.html
	}
	//get controller function
	@GetMapping("/object")//url localhost:8080/object
	public String getObject(Model model)
	{
		Product prod = new Product("abols","garsigs",10,0.99f);
		model.addAttribute("object", prod);
		return "one-product-page";//shows one-product-page gtml
		
		
	}
	//1 uztaisit kontrolejoso funks kas padod allProducts to frontend VV
	@GetMapping("/allProducts")//url localhost:8080/allProducts
	public String getAllProducts(Model model)
	{
		
		model.addAttribute("object", productCRUDService.readAllProducts());
		return "all-product-page";//shows all-product-page html
		
		
	}
	//2. uztaisit html saraksta attelosanai VV
	
	
	//3. Apskatities kas ir @RequestParam and @PathVariable 
	//un izveidot kontrolejosas funkcijas
	
	
	//localhost:8080/products?id=2 -> parada tikai 1 produktu @RequestParam
	

	@GetMapping("/allProductsFilter") //url localhost:8080/allProductsFilter
	public String getAllProductsFilter(@RequestParam(name="id") int id , Model model) 
	{
		try {
				model.addAttribute("object", productCRUDService.readProductById(id));
				return "one-product-page";
		}
		catch(Exception e) {		
		return"error-page";
		}
	}
	
	//localhost:8080/products/1/12/123 -> parada tikai 1 produktu @PathVariable
	@GetMapping("/allProducts/{id}")
	public String getAllProductsById(@PathVariable(name="id")int id, Model model)
	{
		try {
			model.addAttribute("object", productCRUDService.readProductById(id));
			return "one-product-page";
		}
		catch(Exception e) {		
			return"error-page";
		}
		
	}

	//1. getMapping kontrolliera funkcija, nosuta tuksu objektu
	@GetMapping("/addProduct")// url - localhost:8080/add-product
	public String getAddProduct(Product product)//new Product() - tukšs
	{
		return "add-product-page"; //paradis add-product-page.html
	}
	
	//2. html kura var ievadit produktu param iznemot id
	//3. postMapping funkcija kas sanem aizpildito obj un saglaba saraksta.
	
	@PostMapping("/addProduct")
	public String postAddProduct(Product product) //new Product() - aizpildīts
	{
		
		if(productCRUDService.createNewProduct(product))
			return "redirect:/allProducts"; //post norada uz kuru adresi pārlekt
		else 
			return "redirect:/error";
		
	}
	
	//3.1   redirect uz /allProduct url


	@GetMapping("/updateProduct/{id}") //localhost:8080/updateProduct/2
	public String getUpdateProduct(@PathVariable(name="id") int id, Model model)
	{
		try {
			model.addAttribute("product", productCRUDService.readProductById(id));
			return "update-product-page";
		}
		catch(Exception e) {		
			return"error-page";
		}
		
	}
	
	@PostMapping("/updateProduct/{id}") 
	public String postUpdateProduct(@PathVariable(name="id") int id, Product product)
	{
		if(productCRUDService.updateProductById(id, product))
				return "redirect:/allProducts/"+id; //calls localhost page by id
		else
			return"redirect:/error"; //localhost:8080/error
	}

	@GetMapping ("/error")
	public String getError()
	{
		return"error-page";
	}

	//1. GetMapping declaration
	@GetMapping("/deleteProduct/{id}")
	//2. function declaration
	public String getDeleteProduct(@PathVariable(name="id") int id,Model model)
	//3. find product by id
	{
		if(productCRUDService.deleteProductById(id))
		{
				model.addAttribute("object", productCRUDService.readAllProducts());
				return"all-product-page";
		}
		else
			return"error-page";
	
	}
}


	// if u see this, i appreciate ya