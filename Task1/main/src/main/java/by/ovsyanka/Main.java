package by.ovsyanka;

import by.ovsynka.BinarySearch;

public class Main {

    public static void main(String[] args) {
        int index = BinarySearch.recursiveBinarySearch(new int[]{1, 2, 3, 5, 8, 13, 21, 44, 65, 99}, 0, 10, 3);
        System.out.println(index);
    }
}
