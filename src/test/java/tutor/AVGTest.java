package tutor;

import org.example.tutor.AVG;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AVGTest {
    private AVG avg;
    @BeforeEach
    public void setUp(){
        avg = new AVG();
    }
    @Test
    public void testAVG(){
        double exp=9.5;
        double act = avg.avg(9.5, 9.5, 9.5);
    }
}
