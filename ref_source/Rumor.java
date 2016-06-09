import java.util.*;
public class Rumor{

    static int propogate(int num){
        int []parent = new int[num];
        Random rand = new Random();
        int currentPerson = 1;
        int count = 1;
        while(true){
            int nextPerson = rand.nextInt(num-3)+1;
            // refine
            if (nextPerson >= Math.min(currentPerson, parent[currentPerson]))
                nextPerson += 1;
            if (nextPerson >= Math.max(currentPerson, parent[currentPerson]))
                nextPerson += 1;

            if(parent[nextPerson] == 0){
                parent[nextPerson] = currentPerson;
                count += 1;
            }
            else
                break;
            currentPerson = nextPerson;
        }
        return count;
    }

    public static void main(String []args){
        int num = Integer.parseInt(args[0]);
        int []counts = new int[num+1];
        int T = 1000;
        for (int i = 1; i <= T; ++i) {
            int count = propogate(num);
            counts[count] += 1;
        }
        double expectedCount = 0.0;
        for (int i = 1; i <= num; ++i)
            expectedCount += i*counts[i]/(double)T;
        System.out.println("Probabiliy: " + counts[num]/(double)T);
        System.out.println("Expected Count: " + expectedCount);
    }
}
