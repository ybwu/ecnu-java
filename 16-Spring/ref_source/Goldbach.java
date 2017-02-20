
public class Goldbach {
    public static void main(String[] args) { 
        int N = Integer.parseInt(args[0]);

        boolean[] isprime = new boolean[N];

        for (int i = 2; i < N; i++)
            isprime[i] = true;

        // determine primes < N using Sieve of Eratosthenes
        for (int i = 2; i * i < N; i++) {
            if (isprime[i]) {
                for (int j = i; i * j < N; j++)
                    isprime[i*j] = false;
            }
        }

        // count primes
        int primes = 0;
        for (int i = 2; i < N; i++)
            if (isprime[i]) primes++;

        System.out.println("Done tabulating primes.");

        // store primes in list
        int[] list = new int[primes];
        int n = 0;
        for (int i = 0; i < N; i++)
            if (isprime[i]) list[n++] = i;

        // check if N can be expressed as sum of two primes
        int left = 0, right = primes-1;
        while (left <= right) {
            if      (list[left] + list[right] == N) break;
            else if (list[left] + list[right]  < N) left++;
            else right--;
        }
        if (list[left] + list[right] == N)
            System.out.println(N + " = " + list[left] + " + " + list[right]);
        else
            System.out.println(N + " not expressible as sum of two primes");
    }

}
