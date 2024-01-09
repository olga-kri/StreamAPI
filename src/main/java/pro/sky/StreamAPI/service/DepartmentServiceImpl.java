package pro.sky.StreamAPI.service;

import org.springframework.stereotype.Service;
import pro.sky.StreamAPI.exception.EmployeeNotFoundException;
import pro.sky.StreamAPI.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Override
    public Collection<Employee> printEmployeeFromDepartment(int departmentID) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getDepartmentID() == departmentID)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> printEmployeeFromEachDepartments() {
        return employeeService
                .findAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentID));
    }

    @Override
    public Employee printEmployeeWithMaxSalaryFromDepartmentID(int departmentID) {
       return employeeService
               .findAll()
               .stream()
               .filter(e -> e.getDepartmentID() == departmentID)
               .max(comparingInt(Employee::getSalary))
               .orElseThrow(EmployeeNotFoundException::new);
    }

   @Override
    public Employee printEmployeeWithMinSalaryFromDepartmentID(int departmentID) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getDepartmentID() == departmentID)
                .min(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

}
