package com.joey;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joey on 2017/11/19.
 */
public class AppTest {

    private App app = null;

    @Before
    public void setUp() throws Exception {
        app = new App();
    }

    @Test
    public void testScoreNoThrows()
    {
        assertEquals(0, app.getTotalScore());
    }

    @Test
    public void testScoreAfterOneThrow() throws Exception {

        app.add(3);
        app.add(7);

        assertEquals(10, app.getTotalScore());

    }

    @Test
    public void testScoreAfterTwoThrow() throws Exception {

        app.add(3);
        app.add(7);
        app.add(2);
        app.add(5);

        assertEquals(17, app.getTotalScore());

    }

    @Test
    public void testRoundScoreAfterTwoThrow() throws Exception {

        app.add(3);
        app.add(7);
        app.add(2);
        app.add(5);
        assertEquals(17, app.getTotalScore());
        assertEquals(10, app.getScoreForRound(1));
        assertEquals(17, app.getScoreForRound(2));

    }



    @After
    public void tearDown() throws Exception {
    }

}