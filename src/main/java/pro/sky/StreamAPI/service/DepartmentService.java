package pro.sky.StreamAPI.service;

import pro.sky.StreamAPI.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Collection<Employee> printEmployeeFromDepartment(int departmentID);
    Map<Integer, List<Employee>> printEmployeeFromEachDepartments();
    Employee printEmployeeWithMaxSalaryFromDepartmentID(int departmentID);
    Employee printEmployeeWithMinSalaryFromDepartmentID(int departmentID);

}
