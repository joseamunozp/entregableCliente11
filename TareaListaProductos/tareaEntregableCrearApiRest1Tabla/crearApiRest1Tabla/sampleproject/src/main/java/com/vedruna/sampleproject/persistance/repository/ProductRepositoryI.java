package com.vedruna.sampleproject.persistance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vedruna.sampleproject.persistance.models.Product;

// Es una interfaz que actúa como un mecanismo de acceso a los datos, 
// permitiendo realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) 
// sobre las entidades que representan las tablas de la base de datos.
@Repository
public interface ProductRepositoryI extends JpaRepository<Product, Long> {
	
	List<Product> findAll();
	Product save(Product product);
	Product findByProductName(String productName);
	

}
