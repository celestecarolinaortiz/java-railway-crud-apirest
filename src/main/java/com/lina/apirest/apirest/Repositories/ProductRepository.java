package com.lina.apirest.apirest.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lina.apirest.apirest.Entities.Product;

//JpaRepository es una interfaz de Spring Data JPA que proporciona métodos CRUD
// y de paginación para la entidad Products. 
// Long es el tipo de dato del ID de la entidad.
public interface ProductRepository extends JpaRepository<Product, Long> {

}
