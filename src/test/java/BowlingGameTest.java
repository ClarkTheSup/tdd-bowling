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
        bowlingGame.throwBall(0,0, firstThrow);
        bowlingGame.throwBall(0,1, secondThrow);
        bowlingGame.calculateFrameScore();
        assertEquals(expected, bowlingGame.getFrameScores()[0]);
    }

    @Test
    public void given_first_throw_ten_pins_then_cannot_throw_in_this_frame() {
        bowlingGame.throwBall(0,0,10);
        expectedException.expect(RuntimeException.class);
        bowlingGame.throwBall(0,1,2);
    }

    @Test
    public void given_first_throw_ten_pins_then_score_is_sum_of_ten_and_next_two_throw_score() {
        bowlingGame.throwBall(0,0,10);
        bowlingGame.throwBall(1,0,2);
        bowlingGame.throwBall(1,1,3);
        bowlingGame.calculateFrameScore();
        int expectedFrameScore1 = 15;
        int expectedFrameScore2 = 5;
        assertEquals(expectedFrameScore1, bowlingGame.getFrameScores()[0]);
        assertEquals(expectedFrameScore2, bowlingGame.getFrameScores()[1]);
    }

    @Test
    public void given_second_throw_ten_pins_then_score_is_sum_of_ten_and_next_one_throw_score() {
        bowlingGame.throwBall(0,0,5);
        bowlingGame.throwBall(0,1,10);
        bowlingGame.throwBall(1,0,2);
        bowlingGame.throwBall(1,1,3);
        bowlingGame.calculateFrameScore();
        int expectedFrameScore1 = 17;
        int expectedFrameScore2 = 5;
        assertEquals(expectedFrameScore1, bowlingGame.getFrameScores()[0]);
        assertEquals(expectedFrameScore2, bowlingGame.getFrameScores()[1]);
    }

    @Test
    public void given_tenth_frame_strike_then_score_is_sum_of_ten_and_next_two_throw_score() {
        bowlingGame.throwBall(9,0,10);
        bowlingGame.throwBall(10,1,3);
        bowlingGame.throwBall(10,0,2);
        bowlingGame.calculateFrameScore();
        int expectedFrameScore = 15;
        assertEquals(expectedFrameScore, bowlingGame.getFrameScores()[9]);
    }

    @Test
    public void given_tenth_frame_spare_then_score_is_sum_of_ten_and_next_one_throw_score() {
        bowlingGame.throwBall(9,0,5);
        bowlingGame.throwBall(9,1,10);
        bowlingGame.throwBall(10,0,3);
        bowlingGame.calculateFrameScore();
        int expectedFrameScore = 18;
        assertEquals(expectedFrameScore, bowlingGame.getFrameScores()[9]);
    }

    @Test
    public void when_tenth_frame_no_strike_and_spare_then_score_is_sum_of_two_throw_score() {
        bowlingGame.throwBall(9,0,5);
        bowlingGame.throwBall(9,1,6);
        bowlingGame.calculateFrameScore();
        int expectedFrameScore = 11;
        assertEquals(expectedFrameScore, bowlingGame.getFrameScores()[9]);
    }

    @Test
    public void when_tenth_frame_strike_and_new_frame_strike_then_score_is_20() {
        bowlingGame.throwBall(9,0,10);
        bowlingGame.throwBall(10,0,10);
        bowlingGame.calculateFrameScore();
        int expectedFrameScore = 20;
        assertEquals(expectedFrameScore, bowlingGame.getFrameScores()[9]);
    }


}
