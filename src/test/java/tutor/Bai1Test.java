package tutor;

import org.example.tutor.TongMangSN;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Bai1Test {
    private TongMangSN tongMangSN;
    @BeforeEach
    public void setup() {
        tongMangSN=new TongMangSN();
    }
    @Test
    public void testTongHopLe(){
        int arr[]={1,2,3,4,5};
        assertEquals(15,tongMangSN.tongSoNguyen(arr));
    }
    @Test
    public void testTongSoNguyenNgoaiPV(){
        int arr[]={-1,2,3,4,5};
        assertThrows(IllegalArgumentException.class, () -> tongMangSN.tongSoNguyen(arr));
    }
    @Test
    public void testTongSoNguyenTaiBien(){
        int arr[]={1,1000};
        assertEquals(1001,tongMangSN.tongSoNguyen(arr));
    }
    @Test
    public void testTongSoNguyenTaiCanBien(){
        int arr[]={2,999};
        assertEquals(1001,tongMangSN.tongSoNguyen(arr));
    }
    @Test
    public void testTongSoNguyenTaiCan(){
        int arr[]={0,1001};
        assertThrows(IllegalArgumentException.class, () -> tongMangSN.tongSoNguyen(arr));
    }
}
