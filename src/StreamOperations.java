import java.util.*;
import java.util.stream.Collectors;

public class StreamOperations {

    public static void main(String[] args) {

        List<Employee> empList = getEmployeeList();

        //Stream operation to filter employee based on certain attributes of Employee Class
        empList.stream().filter(e -> e.getTitle().equals("Developer")).collect(Collectors.toList());

        //Stream operation to group employee record based on certain attribute of Employee Class
        Map<String, List<Employee>> result = empList.stream().collect(Collectors.groupingBy(Employee::getTitle));
        System.out.println("Stream :: GroupBy Map:: " + result.toString());

        //Stream operation to find average salary
        Double avgSalary = empList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("Stream :: Avg Salary :: " + avgSalary);

        //Stream operataion to find min salary
        Optional<Employee> minSalary = empList.stream().collect(Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println("Stream :: Min Salary :: " + minSalary.toString());

        //Stream operation to find Maximum Salary
        Optional<Employee> maxSalary = empList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println("Stream :: Max Salary :: " + maxSalary.toString());

        //Stream operation for AVP employees salary greater than 100
        System.out.println("Stream :: AVP employees with salary > 100 :: ");
        empList.stream().filter(e -> e.getRole().equals("AVP")).filter(e -> e.getSalary() > 100).forEach(System.out::println);

        //Stream operation for AVP employee with salary <= 100 and provide 10% hike
        System.out.println("Stream :: AVP employees with salary <= 100 provided hike :: ");
        empList.stream().filter(e -> e.getRole().equals("AVP")).filter(e -> e.getSalary() <= 100)
                .map(e -> e.getSalary() + 100).forEach(System.out::println);

        //Stream operation to get sum of all employees salary
        Double sumSalary = empList.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println("Stream :: Sum of all Salaries :: " + sumSalary);

        //Stream operation to get employees bet Salary 100 to 500
        List<Employee> empSalRangeList = empList.stream().collect(Collectors.filtering(e -> e.getSalary() > 100 && e.getSalary() < 500, Collectors.toList()));
        System.out.println("Stream :: Salary Range Employee :: " + empSalRangeList.toString());

        //Stream operation to get VP with min salary
        Optional<Employee> minSalEmp = empList.stream().filter(e -> e.getRole().equals("VP")).collect(Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println("Stream :: Min Salary VP :: " + minSalEmp);

        //Stream operation to get employee with empID=1/2
        System.out.println("Stream :: Find Employee with specific ID ::");
        empList.stream().filter(e -> e.getEmpID().equals("1") || e.getEmpID().equals("2")).forEach(System.out::println);

        //Stream operation to get employee name starting with "R"
        Map<Boolean, List<Employee>> filterEmpList = empList.stream().collect(Collectors.partitioningBy(e -> e.getEmpName().startsWith("R"), Collectors.toList()));
        System.out.println("Stream :: Employee Name Starting with 'R' ::" + filterEmpList.get(true));
        System.out.println("OTHER WAY TO FITER EMPLOYEE STARTING WITH 'R' :: ");
        empList.stream().filter(e -> e.getEmpName().startsWith("R")).forEach(System.out::println);

        //Stream operation to sort Employee list based on salary
        System.out.println("Stream :: Sorted Employee List in Ascending Order:: ");
        empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).forEach(System.out::println);
        System.out.println("Stream :: Sorted Employee List in Descending Order:: ");
        empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).forEach(System.out::println);
    }

    private static List<Employee> getEmployeeList() {
        List<Employee> empList = new ArrayList<>();
        Employee e1 = new Employee("1", "Rohit", "AVP", 100, "Developer");
        Employee e2 = new Employee("2", "Ramesh", "VP", 200, "Developer");
        Employee e3 = new Employee("3", "Suresh", "AVP", 300, "Tester");
        Employee e4 = new Employee("4", "Ravi", "VP", 500, "Tester");
        Employee e5 = new Employee("5", "Kunal", "AVP", 60, "Tester");
        Employee e6 = new Employee("6", "Karry", "VP", 700, "Tester");
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
        empList.add(e4);
        empList.add(e5);
        empList.add(e6);
        return empList;
    }
}
