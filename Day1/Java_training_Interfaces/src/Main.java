import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Date d=new Date();
        d.addDate(LocalDate.now());

        System.out.println("The date 10 days after today is:"+d.addDate(LocalDate.now()));
    }
}