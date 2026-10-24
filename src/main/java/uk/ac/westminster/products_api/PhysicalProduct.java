package uk.ac.westminster.products_api;

// A PhysicalProduct IS-A Product because it has an id, name and price like every product, and can go anywhere a Product is expected.
// A ShoppingCart would fail this test: a cart is not a product, it HAS products, so it should hold a List<Product> field instead of extending Product.
public class PhysicalProduct extends Product {

    private double weightKg;
    private String dimensions;

    public PhysicalProduct() {
    }

    public PhysicalProduct(Long id, String name, double price,
                           double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }
}