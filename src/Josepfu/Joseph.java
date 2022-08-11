package Josepfu;

public class Joseph {
    public static void main(String[] args) {


    }
}

class CircleLinkedList1 {
    //先定义一个first
    private Kids first = new Kids(-1);

    public void addKids(int nums) {
        if (nums < 1) {
            System.out.println("这这这，人数不对吧");
            return;
        }
        Kids cur = null;
        for (int i = 1; i < nums; i++) {
            Kids kids = new Kids(i);

            if (i == 1) {
                first = kids;
                cur.setNext(first);
                cur = first;
            } else {
                cur.setNext(kids);
                kids.setNext(first);
                cur = kids;

            }

        }


    }

    public void showKids() {
        if (first == null) {
            System.out.println("没有小孩哦");
            return;
        }
        Kids cur = first;
        while (true) {
            System.out.printf("小孩的编号为%d\n", cur.getNo());
            if (cur.getNext() == first) {
                break;
            }

            cur = cur.getNext();


        }
    }


    /**
     *
     *
     * @param startNums
     * @param countNums
     * @param nums
     */
    public void countKids(int startNums,int countNums,int nums){

        if (first==null||startNums<1||startNums>nums){
            System.out.println("你的输入有误哦~");
            return;
        }
        Kids helper=first;

        while(true){
            if (helper.getNext()==first){
                break;
            }
            helper=helper.getNext();
        }




    }
}

class Kids {

    private int no;
    private Kids next;

    public Kids(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Kids getNext() {
        return next;
    }

    public void setNext(Kids next) {
        this.next = next;
    }
}

