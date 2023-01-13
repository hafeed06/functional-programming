package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

public class _Consumer {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Should greet Customer :: Consumer")
    void greetCustomerConsumer() {
        // Given
        Customer customer = new Customer("Hafid", "+33405050404");
        // When
        greetCustomerConsumer.accept(customer);
        // Then
        Assertions.assertEquals("Welcome Hafid", outputStreamCaptor.toString().trim());
    }

    static class Customer {
        private String customerName;
        private String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "customerName='" + customerName + '\'' +
                    ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                    '}';
        }
    }

    Consumer<Customer> greetCustomerConsumer = e -> System.out.println("Welcome " + e.customerName);


    static void greetCustomer(Customer customer) {
        System.out.println("Hello : " + customer.customerName +
                ". Thanks for registering your phone number " + customer.customerPhoneNumber);
    }
}
