package CarTaxResources;
import java.util.Scanner;
import java.util.Arrays;

public class Car {
    enum Manufacturer {
        MAHINDRA, TATA, MARUTI
    }

    enum MahindraModel {
        SCORPIO, THAR, SCORPIO_N, XUV_700
    }

    enum TataModel {
        NEXON, HARRIER, SAFARI, ALTROZ
    }

    enum MarutiModel {
        SWIFT, BALENO, CIAZ, ERTIGA
    }

    enum Transmission {
        MANUAL, AUTOMATIC
    }

    enum FuelType {
        DIESEL, PETROL, CNG
    }

    enum Color {
        SILVER, BLUE, YELLOW
    }

    enum Location {
        DELHI, BANGALORE, HYDERABAD, CHENNAI
    }

    private Manufacturer manufacturer;
    private String model;
    private Transmission transmission;
    private FuelType fuelType;
    private Color color;
    private Location location;

    void setter(Manufacturer manufacturer, String model, Transmission transmission, FuelType fuelType, Color color, Location location) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.color = color;
        this.location = location;
    }

    // Getter method to print all attributes
    public void getter() {
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Model: " + model);
        System.out.println("Transmission: " + transmission);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Color: " + color);
        System.out.println("Location: " + location);
    }

    public void allocator() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Manufacturer (" + Arrays.toString(Manufacturer.values()) + "): ");
        Manufacturer manufacturer = Manufacturer.valueOf(scanner.nextLine().toUpperCase());

        String model = "";
        switch (manufacturer) {
            case MAHINDRA:
                System.out.println("Choose Model (" + Arrays.toString(MahindraModel.values()) + "): ");
                model = scanner.nextLine().toUpperCase();
                break;
            case TATA:
                System.out.println("Choose Model (" + Arrays.toString(TataModel.values()) + "): ");
                model = scanner.nextLine().toUpperCase();
                break;
            case MARUTI:
                System.out.println("Choose Model (" + Arrays.toString(MarutiModel.values()) + "): ");
                model = scanner.nextLine().toUpperCase();
                break;
        }

        System.out.println("Enter Transmission (" + Arrays.toString(Transmission.values()) + "): ");
        Transmission transmission = Transmission.valueOf(scanner.nextLine().toUpperCase());

        System.out.println("Enter Fuel Type (" + Arrays.toString(FuelType.values()) + "): ");
        FuelType fuelType = FuelType.valueOf(scanner.nextLine().toUpperCase());

        System.out.println("Enter Colour (" + Arrays.toString(Color.values()) + "): ");
        Color color = Color.valueOf(scanner.nextLine().toUpperCase());

        System.out.println("Enter Location (" + Arrays.toString(Location.values()) + "): ");
        Location location = Location.valueOf(scanner.nextLine().toUpperCase());

        this.setter(manufacturer, model, transmission, fuelType, color, location);
    }
}


