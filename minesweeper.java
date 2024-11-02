public class minesweeper {

    public static void main(String[] args) {
        int width=Integer.parseInt(args[0]);
        int height=Integer.parseInt(args[1]);
        boolean ok=true;
        int[][] minefield = new int[height][width];
        for (int i=2;i<args.length;i++){
            if (Integer.parseInt(args[i])!=1&&Integer.parseInt(args[i])!=0){
                ok=false;
                break;
            }
        }
        if(width<0){
            System.out.println("ERROR: Breite kann nicht negativ sein");
        }
        else if(height<0){
            System.out.println("ERROR: Hoehe kann nicht negativ sein");
        }
        else if(width*height!=args.length-2){
            System.out.println(width*height+" Felder erwartet, aber "+(args.length-2)+" angegeben");
        }
        else if(!ok){
            System.out.println("ERROR:");
        }
        else{
            for(int i=0;i<height;i++){
                for (int j=0;j<width;j++){
                    if(Integer.parseInt(args[i*width+j+2])==1){
                        minefield[i][j]=-1;
                    }
                    else{
                        minefield[i][j]=Integer.parseInt(args[i*width+j+2]);
                    }
                }
            }
            for(int l = 0; l < height; l++) {
                for (int m = 0; m < width; m++) {
                    if (minefield[l][m] == 1) {
                        System.out.print("* ");
                    } 
                    else {
                        System.out.print("0 ");}
                }
                System.out.println();
            }
        }
        int[][] neighborhoodNumbers = new int[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (minefield[row][col] == -1) {
                    neighborhoodNumbers[row][col] = -1;}
                else {
                    int mineCount = 0;
                    for (int i = row - 1; i <= row + 1; i++) {
                        for (int j = col - 1; j <= col + 1; j++) {
                            if (i >= 0 && i < height && j >= 0 && j < width && minefield[i][j] == -1) {
                                mineCount++;
                            }
                        }
                    }
                    neighborhoodNumbers[row][col] = mineCount;
                    }
                }
            }
        for (int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(neighborhoodNumbers[i][j]==0){
                    System.out.print("  ");
                }
                else if(neighborhoodNumbers[i][j]==-1){
                    System.out.print("* ");
                }
                else{
                    System.out.print(neighborhoodNumbers[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
}
