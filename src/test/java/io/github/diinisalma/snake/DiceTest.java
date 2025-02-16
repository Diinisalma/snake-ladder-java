package io.github.diinisalma.snake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("io.github.diinisalma.snake")
public class DiceTest {
    @Test
    public void roll_then_return_value_between_1_and_6() {
        Dice dice = new Dice();
        int value = dice.roll();
        Assertions.assertTrue(value >= 1 && value <= 6);
    }
}
