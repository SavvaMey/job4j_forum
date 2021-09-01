import org.junit.Test;

import static org.junit.Assert.*;

public class AppForTestTest {

    @Test
    public void testThenGetOneReturnOne () {
        AppForTest app = new AppForTest();
        assertEquals(app.get(), 1);
    }

}