public class App {
    public static void main(String[] args) {
        FilePartReader partReader = new FilePartReader();
        partReader.setup("test.txt", 1, 1);

        FileWordAnalyzer wordAnalyzer = new FileWordAnalyzer(partReader);
        System.out.println(wordAnalyzer.getStringsWhichPalindromes());
        //System.out.println(wordAnalyzer.getWordsOrderedAlphabetically());
        //System.out.println(wordAnalyzer.getWordsContainingSubstring("no"));
    }
}
