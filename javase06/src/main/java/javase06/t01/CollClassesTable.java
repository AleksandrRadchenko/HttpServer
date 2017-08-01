package javase06.t01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollClassesTable {
    public static void main(String[] args) {
        printCollectionsTable();
    }

    private static void printCollectionsTable() {
        System.out.println("               Ordering   |   Random   | Key-Value  |   Allows   | Allows Null|   Thread   |  Blocking ");
        System.out.println("                          |   Access   |   Pairs    | Duplicates |    Values  |    Safe    | Operations");
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        Map<String, List<Integer>> table = new HashMap<>();

        table.put("ArrayList ", Arrays.asList(1, 1, 0, 1, 1, 0, 0));
        table.put("LinkedList", Arrays.asList(1, 1, 0, 1, 1, 0, 0));
        table.put("Vector    ", Arrays.asList(1, 1, 0, 1, 1, 1, 0));
        table.put("Stack     ", Arrays.asList(1, 0, 0, 1, 1, 1, 0));

        for (String s : table.keySet()) {
            System.out.printf(s);
            for (Integer i : table.get(s)) {
                System.out.printf("   |     %s ", (i == 1 ? "Yes" : "No "));
            }
            System.out.println();
        }
    }
}
