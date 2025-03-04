import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Laptop {
    private String model;
    private String processor;
    private int ram; // in GB
    private int graphicsCard; // in GB
    private int hardDisk; // in GB
    private LocalDate dateOfManufacture;

    public Laptop(String model, String processor, int ram, int graphicsCard, int hardDisk, LocalDate dateOfManufacture) {
        this.model = model;
        this.processor = processor;
        this.ram = ram;
        this.graphicsCard = graphicsCard;
        this.hardDisk = hardDisk;
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getModel() {
        return model;
    }

    public String getProcessor() {
        return processor;
    }

    public int getRam() {
        return ram;
    }

    public int getGraphicsCard() {
        return graphicsCard;
    }

    public int getHardDisk() {
        return hardDisk;
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "model='" + model + '\'' +
                ", processor='" + processor + '\'' +
                ", ram=" + ram +
                ", graphicsCard=" + graphicsCard +
                ", hardDisk=" + hardDisk +
                ", dateOfManufacture=" + dateOfManufacture +
                '}';
    }
}



class LaptopFilter {
    public static void main(String[] args) {
        List<Laptop> laptops = Arrays.asList(
                new Laptop("ModelA", "Intel i5", 16, 4, 512, LocalDate.of(2022, 1, 15)),
                new Laptop("ModelB", "Intel i7", 8, 2, 256, LocalDate.of(2021, 5, 10)),
                new Laptop("ModelC", "AMD Ryzen 5", 16, 6, 1024, LocalDate.of(2023, 3, 20)),
                new Laptop("ModelD", "Intel i5", 32, 8, 2048, LocalDate.of(2020, 7, 25)),
                new Laptop("ModelE", "AMD Ryzen 7", 16, 4, 512, LocalDate.of(2022, 11, 5))
        );

        int requiredRam = 16;
        int requiredGraphicsCard = 4;


        List<Laptop> filteredLaptops = laptops.stream()
                .filter(laptop -> laptop.getRam() >= requiredRam && laptop.getGraphicsCard() >= requiredGraphicsCard)
                .collect(Collectors.toList());


        Map<String, List<Laptop>> groupedLaptops = filteredLaptops.stream()
                .collect(Collectors.groupingBy(Laptop::getProcessor));

        groupedLaptops.forEach((processor, laptopList) -> {
            laptopList.sort(Comparator.comparing(Laptop::getRam)
                    .thenComparing(Laptop::getHardDisk)
                    .thenComparing(Laptop::getDateOfManufacture));
        });

        groupedLaptops.forEach((processor, laptopList) -> {
            System.out.println("Processor: " + processor);
            laptopList.forEach(System.out::println);
        });
    }
}


