import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Timeout;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FilePartReaderTest {
    FilePartReader fileReader;

    @Before
    public void setup(){
        fileReader = new FilePartReader();
        fileReader.setup("test.txt", 1, 3);
    }

//    @Test
//    @Disabled
//    @Ignore
//    public void testIsDataReadFromFile(){
//        String expected = "That is another i text\n"+
//        "For abba test purposes\n"+
//        "should you care kajak what is inside i\n"+
//        "nobody know\n"+
//        "so";
//        assertEquals(expected, fileReader.read());
//    }

    @Test
    public void testDoesChosenLinesAreRead(){
        String expected = "That is another i text\n"+
                "For abba test purposes\n"+
                "should you care kajak what is inside i\n";
        assertEquals(expected, fileReader.readLines());
    }

    @Test(expected = NullPointerException.class)
    public void isNullPointerThrown(){
        fileReader.setup("test.txt", null, 1);
    }

    @Test
    public void isReadMethodCalledInReadLines(){
        FilePartReader fileReaderMock = Mockito.spy(FilePartReader.class);
        fileReaderMock.setup("test.txt", 1, 3);
        fileReaderMock.readLines();
        try {
            Mockito.verify(fileReaderMock).read();
        }catch(IOException exc){
            System.out.println("IOException");
        }
    }



}