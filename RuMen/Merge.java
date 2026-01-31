package RuMen;

import java.util.*;

public class Merge {


    public static void main(String[] args) {
        List<A> listA = Arrays.asList(
                new A(){ {setUserId(1); setName("Alice"); } },
                new A(){ {setUserId(2); setName("Bob"); } }
        );

        List<B> listB = Arrays.asList(
                new B(){ {setUserId(1); setAge(25); } },
                new B(){ {setUserId(2); setAge(30); } }
        );

        List<C> mergedList = mergeLists(listA, listB);
        for (C c : mergedList) {
            System.out.println(c.getUserId() + " " + c.getName() + " " + c.getAge());
        }
    }

    public static List<C> mergeLists(List<A> listA, List<B> listB) {
        // 使用Map以userId为key存储B中的数据
        Map<Integer, B> bMap = new HashMap<>();
        for (B b : listB) {
            bMap.put(b.getUserId(), b);
        }

        // 遍历 listA，根据 userId 查找对应的 B 对象，并创建 C 对象
        List<C> result = new ArrayList<>();
        for (A a : listA) {
            B b = bMap.get(a.getUserId());
            if (b != null) {
                C c = new C();
                c.setUserId(a.getUserId());
                c.setName(a.getName());
                c.setAge(b.getAge());
                result.add(c);
            }
        }
        return result;
    }
}

 class A {
    private int userId;
    private String name;


    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

 class B {
    private int userId;
    private int age;


    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}

 class C {
    private int userId;
    private int age;
    private String name;


    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
