public class BowlingGame {
    private int currentFrameScore = 0;

    public void throwBall(int pins) {
        currentFrameScore += pins;
    }

    public int getCurrentFrameScore() {
        return currentFrameScore;
    }
}
