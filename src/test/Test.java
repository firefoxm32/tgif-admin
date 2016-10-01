/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Mon
 */
public class Test {
    public static void main(String[] args) {
//       new Test().a();   
        
        String ip = "19123";
        System.out.println(NewClass.http+ip+NewClass.FOO);
        
    }
    public int a() { 
        
        int a = (int)((0.7f+0.3f)*10);
        double aa = (0.7+0.1)*10;
        System.out.println("a: "+a);
        System.out.println("aa: "+aa);
        return 0;
    }
}
