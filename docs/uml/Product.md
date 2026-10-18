# Product, ProductService and ProductController — UML Class Diagram (Tutorial 3)

- `ProductController ..> ProductService` — **dependency** (dashed line, open arrow). The controller uses the service.
- `ProductService --> Product` — **association** (solid line). The service holds a `List<Product>`.
- Every arrow leaves the controller; nothing points back up to it.

Source: [`Product.puml`](Product.puml)

![Tutorial 3 UML class diagram](Product.png)

```mermaid
classDiagram
    class Product {
        -Long id
        -String name
        -double price
        +Product()
        +Product(Long id, String name, double price)
        +getId() Long
        +getName() String
        +getPrice() double
        +setId(Long id) void
        +setName(String name) void
        +setPrice(double price) void
    }
    class ProductService {
        -List~Product~ products
        -Long nextId
        +getAllProducts() List~Product~
        +getProductById(Long id) Optional~Product~
        +addProduct(Product product) Product
        +deleteProduct(Long id) void
        +findByName(String name) List~Product~
        +findCheaperThan(double price) List~Product~
    }
    class ProductController {
        -ProductService productService
        +getAllProducts() List~Product~
        +getProductById(Long id) Product
        +addProduct(Product product) Product
        +deleteProduct(Long id) void
        +search(String name) List~Product~
        +cheaperThan(double price) List~Product~
    }
    ProductController ..> ProductService
    ProductService --> Product
```
