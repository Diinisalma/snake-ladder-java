package io.github.diinisalma.snake;

import java.util.Objects;

public class Snake {
    private int head;
    private int tail;

    public Snake(int head, int tail) {
        if (!isValid(tail)) {
            throw new RuntimeException("Invalid tail position");
        }
        this.head = head;
        this.tail = tail;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        if (!isValid(tail)) {
            throw new RuntimeException("Invalid tail position");
        }
        this.tail = tail;
    }

    private boolean isValid(int tail) {
        return tail < 100 && tail > 1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Snake other = (Snake) obj;
        return tail == other.tail && head == other.head;
    }
}
