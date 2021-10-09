package com.example.springbootcleancode.repository;

import com.example.springbootcleancode.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);

    List<Employee> findByNameAndLastName(String name, String lastName);

    @Query("select e from Employee e where e.name = :name")
    List<Employee> findByNameQuery(@Param("name") String name);

    @Query(value = "select * from Employee e where e.name = :name", nativeQuery = true)
    List<Employee> findByNameQueryNative(@Param("name") String name);

    List<Employee> findAllByNameLike(String name);

    List<Employee> findAllByNameStartingWith(String name);

    List<Employee> findAllByNameEndingWith(String name);

    @Query("select ee from Employee ee where upper(ee.name) like upper(concat('%', :name, '%') ) ")
    List<Employee> findAllByLike(@Param("name") String name);

    @Query(value = "select ee from Employee ee where upper(ee.name) like upper(concat(%:name%) ) ", nativeQuery = true)
    List<Employee> findAllByNativeLike(@Param("name") String name);


}
