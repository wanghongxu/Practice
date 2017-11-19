package com.joey;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }


    public int getTotalScore() {

        return this.thisScore;
    }

    public void add(int i) {

        this.roundScore[this.currentThrowTimes] = i;

        this.currentThrowTimes++;
        this.thisScore += i;

    }

    private int thisScore = 0;
    private int currentThrowTimes = 0;
    private int[] roundScore = new int[21];

    public int getScoreForRound(int i) {
        int ball = 0;
        int tmpScore = 0;

        for(int currentRound = 0; currentRound < i; currentRound++)
        {
            int firstThrow = roundScore[ball++];
            int secondThrow = roundScore[ball++];
            tmpScore += firstThrow + secondThrow;
        }

        return tmpScore;
    }
}
