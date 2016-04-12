import java.awt.Color;
public class Scale{
    public static void main(String []args){
       int w = Integer.parseInt(args[0]); 
       int h = Integer.parseInt(args[1]); 
       Picture p = new Picture(args[2]);
       Picture q = new Picture(w, h);
       for (int i = 0; i < w; ++i){
           for (int j = 0; j < h; ++j){
               Color c = p.get(i*p.width()/w, j*p.height()/h);
               q.set(i, j, c);
       }
    }
    q.show();
    }
}
