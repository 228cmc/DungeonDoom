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
            fileReader = new FileReader("exampleBoard.txt"); //asigned the variable to the new object

            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(fileReader);

            String line; //inicialize line
            List<String> lines = new ArrayList<>();

            while((line = bufferedReader.readLine()) !=null) {
                if (line.matches ("[PBGE.#]+")) {
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


}