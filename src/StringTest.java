import java.util.StringJoiner;

public class StringTest {

    public static void main(String[] args){
        StringJoiner sj=new StringJoiner(",","hello","!");
        System.out.println("sj>"+sj.toString());
        String[] arr=new String[]{"jack","mary","alice"};
        for(String str:arr){
            sj.add(str);
        }
        System.out.println("sj>>"+sj.toString());
    }
}