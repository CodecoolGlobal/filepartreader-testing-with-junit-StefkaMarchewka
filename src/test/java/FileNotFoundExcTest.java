import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import java.io.FileNotFoundException;

public class FileNotFoundExcTest {

    FilePartReader reader;
    @Before
    @Disabled
    public void setup(){
        reader = new FilePartReader();
        reader.setup("test", 1, 3);
    }

    @Test(expected=FileNotFoundException.class)
    public void isExceptionThrownWhenWrongFilePath() throws Exception{
        reader = new FilePartReader();
        reader.setup("test", 1, 3);
        reader.read();
    }

}