import demo.TestRunnable;
import demo.TestThrad;

public class Main {

    public static void main(String[] args) {

        System.out.println("创建一个线程有4种方法");
        System.out.println("方法一：继承Thread类，重写run方法");
        Thread thread=new TestThrad();
        thread.start();
        System.out.println("方法二：实现Runnable接口，重写run方法");
        Thread thread1=new Thread(new TestRunnable());
        thread1.start();
        System.out.println("方法三：使用Thread内部类创建线程");
        Thread thread2=new Thread(){
            @Override
            public void run() {
                System.out.println("I am thread2");
            }
        };
        thread2.start();
        System.out.println("方法四：使用Runnable内部类创建线程");
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("I am thread3");
            }
        };
        Thread thread3=new Thread(runnable);
        thread3.start();
        thread.setName("第一个线程");
        //设为守护线程
        thread.setDaemon(true);
        System.out.println("thrad名称："+thread.getName());
    }
}
