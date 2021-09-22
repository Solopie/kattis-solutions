import java.util.*;

class Pokemon {
    long attack;
    long defense;
    long health;
    String id;

    public Pokemon(long a, long d, long h) {
        attack = a;
        defense = d;
        health = h;
        id = (String.valueOf(a) + d) + h;
    }

    public String toString() {
        return id;
    }
}

class CompareAttack implements Comparator<Pokemon> {
    public int compare(Pokemon a, Pokemon b) {
        if (a.attack < b.attack) {
            return 1;
        } else if (a.attack > b.attack) {
            return -1;
        } else {
            return 0;
        }
    }
}

class CompareDefense implements Comparator<Pokemon> {
    public int compare(Pokemon a, Pokemon b) {
        if (a.defense < b.defense) {
            return 1;
        } else if (a.defense > b.defense) {
            return -1;
        } else {
            return 0;
        }
    }
}

class CompareHealth implements Comparator<Pokemon> {
    public int compare(Pokemon a, Pokemon b) {
        if (a.health < b.health) {
            return 1;
        } else if (a.health > b.health) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Pokemon> bestAttack = new PriorityQueue<>(new CompareAttack());
        PriorityQueue<Pokemon> bestDefense = new PriorityQueue<>(new CompareDefense());
        PriorityQueue<Pokemon> bestHealth = new PriorityQueue<>(new CompareHealth());

        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            Pokemon temp = new Pokemon(sc.nextLong(), sc.nextLong(), sc.nextLong());
            bestAttack.add(temp);
            bestDefense.add(temp);
            bestHealth.add(temp);
        }

        HashSet<String> used = new HashSet<String>();
        for (int j = 0; j < k; j++) {
            used.add(bestAttack.poll().id);
            used.add(bestDefense.poll().id);
            used.add(bestHealth.poll().id);
        }

        System.out.println(used.size());
    }
}
