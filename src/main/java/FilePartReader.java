import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class FilePartReader {
    String filePath;
    int fromLine;
    int toLine;

    public FilePartReader(){

    }


    public static void main(String[] args) {
        FilePartReader f = new FilePartReader();
        f.setup("test2.txt", 1, 2);
        System.out.println(f.read());
    }

    public void setup (String filePath, Integer fromLine, Integer toLine){
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;

    }

    public String readLines (){
        String allContent = read();
        String[] lines = allContent.split( "\n" );
        ArrayList<String> linesList = new ArrayList<String>(Arrays.asList(lines));
        int lineIndex = 0;
        Iterator iterator = linesList.iterator();
        while (iterator.hasNext()){
             //ponumerowac line
        }
        return "";
    }

    public String read () {
        StringBuilder allContent = new StringBuilder();
        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;

            while ((st = br.readLine()) != null)
                allContent.append(st + System.lineSeparator());
        }catch (IOException exc){
            exc.printStackTrace();
        }
        return allContent.toString();
    }

    //should I make seeter or set alle variables in setup method?
//    public void setFilePath(String filePath) {
//        this.filePath = filePath;
//    }
}
