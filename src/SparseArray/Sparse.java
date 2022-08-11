package SparseArray;

public class Sparse {
    public static void main(String[] args) {
        int[][] chess1 = new int[11][11];
        chess1[0][0] = 11;
        chess1[1][1] = 22;
        chess1[2][2] = 33;
        chess1[3][3] = 44;
        chess1[4][4] = 55;


        //准备打印
        System.out.println("这是原本的二维数组");


        for (int[] row : chess1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
//准备转换为稀疏数组
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chess1[i][j] != 0) {
                    sum++;

                }

            }

        }

        int[][] arr = new int[sum + 1][3];
        arr[0][0] = 11;
        arr[0][1] = 11;
        arr[0][2] = sum;

        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chess1[i][j] != 0) {
                    count++;
                    arr[count][0] = i;
                    arr[count][1] = j;
                    arr[count][2] = chess1[i][j];
                }
            }
        }
        System.out.println("稀疏矩阵");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", arr[i][0], arr[i][1], arr[i][2]);
        }
        System.out.println();


        //恢复成原本的二位数组
        int[][] chess2 = new int[arr[0][0]][arr[0][1]];

        //从第二行开始起 找到不为零的数 放入二维数组中
        for (int i = 1; i < arr.length; i++) {
            chess2[arr[i][0]][arr[i][1]] = arr[i][2];

        }
        System.out.println();
        System.out.println("这是恢复之后的二维数组");
        for (int[] row :
                chess2) {
            for (int data:row
                 ) {
                System.out.printf("%d\t",data);

            }
            System.out.println();

        }


    }


}
