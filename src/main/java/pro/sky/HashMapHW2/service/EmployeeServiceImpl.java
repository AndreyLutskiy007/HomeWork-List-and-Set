package pro.sky.HashMapHW2.service;

import org.springframework.stereotype.Service;
import pro.sky.HashMapHW2.exception.EmployeeAlreadyAddedException;
import pro.sky.HashMapHW2.exception.EmployeeNotFoundException;
import pro.sky.HashMapHW2.person.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public EmployeeServiceImpl(List<Employee> employeeList) {
        this.employeeList = new ArrayList<>();
    }

    private final List<Employee> employeeList;

    @Override

    public Employee add(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException("уже есть такой сотрудник");
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee find(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employeeList.contains(employee)) {
            return employee;
        }

        throw new EmployeeNotFoundException("Сотрудник не найден");

    }

    @Override
    public Employee remove(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }
        throw new  EmployeeNotFoundException("сотрудник не найден.");

    }

    @Override
    public Collection<Employee> findAllPerson() {
        return employeeList;
    }
}
