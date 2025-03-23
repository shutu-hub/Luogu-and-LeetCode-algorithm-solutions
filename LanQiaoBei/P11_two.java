package LanQiaoBei;
import java.io.*;


public class P11_two {
    // 左->右 上->下 左上->右下
    public static int[]dx={1,0,1};
    public static int[]dy={0,1,1};
    public static int[]num={2,0,2,0};
    static long sum=0;

    public static void main(String[] args) throws IOException {
        int[][]arrays=new int[300][300];
        InputStream stream=new FileInputStream("D:\\code\\Algorithm\\algorithm\\LanQiaoBei\\f");
        BufferedInputStream br=new BufferedInputStream(stream);
        for (int i = 0; i < 300; i++) {
            for (int j = 0; j < 300; j++) {
                int read = br.read()-'0';
                if (read==0 || read==2){
                    arrays[i][j]=read;
                }
            }
            br.read();
            br.read();
        }
        br.close();
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                if (arrays[i][j]==2){
                    // 开始搜索
                    dfs(i,j,arrays);
                }
            }
        }
        System.out.println(sum);
    }

    public static void dfs(int i,int j,int[][]arrays){
        for (int k = 0; k < 3; k++) {
            int dx1 = dx[k];
            int dy1 = dy[k];
            boolean flag=true;
            for (int l = 1; l < 4; l++) {
                // 分别向三个方向走三次
                int nx=i+l*dx1;
                int ny=j+l*dy1;
                if (nx>=300 || ny>=300 || arrays[nx][ny]!=num[l]){
                    flag=false;
                    break;
                }
            }
            if (flag){
                sum++;
            }
        }
    }
}
