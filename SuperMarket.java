package Codevita;

import java.util.*;

public class SuperMarket {
    public static int MaxBagsSold(int n, int m, List<Pair> dealer, List<Pair> x) {
        Collections.sort(dealer, (a, b) -> Integer.compare(b.secondone, a.secondone));
        Collections.sort(x, (a, b) -> Integer.compare(b.secondone, a.secondone));

        int b = 0;
        int i = 0;

        for (Pair c : dealer) {
            while (i < m && x.get(i).secondone > c.secondone) {
                i++;
            }

            if (i < m && x.get(i).firstone >= c.firstone) {
                b++;
                i++;
            }
        }

        return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Pair> dealer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int firstone = scanner.nextInt();
            int secondone = scanner.nextInt();
            dealer.add(new Pair(firstone, secondone));
        }

        List<Pair> x = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int firstone = scanner.nextInt();
            int secondone = scanner.nextInt();
            x.add(new Pair(firstone, secondone));
        }

        int ans = MaxBagsSold(n, m, dealer, x);
        System.out.print(ans);
    }

    static class Pair {
        int firstone, secondone;

        Pair(int firstone, int secondone) {
            this.firstone = firstone;
            this.secondone = secondone;
        }
    }
}
