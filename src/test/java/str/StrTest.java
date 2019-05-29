package str;

/**
 * @Version 1.0
 * @Since JDK1.6
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/5/29 20:44
 */
public class StrTest {
    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        String newS1 = new String("hello");
        String newS2 = new String("hello");
        String ss1 = "hello";
        String ss2 = "hello";

        System.out.println("ss1="+ss1);
        System.out.println("ss2="+ss2);
        System.out.println("newS1="+newS1);
        System.out.println("newS2="+newS2);
        System.out.println("ss1==ss2是"+(ss1==ss2));
        System.out.println("ss1==newS1是"+(ss1==newS1));
        System.out.println("newS1==newS2是"+(newS1==newS2));
        System.out.println(newS1.intern()==newS2.intern());
    }
}
