import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.floatThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class FileWordAnalyzerTest {
    FilePartReader reader;
    FileWordAnalyzer wordAnalyzer;

    @Before
    public void setup(){
        this.reader = new FilePartReader();
        this.reader.setup("test.txt", 1, 4);
        this.wordAnalyzer = new FileWordAnalyzer(reader);
    }


    @Test
    public void areWordsSortedAlphabetically(){
        String[] arrayResult = {"abba", "another", "care", "for", "i", "i", "inside", "is", "is", "kajak", "know", "nobody", "purposes", "should", "test", "text", "that", "what", "you"};
        List<String> listResult = Arrays.asList(arrayResult);
        assertEquals(listResult, wordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    public void areWordsWithSubstringReturn(){
        String[] arrayResult= {"another", "nobody", "know"};
        List<String> expected = Arrays.asList(arrayResult);
        assertEquals(expected, wordAnalyzer.getWordsContainingSubstring("no"));
    }

    @Test
    public void arePalindromesFound(){
        String[] array = {"abba", "kajak"};
        List<String> expected = Arrays.asList(array);
        assertEquals(expected, wordAnalyzer.getStringsWhichPalindromes());
    }

    //same methods but with mock objects
    @Test
    public void areWordsWithSubstringReturnMock(){
        String linesRead = "That is another i text\n"+
                "For abba test purposes\n"+
                "should you care kajak what is inside i\n"+
                "nobody know\n"+
                "so";
        FilePartReader reader = Mockito.mock(FilePartReader.class);
        Mockito.when(reader.readLines()).thenReturn(linesRead);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);

        String[] arrayResult= {"another", "nobody", "know"};
        List<String> expected = Arrays.asList(arrayResult);
        assertEquals(expected, analyzer.getWordsContainingSubstring("no"));

    }

    @Test
    public void areWordsSortedAlphabeticallyMock(){
        String[] arrToReturn = {"another", "i", "is", "text", "that"};
        List<String> listToReturn = Arrays.asList(arrToReturn);
        String linesRead = "That is another i text";

        FilePartReader reader = Mockito.mock(FilePartReader.class);
        Mockito.when(reader.readLines()).thenReturn(linesRead);

        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        assertEquals(listToReturn, analyzer.getWordsOrderedAlphabetically());

    }

    @Test
    public void arePalindromesFoundMock(){
        String linesRead = "That is another i text"+
                            "For abba test purposes"+
                            "should you care kajak what is inside i";
        FilePartReader reader = Mockito.mock(FilePartReader.class);
        Mockito.when(reader.readLines()).thenReturn(linesRead);

        String[] array = {"abba", "kajak"};
        List<String> expected = Arrays.asList(array);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        assertEquals(expected, analyzer.getStringsWhichPalindromes());

    }

    @Test
    public void isReadLineMethodCalledInAlphabeticalSort(){
        FilePartReader mockFilePartReader = Mockito.mock(FilePartReader.class);
        when(mockFilePartReader.readLines()).thenReturn("");

        FileWordAnalyzer analyzer = new FileWordAnalyzer(mockFilePartReader);
        analyzer.getWordsOrderedAlphabetically();
        Mockito.verify(mockFilePartReader).readLines();
    }




}