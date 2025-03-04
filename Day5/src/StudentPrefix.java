import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class StudentPrefix {
    public String prefix;
    public String name;
    public String gender;
    public StudentPrefix(String prefix, String name, String gender) {
        this.prefix = prefix;
        this.name = name;
        this.gender = gender;
    }

    public String getPrefix() {
        return this.prefix;
    }
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getName() {
        return this.name;
    }

    public String getGender() {
        return this.gender;
    }

    @Override
    public String toString() {
        return prefix + " " + name + " (" + gender + ")";
    }
}

class Main8 {
    public static void main(String[] args) {
        StudentPrefix st1 = new StudentPrefix("Mr", "Divy", "M");
        StudentPrefix st2 = new StudentPrefix("Mrs", "John", "F");
        StudentPrefix st3 = new StudentPrefix("Mr", "Alice", "F");
        StudentPrefix st4 = new StudentPrefix("Mr", "ASD", "M");
        StudentPrefix st5 = new StudentPrefix("Mr", "Divy2", "M");
        StudentPrefix st6 = new StudentPrefix("Mr", "Divy4", "M");
        StudentPrefix st7 = new StudentPrefix("Mrs", "Divy5", "M");
        StudentPrefix st8 = new StudentPrefix("Mr", "Divy7", "F");
        StudentPrefix st9 = new StudentPrefix("Mrs", "Divy6", "F");
        StudentPrefix st10 = new StudentPrefix("Mr", "Divy8", "M");
        StudentPrefix st11 = new StudentPrefix("Mr", "Divy9", "M");
        StudentPrefix st12 = new StudentPrefix("Mr", "Divy10", "M");
        StudentPrefix st13 = new StudentPrefix("Mrs", "Divy11", "M");

        ArrayList<StudentPrefix> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        students.add(st6);
        students.add(st7);
        students.add(st8);
        students.add(st9);
        students.add(st10);
        students.add(st11);
        students.add(st12);
        students.add(st13);

        List<StudentPrefix> correctedStudents = students.stream()
                .map(student -> {
                    if (student.getPrefix().equals("Mrs") && student.getGender().equals("M")) {
                        student.setPrefix("Mr");
                    } else if (student.getPrefix().equals("Mr") && student.getGender().equals("F")) {
                        student.setPrefix("Mrs");
                    }
                    return student;
                })
                .collect(Collectors.toList());

        correctedStudents.forEach(st -> {
            System.out.println(st.getPrefix() + " " + st.getName() + " " + st.getGender());
        });
    }
}
