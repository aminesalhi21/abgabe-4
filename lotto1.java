import java.util.Random;
public class lotto1 {
    public static void main(String[]args) {
        int n=Integer.parseInt(args[0]);
        int m=Integer.parseInt(args[1]);
        if(n<1){
            System.out.println("Error: n muss grosser oder gleich 1 sein");
        }
        else if (n>m){
            System.out.println("Error: m muss grosser oder gleich n sein");
        }
        else{int[] result = alt(n, m);
            for (int num : result) {
                System.out.print(num + " ");
        }
        System.out.println(); 
        }
    }
   
    private static int[] alt(int x,int y){
        int[] result=new int[x];
        Random rand = new Random();
        for (int i=0 ; i<x ;i++){
            boolean ok;
            int d;
            do {
                d = rand.nextInt(y) + 1;
                ok = true;
                for (int j = 0; j < i; j++) {
                    if (result[j] == d) {
                        ok = false; 
                        break;
                    }
                }
            } while (!ok);  
            result[i] = d;
            
        }    
        return result ;
        }
         
    }

    
