import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array::");
        int n=sc.nextInt();
        ArrayList<Integer> productId=new ArrayList<>(n);

        for(int i=0;i<n;i++){
            System.out.println("Enter the product id of "+(i+1)+" product");
            int temp=sc.nextInt();

            //Autoboxing--> Conversion from Int(Primitive Type) to object.
            productId.add(temp);
        }

        System.out.println(productId);

        //Unboxing--> Conversion from object to Int(Primitive Type).
        System.out.println("The element at index 4 is "+productId.get(4));

    }
}