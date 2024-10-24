package com.vedruna.sampleproject.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.sampleproject.persistance.models.Product;
import com.vedruna.sampleproject.services.ProductServiceI;

//Es responsable de manejar las solicitudes HTTP de entranda y salida.
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/product")
public class ProductController {
	
	@Autowired
	private ProductServiceI productServiceI;
	
	//Consultar todos los productos.
	@GetMapping("/list")
    public List<Product> getAllProducts() {
        return productServiceI.findAll();
    }
	
	//Consultar un producto por su nombre.
	@GetMapping("/name/{productname}")
    public Product showProductByUsername(@PathVariable String productname) {
        return productServiceI.findByProductName(productname);
    }
	
	//Crear un Producto
	@PostMapping("/create")
    public Product postProduct(@RequestBody Product product) {
		return productServiceI.save(product);
	}
	
	//Editar producto por su id.
	@PutMapping("/edit/{id}")
	public String update(@PathVariable Long id, @RequestBody Product producto) {
	    try {
	        Optional<Product> productoOptional = productServiceI.findById(id);
	        
	        if (productoOptional.isPresent()) {
	        	//productoDB es el objeto que se asignara los valores para actualizar.
	            Product productoDB = productoOptional.get();
	            productoDB.setProductName(producto.getProductName());
	            productoDB.setProductPrice(producto.getProductPrice());
	            //Guardamos los nuevos valores editados.
	            productServiceI.save(productoDB);
	            
	            return "Producto actualizado!";
	        } else {
	            return "Producto no encontrado.";
	        }
	    } catch (Exception e) {
	        return "Error al actualizar el producto: " + e.getMessage();
	    }
	}
	
	// Eliminar producto por su id.
	@DeleteMapping("delete/{id}")	
	public String delete(@PathVariable Long id) {
	    try {
	        Optional<Product> productoOptional = productServiceI.findById(id);
	        
	        if (productoOptional.isPresent()) {
	            productServiceI.deleteById(id);
	            return "Producto eliminado exitosamente.";
	        } else {
	            return "Producto no encontrado.";
	        }
	    } catch (Exception e) {
	        return "Error al eliminar el producto: " + e.getMessage();
	    }
	}
	
	
	 
	

}
