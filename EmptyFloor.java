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

            String line; //inicialize line
            List<String> lines = new ArrayList<>();

            while((line = bufferedReader.readLine()) !=null) {


                if(!line.matches(".*[PBGE.#].#")){
                    System.out.println(" with no caracters valid" + line);
                    continue;
                }


                //second validation
                if (containsValidLetters(line)) {
                    lines.add(line);
                }else { 
                    System.out.println("invalid line: " + line);
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
        if (line.matches (".*[PBGE.#]+.*")) {

                if (!line.contains("##") && !line.contains("..")) {
            return false; // No cumple con la condición de '#' o '..'
        }
        }
        return true;
    }
}
