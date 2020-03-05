package com.telran;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Employee emp1 = new Employee("Vasya", 20000);
        Employee emp2 = new Employee("Petya", 10000);
        Employee emp3 = new Employee("Olya", 15000);
        Employee emp4 = new Employee("Masha", 25000);
        Employee emp5 = new Employee("Stepa", 20000);
        Employee emp6 = new Employee("Lisa", 15000);

        Department dep1 = new Department("Dep1","111df45", Arrays.asList(emp1,emp2));
        Department dep2 = new Department("Dep2","001df45", Arrays.asList(emp3,emp4));
        Department dep3 = new Department("Dep3","111df55", Arrays.asList(emp5,emp6));

        Stream<Department> deptStream = Stream.of(dep1,dep2,dep3);

        int res = (int) deptStream.filter(dep -> dep.getCode().startsWith("111"))
                .flatMap(department -> department.getEmployees().stream())
                .filter(employee -> employee.getSalary()>10000)
                .count();
        System.out.println(res);
    }
}
