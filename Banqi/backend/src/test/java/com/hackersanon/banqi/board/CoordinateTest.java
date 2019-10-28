package com.hackersanon.banqi.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getRow() {
        Coordinate coordinate = new Coordinate(3,3);
        assertEquals(3, coordinate.getRow());
    }

    @Test
    void getColumn() {
        Coordinate coordinate = new Coordinate(2,7);
        assertEquals(7, coordinate.getColumn());
    }

    @Test
    void setColumn() {
    }

    @Test
    void setRow() {
    }

    @Test
    void isCoordinateValid() {
    }

    @Test
    void getStringPosition() {
    }
}