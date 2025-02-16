package io.github.diinisalma.snake;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("io.github.diinisalma.snake")
public class SnakeTest {

    @Test
    public void given_head_value_100_or_more_then_throw_error() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> new Snake(101, 1));
        Assertions.assertEquals("Invalid head position", exception.getMessage());
    }

    @Test
    public void setHead_given_head_value_100_or_more_then_throw_error() {
        Snake snake = new Snake(10, 1);
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> snake.setHead(101));
        Assertions.assertEquals("Invalid head position", exception.getMessage());
    }
}
