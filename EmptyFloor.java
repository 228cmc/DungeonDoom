import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

public class EmptyFloor { 
    int width;
    int height;

    public EmptyFloor( int width, int height){
        this.width = width;
        this.height = height;
    }

    //getters and setters 
    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) { 
        this.height= height;
    }

    public  void getDimensions(String filePath){
        try{
            FileReader fileReader; //create a variable type fileReader
            fileReader = new FileReader("exampleBoard2.txt"); //asigned the variable to the new object

            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(fileReader);

            //inicialize line, lines, count for determining first line
            String line; 
            List<String> lines = new ArrayList<>();
            int count =0;

            while((line = bufferedReader.readLine()) !=null) {

                line = line.trim();//allow spaces at the beginning and end

                // first validation
                if (containsValidLetters(line)) {
                    count++;
                    if (count ==1){
                        this.width= line.length();
                        System.out.println(this.width);
                    }

                    if(this.width == line.length()) { 
                        lines.add(line);
                    }else {
                        System.err.println("invalid line because of lenght : "+line);
                    }
                } else { 
                    System.out.println("invalid line because of the characters: " + line);
                }
            }

            System.out.println("Board");

            //print the whole board to check 
            for (String l:lines) {
                System.out.println(l);
            }

            bufferedReader.close();

            System.out.println("exito");
        } catch(Exception e) {
            System.out.println("error");
        }
    }

    private boolean containsValidLetters(String line) {
        if (!line.matches("[PBGE.#]+")) {//the line has to have valid characters
            return false; 
        }
        return true;
    }
}
