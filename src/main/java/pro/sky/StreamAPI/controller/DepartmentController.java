package pro.sky.StreamAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.StreamAPI.model.Employee;
import pro.sky.StreamAPI.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping(path = "/all", params = {"departmentID"})
    public Collection<Employee> allEmployeeFromDepartmentID(@RequestParam int departmentID) {
        return departmentService.printEmployeeFromDepartment(departmentID);
    }
    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> allEmployeeFromEachDepartmentID() {
        return departmentService.printEmployeeFromEachDepartments();
    }
    @GetMapping(path = "/max-salary")
    public Employee EmployeeWithMaxSalaryFromDepartmentID(@RequestParam int departmentID) {
        return departmentService.printEmployeeWithMaxSalaryFromDepartmentID(departmentID);
    }
    @GetMapping(path = "/max-salary")
    public Employee EmployeeWithMinSalaryFromDepartmentID(@RequestParam int departmentID) {
        return departmentService.printEmployeeWithMinSalaryFromDepartmentID(departmentID);
    }
}