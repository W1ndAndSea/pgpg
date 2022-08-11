package SparseArray;

public class Test {
    public static void main(String[] args) {
        int[][] chess = new int[11][11];
        chess[1][1] = 22;
        chess[2][2] = 33;
        chess[3][3] = 44;
        chess[4][4] = 55;
        chess[8][8] = 99;

        //输出原本的二维数组
        System.out.println("this is orginal");

        for (int[] row : chess) {
            for (int value : row) {
                System.out.printf("%d\t", value);

            }
            System.out.println();

        }
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chess[i][j] != 0) {
                    sum++;
                }

            }

        }

        //创建稀疏数组

        int[][] sp = new int[sum + 1][3];
        sp[0][0] = 11;
        sp[0][1] = 11;
        sp[0][2] = sum;

        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chess[i][j] != 0) {
                    count++;
                    sp[count][0] = i;
                    sp[count][1] = j;
                    sp[count][2] = chess[i][j];
                }

            }

        }
        System.out.println();
        System.out.println("稀疏数组为");
        for (int i = 0; i < sp.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sp[i][0], sp[i][1], sp[i][2]);
        }
        System.out.println();


        //稀疏数组转换为原数组

        int chess2[][] = new int[sp[0][0]][sp[0][1]];

        for (int i = 1; i < sp.length; i++) {
            chess2[sp[i][0]][sp[i][1]] = sp[i][2];

            System.out.println();
            System.out.println("这是原本的数组");

            for (int[] row : chess2) {
                for (int data : row) {
                    System.out.printf("%d\t", data);
                }
                System.out.println();

            }


        }

    }
}
