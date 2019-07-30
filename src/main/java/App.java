public class App {
    public static void main(String[] args) {
        FilePartReader f = new FilePartReader();
        f.setup("test2.txt", 1, 4);
        //System.out.println(f.readLines());
        FileWordAnalyzer fa = new FileWordAnalyzer(f);
        System.out.println(fa.getWordsOrderedAlphabetically());
    }
}
