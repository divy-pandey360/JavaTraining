import java.util.HashMap;
import java.util.Map;

public class Product {
    private String productId;
    private String productName;
    private String category;
    private double price;
    private int stockQuantity;
    private double discount;
    private String supplier;


    public Product(String productId, String productName, String category, double price, int stockQuantity, double discount, String supplier) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.discount = discount;
        this.supplier = supplier;
    }

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", discount=" + discount +
                ", supplier='" + supplier + '\'' +
                '}';
    }
}



class ProductInventory {
    private Map<String, Product> inventory;

    public ProductInventory() {
        this.inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void removeProduct(String productId) {
        inventory.remove(productId);
    }

    public void updateProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateStockQuantity(String productId, int newQuantity) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setStockQuantity(newQuantity);
        }
    }

    public void updatePrice(String productId, double newPrice) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setPrice(newPrice);
        }
    }

    public void updateDiscount(String productId, double newDiscount) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setDiscount(newDiscount);
        }
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public void displayInventory() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public String idToName(String productId) {
        Product product = inventory.get(productId);
        if (product != null) {
            return product.getProductName();
        } else {
            return "Product not found";
        }
    }

}



class Main1 {
    public static void main(String[] args) {
        ProductInventory inventory = new ProductInventory();

        Product product1 = new Product("P001", "Laptop", "Electronics", 75000.0, 10, 5.0, "SupplierA");
        inventory.addProduct(product1);

        Product product2 = new Product("P002", "Smartphone", "Electronics", 30000.0, 20, 10.0, "SupplierB");
        inventory.addProduct(product2);

        Product product3 = new Product("P003", "Tablet", "Electronics", 20000.0, 15, 7.5, "SupplierC");
        inventory.addProduct(product3);

        Product product4 = new Product("P004", "Headphones", "Accessories", 5000.0, 50, 15.0, "SupplierD");
        inventory.addProduct(product4);

        Product product5 = new Product("P005", "Smartwatch", "Wearables", 10000.0, 30, 12.0, "SupplierE");
        inventory.addProduct(product5);

        Product product6 = new Product("P006", "Camera", "Electronics", 45000.0, 8, 5.0, "SupplierF");
        inventory.addProduct(product6);

        Product product7 = new Product("P007", "Printer", "Office Supplies", 15000.0, 12, 8.0, "SupplierG");
        inventory.addProduct(product7);

        Product product8 = new Product("P008", "Monitor", "Electronics", 25000.0, 25, 10.0, "SupplierH");
        inventory.addProduct(product8);


        System.out.println("=================Products before deletion=========================");
        inventory.displayInventory();
        inventory.removeProduct("P001");

        System.out.println("=================Products after deletion 1=========================");
        inventory.displayInventory();





        inventory.updateStockQuantity("P001", 15);
        inventory.updateStockQuantity("P006",18);

        inventory.updatePrice("P001", 78000.0);

        inventory.updateDiscount("P001", 7.5);

        Product product = inventory.getProduct("P001");
        System.out.println(product);

        System.out.println("=================Products after final Updation 1=========================");
        inventory.displayInventory();


    }
}

