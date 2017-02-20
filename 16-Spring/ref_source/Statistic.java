import java.util.*;

public class Statistic{

    public static double max(double []a) { 
        double r = a[0];
        for (int i = 0; i < a.length; ++i) {
            if (a[i] > r) 
                r = a[i];
        }
        return r;
    }

    public static double min(double []a) { 
        double r = a[0];
        for (int i = 0; i < a.length; ++i) {
            if (a[i] < r) 
                r = a[i];
        }
        return r;
    }

    public static double mean(double []a) { 
        double r = 0;
        for (int i = 0; i < a.length; ++i)
            r += a[i];
        return r/a.length;
    }

    public static double variance(double []a) { 
        double m = mean(a);
        double r = 0;
        for (int i = 0; i < a.length; ++i)
            r += (a[i]-m)*(a[i]-m);
        return Math.sqrt(r)/a.length;
    }

    public static double select(double []a, int k) { 
        if (k > a.length){
            System.err.println("k should be less than array length");
            System.exit(1);
        }
        double b[] = new double[a.length];
        for (int i = 0; i < a.length; ++i)
            b[i] = a[i];
        Arrays.sort(b);
        return b[k];
    }

    public static int count(double []a, double k) { 
        int r = 0; 
        for (int i = 0; i < a.length; ++i)
            if(a[i] == k)
                r += 1;
        return r;
    }

    public static int[] histogram(double []a) { 
        int b[] = new int[a.length];
        for (int i = 0; i < a.length; ++i)
            b[i] = count(a, a[i]);
        return b;
    }
}
