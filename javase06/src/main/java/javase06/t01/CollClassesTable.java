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
        System.out.println("                 Ordering   |   Random    | Key-Value  |   Allows    | Allows Null |   Thread   |  Blocking ");
        System.out.println("                            |   Access    |   Pairs    | Duplicates  |    Values   |    Safe    | Operations");
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        Map<String, List<Integer>> table = new HashMap<>();

        for (String s : table.keySet()) {
            System.out.printf(s);
            for (Integer i : table.get(s)) {
                System.out.printf("    |     %s ", (i == 1 ? "Yes" : "No"));
            }
            System.out.println();
        }
    }
}
