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

        return getScoreForRound(getCurrentRound() - 1);
    }

    public void add(int pins) {

        this.throwedScore[this.currentThrowTimes++] = pins;

        adjustCurrentRound(pins);
    }

    private void adjustCurrentRound(int pins)
    {
        if (firstThrow == true)
        {
            if (pins == 10)
                currentRound++;
            else
                firstThrow = false;
        }
        else
        {
            firstThrow = true;
            currentRound++;
        }
        currentRound = Math.min(11, currentRound);
    }

    public int getCurrentRound()
    {
        return this.currentRound;
    }

    public int getScoreForRound(int round) {
        int ball = 0;
        int tmpScore = 0;

        for(int currentRound = 0; currentRound < round; currentRound++)
        {
            int firstThrow = throwedScore[ball++];


            if(firstThrow == 10)
            {
                //Strike

                tmpScore += 10 + throwedScore[ball] + throwedScore[ball+1];
            }
            else
            {
                int secondThrow = throwedScore[ball++];
                int roundScore = firstThrow + secondThrow;
                if(roundScore == 10)
                {
                    tmpScore += roundScore + throwedScore[ball];
                }
                else
                {
                    tmpScore += roundScore;
                }

            }

        }

        return tmpScore;
    }

    private int thisScore = 0;
    private boolean firstThrow = true;
    private int currentRound = 1;
    private int currentThrowTimes = 0;
    private int[] throwedScore = new int[21];
}
