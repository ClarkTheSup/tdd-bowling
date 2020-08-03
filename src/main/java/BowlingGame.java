public class BowlingGame {
    private int [][] throwScores = new int[10][2];
    private int [] frameScores = new int[10];

    public void throwBall(int frameNum, int throwNum, int pins) {
        if (frameNum == 10) {
            frameScores[(frameNum - 1)] += pins;
            return;
        }

        if (throwScores[frameNum][0] == 10 && throwNum == 1) {
            throw new RuntimeException("Cannot throw again.");
        }
        throwScores[frameNum][throwNum] = pins;

    }

    public void calculateFrameScore() {
        for(int i=0; i<10; i++) {
            frameScores[i] += throwScores[i][0] + throwScores[i][1];
        }
        for(int i=0; i<9; i++) {
            if (throwScores[i][0] == 10) {
                frameScores[i] += throwScores[i+1][0] + throwScores[i+1][1];
            } else if (throwScores[i][1] == 10) {
                frameScores[i] += throwScores[i+1][0];
            }
        }


    }

    public int[][] getThrowScores() {
        return throwScores;
    }
    public int[] getFrameScores() {
        return frameScores;
    }
}
