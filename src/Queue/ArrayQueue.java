package Queue;

import java.util.Scanner;
//存在问题  数组只可以使用一次
public class ArrayQueue {
        private int maxSize;
        private int front;
        private int rear;
        private int[] arr;

        public ArrayQueue(int arrMaxSize) {
            maxSize = arrMaxSize;
            arr = new int[maxSize];
            front = -1;
            rear = -1;
        }

        public boolean isFull() {
            return rear == maxSize - 1;
        }

        public boolean isEmpty() {
            return rear == front;
        }

        public void addQueue(int n) {
            if (isFull()) {
                System.out.println("队列满，不能加入数据~");
            } else {
                ++rear;
                arr[rear] = n;
            }
        }

        public int getQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列空，不能取数据");
            } else {
                ++front;
                return arr[front];
            }
        }

        public void showQueue() {
            if (isEmpty()) {
                System.out.println("队列空的，没有数据~~");
            } else {
                for(int i = 0; i < arr.length; ++i) {
                    System.out.printf("arr[%d]=%d\n", i, arr[i]);
                }

            }
        }

        public int headQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列空的，没有数据~~");
            } else {
                return arr[front + 1];
            }
        }
    }
class ArrayQueueDemo{

    public ArrayQueueDemo() {
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
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
                    queue.addQueue(value);
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'g':
                    try {
                        res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception var8) {
                        System.out.println(var8.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception var7) {
                        System.out.println(var7.getMessage());
                    }
                    break;
                case 's':
                    queue.showQueue();
            }
        }

        System.out.println("程序退出~~");
    }









}
