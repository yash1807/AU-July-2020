package com.junit.assignment.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.junit.assignment.model.Employee;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
 
public class EmployeevalidationTest {
 
    private static ValidatorFactory validatorFactory;
    private static Validator validator;
 
    @BeforeClass
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }
 
    @AfterClass
    public static void close() {
        validatorFactory.close();
    }
 
    @Test
    public void shouldHaveNoViolations() {
        //given:
    	Employee employeeToAdd = new Employee("Yash", "rai", "auassignment@gmail.com", "9876543210");
 
        //when:
        Set<ConstraintViolation<Employee>> violations
                = validator.validate(employeeToAdd);
 
        //then:
        assertTrue(violations.isEmpty());
    }
 
    @Test
    public void shouldDetectInvalidName() {
        //given too short name:
    	Employee employeeToAdd = new Employee("Yash", "Rai", "auassignment@gmail.com", "9875432105");
 
        //when:
        Set<ConstraintViolation<Employee>> violations
                = validator.validate(employeeToAdd);
 
        //then:
        assertTrue(violations.isEmpty());
 
        
    }
}
