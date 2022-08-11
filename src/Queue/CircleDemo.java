package Queue;

import java.util.Scanner;

public class CircleDemo {
    public static void main(String[] args) {
        Circle circle=new Circle(4);
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
                    circle.addQueue(value);
                    break;
                case 'e':
                    sc.close();
                    flag = false;
                    break;
                case 'g':
                    try {
                        fina = circle.getQueue();
                        System.out.printf("取出的数据是%d\n", fina);
                    } catch (Exception var8) {
                        System.out.println(var8.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        fina = circle.headQueue();
                        System.out.printf("队列头的数据是%d\n", fina);
                    } catch (Exception var7) {
                        System.out.println(var7.getMessage());
                    }
                    break;
                case 's':
                    circle.showQueue();
            }



            }

        }


    }


class Circle {
    private int maxSize;
    private int[] arr;
    private int front;
    private int rear;

    public Circle(int arrMaxSize) {
        maxSize = arrMaxSize;
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
            System.out.println("队列满，不能加入数据~");
        } else {

            arr[rear] = n;
            rear = (rear + 1) % maxSize;
        }
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空,不能取数据");
        } else {
            int value = arr[front];
            front = (front + 1) % maxSize;
            return value;


        }


    }

    public void showQueue() {
        if (isEmpty()) {

            System.out.println("队列是空的哦");

        } else {
            for (int i = front; i < front + size(); i++) {
                System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);

            }

        }


    }

    private int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("this is empty!");

        } else {
            return arr[front];


        }


    }


}