package SparseArray;

public class Te {

    public static void main(String[] args) {
    int [][]chess1=new int[11][11];

    chess1[1][1]=11;
    chess1[2][2]=22;
    chess1[3][3]=33;
    chess1[4][4]=44;
    chess1[5][5]=55;
        System.out.println("this is oraginal");

        for (int[]row:chess1) {
            for (int data:row) {
                System.out.printf("%d\t",data);

            }
            System.out.println();
        }

        //转换为稀疏数组

        int sum=0;
        for (int i = 0; i <11; i++) {
            for (int j = 0; j <11; j++) {
                if (chess1[i][j]!=0){
                    sum++;

                }

            }

        }


        //定义稀疏数组
        int[][]arr=new int[sum+1][3];
        arr[0][0]=11;
        arr[0][1]=11;
        arr[0][2]=sum;

        //开始遍历
        int count=0;
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j <11 ; j++) {
                if (chess1[i][j]!=0){
                    count++;
                    arr[count][0]=i;
                    arr[count][1]=j;
                    arr[count][2]=chess1[i][j];
                }
            }
        }
        //准备打印稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组是~~");
        for (int i = 0; i < arr.length ; i++) {
            System.out.printf("%d\t%d\t%d\t\n",arr[i][0],arr[i][1],arr[i][2]);

        }
        System.out.println();



        //开始还原


        int[][]chess2=new int[arr[0][0]][arr[0][1]];

        //从第二行开始读取

        for (int i = 1; i < arr.length ; i++) {
            chess2[arr[i][0]][arr[i][1]]=arr[i][2];
        }
        //恢复之后的数组
        System.out.println();
        System.out.println("恢复之后的数组");
        for (int[]row:chess2) {
            for (int data:row)
            {
                System.out.printf("%d\t",data);

            }
            System.out.println();
        }

    }
}




