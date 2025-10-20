import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitTestConfiguration {

    @Test
    public void TestJUnit() {
        String string = "Test JUnit Configuration";
        assertEquals("Test JUnit Configuration", string);
    }
}
