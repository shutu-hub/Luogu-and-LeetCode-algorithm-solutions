package Hot100;

public class L60 {

    static int[]dx = {0,0,1,-1};
    static int[]dy = {1,-1,0,0};

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {
        char c = word.charAt(0);
        boolean[][] flags = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]==c && !flags[i][j]){
                    boolean digui = digui(board, word, i, j, 0, flags);
                    if (digui){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean  digui(char[][] board, String word, int i, int j,int start,boolean[][] flags){
        if (board[i][j]!=word.charAt(start)){
            return false;
        }
        flags[i][j] = true;
        if (start==word.length()-1){
            return true;
        }
        // 从(i,j)开始，向四周搜索下一个单词
        for (int k = 0; k < dx.length; k++) {
            int xx= i+dx[k];
            int yy= j+dy[k];
            if (xx < 0 || xx>=board.length || yy<0 || yy>=board[0].length || flags[xx][yy]){
                continue;
            }
            boolean res = digui(board, word, xx, yy, start + 1, flags);
            if (res){
                return true;
            }
        }
        // 这个元素的四周都搜索过了，该元素无法找到有效路径，则退回到上一步并归回该元素的状态
        flags[i][j]=false;
        return false;
    }
}
