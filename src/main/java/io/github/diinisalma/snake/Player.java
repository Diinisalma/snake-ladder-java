package io.github.diinisalma.snake;

public class Player {
    private String name;
    private int endPosition = 0;
    private int startPosition = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEndPosition() {
        if (endPosition < 0) {
            return 0;
        } else if (endPosition > 100) {
            return 100;
        } else {
            return this.endPosition;
        }
    }

    public void setEndPosition(int position) {
        this.endPosition = position;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }
}
