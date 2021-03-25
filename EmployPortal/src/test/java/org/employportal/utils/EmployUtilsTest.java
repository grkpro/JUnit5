package org.employportal.utils;

import org.employportal.dto.Employ;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Period;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.DoubleStream;

@DisplayName("Employ Utils")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployUtilsTest {

    static List<Employ> employList;
    EmployUtils employUtils = new EmployUtils();

    @BeforeAll
    static void prepare() {
        employList = Arrays.asList(
                new Employ("1", "Ravi", 5000, new Date(1990, 01, 01), new Date(2011, 10, 10)),
                new Employ("4", "Kiran", 56200),
                new Employ("11", "Madhu", 345000)
        );
    }

    @BeforeEach
    void validate() {
        Assertions.assertTrue(!employList.isEmpty());
    }

    @AfterEach
    void displayData() {
//        employList.forEach(System.out::println);
    }

    @Test
    @DisplayName("Sorting of Data By Name")
    @Order(value = 1)
    void sortByName() {
        System.out.println("Sorting of Employs by Name:");
        employUtils.sortByName(employList);
        employList.forEach(System.out::println);
    }

    @Test
    @DisplayName("Applying Bonus to All Employs")
    @Order(value = 2)
    void applyBonusToAll() {
        System.out.println("Applying Bonus to all employs");
        employUtils.applyBonusToAll(employList, 30);
        employList.forEach(System.out::println);
    }

    @Test
    void getEmploysBySalary() {
        System.out.println("Employs by Salary");
        employUtils.getEmploysBySalary(employList, 10000).forEach(System.out::println);
    }

    @DisplayName("Employ information by Id")
    @ParameterizedTest(name="#{index} - Employ Id={0}")
    @ValueSource(strings = {"4","11","50","60"})
    void getEmployById(String id) {
        System.out.println("Employ by Id:");
        Employ e = employUtils.getEmployById(employList, id);
        Assertions.assertNotNull(e,"Employ is null");
    }


    //Conditional Test: This Test method will execute only on MAC Operating system.
    @Test
    @EnabledOnOs(OS.MAC)
    @DisplayName("All Employ Name:: Only on MAC OS")
    void getAllEmployNames() {
        System.out.println("List of all employ names");
        employUtils.getAllEmployNames(employList).forEach(System.out::println);
    }

    @DisplayName("Employ Names by Salary")
    @ParameterizedTest(name="#{index} - Salary of Employ ={0}")
    @MethodSource("salaryDataSource")
    void getAllEmployNamesBySalary(double salary) {
        System.out.println("List of all employ names by salary");
        List<String> employs = employUtils.getAllEmployNamesBySalary(employList, salary);

        //If assume condition true then it will execute otherwise aborting test
        Assumptions.assumeTrue(!employs.isEmpty(),()->"Aborting Test");
        employUtils.getAllEmployNamesBySalary(employList, salary).forEach(System.out::println);
    }

    static DoubleStream salaryDataSource(){
        return DoubleStream.of(4000,5000,3000);
    }
}