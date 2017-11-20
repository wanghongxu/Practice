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
    public void testScoreAfterOneRound() throws Exception {

        app.add(3);
        app.add(6);

        assertEquals(9, app.getTotalScore());

    }

    @Test
    public void testScoreAfterTwoRound() throws Exception {

        app.add(3);
        app.add(6);
        app.add(2);
        app.add(5);

        assertEquals(16, app.getTotalScore());

    }

    @Test
    public void testRoundScoreAfterTwoRound() throws Exception {

        app.add(3);
        app.add(6);
        app.add(2);
        app.add(5);
        assertEquals(16, app.getTotalScore());
        assertEquals(9, app.getScoreForRound(1));
        assertEquals(16, app.getScoreForRound(2));

    }

    @Test
    public void testSpareAfterOneRound() throws Exception {

        app.add(3);
        app.add(7);
        app.add(2);
        app.add(5);
        assertEquals(17, app.getTotalScore());
        assertEquals(12, app.getScoreForRound(1));
        assertEquals(19, app.getScoreForRound(2));

    }

    @Test
    public void testStrikeAfterOneRound() throws Exception {

        app.add(10);
        app.add(7);
        app.add(3);
        app.add(5);
        app.add(3);
        //assertEquals(43, app.getTotalScore());
        assertEquals(20, app.getScoreForRound(1));
        assertEquals(35, app.getScoreForRound(2));

    }


    @After
    public void tearDown() throws Exception {
    }

}