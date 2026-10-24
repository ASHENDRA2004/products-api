package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    // Tutorial 4: two different subclasses in ONE List<Product>.
    // No cast is needed, because a DigitalProduct IS-A Product and a PhysicalProduct IS-A Product.
    public ProductService() {
        products.add(new DigitalProduct(
                nextId++, "Clean Code (E-book)", 29.99,
                "/downloads/clean-code.pdf", 4.2));

        products.add(new PhysicalProduct(
                nextId++, "27-inch Monitor", 249.99,
                5.4, "61cm x 41cm x 18cm"));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))   // .equals, never == on Long
                .findFirst();
    }

    public Product addProduct(Product product) {
        product.setId(nextId++);   // use the value, then add one
        products.add(product);
        return product;
    }

    public void deleteProduct(Long id) {
        // removeIf is safe; removing inside a for loop throws ConcurrentModificationException
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findByName(String name) {
        // go through the list, keep the ones whose name contains the text, collect what survived
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }

    // stretch task: a rule about products, not about HTTP, so it lives in the service
    public List<Product> findCheaperThan(double price) {
        return products.stream()
                .filter(p -> p.getPrice() < price)
                .toList();
    }
}
