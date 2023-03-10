package pro.sky.HashMapHW2.service;

import pro.sky.HashMapHW2.person.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String lastName, String firstName);

    Employee find(String lastName, String firstName);

    Employee remove(String lastName, String firstName);

    Collection<Employee> findAllPerson();

}
