package DoubleLinkedList;


public class DoubleLinkedDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(5, "入云龙", "公孙胜");
        DoubleLinked linked = new DoubleLinked();
        linked.add(hero1);
        linked.add(hero2);
        linked.add(hero3);
        linked.add(hero4);

        linked.list();

        System.out.println("--------------");
        linked.addByOrder(new HeroNode(4, "豹子头", "林冲"));
        linked.list();


    }
}

class DoubleLinked {
    HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //先进行遍历
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
        heroNode.pre = temp;
    }


    public void addByOrder(HeroNode heroNode) {
        // 因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        HeroNode temp = head;
        boolean flag = false;
        boolean flag1 = false;
        while (true) {
            if (temp.next == null)
                break;
            if (temp.next.no > heroNode.no) {
                flag1 = true;
                break;
            }
            if (temp.next.no == heroNode.no) {
                // 已经存在该编号(不可重复)
                flag = true;
                break;
            }
            // 没满足以上，后移下一次节点继续找
            temp = temp.next;
        }
        // 对 flag 进行判断
        if (flag)
            // 不能添加，说明编号已经存在
            System.out.printf("编号 %d 已存在,加入失败\n", heroNode.no);
        else {
            if(flag1){
                //插中间
                temp.next.pre = heroNode;
                heroNode.next = temp.next;
                temp.next = heroNode;
                heroNode.pre = temp;
            }
            else{
                //插最末
                temp.next = heroNode;
                temp = heroNode.pre;
            }
        }

    }





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
        if (head.next == null) {
            System.out.println("链表是空的，无法删除");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                temp = temp.next;
            }
        }
        if (flag) {
            temp.pre.next = temp.next;
        }
        if (temp.next != null) {
            temp.next.pre = temp.pre;
        } else {

            System.out.println("要删除的节点不存在");
        }


    }

    public void serach(int no) {
        if (head.next == null) {
            System.out.println("对不起，链表是空的哦~");
        }
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
            temp = temp.next;
        }
        if (flag) {
            System.out.println(temp);
        } else {
            System.out.println("没有找到,你再看看~~~");
        }
    }


}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;
    public HeroNode pre;


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