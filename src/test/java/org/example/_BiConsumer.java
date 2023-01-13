package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class _BiConsumer {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @ParameterizedTest
    @DisplayName("Should greet Customer :: BiConsumer")
    @MethodSource("getDifferentCustomers")
    void greetCustomerBiConsumer(Customer customer, Boolean showPhone) {
        // Given
        String expectedPhone = showPhone ? customer.customerPhoneNumber : "HIDDEN";

        // When
        greetCustomerConsumer.accept(customer, showPhone);
        // Then
        Assertions.assertEquals(
                "Hello " + customer.customerName + ", Your Phone Number is : " +
                        expectedPhone,
                outputStreamCaptor.toString().trim()
        );
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

    static BiConsumer<Customer, Boolean> greetCustomerConsumer = (customer, showPhone) ->
            System.out.println("Hello " + customer.customerName +
                    ", Your Phone Number is : " +
                            (showPhone ? customer.customerPhoneNumber : "HIDDEN")
                    );


    static void greetCustomer(Customer customer) {

        System.out.println("Hello : " + customer.customerName +
                ". Thanks for registering your phone number " + customer.customerPhoneNumber);
    }


    private static Stream<Arguments> getDifferentCustomers() {
        return
                Stream.of(
                        Arguments.of(new Customer("Hafid", "+33405050404"), true),
                        Arguments.of( new Customer("John", "+21235050404"), false)
                );


    }
}
