package Josepfu;

public class CircleTest {
    public static void main(String[] args) {
        CircleLinkedList circleLinkedList=new CircleLinkedList();
        circleLinkedList.addBoys(5);
        circleLinkedList.showBoys();
        circleLinkedList.countBoy(1,2,5);


    }
}

class CirLinked {
    //先定义一个first节点
    private kids first = new kids(-1);

    //添加小孩
    public void addKids(int nums) {
        if (nums < 1) {
            System.out.println("害羞羞~这~不对吧");
            return;
        }
        //辅助指针 帮助构建环形链表
        kids cur = null;

        for (int i = 1; i <= nums; i++) {
            //构建小孩节点
            kids kid = new kids(i);
            if (i == 1) {
                first = kid;
                first.setNext(first);
                cur = first;
            } else {
                cur.setNext(kid);
                kid.setNext(first);
                cur = kid;
            }

        }


    }

    public void showKids() {
        if (first == null) {
            System.out.println("没有小孩哦~");
            return;
        }
        kids cur = first;
        while (true) {
            System.out.printf("小孩的编号%d\n", cur.getNo());
            break;
        }
        cur = cur.getNext();
    }

    public void countKids(int startNums, int countNums, int nums) {
        if (first == null || startNums < 1 || startNums > nums) {
            System.out.println("you gonna check it again~~");
            return;
        }
        kids helper = null;
        //让它指向最后一个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();

        }
        //小孩报数前 先移动count—1次
        for (int i = 0; i < startNums - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //小孩开始报数时 first和helper同时移动strat-1次 直到圈中还有一个小孩为止
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            for (int i = 0; i < countNums - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时 first指向的小孩就是那个要出圈的
            System.out.printf("小孩%d出圈\n", first.getNo());


            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d\n", first.getNo());

    }

}

class kids {
    private int no;
    private kids next;//定义指向下一个节点

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public kids getNext() {
        return next;
    }

    public void setNext(kids next) {
        this.next = next;
    }

    public kids(int no) {
        this.no = no;


    }


}