abstract class Circuit {  
    public abstract double resistance();
}

class SingleResistor extends Circuit{
    double value;
    public SingleResistor(double v){
        value = v;
    }
    public double resistance(){
        return value;
    }
}

class ParallelNetwork extends Circuit{
    private Circuit a;
    private Circuit b;

    public ParallelNetwork (Circuit a, Circuit b){
        this.a = a;
        this.b = b;
    }

    public double resistance(){
        double ra = a.resistance();
        double rb = b.resistance();
        return 1.0/(1.0/ra + 1.0/rb);
    }
}

class SeriesNetwork extends Circuit{
    private Circuit a;
    private Circuit b;

    public SeriesNetwork (Circuit a, Circuit b){
        this.a = a;
        this.b = b;
    }

    public double resistance(){
        double ra = a.resistance();
        double rb = b.resistance();
        return ra+rb;
    }
}

class CircuitFactory{

   public static Circuit buildCircuit(String s){
       return buildCircuit(s, 0, s.length());
   }

   private static Circuit buildCircuit(String s, int start, int end){
      // System.out.println("start:"+start + " end:"+end);
      int middle = findMiddle(s, start, end);
      if (middle == -1)
          return new SingleResistor(Double.parseDouble(s.substring(start, end)));
      else {
          int aStart = findNextComma(s, start, middle)+1;
          int aEnd = s.charAt(middle-1) == ')'?middle-1:middle;
          Circuit a = buildCircuit(s, aStart, aEnd);

          int bStart = middle+1;
          int bEnd = s.charAt(end-1) == ')'?end-1:end;;
          Circuit b = buildCircuit(s, bStart, bEnd);

          if (s.charAt(start+1) == '-')
              return new SeriesNetwork(a, b);
          else
              return new ParallelNetwork(a, b);
      }
   }

   private static int findMiddle(String s, int start, int end){
       int nextComma = findNextComma(s, start, end);
       if (nextComma == -1)
           return -1;
       if (s.charAt(nextComma+1) == '('){
           int count = 1;
           for (int i = nextComma+2; i < end; ++i){
               if (s.charAt(i) == '(')
                   count += 1;
               else if (s.charAt(i) == ')')
                   count -= 1;
               else
                   continue;
               if (count == 0)
                   return i+1;
           }
           return -1;
       }
       else
           return findNextComma(s, nextComma+1, end);
   }

   private static int findNextComma(String s, int from, int to){
       for(int i = from; i < to; ++i){
           if (s.charAt(i) == ',')
               return i;
       }
       return -1;
   }
}

public class CircuitNetwork{
    public static void main(String []args){
        Circuit c = CircuitFactory.buildCircuit(args[0].replaceAll(" ", ""));
        System.out.println(c.resistance());
    }
}
