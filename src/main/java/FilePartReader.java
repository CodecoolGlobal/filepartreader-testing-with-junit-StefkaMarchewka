import java.io.*;
import java.util.*;

public class FilePartReader {
    String filePath;
    int fromLine;
    int toLine;

    public FilePartReader(){
        toLine = 0;
        fromLine = 100;
    }

    public void setup (String filePath, Integer fromLine, Integer toLine){

        if (fromLine < 1) {
            throw new IllegalArgumentException();
        } else if (toLine < fromLine) {
            throw new IllegalArgumentException();
        } else {
            this.filePath = filePath;
            this.fromLine = fromLine - 1;
            this.toLine = toLine - 1;
        }

    }

    public String readLines (){
        String allContent = "";
        try {
            allContent = read();
        }catch (IOException exc){
            System.out.println("there is no such file");
        }
        String[] lines = allContent.split( "\n" );
        Map<Integer, String> mapWithLines = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i<lines.length; i++){
            mapWithLines.put(i, lines[i]);
        }
        for (int j = fromLine; j<=toLine; j++){
            result.append(mapWithLines.get(j)+System.lineSeparator());
        }
        return result.toString();
    }

    public String read() throws IOException {
        StringBuilder allContent = new StringBuilder();

            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null)
                allContent.append(st + System.lineSeparator());

        return allContent.toString().trim();
    }

}
