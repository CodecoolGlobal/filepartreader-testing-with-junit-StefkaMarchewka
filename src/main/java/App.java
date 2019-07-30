public class App {
    public static void main(String[] args) {
        FilePartReader partReader = new FilePartReader();
        partReader.setup("test2.txt", 1, 25);

        FileWordAnalyzer wordAnalyzer = new FileWordAnalyzer(partReader);
        System.out.println(wordAnalyzer.getWordsContainingSubstring("oo"));
    }
}
