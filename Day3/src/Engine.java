import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

class Engine {
    private Map<String, Customer> customers;
    private Map<String, Order> orders;
    ProductInventory inventory;

    public Engine() {
        this.customers = new HashMap<>();
        this.orders = new HashMap<>();
        this.inventory = new ProductInventory();
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.customerId, customer);
    }

    public void addOrder(Order order) {
        double totalPrice = 0;
        for (String productId : order.products) {
            Product product = inventory.getProduct(productId);
            if (product != null) {
                totalPrice += product.getPrice();
            }
        }
        order.totalPrice = totalPrice;
        orders.put(order.orderId, order);
    }

    public Map<String, Double> calculateTotalRevenues() {
        Map<String, Double> revenues = new HashMap<>();
        for (Order order : orders.values()) {
            double totalPrice = 0;
            for (String productId : order.products) {
                Product product = inventory.getProduct(productId);
                if (product != null) {
                    totalPrice += product.getPrice();
                }
            }
            revenues.put(order.customerId, revenues.getOrDefault(order.customerId, 0.0) + totalPrice);
        }
        return revenues;
    }

    public int countCancelledOrders() {
        int count = 0;
        for (Order order : orders.values()) {
            if ("Cancelled".equals(order.status)) {
                count++;
            }
        }
        return count;
    }

    public Map<String, List<Order>> getOrdersByDate() {
        Map<String, List<Order>> ordersByDate = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (Order order : orders.values()) {
            String date = sdf.format(order.orderDate);
            ordersByDate.computeIfAbsent(date, k -> new ArrayList<>()).add(order);
        }
        return ordersByDate;
    }

    public List<String> getTop5Products() {
        Map<String, Long> productCount = orders.values().stream()
                .flatMap(order -> order.products.stream())
                .collect(Collectors.groupingBy(productId -> productId, Collectors.counting()));

        return productCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> getUsersByProduct(String productId) {
        return orders.values().stream()
                .filter(order -> order.products.contains(productId))
                .map(order -> order.customerId)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Order> findThreeOrdersSamePrice() {
        Map<Double, List<Order>> priceMap = new HashMap<>();

        for (Order order : orders.values()) {
            priceMap.computeIfAbsent(order.totalPrice, k -> new ArrayList<>()).add(order);
        }

        for (List<Order> orderList : priceMap.values()) {
            if (orderList.size() >= 3) {
                return orderList.subList(0, 3);
            }
        }

        return new ArrayList<>();
    }

    public List<Order> findOrdersWithPricePattern() {
        List<Order> orderList = new ArrayList<>(orders.values());
        for (int i = 0; i < orderList.size() - 4; i++) {
            double p1 = orderList.get(i).totalPrice;
            double p2 = orderList.get(i + 1).totalPrice;
            double p3 = orderList.get(i + 2).totalPrice;
            double p4 = orderList.get(i + 3).totalPrice;
            double p5 = orderList.get(i + 4).totalPrice;
            if (p1 < p2 && p2 > p3 && p3 < p4 && p4 > p5) {
                return orderList.subList(i, i + 5);
            }
        }
        return new ArrayList<>();
    }
}

class Main21 {
    public static void main(String[] args) {
        Engine engine = new Engine();

        // Add customers
        Customer customer1 = new Customer("C001", "John Doe", "john.doe@example.com", "1234567890", "New York");
        Customer customer2 = new Customer("C002", "Jane Smith", "jane.smith@example.com", "0987654321", "Los Angeles");
        Customer customer3 = new Customer("C003", "Alice Johnson", "alice.johnson@example.com", "1122334455", "Chicago");
        Customer customer4 = new Customer("C004", "Bob Brown", "bob.brown@example.com", "2233445566", "Houston");
        Customer customer5 = new Customer("C005", "Charlie Davis", "charlie.davis@example.com", "3344556677", "Phoenix");

        engine.addCustomer(customer1);
        engine.addCustomer(customer2);
        engine.addCustomer(customer3);
        engine.addCustomer(customer4);
        engine.addCustomer(customer5);

        ProductInventory inventory = engine.inventory;
        Product product1 = new Product("P001", "Laptop", "Electronics", 75000.0, 10, 5.0, "SupplierA");
        Product product2 = new Product("P002", "Smartphone", "Electronics", 30000.0, 20, 10.0, "SupplierB");
        Product product3 = new Product("P003", "Tablet", "Electronics", 20000.0, 15, 7.5, "SupplierC");
        Product product4 = new Product("P004", "Headphones", "Accessories", 5000.0, 50, 15.0, "SupplierD");
        Product product5 = new Product("P005", "Smartwatch", "Wearables", 10000.0, 30, 12.0, "SupplierE");

        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);
        inventory.addProduct(product4);
        inventory.addProduct(product5);

        Order order1 = new Order("O001", "C001", Arrays.asList("P001", "P002"), "Processing", new Date());
        Order order2 = new Order("O002", "C002", Arrays.asList("P003", "P004"), "Shipped", new Date());
        Order order3 = new Order("O003", "C003", Arrays.asList("P005", "P001"), "Delivered", new Date());
        Order order4 = new Order("O004", "C004", Arrays.asList("P002", "P003"), "Cancelled", new Date());
        Order order5 = new Order("O005", "C005", Arrays.asList("P004", "P005"), "Processing", new Date());

        engine.addOrder(order1);
        engine.addOrder(order2);
        engine.addOrder(order3);
        engine.addOrder(order4);
        engine.addOrder(order5);

        Map<String, Double> revenues = engine.calculateTotalRevenues();
        System.out.println("Total Revenues Generated from Each Customer:");
        for (Map.Entry<String, Double> entry : revenues.entrySet()) {
            System.out.println("Customer ID: " + entry.getKey() + ", Total Revenue: " + entry.getValue());
        }

        int cancelledOrders = engine.countCancelledOrders();
        System.out.println("Number of Cancelled Orders: " + cancelledOrders);

        Map<String, List<Order>> ordersByDate = engine.getOrdersByDate();
        System.out.println("Orders by Date:");

        for (Map.Entry<String, List<Order>> entry : ordersByDate.entrySet()) {
            System.out.println("Date: " + entry.getKey());
            for (Order order : entry.getValue()) {
                System.out.println(order);
            }
        }

        List<String> top5Products = engine.getTop5Products();
        System.out.println("Top 5 Products Bought by Customers:");
        for (String productId : top5Products) {
            System.out.println("Product ID: " + productId);
        }

        List<String> usersByProduct = engine.getUsersByProduct("P001");
        System.out.println("Users Who Bought Product P001:");
        for (String customerId : usersByProduct) {
            System.out.println("Customer ID: " + customerId);
        }

        List<Order> threeConsecutiveOrders = engine.findThreeOrdersSamePrice();
        System.out.println("Three Consecutive Orders with the Same Price:");
        for (Order order : threeConsecutiveOrders) {
            System.out.println(order);
        }

        List<Order> ordersWithPricePattern = engine.findOrdersWithPricePattern();
        System.out.println("Orders with Price Pattern:");
        for (Order order : ordersWithPricePattern) {
            System.out.println(order);
        }
    }
}
