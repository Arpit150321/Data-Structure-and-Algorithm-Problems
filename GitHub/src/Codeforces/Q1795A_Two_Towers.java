package Codeforces;
//Make substring function which is make the pair the of neighbour block like (RRBRBR) --> (RR,RB,BR,RB,BR)
//Check that if both tower have BB or RR pair than return yes
//Check that if both tower doesn't have BB or RR pair than return no
//Check that if Only one tower has BB or RR than check top block of both pair
//If both top block are same than return no
//Otherwise move the top block from tower which contain BB or RR pair to other tower until the both tower doesn't have same top block.
import java.util.ArrayList;
import java.util.Scanner;
public class Q1795A_Two_Towers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //Total test cases T
        int T = sc.nextInt();
        
        while(T > 0){
            
            int n,m;
            n = sc.nextInt();
            m = sc.nextInt();

            String s1 = sc.next();
            String s2 = sc.next();

            boolean check1 = checkPattern(s1, n);
            boolean check2 = checkPattern(s2, m);
            
            //CHECK Both String doesn't contain BB or RR
            if(check1 && check2){
                System.out.println("YES");
            }
            
            //CHECK Both String contain BB or RR
            else if(!check1 && !check2){
                System.out.println("NO");
            }
            
            //Only One Tower contain BB or RR
            else{
                int flag = 0;
                
                //CHECK First Tower Contain BB or RR
                if(!check1){
                    flag = 1;
                }
                
                //First Tower contain BB or RR
                if(flag == 1){
                    while(s1.charAt(s1.length()-1) != s2.charAt(s2.length()-1)){
                        s2 = s2 + s1.charAt(s1.length()-1);
                        s1 = s1.substring(0,s1.length()-1);
                    }
                    if(checkPattern(s1,s1.length())){
                        System.out.println("YES");
                    }
                    else{
                        System.out.println("NO");
                    }
                }
                
                //Second Tower Contain BB or RR
                else{
                    while(s1.charAt(s1.length()-1) != s2.charAt(s2.length()-1)){
                        s1 = s1 + s2.charAt(s2.length()-1);
                        s2 = s2.substring(0,s2.length()-1);
                    }
                    if(checkPattern(s2,s2.length())){
                        System.out.println("YES");
                    }
                    else{
                        System.out.println("NO");
                    }
                }
            }
            T --;
        }
    }
    
    //substring function which is make the pair the of neighbour block like (RRBRBR) --> (RR,RB,BR,RB,BR)
    static boolean checkPattern(String s, int n){
        ArrayList<String> str = new ArrayList<>();
        for (int i = 0; i < n-1; i++){
            str.add(s.substring(i,i+2));
        }
        if(str.contains("BB") || str.contains("RR")){
            return false;
        }
        return true;
    }
}
