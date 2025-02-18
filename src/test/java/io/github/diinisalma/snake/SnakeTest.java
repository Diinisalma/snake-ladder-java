package io.github.diinisalma.snake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SnakeTest {

    @ParameterizedTest
    @ValueSource(ints = {100, 101, 1})
    public void setTail_given_tail_invalid_value_then_throw_error(int tail) {
        Snake snake = new Snake(1, 10);
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> snake.setTail(tail));
        Assertions.assertEquals("Invalid tail position", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 101, 1})
    public void given_tail_invalid_value_then_throw_error(int tail) {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> new Snake(1, tail));
        Assertions.assertEquals("Invalid tail position", exception.getMessage());
    }

    @Test
    public void given_tail_valid_value_then_set_tail() {
        Snake snake = new Snake(1, 2);
        Assertions.assertEquals(2, snake.getTail());
    }

    @Test
    public void setTail_given_tail_valid_value_then_set_tail() {
        Snake snake = new Snake(1, 2);
        snake.setTail(3);
        Assertions.assertEquals(3, snake.getTail());
    }
    
    
}
