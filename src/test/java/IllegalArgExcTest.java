import org.junit.Before;
import org.junit.Test;


public class IllegalArgExcTest {
    FilePartReader reader;

    @Before
    public void setup(){
        reader = new FilePartReader();
    }

    @Test(expected = IllegalArgumentException.class)
    public void isExceptionThrownWhenSecondValueSmaller(){
        reader.setup("test", 3, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isExceptionThrownWhenFirstValueBelowOne(){
        reader.setup("test.txt", 0, 1);
    }



}