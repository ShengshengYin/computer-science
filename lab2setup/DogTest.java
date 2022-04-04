import static org.junit.Assert.*;
import org.junit.Test;

public class DogTest {
    @Test
    public void testSmall() {
        Dog d = new Dog(5);
        assertEquals("yip", d.noise());

    }

    @Test
    public void testLarge() {
        Dog d = new Dog(30);
        assertEquals("bark", d.noise());
    }
}
