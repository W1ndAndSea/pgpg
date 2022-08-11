package LinkedList;

public class HeroTest {

    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.add(new Hero(1,"及时雨","宋江"));
        list.add(new Hero(2,"玉麒麟","卢俊义"));
        list.add(new Hero(3,"智多星","吴用"));
        list.list();
        System.out.println("---------------------");
        list.serach(2);
        System.out.println("---------------------");
        list.update(new Hero(1,"大帅哥","pg"));
        list.list();


    }
}

class LinkedList {
    public Hero head = new Hero(0, "", "");

    public void add(Hero hero) {
        Hero temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = hero;


    }

    public void addByOrder(Hero hero) {
        Hero temp = hero;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > hero.no) {

                break;
            } else if (temp.next.no == hero.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("英雄已经存在了，不能加入了");
        } else {
            hero.next = temp.next;
            temp.next = hero;
        }

    }

    public void update(Hero hero) {
        Hero temp = head.next;
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == hero.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = hero.name;
            temp.nickname = hero.nickname;
        } else {
            System.out.println("对不起，没有找到哦~~");
        }
    }


    public void delete(int no) {
        Hero temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("节点不存在~");
        }
    }




    public void serach(int no){
        Hero temp=head.next;
        boolean flag=false;
        while(true){
            if (temp==null){
                break;
            }if (temp.no==no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            System.out.println(temp);
        }else{
            System.out.println("对不起，没找到~~");
        }
    }

    public void list(){
        if (head.next==null){

            System.out.println("对不起,这个链表是空的~");
            return;
        }
        Hero temp=head.next;
       while(true){


           if (temp==null){
               break;
           }
           System.out.println(temp);
           temp=temp.next;
       }

    }
}


class Hero {
    public int no;
    public String name;
    public String nickname;
    public Hero next;

    public Hero(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}