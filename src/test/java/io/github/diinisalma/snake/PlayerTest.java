package io.github.diinisalma.snake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("io.github.diinisalma.snake")
public class PlayerTest {
    @Test
    public void getEndPosition_given_less_than_zero_then_return_zero() {
        Player player = new Player("test");
        player.setEndPosition(-1);
        Assertions.assertEquals(0, player.getEndPosition());
    }

    @Test
    public void getEndPosition_given_101_then_return_100() {
        Player player = new Player("test");
        player.setEndPosition(101);
        Assertions.assertEquals(100, player.getEndPosition());
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 5, 90, 100 })
    public void getEndPosition_given_between_0_and_100_then_return_value(int param) {
        Player player = new Player("test");
        player.setEndPosition(param);
        Assertions.assertEquals(param, player.getEndPosition());
    }

    @Test
    public void getStartPosition_given_value_then_return_value() {
        Player player = new Player("test");
        player.setStartPosition(1);
        Assertions.assertEquals(1, player.getStartPosition());
    }
}
