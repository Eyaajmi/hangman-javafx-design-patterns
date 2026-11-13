
package com.hangman.model;

public class GameStatistics {

    private int gamesPlayed;
    private int gamesWon;
    private int gamesLost;
    private int totalScore;
    private int bestScore;

    public GameStatistics() {
        this.gamesPlayed = 0;
        this.gamesWon = 0;
        this.gamesLost = 0;
        this.totalScore = 0;
        this.bestScore = 0;
    }

    public void recordWin(int score) {
        gamesPlayed++;
        gamesWon++;
        totalScore += score;

        if (score > bestScore) {
            bestScore = score;
        }
    }

    public void recordLoss(int score) {
        gamesPlayed++;
        gamesLost++;
        totalScore += score;

        if (score > bestScore) {
            bestScore = score;
        }
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getBestScore() {
        return bestScore;
    }
}
