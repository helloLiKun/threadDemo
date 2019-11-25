package demo;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListDemo {
    public static void main(String[] args) throws InterruptedException {
        //arraylist非线程安全，不能得到想要的结果
//        listdemo(new ArrayList());
        //Collections.synchronizedList(List<T> list)   获取读写加锁的List
//        listdemo(Collections.synchronizedList(new ArrayList<>()));
        //CopyOnWriteArrayList   对写加锁,内部靠copy当前list的数组实现，故写入较慢，但读取较快
        listdemo(new CopyOnWriteArrayList());
    }


    static void listdemo(List list) throws InterruptedException {
        Runnable runnable=new Runnable(){
            @Override
            public void run() {
                for(int i=0;i<100000;i++){
                    list.add(i);
                }
            }
        };

        Thread one=new Thread(runnable);
        Thread two=new Thread(runnable);
        one.start();
        two.start();
        one.join();
        two.join();
        System.out.println("集合个数"+list.size());
    }

}
