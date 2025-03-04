import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Employee {
    public String name;
    public Employee(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }
}

class Department {
    private Map<String, List<Employee>> mapping;

    public Department(Map<String, List<Employee>> mapping) {
        this.mapping = mapping;
    }

    public void addToDep(String name, List<Employee> employees) {
        if (mapping.containsKey(name)) {
            mapping.get(name).addAll(employees);
        } else {
            mapping.put(name, employees);
        }
    }
}





class Main5 {
    public static void main(String[] args) {
        // Create employees for each department
        List<Employee> employeesDept1 = Arrays.asList(
                new Employee("Alice"), new Employee("Bob"), new Employee("Charlie"),
                new Employee("David"), new Employee("Eve"), new Employee("Frank"),
                new Employee("Grace")
        );

        List<Employee> employeesDept2 = Arrays.asList(
                new Employee("Hannah"), new Employee("Ivy"), new Employee("Jack"),
                new Employee("Karen"), new Employee("Leo"), new Employee("Mona"),
                new Employee("Nina")
        );

        List<Employee> employeesDept3 = Arrays.asList(
                new Employee("Oscar"), new Employee("Paul"), new Employee("Quincy"),
                new Employee("Rachel"), new Employee("Steve"), new Employee("Tina"),
                new Employee("Uma")
        );

        List<Employee> employeesDept4 = Arrays.asList(
                new Employee("Victor"), new Employee("Wendy"), new Employee("Xander"),
                new Employee("Yara"), new Employee("Zane"), new Employee("Amy"),
                new Employee("Brian")
        );

        List<Employee> employeesDept5 = Arrays.asList(
                new Employee("Cathy"), new Employee("Derek"), new Employee("Ella"),
                new Employee("Fred"), new Employee("Gina"), new Employee("Harry"),
                new Employee("Irene")
        );

        Map<String, List<Employee>> departmentMap = new HashMap<>();
        departmentMap.put("HR", employeesDept1);
        departmentMap.put("Finance", employeesDept2);
        departmentMap.put("IT", employeesDept3);
        departmentMap.put("Marketing", employeesDept4);
        departmentMap.put("Sales", employeesDept5);

        Department department = new Department(departmentMap);
        ArrayList<String> allEmployee=new ArrayList<String>();



        departmentMap.forEach((deptName, employees) -> {
            employees.forEach(employee ->
                    allEmployee.add(employee.name)
            );
        });

        //-------------1st Question---------------

        System.out.println("Employees::"+allEmployee);


        char letter='A';
        List<String> filteredEmployees = allEmployee.stream()
                .filter(name -> name.startsWith(String.valueOf(letter)))
                .collect(Collectors.toList());


        System.out.println("Filtered employees::"+filteredEmployees);

        Map<String, Map<Character, Long>> frequencyMap = allEmployee.stream()
                .collect(Collectors.toMap(
                        str -> str,
                        str -> {
                            Map<Character, Long> charCountMap = new HashMap<>();
                            for (char c : str.toCharArray()) {
                                charCountMap.put(c, charCountMap.getOrDefault(c, 0L) + 1);
                            }
                            return charCountMap;
                        }
                ));


        frequencyMap.forEach((str, freqMap) -> {
            System.out.println("String: " + str);
            freqMap.forEach((ch, freq) -> System.out.println("  " + ch + ": " + freq));
        });

        //---------------Sorted employees----------------
        List<String> sortedEmployees = allEmployee.stream()
                .sorted()
                .collect(Collectors.toList());




        System.out.println("Employees"+sortedEmployees);


        Collections.shuffle(allEmployee);


        //----------------- Create five Sports team with each team containing randomized employees-------
        int teamSize = allEmployee.size() / 5;
        List<List<String>> teams = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            List<String> team = allEmployee.stream()
                    .skip(i * teamSize)
                    .limit(teamSize)
                    .collect(Collectors.toList());
            teams.add(team);
        }

        for (int i = 0; i < teams.size(); i++) {
            System.out.println("Team " + (i + 1) + ": " + teams.get(i));
        }


    }
}
