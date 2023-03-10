package pro.sky.HashMapHW2.service;

import org.springframework.stereotype.Service;
import pro.sky.HashMapHW2.exception.EmployeeAlreadyAddedException;
import pro.sky.HashMapHW2.exception.EmployeeNotFoundException;
import pro.sky.HashMapHW2.person.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;
    public EmployeeServiceImpl() {

        this.employees = new HashMap<>();
    }



    @Override

    public Employee add(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("уже есть такой сотрудник");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee find(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }

        throw new EmployeeNotFoundException("Сотрудник не найден");

    }

    @Override
    public Employee remove(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employees.containsKey(employee.getFullName())) {
             employees.remove(employee.getFullName());
            return employee;

        }
        throw new  EmployeeNotFoundException("сотрудник не найден.");

    }

    @Override
    public Collection<Employee> findAllPerson() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
