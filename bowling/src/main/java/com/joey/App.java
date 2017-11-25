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

        int currentRoundNum = getCurrentRound();

        return getScoreForRound(currentRoundNum);
    }

    public void add(int pins) {

        this.throwedScore[this.currentThrowTimes++] = pins;
        this.thisScore += pins;

        if(pins == 10)
        {
            this.currentThrowTimes++;
        }
    }

    public int getCurrentRound()
    {
        return this.currentThrowTimes / 2;
    }

    public int getScoreForRound(int round) {
        int ball = 0;
        int tmpScore = 0;

        for(int currentRound = 0; currentRound < round; currentRound++)
        {
            int firstThrow = throwedScore[ball++];

            //Strike
            if(firstThrow == 10)
            {
                tmpScore += 10 + throwedScore[++ball] + throwedScore[ball+1];
            }
            //Spare
            else
            {
                int secondThrow = throwedScore[ball++];
                if(firstThrow + secondThrow == 10)
                {
                    tmpScore += 10 + throwedScore[ball];
                }
                else
                {
                    tmpScore += firstThrow + secondThrow;
                }

            }

        }

        if(round == 10)
        {
            tmpScore += throwedScore[ball];
        }

        return tmpScore;
    }

    private int thisScore = 0;
    private int currentThrowTimes = 0;
    private int[] throwedScore = new int[21];
}
