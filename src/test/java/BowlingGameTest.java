import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {
    private BowlingGame bowlingGame;

    @Before
    public void before() {
        this.bowlingGame = new BowlingGame();
    }

    @Test
    public void when_throw_twice_and_less_than_ten_then_score_is_num_of_fell_pins() {
        int firstThrow = 2;
        int secondThrow = 3;
        int expected = firstThrow + secondThrow;
        bowlingGame.throwBall(firstThrow);
        bowlingGame.throwBall(secondThrow);
        assertEquals(expected, bowlingGame.getCurrentFrameScore());
    }

}
