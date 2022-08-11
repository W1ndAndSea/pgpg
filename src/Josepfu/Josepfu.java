package Josepfu;

public class Josepfu {
    public static void main(String[] args) {
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.addBoys(5);
        circleLinkedList.showBoys();
        System.out.println("------------------");
        circleLinkedList.countBoy(2, 2, 5);

    }
}

//船舰一个环形的单向列表
class CircleLinkedList {
    //创建一个first节点
    private Boy first = new Boy(-1);

    //添加小孩
    public void addBoys(int nums) {
        if (nums < 1) {
            System.out.println("num的值不正确哦~");
            return;
        }
        Boy curBoy = null; // 辅助指针，帮助构建环形链表
        // 使用 for 来创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号，创建小孩节点
            Boy boy = new Boy(i);
            // 如果是第一个小孩
            if (i == 1) {
                first = boy;
                first.setNext(first); // 构成环
                curBoy = first; // 让 curBoy 指向第一个小孩
            } else {
                curBoy.setNext(boy);//
                boy.setNext(first);//
                curBoy = boy;


            }
        }


    }

    public void showBoys() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("没有任何小孩哦~");
            return;
        }

        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号 %d\n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }


    }

    /**
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //先对参数进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("输出的参数有误，请重新输入哦~");
            return;
        }
        //创建辅助指针，帮助小孩完成出圈
        Boy helper = first;


        //需求创建一个辅助变量（helper），事先指向环形链表的最后一个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }


        //小孩报数前 先让first和helper移动start-1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();

        }

        //当小孩报数时，让 first和helper指针同时移动count-1次，然后出圈
        //直到圈中还有有一个小孩为止
        while (true) {
            if (helper == first) {
                break;
            }

            //让first和helper指针同时移动countNum-1
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first、指向的节点就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            //这时将first指向小孩节点出圈
            first = first.getNext();
            helper.setNext(first);

        }
        System.out.printf("最后留在圈中的小孩编号%d\n", first.getNo());


    }

}


class Boy {
    private int no;//编号
    private Boy next;//指向下一个节点，默认为null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}