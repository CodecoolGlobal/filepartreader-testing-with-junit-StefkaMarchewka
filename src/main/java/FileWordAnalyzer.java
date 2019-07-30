import java.util.*;

public class FileWordAnalyzer {
    FilePartReader partReader;

    public FileWordAnalyzer(FilePartReader partReader){
        this.partReader = partReader;
    }

    public List getWordsOrderedAlphabetically (){
        List<String> result;
        String toProcess = partReader.readLines().replaceAll("\n", " ").toLowerCase();
        String[] wordFromLine = toProcess.split(" ");

        result = Arrays.asList(wordFromLine);
        Collections.sort(result);
        return result;
    }

    public List getWordsContainingSubstring (String subString ){
        List<String> result = new ArrayList<>();
        String toProcess = partReader.readLines().replaceAll("\n", " ").toLowerCase();
        String[] wordFromLine = toProcess.split(" ");

        for (String word:wordFromLine) {
            if (word.contains(subString)){
                result.add(word);
            }
        }

        return result;
    }


}
