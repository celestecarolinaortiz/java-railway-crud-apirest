package com.lina.apirest.apirest.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lina.apirest.apirest.Repositories.ProductRepository;
import com.lina.apirest.apirest.Entities.Product;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


//ProductController manejará las solicitudes HTTP relacionadas con los productos.
// Por ejemplo, podrá gestionar solicitudes para crear, leer, actualizar y eliminar productos.
@RestController
//Con /products se podrá acceder a la base de datos de productos
@RequestMapping("/products")
public class ProductController {
    //Autowired sirve para inyectar la dependencia del repositorio de productos
    @Autowired
    private ProductRepository productRepository;

    //GetMapping para manejar las solicitudes GET a /products (Todos los productos)
    @GetMapping("")
    public List<Product> getAllProducts() {
        //Con findAll() se obtienen todos los productos de la base de datos
        return productRepository.findAll();
    }

    //GetMapping un solo producto por su id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        //findById() busca un producto por su id
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product " + id +" not found"));
    }

    //PostMapping para manejar las solicitudes POST a /products
    //RequestBody indica que el producto se recibirá en el cuerpo de la solicitud HTTP
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
                    
        //save() guarda el producto en la base de datos y también devuelve el producto guardado
        return productRepository.save(product);
    }
    //PutMapping para manejar las solicitudes PUT a /products/{id} (Actualizar un producto existente)
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails){
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product " + id +" not found"));
       
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());

        //save() guarda el producto actualizado en la base de datos y también devuelve el producto guardado
        return productRepository.save(product);
    }
    
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
       Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product " + id +" not found"));
       productRepository.delete(product);

       return "Product " + id + " deleted successfully";
    }
    
    
}
