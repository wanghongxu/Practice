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

    public void add(int pins) {

        this.roundScore[this.currentThrowTimes++] = pins;
        this.thisScore += pins;

//        if(pins == 10)
//        {
//            this.currentThrowTimes++;
//        }
    }

    public int getScoreForRound(int round) {
        int ball = 0;
        int tmpScore = 0;

        for(int currentRound = 0; currentRound < round; currentRound++)
        {
            int firstThrow = roundScore[ball++];

            //Strike
            if(firstThrow == 10)
            {
                tmpScore += 10 + roundScore[ball] + roundScore[ball+1];
            }
            //Spare
            else
            {
                int secondThrow = roundScore[ball++];
                if(firstThrow + secondThrow == 10)
                {
                    tmpScore += 10 + roundScore[ball];
                }
                else
                {
                    tmpScore += firstThrow + secondThrow;
                }

            }

        }

        return tmpScore;
    }

    private int thisScore = 0;
    private int currentThrowTimes = 0;
    private int[] roundScore = new int[21];
}
