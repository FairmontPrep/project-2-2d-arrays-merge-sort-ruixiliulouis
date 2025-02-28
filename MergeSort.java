import java.util.ArrayList;

public class MergeSort {
    public static ArrayList<GamePiece> sort(ArrayList<GamePiece> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        ArrayList<GamePiece> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<GamePiece> right = new ArrayList<>(list.subList(mid, list.size()));

        return merge(sort(left), sort(right));
    }

    private static ArrayList<GamePiece> merge(ArrayList<GamePiece> left, ArrayList<GamePiece> right) {
        ArrayList<GamePiece> sortedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getValue() <= right.get(j).getValue()) {
                sortedList.add(left.get(i++));
            } else {
                sortedList.add(right.get(j++));
            }
        }

        while (i < left.size()) sortedList.add(left.get(i++));
        while (j < right.size()) sortedList.add(right.get(j++));

        return sortedList;
    }
}