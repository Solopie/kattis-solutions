import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            int b = sc.nextInt();
            if (n == -1)
                break;

            PriorityQueue<City> pq = new PriorityQueue<>();
            while (n-- > 0) {
                b--;
                pq.add(new City(sc.nextInt(), 1));
            }

            while (b-- > 0) {
                City c = pq.poll();
                c.ballotBoxes++;
                if (c.population % c.ballotBoxes != 0)
                    c.currPop = (c.population / c.ballotBoxes) + 1;
                else
                    c.currPop = (c.population / c.ballotBoxes);
                pq.add(c);
            }
            // System.out.println(pq.toString());
            System.out.println(pq.peek().currPop);
        }
    }

    private static class City implements Comparable<City> {
        int population, ballotBoxes, currPop;

        public City(int p, int b) {
            population = p;
            ballotBoxes = b;
            currPop = p;
        }

        public int compareTo(City o) {
            return o.currPop - currPop;
        }

        public String toString() {
            return population + " " + ballotBoxes + " " + currPop;
        }
    }
}
