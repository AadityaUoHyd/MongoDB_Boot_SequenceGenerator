package org.aadi.mongoDB.repository;

import org.aadi.mongoDB.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository <Product, Integer>{
}