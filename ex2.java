//Order an irregular int table by ascending order of line sum. If the sum is equal in two lines, order by length.

public class ex2 {

    public static int sumLine(int[] line){
        int sum=0;
        for(int num: line){
            sum+=num;
        }
        return sum;
    }

    public static int[][] order(int[][] tab){
        int[] temp;
        for(int i=0;i<tab.length;i++){
            for(int j=i+1;j<tab.length;j++){
                if(sumLine(tab[i])>sumLine(tab[j])){
                    temp = tab[i];
                    tab[i] = tab[j];
                    tab[j] = temp;
                }else if(sumLine(tab[i])==sumLine(tab[j])){
                    if(tab[i].length>tab[j].length){
                        temp = tab[i];
                        tab[i] = tab[j];
                        tab[j] = temp;
                    }
                }
            }
        }
        return tab;
    }

    public static void main(String[] args) {
        int tab[][] = {{40},{2,4,6},{7,5},{5,7},{},{12,-15},{1,3,7,8}};
        System.out.println("Inicial Table:");
        for(int[] line: tab){
            for(int num=0;num<line.length;num++){
                System.out.printf("%d ",line[num]);
            }
            System.out.println();
        }
        int end[][] = order(tab);
        System.out.println("\nOrdered Table:");
        for(int[] line: end){
            for(int num=0;num<line.length;num++){
                System.out.printf("%d ",line[num]);
            }
            System.out.println();
        }
    } 
    
}
