import java.util.ArrayList;
public class Customer {
    String customerId;
    String customerName;
    String customerEmail;
    String customerPhoneNo;
    String customerAddress;

    public Customer(String customerId, String customerName, String customerEmail, String customerPhoneNo, String customerAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNo = customerPhoneNo;
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPhoneNo='" + customerPhoneNo + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }
}

//class Main2{
//    public static void main(String[] args){
//        Customer c21=new Customer("C0012","Divy","divypandey104@hmail.com","9555772405","Varanasi");
//        Customer c1 = new Customer("C001", "John Doe", "john.doe@example.com", "1234567890", "New York");
//        Customer c2 = new Customer("C002", "Jane Smith", "jane.smith@example.com", "0987654321", "Los Angeles");
//        Customer c3 = new Customer("C003", "Alice Johnson", "alice.johnson@example.com", "1122334455", "Chicago");
//        Customer c4 = new Customer("C004", "Bob Brown", "bob.brown@example.com", "2233445566", "Houston");
//        Customer c5 = new Customer("C005", "Charlie Davis", "charlie.davis@example.com", "3344556677", "Phoenix");
//
//        ArrayList<Object> customerList = new ArrayList<>();
//        customerList.add(c21);
//        customerList.add(c1);
//        customerList.add(c2);
//        customerList.add(c3);
//        customerList.add(c4);
//        customerList.add(c5);
//
//
//    }
//}

