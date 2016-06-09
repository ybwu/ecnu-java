import java.io.*;
import java.util.*;

public class Cat{
    public static void main(String[] args) { 
        try { 
            for (String fn: args){
                BufferedReader bf = new BufferedReader(new FileReader(fn));
                String line = null;
                while((line = bf.readLine()) != null)
                    System.out.println(line);
                bf.close();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
