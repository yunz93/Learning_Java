package LintCode;

/**
 * Lintcode 496 玩具工厂
 * 考察简单工厂模式的写法
 * Created by Administrator on 2017/8/9 0009.
 */
interface Toy {
    void talk();
}

class Dog implements Toy {
    // Write your code here
    public void talk() {
        System.out.println("Wow");
    }
}

class Cat implements Toy {
    // Write your code here
    public void talk() {
        System.out.println("Meow");
    }
}

public class Solution_496 {
    /**
     * @param type a string
     * @return Get object of the type
     */
    public Toy getToy(String type) {
        // Write your code here
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("Dog")) {
            return new Dog();
        } else if(type.equalsIgnoreCase("Cat")) {
            return new Cat();
        }
        return null;
    }
}
