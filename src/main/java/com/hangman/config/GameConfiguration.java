
package com.hangman.config;

public class GameConfiguration {

    private static final GameConfiguration INSTANCE =
            new GameConfiguration();

    private final int classicMaxAttempts = 8;
    private final int challengeMaxAttempts = 5;
    private final boolean hintsEnabled = true;

    private GameConfiguration() {
    }

    public static GameConfiguration getInstance() {
        return INSTANCE;
    }

    public int getClassicMaxAttempts() {
        return classicMaxAttempts;
    }

    public int getChallengeMaxAttempts() {
        return challengeMaxAttempts;
    }

    public boolean isHintsEnabled() {
        return hintsEnabled;
    }
}
