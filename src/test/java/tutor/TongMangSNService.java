package tutor;

import org.example.tutor.TongMangSN;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TongMangSNService {
    private TongMangSN tongMangSN;
    @BeforeEach
    public void setUp(){
        tongMangSN = new TongMangSN();
    }
    @Test
    public void testTongMangSNHopLe(){
        int [] arr = {1,2,3,4,5};
        int ex = 15;
        int re=tongMangSN.tongSoNguyen(arr);
        assertEquals(ex,re);
    }
}
