import java.util.Date;
import java.util.List;
import java.util.Arrays;

public class Order {
    String orderId;
    String customerId;
    List<String> products;
    String status;
    Date orderDate;
    Double totalPrice;

    public Order(String orderId, String customerId, List<String> products, String status, Date orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.products = products;
        this.status = status;
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", products=" + products +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }
}

//class Main3{
//
//    public static void main(String[] args){
//        Order order = new Order("O001", "C001", Arrays.asList("P001", "P002"), "Processing", new Date());
//
//        System.out.println("Order ID: " + order.orderId);
//        System.out.println("Customer ID: " + order.customerId);
//        System.out.println("Products: " + order.products);
//        System.out.println("Status: " + order.status);
//        System.out.println("Order Date: " + order.orderDate);
//    }
//
//}

