package Comparable_vs_Comparator;

import java.util.Comparator;

/**
 * Created by Administrator on 2017/7/6 0006.
 */
public class PersonCompartor implements Comparator<Person>
{
    @Override
    public int compare(Person o1, Person o2)
    {
        return o1.getAge()-o2.getAge();
    }
}
