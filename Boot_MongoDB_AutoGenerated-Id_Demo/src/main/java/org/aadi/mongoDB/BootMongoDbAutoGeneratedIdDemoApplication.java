 package org.aadi.mongoDB;

import java.util.List;

import org.aadi.mongoDB.model.Product;
import org.aadi.mongoDB.repository.ProductRepository;
import org.aadi.mongoDB.service.SequenceGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BootMongoDbAutoGeneratedIdDemoApplication {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private SequenceGenerationService service;

	@PostMapping("/saveProduct")
	public Product save(@RequestBody Product product){
		//generate sequence
		product.setId(service.getSequenceNumber(Product.SEQUENCE_NAME));
		return repository.save(product);
	}

	@GetMapping("/product")
	public List<Product> getProducts(){
		return repository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(BootMongoDbAutoGeneratedIdDemoApplication.class, args);
	}
}