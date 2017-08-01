package javase06.t01;

import java.util.*;

public class CollClassesTable {
    public static void main(String[] args) {
        printCollectionsTable();
    }

    private static void printCollectionsTable() {
        System.out.println("               Ordering   |   Random   | Key-Value  |   Allows   | Allows Null|   Thread   |  Blocking ");
        System.out.println("                          |   Access   |   Pairs    | Duplicates |    Values  |    Safe    | Operations");
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        Map<String, List<Integer>> table = new LinkedHashMap<>();

        table.put("ArrayList    ", Arrays.asList(1, 1, 0, 1, 1, 0, 0));
        table.put("LinkedList   ", Arrays.asList(1, 1, 0, 1, 1, 0, 0));
        table.put("Vector       ", Arrays.asList(1, 1, 0, 1, 1, 1, 0));
        table.put("Stack        ", Arrays.asList(1, 0, 0, 1, 1, 1, 0));
        table.put("HashMap      ", Arrays.asList(0, 1, 1, 0, 1, 0, 0));
        table.put("TreeMap      ", Arrays.asList(1, 1, 1, 0, 1, 0, 0));
        table.put("LinkedHashMap", Arrays.asList(1, 1, 1, 0, 1, 0, 0));
        table.put("HashSet      ", Arrays.asList(0, 1, 0, 0, 1, 0, 0));
        table.put("TreeSet      ", Arrays.asList(1, 1, 0, 0, 1, 0, 0));
        table.put("LinkedHashSet", Arrays.asList(0, 1, 0, 0, 1, 0, 0));

        for (String s : table.keySet()) {
            System.out.printf(s);
            for (Integer i : table.get(s)) {
                System.out.printf("   |     %s ", (i == 1 ? "Yes" : "No "));
            }
            System.out.println();
        }
    }
}
