package com.example.springbootcleancode.webRest;

import com.example.springbootcleancode.domain.Employee;
import com.example.springbootcleancode.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeResource {

    public final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity create(@RequestBody Employee employee){
        Employee employee1 = employeeService.save(employee);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employees")
    public ResponseEntity update(@RequestBody Employee employee){
        Employee employee1 = employeeService.save(employee);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/employees")
    public ResponseEntity findAll(){
        List<Employee> employeeList = employeeService.findAll();
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping("/employees/{name}")
    public ResponseEntity getAll(@PathVariable String name){
        List<Employee> employeeList = employeeService.findByName(name);
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping("/employees/search")
    public ResponseEntity getAllSearch(@RequestParam String name){
        List<Employee> employeeList = employeeService.findAllByParam(name);
        return ResponseEntity.ok(employeeList);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.ok("Ma'lumot uchirildi.");
    }

}
