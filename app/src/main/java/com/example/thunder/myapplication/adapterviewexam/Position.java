package com.example.thunder.myapplication.adapterviewexam;

/**
 * 모델 클래스
 */

public class Position {
    private String position;

    public Position(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Position{" +
                "position='" + position + '\'' +
                '}';
    }
}
