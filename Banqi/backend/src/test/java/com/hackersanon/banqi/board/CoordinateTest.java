package com.hackersanon.banqi.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    private Coordinate coordinate;

    @BeforeEach
    void setUp() {
        coordinate = new Coordinate(0, 0);
    }

    @Test
    void getRow() {
        assertEquals(0, coordinate.getRow());
    }

    @Test
    void getColumn() {
        assertEquals(0, coordinate.getColumn());
    }

    @Test
    void setColumn() {
        assertTrue(coordinate.setColumn(5));
    }

    @Test
    void setInvalidColumn() {
        assertFalse(coordinate.setColumn(-5));
        assertFalse(coordinate.setColumn(9));
    }

    @Test
    void setRow() {
        assertTrue(coordinate.setRow(2));
    }

    @Test
    void setInvalidRow() {
        assertFalse(coordinate.setRow(-2));
        assertFalse(coordinate.setRow(4));
    }

    @Test
    void isCoordinateValid() {
        assertTrue(Coordinate.isCoordinateValid(3, 7));
    }

    @Test
    void isCoordinateInvalid() {
        assertFalse(Coordinate.isCoordinateValid(8, -4));
    }

    @Test
    void getStringPosition() {
        assertEquals("a0", coordinate.getStringPosition());
    }
}