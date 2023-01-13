package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _BiFunction {

    @Test
    @DisplayName("Should implement by one using imperative approach")
    void should_increment() {
        // Given
        int number = 0;

        // When
        int newNumber = increment(number);

        // Then
        Assertions.assertEquals(1, newNumber);
    }

    @Test
    @DisplayName("Should Increment By One Using FunctionalInteface")
    void should_increment_with_function() {
        // Given
        int number = 0;

        // When
        int newNumber = incrementByOneFunction.apply(number);

        // Then
        Assertions.assertEquals(1, newNumber);
    }

    @Test
    @DisplayName("Should Increment By One And Multiply By 10")
    void shouldIncrementAndMultiply() {
        // Given
        int number = 1;

        // When
        int newNumber = incrementByOneAndMultiplyBy10.apply(number);

        // Then
        Assertions.assertEquals(20, newNumber);
    }

    @Test
    @DisplayName("Should Increment By One And Multiply By 10 With Compose")
    void shouldIncrementAndMultiplyWithCompose() {
        // Given
        int number = 1;

        // When
        int newNumber = multiplyBy10.compose(incrementByOneFunction).apply(number);

        // Then
        Assertions.assertEquals(20, newNumber);
    }

    @Test
    @DisplayName("Should increment by one and multiply by 10 with BiFunction")
    void shouldIncrementAndMultiply10WithBiFunction() {
        // Given
        int number = 1;

        // When
        int newNumber = incrementAndMultiplyBiFunctional.apply(number, 10);

        // Then
        Assertions.assertEquals(20, newNumber);
    }
    // The first "Integer" means the input, the second one means the output
    static Function<Integer, Integer> incrementByOneFunction = number -> ++number;
    static Function<Integer, Integer> multiplyBy10 = number -> number * 10;
    static Function<Integer, Integer> incrementByOneAndMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10);

    static BiFunction<Integer, Integer, Integer> incrementAndMultiplyBiFunctional =
            (number, multiplier) -> (number + 1) * multiplier;
    static int increment(int number) {
        return ++number;
    }

}
