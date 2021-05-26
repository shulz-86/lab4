package shulz.lab4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shulz.lab4.entities.Product;
import shulz.lab4.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(int id) {
        return productRepository.findOneById(id);
    }

    public List<Product> getProductList() {
        return productRepository.getProductList();
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }
}
