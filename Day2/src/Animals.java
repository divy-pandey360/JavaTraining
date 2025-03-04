import java.util.*;
public class Animals {
    String name;
    String habitat;
    String diet;

    public Animals(String name, String habitat, String diet) {
        this.name = name;
        this.habitat = habitat;
        this.diet = diet;
    }

    public void describe() {
        System.out.println(name + " lives in " + habitat + " and is a " + diet + ".");
    }
}

class Mammal extends Animals {
    boolean hasFur;
    boolean isDomesticated;

    public Mammal(String name, String habitat, String diet, boolean hasFur, boolean isDomesticated) {
        super(name, habitat, diet);
        this.hasFur = hasFur;
        this.isDomesticated = isDomesticated;
    }

//    @Override
//    public void describe() {
//        super.describe();
//        System.out.println("Has fur: " + hasFur + ", Domesticated: " + isDomesticated);
//    }
}

class Canine extends Mammal {
    String breed;
    boolean isWorkingDog;

    public Canine(String name, String habitat, String diet, boolean hasFur, boolean isDomesticated, String breed, boolean isWorkingDog) {
        super(name, habitat, diet, hasFur, isDomesticated);
        this.breed = breed;
        this.isWorkingDog = isWorkingDog;
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println("Breed: " + breed + ", Working dog: " + isWorkingDog);
    }
}

class Feline extends Mammal {
    boolean isBigCat;
    String climbingAbility;

    public Feline(String name, String habitat, String diet, boolean hasFur, boolean isDomesticated, boolean isBigCat, String climbingAbility) {
        super(name, habitat, diet, hasFur, isDomesticated);
        this.isBigCat = isBigCat;
        this.climbingAbility = climbingAbility;
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println("Big cat: " + isBigCat + ", Climbing ability: " + climbingAbility);
    }
}

class Bird extends Animals {
    boolean canFly;
    float wingSpan;

    public Bird(String name, String habitat, String diet, boolean canFly, float wingSpan) {
        super(name, habitat, diet);
        this.canFly = canFly;
        this.wingSpan = wingSpan;
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println("Can fly: " + canFly + ", Wing span: " + wingSpan + " meters");
    }
}

class Raptor extends Bird {
    boolean isNocturnal;
    String beakType;

    public Raptor(String name, String habitat, String diet, boolean canFly, float wingSpan, boolean isNocturnal, String beakType) {
        super(name, habitat, diet, canFly, wingSpan);
        this.isNocturnal = isNocturnal;
        this.beakType = beakType;
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println("Nocturnal: " + isNocturnal + ", Beak type: " + beakType);
    }
}

class Songbird extends Bird {
    String songType;
    String colorPattern;

    public Songbird(String name, String habitat, String diet, boolean canFly, float wingSpan, String songType, String colorPattern) {
        super(name, habitat, diet, canFly, wingSpan);
        this.songType = songType;
        this.colorPattern = colorPattern;
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println("Song type: " + songType + ", Color pattern: " + colorPattern);
    }
}

class Fish extends Animals {
    String waterType;
    boolean hasScales;

    public Fish(String name, String habitat, String diet, String waterType, boolean hasScales) {
        super(name, habitat, diet);
        this.waterType = waterType;
        this.hasScales = hasScales;
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println("Water type: " + waterType + ", Has scales: " + hasScales);
    }
}

class Shark extends Fish {
    boolean isPredator;
    String finType;

    public Shark(String name, String habitat, String diet, String waterType, boolean hasScales, boolean isPredator, String finType) {
        super(name, habitat, diet, waterType, hasScales);
        this.isPredator = isPredator;
        this.finType = finType;
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println("Predator: " + isPredator + ", Fin type: " + finType);
    }
}

class Goldfish extends Fish {
    float tankSize;
    boolean isFancy;

    public Goldfish(String name, String habitat, String diet, String waterType, boolean hasScales, float tankSize, boolean isFancy) {
        super(name, habitat, diet, waterType, hasScales);
        this.tankSize = tankSize;
        this.isFancy = isFancy;
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println("Tank size: " + tankSize + " liters, Fancy breed: " + isFancy);
    }
}

class Main1 {
    public static void main(String[] args) {
        Canine dog = new Canine("Dog", "Domestic", "Omnivore", true, true, "Labrador", true);
        Feline cat = new Feline("Cat", "Domestic", "Carnivore", true, true, false, "Excellent");
        Raptor eagle = new Raptor("Eagle", "Mountains", "Carnivore", true, 2.0f, false, "Hooked");
        Songbird sparrow = new Songbird("Sparrow", "Forests", "Omnivore", true, 0.25f, "Melodic", "Brown and white");
        Fish salmon = new Fish("Salmon", "Rivers", "Omnivore", "Freshwater", true);
        Shark greatWhite = new Shark("Great White Shark", "Ocean", "Carnivore", "Saltwater", true, true, "Dorsal");
        Goldfish goldfish = new Goldfish("Goldfish", "Aquarium", "Omnivore", "Freshwater", true, 20.0f, true);

//        dog.describe();
//        cat.describe();
//        eagle.describe();
//        sparrow.describe();
//        salmon.describe();
//        greatWhite.describe();
//        goldfish.describe();

        findCommonAncestor(eagle, goldfish);
    }


    public static void findCommonAncestor(Object obj1, Object obj2) {
        Class<?> clazz1 = obj1.getClass();
        Class<?> clazz2 = obj2.getClass();
        while (clazz1 != null) {
            Class<?> temp = clazz2;
            while (temp != null) {
                if (clazz1.equals(temp)) {
                    System.out.println("Common Ancestor: " + clazz1.getName());
                    return;
                }
                temp = temp.getSuperclass();
            }
            clazz1 = clazz1.getSuperclass();
        }
        System.out.println("No common ancestor found.");
    }
}

