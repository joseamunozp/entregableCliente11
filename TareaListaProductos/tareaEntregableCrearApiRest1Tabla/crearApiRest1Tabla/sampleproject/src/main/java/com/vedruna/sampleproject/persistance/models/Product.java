package com.vedruna.sampleproject.persistance.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

// Una entidad es una clase que se utiliza para mapear una tabla de la base de datos a un objeto en la aplicación.
@NoArgsConstructor
@Data
@Entity
@Table(name="products")
public class Product implements Serializable {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="product_id")
	    private Long  productId;

	    @Column(name="product_name")
	    private String productName;

	    @Column(name="product_price")
	    private Double productPrice;

		public Long getProductId() {
			return productId;
		}

		public void setProductId(Long  productId) {
			this.productId = productId;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public Double getProductPrice() {
			return productPrice;
		}

		public void setProductPrice(Double productPrice) {
			this.productPrice = productPrice;
		}
	    
	   /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

}
