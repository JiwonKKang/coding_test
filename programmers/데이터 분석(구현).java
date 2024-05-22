import java.util.*;
class Solution {
        public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<int[]> filtered = new ArrayList<>();

        switch (ext) {
            case "code" -> {
                for (int[] datum : data) {
                    if (datum[0] < val_ext) {
                        filtered.add(datum);
                    }
                }
            }
            case "date" -> {
                for (int[] datum : data) {
                    if (datum[1] < val_ext) {
                        filtered.add(datum);
                    }
                }
            }
            case "maximum" -> {
                for (int[] datum : data) {
                    if (datum[2] < val_ext) {
                        filtered.add(datum);
                    }
                }
            }
            case "remain" -> {
                for (int[] datum : data) {
                    if (datum[3] < val_ext) {
                        filtered.add(datum);
                    }
                }
            }
        }

        Comparator<int[]> comparator = switch (sort_by) {
            case "code" -> Comparator.comparingInt(a -> a[0]);
            case "date" -> Comparator.comparingInt(a -> a[1]);
            case "maximum" -> Comparator.comparingInt(a -> a[2]);
            case "remain" -> Comparator.comparingInt(a -> a[3]);
            default -> throw new IllegalArgumentException("Invalid sort_by parameter");
        };

        filtered.sort(comparator);

        return filtered.toArray(new int[0][]);
    }
}
