package io.github.diinisalma.snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {
    private final List<Snake> snakes = new ArrayList<>();
    private final List<Ladder> ladders = new ArrayList<>();
    private Player[] players;
    private static Dice dice;
    private Player winner;
    private boolean gameOver = false;

    public void setupGame() {
        try (Scanner scanner = new Scanner(System.in)) {
            // Enter no of snakes
            int noOfSnakes = scanner.nextInt();
            for (int idx = 0; idx < noOfSnakes; idx++) {
                snakes.add(new Snake(scanner.nextInt(), scanner.nextInt()));
            }
            // Enter no of ladders
            int noOfLadders = scanner.nextInt();
            for (int idx = 0; idx < noOfLadders; idx++) {
                Ladder inputLadder = new Ladder(scanner.nextInt(), scanner.nextInt());
                if (isLadderOverlapWithSnake(inputLadder)) {
                    throw new RuntimeException("Ladder overlaps with snake");
                }
                ladders.add(inputLadder);
            }
            // Enter no of players
            int noOfPlayers = scanner.nextInt();
            players = new Player[noOfPlayers];
            for (int idx = 0; idx < players.length; idx++) {
                players[idx] = new Player(scanner.next());
            }
            startGame();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void startGame() {
        while (!gameOver) {
            for (Player player : players) {
                player.setStartPosition(player.getEndPosition());
                int rolledDice = dice.roll();
                player.setEndPosition(rolledDice + player.getEndPosition());
                Snake snake = snakes.stream().filter(s -> s.getHead() == player.getEndPosition()).findFirst()
                        .orElse(null);
                if (snake != null) {
                    player.setEndPosition(snake.getTail());
                }
                Ladder ladder = ladders.stream().filter(l -> l.getStart() == player.getEndPosition()).findFirst()
                        .orElse(null);
                if (ladder != null) {
                    player.setEndPosition(ladder.getEnd());
                }
                System.out.printf("%s rolled a %d and moved from %d to %d%n", player.getName(), rolledDice,
                        player.getStartPosition(), player.getEndPosition());
                if (player.getEndPosition() >= 100) {
                    winner = player;
                    gameOver = true;
                    break;
                }
            }
        }
        System.out.printf("%s wins the game%n", winner.getName());
    }

    private boolean isLadderOverlapWithSnake(Ladder ladder) {
        Snake snake = new Snake(ladder.getEnd(), ladder.getStart());
        return snakes.stream().anyMatch(s -> s.equals(snake));
    }
}
