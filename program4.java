import java.util.*;
public class program4 {
    private static boolean helper(String s){
        int bitmask=0;
        for(int i=0;i<s.length();i++){
            bitmask^=(1<<(s.charAt(i)-'a'));
        }
        return (bitmask & (bitmask-1))==0;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(helper(s));
    }
}
