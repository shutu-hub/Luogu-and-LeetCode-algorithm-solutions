package BinarySearch;

import java.io.*;

public class P2249 {
    static InputStream inputStream = System.in;
    static int bufferPointer = 0;
    static int bytesRead = 0;
    static byte[] buffer = new byte[1 << 16];

    static int readInt() throws IOException {
        int c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        int res = 0;
        do {
            res = res * 10 + c - '0';
            c = read();
        } while (c >= '0' && c <= '9');
        return neg ? -res : res;
    }

    static int read() throws IOException {
        if (bufferPointer >= bytesRead) {
            bytesRead = inputStream.read(buffer);
            bufferPointer = 0;
            if (bytesRead == -1) buffer[0] = -1;
        }
        return buffer[bufferPointer++];
    }

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int m = readInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = readInt();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int x = readInt();
            int pos = binarySearch(array, x);
            sb.append(pos).append(' ');
        }
        System.out.println(sb.toString().trim());
    }

    private static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return array.length > 0 && array[left] == target ? left + 1 : -1;
    }
}