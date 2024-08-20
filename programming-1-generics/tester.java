import java.io.*;
import java.util.Arrays;

public class tester{
    
    public static void main(String[] args){
        Rectangle[] s = new Rectangle[8];
        s[0] = new Rectangle(4,5);
        s[1] = new Rectangle(20,1);
        s[2] = new Rectangle(3,2);
        s[3] = new Rectangle(5,2);
        s[4] = new Rectangle(22,3);
        s[5] = new Rectangle(0,3);
        s[6] = new Rectangle(1,10);
        s[7] = new Rectangle(11,6);
        Rectangle x = new Rectangle(16, 1);
        GenericMethods y = new GenericMethods();
        int r = y.linearSearch(s,x);
        System.out.println(r);
        Arrays.sort(s);
        int e = y.binarySearch(s,x);
        System.out.println(e);
        
    }
}