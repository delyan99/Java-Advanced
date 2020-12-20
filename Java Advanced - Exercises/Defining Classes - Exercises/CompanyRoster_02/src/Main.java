import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departments = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Employee> employees = new ArrayList<>();
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            Employee employee = null;
            if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (tokens.length == 5) {
                if (!tokens[4].contains("@")) {
                    int age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, department, age);
                } else {
                    String email = tokens[4];
                    employee = new Employee(name, salary, position, department, email);
                }

            } else if (tokens.length == 4) {
                employee = new Employee(name, salary, position, department);
            }

            departments.putIfAbsent(department, new Department(department));
            departments.get(department).getEmployees().add(employee);
        }
        String highestAverageSalaryDepartment = "";
        double highestAverageSalary = 0.0;

        for (Department department : departments.values()) {
            double sum = 0;
            List<Employee> employees = department.getEmployees();
            for (Employee employee : employees) {
                sum += employee.getSalary();
            }
            if (sum >= highestAverageSalary) {
                highestAverageSalary = sum;
                highestAverageSalaryDepartment = department.getName();
            }
        }


        System.out.println(String.format("Highest Average Salary: %s", highestAverageSalaryDepartment));
        List<Employee> employees = departments.get(highestAverageSalaryDepartment).getEmployees();
        employees.stream().sorted((l, r) -> Double.compare(r.getSalary(), l.getSalary())).forEach(p -> System.out.println(p));

    }
}
