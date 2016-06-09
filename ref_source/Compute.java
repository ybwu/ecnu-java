import java.io.*;
import java.util.*;

public class Compute{
    public static double[] buildData(String fn) {
        ArrayList<Double> r = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(fn));
            String line = null;
            while((line = br.readLine()) != null) 
                r.add(Double.parseDouble(line));
            br.close();
        }
        catch (Exception e){
            System.err.println(e);
        }

        double []data = new double[r.size()];
        for (int i = 0; i < r.size(); ++i)
            data[i] = r.get(i);
        return data;
    }
    public static void main(String[] args) { 
        double []data = buildData(args[0]);
        //System.out.println(data);
        System.out.println(Statistic.max(data));
        System.out.println(Statistic.min(data));
        System.out.println(Statistic.mean(data));
        System.out.println(Statistic.variance(data));
        System.out.println(Statistic.select(data, data.length-1));
    }
}
