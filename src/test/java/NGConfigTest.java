import org.example.Caculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NGConfigTest {
    @Test
    public void testAdd(){
        Caculator calc=new Caculator();
        Assert.assertEquals(calc.add(10,20),30);
    }
}
