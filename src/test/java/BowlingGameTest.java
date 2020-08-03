import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {
    private BowlingGame bowlingGame;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

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

    @Test
    public void given_first_throw_ten_pins_then_cannot_throw_in_this_frame() {
        bowlingGame.throwBall(10);
        expectedException.expect(RuntimeException.class);
        bowlingGame.throwBall(2);
    }

}
