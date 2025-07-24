import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;
import org.junit.jupiter.api.Test;

public class AlgTest {
    @Test
    public void test() {
        double freq = 440.0;
        for (int i = 0; i <= StdAudio.SAMPLE_RATE; i++) {
            StdAudio.play(0.5 * Math.sin(2*Math.PI * freq * i / StdAudio.SAMPLE_RATE));
        }
    }

    @Test
    public void test2() {
        // StdDraw stdDraw = StdDraw
    }
}
