package pro.sky.StreamAPI.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.*;

public class Employee {
    private final String firstName;
    private final String lastName;
    private int departmentID;
    private int salary;

    public Employee(String firstName, String lastName) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
        this.departmentID = departmentID;
        this.salary = salary;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public int getDepartmentID() {
        return departmentID;
    }
    public int getSalary() {
        return salary;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
