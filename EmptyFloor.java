import java.io.BufferedReader;
import java.io.FileReader;

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

            bufferedReader.close();

            System.out.println("exito");
        } catch(Exception e) {
            System.out.println("error");
        }
    }


}