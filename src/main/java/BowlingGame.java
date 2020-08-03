public class BowlingGame {
    private int currentFrameScore = 0;

    public void throwBall(int pins) {
        if (currentFrameScore == 10) {
            throw new RuntimeException("Cannot throw again.");
        }
        currentFrameScore += pins;
    }

    public int getCurrentFrameScore() {
        return currentFrameScore;
    }
}
