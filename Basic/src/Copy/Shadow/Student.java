package Copy.Shadow;

class Professor {
    String name;
    int age;
    Professor(String name,int age) {
        this.name=name;
        this.age=age;
    }
}

class Student implements Cloneable {
    String name;//常量对象。
    int age;
    Professor p;//学生1和学生2的引用值都是一样的。

    Student(String name,int age,Professor p) {
        this.name=name;
        this.age=age;
        this.p=p;
    }

    public Object clone() {
        Student o=null;
        try {
            o=(Student)super.clone();
        }
        catch(CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        o.p = p;
        return o;
    }

    public static void main(String[] args) {
        Professor p=new Professor("wangwu",50);
        Student s1=new Student("zhangsan",18,p);
        Student s2=(Student)s1.clone();
        s2.p.name="lisi";
        s2.p.age=30;
        System.out.println("name="+s1.p.name+","+"age="+s1.p.age);//学生1的教授成为lisi,age为30。
    }
}
