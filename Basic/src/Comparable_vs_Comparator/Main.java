package Comparable_vs_Comparator;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/7/6 0006.
 */
public class Main {
    public static void main(String[] args)
    {
        Person[] people=new Person[]{new Person("xujian", 20),new Person("xiewei", 10)};
        System.out.println("排序前");
        for (Person person : people)
        {
            System.out.println(person.getName()+":"+person.getAge());
        }
        // Comparable 比较
        //Arrays.sort(people);
        // Comparator 比较1
        Arrays.sort(people, new PersonCompartor());
        // Comparator 比较2
//        PersonCompartor pc = new PersonCompartor();
//        pc.compare(people[0], people[1]);
        System.out.println("\n排序后");
        for (Person person : people)
        {
            System.out.println(person.getName()+":"+person.getAge());
        }
    }
}
