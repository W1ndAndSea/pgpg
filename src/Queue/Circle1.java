package Queue;

import java.util.Scanner;

public class Circle1 {
    public static void main(String[] args) {
        CircleTest circleTest=new CircleTest(4);
        char key=' ';
        Scanner sc=new Scanner(System.in);
        boolean flag=true;
        while(flag){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key=sc.next().charAt(0);

            int fina;
            switch(key){
                case'a':
                    System.out.println("请你输入一个数");
                    int value =sc.nextInt();
                    circleTest.addQueue(value);
                    break;
                case'e':
                    sc.close();
                    flag=false;
                    break;
                case 'g':
                    try {
                        fina = circleTest.getQueue();
                        System.out.printf("取出的数据是%d\n", fina);
                    } catch (Exception var8) {
                        System.out.println(var8.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        fina = circleTest.headQueue();
                        System.out.printf("队列头的数据是%d\n", fina);
                    } catch (Exception var7) {
                        System.out.println(var7.getMessage());
                    }
                    break;
                case 's':
                    circleTest.showQueue();
            }






            }



        }


    }


class CircleTest {
    private int maxSize;
    private int[] arr;
    private int front;
    private int rear;

    public CircleTest(int MaxSize) {
        maxSize = MaxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {

        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满了哦");
        } else {
            arr[rear] = n;
            rear = (rear + 1) % maxSize;
        }


    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("列表是空的哟~");
        } else {
            for (int i = front; i < front + size(); i++) {
                System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
            }
        }
    }

    private int size() {
        return (rear + maxSize - front) % maxSize;
    }


    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("this is empty");
        } else {
            int value = arr[front];
            front = (front + 1) % maxSize;
            return value;
        }


    }


    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("this is empty!");

        } else {
            return arr[front];


        }


    }


}





