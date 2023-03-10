package pro.sky.HashMapHW2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HashMapHW2.person.Employee;
import pro.sky.HashMapHW2.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService employeeService) {
        this.service = employeeService;
    }

    @GetMapping("/add")
    public Employee add (@RequestParam String lastName, @RequestParam String firstName){
        return service.add(lastName, firstName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String lastName, @RequestParam String firstName) {
        return service.find(lastName, firstName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String lastName,@RequestParam String firstName) {
        return service.remove(lastName, firstName);
    }

    @GetMapping("/findAllPerson")
    public Collection<Employee> findAllPerson() {
        return service.findAllPerson();

    }
}
