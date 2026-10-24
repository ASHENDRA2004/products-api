package uk.ac.westminster.products_api;

import java.util.ArrayList;
import java.util.List;

// Stretch task: is BundleProduct really an IS-A Product?
// YES (my answer): a bundle is sold like any product - it has its own id, name and price, and it can sit in
// the same List<Product> and come back from GET /products. A customer buys "Starter Kit" as one product.
// BUT there is a HAS-A hiding inside it too: a bundle CONTAINS other products, so "items" is composition
// (a List<Product> field), not inheritance. So BundleProduct IS-A Product and also HAS-A list of Products.
// If a bundle were only a container that is never sold by itself (like a ShoppingCart), extends would be wrong.
public class BundleProduct extends Product {

    private List<Product> items = new ArrayList<>();

    // no-arg constructor: Jackson needs this to build an object from JSON
    public BundleProduct() {
    }

    public BundleProduct(Long id, String name, double price, List<Product> items) {
        super(id, name, price);   // MUST be the first statement
        this.items = items;
    }

    public List<Product> getItems() {
        return items;
    }

    public int getItemCount() {
        return items.size();
    }
}
