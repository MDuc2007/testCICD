import org.example.Caculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class CaculatorTest {
    private Caculator caculator;

    @BeforeAll
    public static void setUpBeforeClass() {
        System.out.println("CaculatorTest setUpBeforeClass");
    }

    @BeforeEach
    public void setUp() throws Exception {
        caculator = new Caculator();
        System.out.println("Caculator setUp");
    }

    @Test
    public void testAdd() {
        assertEquals(5, caculator.add(2, 3));
    }

    @Test

    public void testSubtract() {
        assertEquals(5, caculator.subtract(2, 3));
    }

    @Test

    public void testMultiply() {
        assertEquals(5, caculator.multiply(2, 3));
    }

    @Test

    public void testDivide() {
        assertEquals(5, caculator.divide(2, 3));
    }

    @Test
    public void testDivideByZero() {
        ArithmeticException exception = assertThrowsExactly(
                ArithmeticException.class, () -> caculator.divide(10, 0)
        );
        assertEquals("Divide by zero", exception.getMessage());
    }

    @Test
    public void testDivideByZero_tryCatch() {
        try {
            caculator.divide(10, 0);
            fail("Expected ArithmeticException was not thrown");
        } catch (ArithmeticException e) {
            assertEquals("Divide by zero", e.getMessage());
        }
    }

    private static <T extends Throwable> T expectdException(Class<T> type, Runnable code) {
        return assertThrows(type, code::run);
    }

    @Test
    public void testDivideByZero_helper() {
        ArithmeticException exception = expectdException(ArithmeticException.class, () -> caculator.divide(10, 0));
        assertTrue(exception.getMessage().contains("Divide by zero"));
    }

    @Test
    void testAllOperationsWithInternalError() {
        assertAll("Minh hoạ gom nhiều test lại (ErrorCollector)",
                // Sai vẫn chạy tiếp
                () -> assertEquals(7, caculator.add(4, 5)),
                // Sai
                () -> assertEquals(1, caculator.subtract(8, 5)),
                // Đúng
                () -> assertEquals(20, caculator.multiply(4, 5)),
                // Đúng
                () -> assertEquals(4, caculator.divide(16, 4)),
                // Sai
                () -> assertThrows(ArithmeticException.class,
                        () -> caculator.divide(10, 0),
                        "Chia cho 0 phải phát sinh ngoại lệ!"
                )
        );
    }


    @AfterEach
    public void tearDownAfterClass() throws Exception {
        System.out.println("CaculatorTest tearDownAfterClass");
    }

    @AfterAll
    public static void tearDownAfter() throws Exception {
        System.out.println("CaculatorTest tearDownAfter");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("Minh hoa @ValueSource, phuong thuc add(x,0)")
    void testAdd(int number) {
        assertEquals(number + 3, caculator.add(number, 3));
        System.out.println("Tong: " + caculator.add(number, 3));
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "5,7,12",
            "-3,3,0"
    })
    void testAdd_withCSVSource(int a, int b, int c) {
        assertEquals(c, caculator.add(a, b));
        System.out.println("Tong: " + caculator.add(a, b));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void tesAdd_withCsvFilesource(int a, int b, int c) {
        assertEquals(c, caculator.add(a, b));
        System.out.println("Tong: " + caculator.add(a, b));
    }

    @ParameterizedTest
    @MethodSource("addArgumentsProvider")
    void testAdd_withMethodSource(int a, int b, int c) {
        assertEquals(c, caculator.add(a, b));
    }
    static Stream<Arguments> addArgumentsProvider() {
        return Stream.of(
                Arguments.of(3, 4, 7),
                Arguments.of(100, 200, 300),
                Arguments.of(-1, -2, -3)
        );
    }

    @ParameterizedTest
    @EnumSource(TestOperand.class)
    void testAdd_EnumSource(TestOperand operand) {
        int x = switch (operand){
            case ONE -> 1;
            case TWO -> 2;
            case THREE -> 3;
        };
        int result = caculator.add(x, 3);
        assertEquals(x+3,result);
    }
    enum TestOperand{
        ONE,TWO,THREE
    }
}
