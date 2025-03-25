package LanQiaoBei.P10;

public class one {
    public static void main(String[] args) {
        int[][]array=new int[21][6];
        array[1][1]=97; array[1][2]=90;
        array[2][1]=92; array[2][2]=85;array[2][3]=96;
        array[3][5]=93;
        array[4][4]=80;array[4][5]=86;
        array[5][1]=89;array[5][2]=83;array[5][3]=97;
        array[6][1]=82;array[6][2]=86;
        array[7][4]=87;array[7][5]=90;
        array[8][2]=97;array[8][3]=96;
        array[9][3]=89;
        array[10][1]=95;array[10][2]=99;
        array[11][3]=96;array[11][4]=97;
        array[12][4]=93;array[12][5]=98;
        array[13][1]=94;array[13][2]=91;
        array[14][2]=83;array[14][3]=87;
        array[15][3]=98;array[15][4]=97;array[15][5]=98;
        array[16][4]=93;array[16][5]=86;
        array[17][1]=98;array[17][2]=83;array[17][3]=99;array[17][4]=98;array[17][5]=81;
        array[18][1]=93;array[18][2]=87;array[18][3]=92;array[18][4]=96;array[18][5]=98;
        array[19][4]=89;array[19][5]=92;
        array[20][2]=99;array[20][3]=96;array[20][4]=95;array[20][5]=81;
        long max=0;
        for (int i = 1; i <=20 ; i++) {
            for (int j = 1; j <=20 ; j++) {
                for (int k = 1; k <=20 ; k++) {
                    for (int l = 1; l <=20 ; l++) {
                        for (int m = 1; m <=20 ; m++) {
                            if (i!=j && i!=k && i!=l && i!=m && j!=k && j!=l && j!=m && k!=l && k!=m && l!=m ){
                                int sum=array[i][1]+array[j][2]+array[k][3]+array[l][4]+array[m][5];
                               if (sum>max){
                                   System.out.println(array[i][1]+","+array[j][2]+","+array[k][3]+","+array[l][4]+","+array[m][5]);
                               }
                                max=Math.max(max,sum);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}
