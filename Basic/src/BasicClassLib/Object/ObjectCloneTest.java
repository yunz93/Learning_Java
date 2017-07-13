package BasicClassLib.Object;

/**
 * Created by Administrator on 2017/6/20 0020.
 */
public class ObjectCloneTest implements Cloneable {
    public static void main(String[] args) {
        ObjectCloneTest o1 = new ObjectCloneTest();

        try {
            ObjectCloneTest o2 = (ObjectCloneTest) o1.clone();
            System.out.println("Object1 equals to Object2 ? " + o1.equals(o2));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
