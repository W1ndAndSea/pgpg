package LinkedList;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {

//进行测试
//先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        SingelLinkedList singelLinkedList = new SingelLinkedList();
        singelLinkedList.add(hero1);
        singelLinkedList.add(hero2);
        singelLinkedList.add(hero3);
        singelLinkedList.add(hero4);

        singelLinkedList.list();

        System.out.println("---------------------");
        singelLinkedList.serach(5);
        System.out.println("---------------------");
        singelLinkedList.update(new HeroNode(1, "大鹏", "大帅哥"));
        singelLinkedList.delete(1);
        singelLinkedList.list();


        System.out.println("-------------");
        System.out.println(getLength(singelLinkedList.getHead()));
        System.out.println("---------------");
        System.out.println(getIt(singelLinkedList.getHead(), 2));
//
//        System.out.println("-------------------------------------");
//        reverseList(singelLinkedList.getHead());
//        singelLinkedList.list();

        System.out.println("-----------------------");

        printRev(singelLinkedList.getHead());


    }

    //获取有效接节点数
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }


        return length;
    }


    //
    //获取倒数第k个元素
    //查找单链表中的倒数第 k 个结点 【新浪面试题】
    //思路
    //1. 编写一个方法，接收 head 节点，同时接收一个 index
    //2. index 表示是倒数第 index 个节点
    //3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
    //4. 得到 size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
    //5. 如果找到了，则返回该节点，否则返回 nulll


    public static HeroNode getIt(HeroNode head, int index) {
        //先判空
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);
        //进行遍历 先做一个index的校验
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;


    }


    //获取倒数第k的元素
    public static HeroNode getK(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;


    }


    /**
     * 单链表的反转【腾讯面试题，有点难度】
     */


    public static void reverseList(HeroNode head) {
        //若单链表为空，或者只有一个节点
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助指针帮我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向cur的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");

        //遍历原来的链表 每取出一个放在链表的最前端
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;//将cur的下一个节点指向链表的最前端
            reverseHead.next = cur;//将cur连接到新的链表上
            cur = next;
        }
        //将 head.next 指向 reverseHead.next , 实现单链表的反转
        head.next = reverseHead.next;

    }


    //单链表的反转

    public static void rev(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode revHead = new HeroNode(0, "", "");
        HeroNode cur = head.next;
        HeroNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = revHead.next;
            revHead.next = cur;
            cur = next;
        }
        head.next = revHead.next;
    }

    //逆序打印单链表

    public static void printRev(HeroNode head) {

        if (head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());

        }
    }

    //逆序打印


    //合并两个有序的单链表  合并后依然有序
    public static HeroNode merge(HeroNode head1, HeroNode head2) {
        if (head1.next == null && head2.next == null) {
            return null;
        }
        if (head1.next == null && head2.next != null) {
            return head2;
        } else if (head2.next == null && head1.next != null) {
            return head1;
        }
        HeroNode newHead = new HeroNode(0, "", "");
        HeroNode cur1 = head1.next;
        HeroNode cur2 = head2.next;
        HeroNode temp = newHead;

        while (cur1 != null && cur2 != null) {
            if (cur1.no < cur2.no) {
                temp.next = cur1;
                cur1 = cur1.next;
            } else {
                temp.next = cur2;
                cur2 = cur2.next;
            }
            temp = temp.next;
        }
        if (cur1 == null) {
            temp.next = cur2;
            cur2 = cur2.next;
        }
        if (cur2 == null) {
            while (cur1 != null) {
                temp.next = cur1;
                cur1 = cur1.next;
            }
        }

    return newHead;
    }

}

class SingelLinkedList {
    //先初始化一个头节点，头节点不用动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }
    //添加节点到单向链表

    /**
     * 思路
     * 当不考虑编号顺序的时候
     * 1.找到当前链表的最后一个节点
     * 2.将这个节点的next指向新的节点
     */
    public void add(HeroNode heroNode) {
        //head节点不能动，我们需要一个辅助变量temp
        HeroNode temp = head;
        //遍历链表 找到最后
        while (true) {
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将这个节点的next指向新的节点
        temp.next = heroNode;
    }
    //第二种添加按照顺序添加
    //如果有了这个排名，则提示失败

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;//flag判断待添加的是否存在

        while (true) {
            if (temp.next == null) {
                //说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {
                //说明位置已经找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {
                //说明希望添加的heroNode已经存在了
                flag = true;
                break;
            }
            temp = temp.next;//后移，遍历此链表

        }
        if (flag) {
            //不能添加，说明编号存在
            System.out.printf("准备插入的英雄编号 %d 已经存在,不能加入\n", heroNode);
        } else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;


        }


    }

    //修改节点 根据no来修改


    public void update(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("链表是空的~~");
            return;
        }
        //找到需要修改的节点
        //定义一个辅助变量
        HeroNode temp = head.next;

        boolean flag = false;//表示是否找到了节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                //找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        } else {
            //没有找到
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", heroNode.no);
        }


    }


    public void delete(int no) {

        HeroNode temp = head;
        boolean flag = false;//表示待删除节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                //找到待删除节点的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;//后移,遍历
        }//判断flag
        if (flag) {
            //找到了
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的%d节点不存在\n", no);


        }


    }


    public void serach(int no) {
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {

            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;//后移,遍历
        }
        if (flag) {
            //找到了
            System.out.println(temp);
        } else {
            System.out.println("没有找到哎,你再看看");
        }


    }


    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            //判断是否在链表的最后
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            //将temp后移
            temp = temp.next;


        }

    }


}


class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;


    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}