package tutor;

import org.example.tutor.Sach;
import org.example.tutor.SachService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SachServiceTest {
    private SachService sachService;

    @BeforeEach
    public void setUp() {
        sachService = new SachService();
    }

    @Test
    public void testSachHopLe() {
        Sach sach = new Sach("S1", "Sach mot", 36, "Bui duc", 1);
        assertTrue(sachService.themSach(sach));
    }

    @Test
    public void testSachHopLeSoTrang0() {
        Sach sach = new Sach("S2", "Sach hai", 0, "Bui duc", 2);
        assertThrows(IllegalArgumentException.class, () -> sachService.themSach(sach));
    }

    @Test
    public void testSachHopLeSoTrang51() {
        Sach sach = new Sach("S3", "Sach ba", 51, "Bui duc", 2);
        assertThrows(IllegalArgumentException.class, () -> sachService.themSach(sach));
    }

    @Test
    public void testSachNull() {
        assertThrows(NullPointerException.class, () -> sachService.themSach(null));
    }

    @Test
    public void testSachTenKTDB() {
        Sach sach = new Sach("S4", "Sach bon#$%", 36, "Bui duc", 2);
        assertThrows(IllegalArgumentException.class, () -> sachService.themSach(sach));
    }

    @Test
    public void suaSachHopLe() {
        Sach sach = new Sach("S1", "Sach mot", 36, "Bui duc", 1);
        sachService.themSach(sach);
        Sach sachMoi = new Sach("S1", "Sach mot", 18, "Bui duc", 1);
        assertTrue(sachService.suaSach("S1", sachMoi));
    }

    @Test
    public void suaSachKhongID() {
        Sach sachMoi = new Sach("S2", "Sach mot", 36, "Bui duc", 1);
        assertThrows(IllegalArgumentException.class, () -> sachService.suaSach("No", sachMoi));
    }

    @Test
    public void suaSachSoTrang0() {
        Sach sach = new Sach("S2", "Sach mot", 36, "Bui duc", 1);
        sachService.themSach(sach);
        Sach sachMoi = new Sach("S2", "Sach mot", 0, "Bui duc", 1);
        assertThrows(IllegalArgumentException.class, () -> sachService.suaSach("S2", sachMoi));
    }

    @Test
    public void suaSachSoTrang51() {
        Sach sach = new Sach("S3", "Sach mot", 36, "Bui duc", 1);
        sachService.themSach(sach);
        Sach sachMoi = new Sach("S3", "Sach mot", 51, "Bui duc", 1);
        assertThrows(IllegalArgumentException.class, () -> sachService.suaSach("S3", sachMoi));
    }

    @Test
    public void suaSachTenKTDB() {
        Sach sach = new Sach("S4", "Sach mot", 36, "Bui duc", 1);
        sachService.themSach(sach);
        Sach sachMoi = new Sach("S4", "Sach mot$$$$@@@", 36, "Bui duc", 1);
        assertThrows(IllegalArgumentException.class, () -> sachService.suaSach("S4", sachMoi));
    }
}
