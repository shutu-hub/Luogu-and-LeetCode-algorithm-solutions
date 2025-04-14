package RuMen;

public class LintCode1243 {
    public static void main(String[] args) {
        int i = countSegments("\"d kaj slj fa'flka ;l ;a lkas a ;sa kl; lkd;k   k; ksa; k; k ;aksldkls;c,  ,s.dad\"");
        System.out.println(i);
    }

    public static int countSegments(String s) {
        if (s.isEmpty()){
            return 0;
        }
        String[] s1 = s.split(" ");
        int count=0;
        for (String ele : s1) {
            if (ele.isEmpty()){
                count++;
            }
        }
        return s1.length-count;
    }
}
