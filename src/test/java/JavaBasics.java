import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaBasics {
    @Test
    public void javaBasic() {

        int a = 12;
        int b = 11;

        //int c = sumDigits(11, 10);
        int d = sumDigits(a, b);

        //System.out.println("Sum is:" + c);
        System.out.println("Sum is:" + d);
        Assertions.assertEquals(23, d, "Sum is not correct!");

    }

    private int sumDigits (int a, int b)
    {
        return a + b;
    }
    }
