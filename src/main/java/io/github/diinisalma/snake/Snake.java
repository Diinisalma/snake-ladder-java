package io.github.diinisalma.snake;

public class Snake {
    private int head;
    private int tail;

    public Snake(int head, int tail) {
        if (!isValid(head)) {
            throw new RuntimeException("Invalid head position");
        }
        this.head = head;
        this.tail = tail;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        if (!isValid(head)) {
            throw new RuntimeException("Invalid head position");
        }
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    private boolean isValid(int head) {
        return head != 100;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + head;
        result = prime * result + tail;
        return result;
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
        return tail == other.tail || head == other.head;
    }
}
