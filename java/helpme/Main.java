import java.util.*;

class PieceComparator implements Comparator<Character> {
    static ArrayList<Character> pieceOrder = new ArrayList<>(Arrays.asList('K', 'Q', 'R', 'B', 'N', 'P'));

    public int compare(Character s1, Character s2) {
        if (pieceOrder.indexOf(s1) > pieceOrder.indexOf(s2))
            return 1;
        if (pieceOrder.indexOf(s1) < pieceOrder.indexOf(s2))
            return -1;
        return 0;
    }
}

class PositionComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        // Row Compare
        if (s1.charAt(1) < s2.charAt(1))
            return 1;
        if (s1.charAt(1) > s2.charAt(1))
            return -1;

        // Col Compare
        if (s1.charAt(0) > s2.charAt(0))
            return 1;
        if (s1.charAt(0) < s2.charAt(0))
            return -1;

        return 0;
    }
}

public class Main {
    static TreeMap<Character, ArrayList<String>> white = new TreeMap<>(new PieceComparator());
    static TreeMap<Character, ArrayList<String>> black = new TreeMap<>(new PieceComparator());

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        for (int i = 8; i >= 1; i--) {
            sc.nextLine();
            String curLine = sc.nextLine();
            curLine = curLine.substring(1, curLine.length() - 1);
            String[] cols = curLine.split("\\|");
            for (int j = 0; j < cols.length; j++) {
                String col = cols[j];
                if (col.charAt(1) != ':' && col.charAt(1) != '.') {
                    addPiece(col.charAt(1), j, i);
                }
            }
        }

        for (Character c : white.keySet()) {
            Collections.sort(white.get(c), new PositionComparator());
        }

        for (Character c : black.keySet()) {
            Collections.sort(black.get(c), new PositionComparator());
        }

        System.out.print("White: ");

        for (Map.Entry<Character, ArrayList<String>> m : white.entrySet()) {
            for (int i = 0; i < m.getValue().size(); i++) {
                String s = m.getValue().get(i);
                if (m.getKey() == 'P') {
                    System.out.print(s + ",");
                } else {
                    System.out.print(m.getKey() + s + ",");
                }
            }

            // String s = m.getValue().get(m.getValue().size() - 1);
            // System.out.print(m.getKey() + s + "\n");
        }

        System.out.println();

        System.out.print("Black: ");

        for (Map.Entry<Character, ArrayList<String>> m : black.entrySet()) {
            for (int i = 0; i < m.getValue().size(); i++) {
                String s = m.getValue().get(i);

                if (m.getKey() == 'P') {
                    System.out.print(s + ",");
                } else {
                    System.out.print(m.getKey() + s + ",");
                }
            }

            // String s = m.getValue().get(m.getValue().size() - 1);
            // System.out.print(m.getKey() + s + "\n");
        }

        System.out.println();
    }

    public static void addPiece(char piece, int col, int row) {
        char colChar = (char) ('a' + col);

        if (Character.isUpperCase(piece)) {
            // White
            if (!white.containsKey(piece)) {
                white.put(piece, new ArrayList<String>());
            }
            white.get(piece).add(String.valueOf(colChar) + row);
        } else {
            // Black
            piece = Character.toUpperCase(piece);
            if (!black.containsKey(piece)) {
                black.put(piece, new ArrayList<String>());
            }
            black.get(piece).add(String.valueOf(colChar) + row);
        }
    }

}
