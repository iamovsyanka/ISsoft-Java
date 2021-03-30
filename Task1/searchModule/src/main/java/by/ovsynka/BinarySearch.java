package by.ovsynka;

public class BinarySearch {

    public static int recursiveBinarySearch(int[] arr, int start, int end, int elementToSearch) {
        if (end >= start) {
            SimpleLogger.writeLog("Binary search start = " + start + ", end = " + end + "\n" );
            int mid = start + (end - start) / 2;

            if (arr[mid] == elementToSearch) {
                return mid;
            }

            return arr[mid] > elementToSearch ?
                    recursiveBinarySearch(arr, start, mid - 1, elementToSearch) :
                    recursiveBinarySearch(arr, mid + 1, end, elementToSearch);
        }

        return -1;
    }
}
