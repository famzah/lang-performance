import java.util.*;
import java.lang.Math;

class PrimeNumbersGenerator {
    List<Integer> get_primes7(int n) {
        List<Integer> res = new LinkedList<Integer>();

        if (n < 2) return res;
        if (n == 2) {
            res.add(2);
            return res;
        }
        List<Integer> s = new ArrayList<Integer>();
        for (int i = 3; i < n + 1; i += 2) {
            s.add(i);
        }
        int mroot = (int) Math.sqrt(n);
        int half = s.size();
        int i = 0;
        int m = 3;
        while (m <= mroot) {
            if (s.get(i) != 0) {
                int j = (int) ((m * m - 3) / 2);
                s.set(j, 0);
                while (j < half) {
                    s.set(j, 0);
                    j += m;
                }
            }
            i = i + 1;
            m = 2 * i + 3;
        }
        res.add(2);
        for (int it = 0; it < s.size(); ++it) {
            if (s.get(it) != 0) {
                res.add(s.get(it));
            }
        }

        return res;
    }
}

class PrimeNumbersBenchmarkApp {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long periodTime = Long.parseLong(System.getenv("RUN_TIME"), 10) * 1000;

        List<Integer> res;

        while ((System.currentTimeMillis() - startTime) < periodTime) {
            res = (new PrimeNumbersGenerator()).get_primes7(10000000);
            System.out.format("Found %d prime numbers.\n", res.size());
        }
    }
}
