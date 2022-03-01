import org.junit.Test;


public class FlikTest {
    @Test
    public void testFlik() {
        int i = 0;
        for (i = 0; i < 500; ++i) {
            if (!Flik.isSameNumber(i, i)) {
                break; // break exits the for loop!
            }
        }
        System.out.println("i is " + i);

    }
}

