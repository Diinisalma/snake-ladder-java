package io.github.diinisalma.snake;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    
    private Board board;
    
    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void setupGame_given_valid_input_should_not_throw_exception() {
        String input = "2\n" +  // number of snakes
                      "14 4\n" + // snake 1 from 14 to 4
                      "99 77\n" + // snake 2 from 99 to 77
                      "2\n" +  // number of ladders
                      "20 38\n" + // ladder 1 from 20 to 38
                      "71 92\n" + // ladder 2 from 71 to 92
                      "2\n" +  // number of players
                      "Tom\n" + // player 1 name
                      "Jerry\n";  // player 2 name
        
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        assertDoesNotThrow(() -> board.setupGame());
    }

    @Test
    void setupGame_given_ladder_snake_overlap_should_throw_exception() {
        String input = "1\n" +  // number of snakes
                      "38 20\n" + // snake from 38 to 20
                      "1\n" +  // number of ladders
                      "20 38\n" + // ladder trying to overlap with snake
                      "1\n" +  // number of players
                      "John\n"; // player name
        
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        Exception exception = assertThrows(RuntimeException.class, () -> board.setupGame());
        assertEquals("Ladder overlaps with snake", exception.getMessage());
    }
}
