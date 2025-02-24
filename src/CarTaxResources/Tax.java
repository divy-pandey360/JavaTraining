package CarTaxResources;

import java.util.Scanner;

public class Tax {

    private int age;
    private double salary;
    private int investment;
    private int health_insurance;
    private int home_loan;
    private double taxAmnt;
    Scanner scanner = new Scanner(System.in);

    public void setter() {
        System.out.println("Enter your age:");
        this.age = scanner.nextInt();

        System.out.println("Enter your salary:");
        this.salary = scanner.nextInt();

        System.out.println("Enter your investment in tax-saving instruments:");
        this.investment = scanner.nextInt();

        System.out.println("Enter your health insurance premium:");
        this.health_insurance = scanner.nextInt();

        System.out.println("Enter your home loan interest paid:");
        this.home_loan = scanner.nextInt();
    }

    public void calculator() {
        double deduction80C = Math.min(investment, 150000);
        double deduction80D = (age >= 60) ? Math.min(health_insurance, 50000) : Math.min(health_insurance, 25000);
        double deduction24 = Math.min(home_loan, 200000);

        double taxableIncome = salary - deduction80C - deduction80D - deduction24;
        System.out.println(taxableIncome);
        int YOUNG=60;

        if (this.age < 60) {
            if (taxableIncome <= 250000) {
                this.taxAmnt = 0;
            } else if (taxableIncome <= 500000) {
                this.taxAmnt = 0.05 * (taxableIncome-250000);
            } else if (taxableIncome <= 1000000) {
                this.taxAmnt =(0.05 * 250000) + (0.2 * (taxableIncome-500000));
            } else {

                this.taxAmnt = (0.05 * 250000) + (0.2 * 500000) + (0.3 * (taxableIncome-1000000));
                System.out.println("The total tax amount is: " + this.taxAmnt);
            }
        } else if (this.age >= 60 && this.age <= 80) {
            if (taxableIncome <= 300000) {
                this.taxAmnt = 0;
            } else if (taxableIncome <= 500000) {
                this.taxAmnt = 0.05 * (taxableIncome-200000);
            } else if (taxableIncome <= 1000000) {
                this.taxAmnt =(0.05 * 200000) + (0.2 * (taxableIncome-500000));
            } else {
                this.taxAmnt = (0.05 * 200000) + (0.2 * 5000000) + (0.3 * (taxableIncome-1000000));
            }
        } else { // For age above 80
            if (taxableIncome <= 500000) {
                this.taxAmnt = 0;
            } else if (taxableIncome <= 1000000) {
                this.taxAmnt = 0.2 * (taxableIncome-500000);
            } else {
                this.taxAmnt = (0.2 * 5000000) + (0.3 * (taxableIncome-1000000));
            }
        }

        System.out.println("The total tax amount is: " + this.taxAmnt);
    }

}
