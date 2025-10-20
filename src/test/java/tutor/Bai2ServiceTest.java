package tutor;

import org.example.tutor.Bai2;
import org.example.tutor.Bai2Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Bai2ServiceTest {
    private Bai2Service bai2;
    @BeforeEach
    public void setUp(){
        bai2=new Bai2Service();
    }
    @Test
    public void testSuaSVHopLe(){
        Bai2 b2 = new Bai2("SV1","Duc BUh",99,0.1f,5,"CNTT");
        bai2.addSV(b2);
        Bai2 b2Moi = new Bai2("SV1","Duc BUh",19,9.1f,5,"CNTT");
        assertTrue(bai2.suaSV("SV1",b2Moi));
    }
    @Test
    public void testSuaSVKhongID(){
        Bai2 b2 = new Bai2("SV1","Duc BUh",99,0.1f,5,"CNTT");
        bai2.addSV(b2);
        Bai2 b2Moi = new Bai2("","Duc BUh",19,9.1f,5,"CNTT");
        assertThrows(NullPointerException.class, () -> bai2.suaSV("",b2Moi));
    }
    @Test
    public void testSuaSVNgoaiPV(){
        Bai2 b2 = new Bai2("SV2","Duc BUh",99,0.1f,5,"CNTT");
        bai2.addSV(b2);
        Bai2 b2Moi = new Bai2("SV2","Duc BUh",19,-10.0f,5,"CNTT");
        assertThrows(IllegalArgumentException.class, () -> bai2.suaSV("SV2",b2Moi));
    }
    @Test
    public void testSuaSVTrongTen(){
        Bai2 b2 = new Bai2("SV3","Duc BUh",99,0.1f,5,"CNTT");
        bai2.addSV(b2);
        Bai2 b2Moi = new Bai2("SV3","",19,9.0f,5,"CNTT");
        assertThrows(NullPointerException.class, () -> bai2.suaSV("SV3",b2Moi));
    }
    @Test
    public void testSuaSVTrongTuoi(){
        Bai2 b2 = new Bai2("SV4","Duc BUh",99,0.1f,5,"CNTT");
        bai2.addSV(b2);
        Bai2 b2Moi = new Bai2("SV4","Duc buh",null,9.0f,5,"CNTT");
        assertThrows(NullPointerException.class, () -> bai2.suaSV("SV4",b2Moi));
    }
    @Test
    public void testSuaSVTrongDTB(){
        Bai2 b2 = new Bai2("SV5","Duc BUh",99,0.1f,5,"CNTT");
        bai2.addSV(b2);
        Bai2 b2Moi = new Bai2("SV5","",19,null,5,"CNTT");
        assertThrows(NullPointerException.class, () -> bai2.suaSV("SV5",b2Moi));
    }
    @Test
    public void testSuaSVTrongKy(){
        Bai2 b2 = new Bai2("SV6","Duc BUh",99,0.1f,5,"CNTT");
        bai2.addSV(b2);
        Bai2 b2Moi = new Bai2("SV6","",19,9.0f,null,"CNTT");
        assertThrows(NullPointerException.class, () -> bai2.suaSV("SV6",b2Moi));
    }
    @Test
    public void testSuaSVTrongNganh(){
        Bai2 b2 = new Bai2("SV2","Duc BUh",99,0.1f,5,"CNTT");
        bai2.addSV(b2);
        Bai2 b2Moi = new Bai2("SV2","",19,9.0f,5,"");
        assertThrows(NullPointerException.class, () -> bai2.suaSV("SV2",b2Moi));
    }
}
