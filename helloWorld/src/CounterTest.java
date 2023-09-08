import org.junit.jupiter.api.Assertions;

class CounterTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void add() {
        // 創建被測試的對象
        Counter yourObject = new Counter(0);

        // 調用add方法並檢查返回值是否符合預期
        int result = yourObject.add();
        Assertions.assertEquals(1, result);

        // 再次調用add方法並檢查返回值是否增加了
        result = yourObject.add();
        Assertions.assertEquals(2, result);
    }
}