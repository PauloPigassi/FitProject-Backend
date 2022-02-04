package com.example.project.model;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbProductCategory")
public class ProductCategory {
	

		@EmbeddedId
		private ProductCategoryId productCategoryId;
		

		public ProductCategoryId getProductCategoryId() {
			return productCategoryId;
		}

		public void setProductCategoryId(ProductCategoryId productCategoryId) {
			this.productCategoryId = productCategoryId;
		}

		@Override
		public int hashCode() {
			return Objects.hash(productCategoryId);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ProductCategory other = (ProductCategory) obj;
			return Objects.equals(productCategoryId, other.productCategoryId);
		}
		
		
}
