package Queue;

import java.util.Scanner;

public class CirDemo {
    public static void main(String[] args) {
        Cir cir = new Cir(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);
            int res;
            switch(key) {
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    cir.addQueue(value);
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'g':
                    try {
                        res = cir.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception var8) {
                        System.out.println(var8.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        res = cir.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception var7) {
                        System.out.println(var7.getMessage());
                    }
                    break;
                case 's':
                    cir.showQueue();
            }
        }

        System.out.println("程序退出~~");
    }

    }

class Cir {
    public int[] arr;
    public int rear;
    public int front;
    public int maxSize;

    public Cir(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }


    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {

        return front == rear;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("已经满了哦");
            return;
        } else {
            arr[rear] = n;
            rear = (rear + 1) % maxSize;
        }
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("是空的哦，不可以取~~");
        } else {
            int value = arr[front];
            front = (front + 1) % maxSize;
            return value;
        }
    }

    public void showQueue() {
        if (isEmpty()){
            System.out.println("队列是空的哦~~");
        }else{

            for (int i = front; i <front+size() ; i++) {
                System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
            }
            
        }

    }

    private int size() {
        return (rear+maxSize-front)%maxSize;
    }
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        } else {
            return arr[front];
        }
    }


}