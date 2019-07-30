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

    public List getStringsWhichPalindromes (){
        List<String> result = new ArrayList<>();
        String toProcess = partReader.readLines().replaceAll("\n", " ").toLowerCase();
        String[] wordFromLine = toProcess.split(" ");
        for (String word: wordFromLine){
            Optional<String> firstHalf = Optional.empty();
            Optional<String> secondHalf = Optional.empty();
            if ((word.length())%2 == 0 && !(word.equals(""))){
                firstHalf = Optional.of(word.substring(0, word.length()/2));
                secondHalf = Optional.of(word.substring(word.length()/2));
            }
            else {
                if (word.length() > 1) {
                    firstHalf = Optional.of(word.substring(0, word.length() / 2));
                    secondHalf = Optional.of(word.substring(word.length() / 2 + 1));
                }
                else {
                    firstHalf = Optional.of("");
                    secondHalf = Optional.of(" ");
                }
            }
            String reversedSecond = new StringBuilder(secondHalf.get()).reverse().toString();
            if (firstHalf.get().equals(reversedSecond)){
                result.add(word);
            }
        }

        return result;
    }


}
