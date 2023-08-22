package com.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.entities.AnswerModel;
import com.project.entities.Product;
import com.project.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private AnswerModel answer;
	
	public List<Product> findAll(){
		return repo.findAll();
	}
	
	public ResponseEntity<?> addProduct(Product product) {
		if(product.getName().equals("")) {
			answer.setMsg("O nome do produto é obrigatório.");
			return new ResponseEntity<AnswerModel>(answer, HttpStatus.BAD_REQUEST);
		}
		else if(product.getBrand().equals("")) {
			answer.setMsg("O nome da marca é obrigatório.");
			return new ResponseEntity<AnswerModel>(answer, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Product>(repo.save(product), HttpStatus.CREATED);
		}

	
	public ResponseEntity<?> update(Long id, Product product){
		if(product.getName().equals("")) {
			answer.setMsg("O nome do produto é obrigatório.");
			return new ResponseEntity<AnswerModel>(answer, HttpStatus.BAD_REQUEST);
		}
		else if(product.getBrand().equals("")) {
			answer.setMsg("O nome da marca é obrigatório.");
			return new ResponseEntity<AnswerModel>(answer, HttpStatus.BAD_REQUEST);
		}
		product.setId(id);
		return new ResponseEntity<Product>(repo.save(product), HttpStatus.CREATED);
		}

}

