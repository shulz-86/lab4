package shulz.lab4.repositories;

import org.springframework.stereotype.Component;
import shulz.lab4.entities.Product;
import shulz.lab4.exceptions.ProductNotFoundException;

import java.util.*;

@Component
public class ProductRepository {

    private static final String PRODUCT_NOT_FOUND_ERROR_MESSAGE = "Продукт с id='%s' не найден";
    private static List<Product> productList = new Vector<>();
    static {
        productList.addAll(Arrays.asList(new Product(1, "картофель", 15.20),
                new Product(2, "свекла", 12.10),
                new Product(3, "морковь", 10.00),
                new Product(4, "капуста", 8.50),
                new Product(5, "груши", 30.10),
                new Product(6, "бананы", 25.50),
                new Product(7, "апельсины", 23.30),
                new Product(8, "яблоки", 28.50),
                new Product(9, "черешня", 55.90),
                new Product(10, "клубника", 60.00)));
    }


    public Product findOneById(int id) {
        Optional<Product> optionalProduct = productList
                .stream()
                .filter(product -> product.getId() == id)
                .findFirst();
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException(String.format(PRODUCT_NOT_FOUND_ERROR_MESSAGE, id));
        }
        return optionalProduct.get();
    }

    public List<Product> getProductList() {
        return productList;
    }


    public void addProduct(Product product) {
        productList.add(product);
        productList.sort(Comparator.comparing(Product::getId));
    }
}