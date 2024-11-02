public class cosinus {
    public static void main(String[] args) {
        if(args.length==0){
            System.out.println("ERROR: Kein Argument angegeben.");
            return;
        }
        double x=Double.parseDouble(args[0]);
        double result=cos(x);
        System.out.println(result);
    }
    private static Double cos(double y){
        y = y % (2 * Math.PI);
        if (y < 0) {
            y += 2 * Math.PI;}
        double powerX = 1;
        double num=1;
        for (int i = 0; i < 11; i++) {
            num*=2;
            powerX+=Math.pow(y, num)/fact(num);
        }
        return powerX;

    }
    private static Double fact(double f){
        double n=1;
        for(int i=1;i<=f;i++){
            n*=i;
        }
        return n;
    }
}
