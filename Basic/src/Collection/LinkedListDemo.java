package Collection;

import java.util.LinkedList;

/**
 * Created by Administrator on 2017/6/21 0021.
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");
        list.add("666");
        list.add("777");
        list.add("888");
        list.add(2, "999");
        System.out.println(list);
    }
}
