package Hot100;

public class L8 {

    public static void main(String[] args) {
        lengthOfLongestSubstring("tmmzuxt");
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] count = new int[128];
        int left=0;
        int maxLength=0;
        for (int right = 0; right < s.length(); right++) {
            char index=s.charAt(right);
            count[index]++;
            while (count[index]>1){
                char charLeft = s.charAt(left);
                count[charLeft]--;
                left++;
            }
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}
