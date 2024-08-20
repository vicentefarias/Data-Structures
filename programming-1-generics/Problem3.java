public class Problem3{
    
    public static void main(String[] args){
 
        int[] x = new int[4];
        x[0] = 5;
        x[1] = 10;
        x[2] = 20;
        x[3] = 40;
        BigO O = new BigO();
        for(int i: x){
            System.out.println("n = "+ i +"");
            System.out.println("");
            System.out.println("O(1):");
            O.constant(i);
            System.out.println("");
            System.out.println("O(n^3):");
            O.cubic(i);
            System.out.println("");
            System.out.println("O(2^n):");
            System.out.println("");
            O.exp(i);
            System.out.println("^^ True Elapsed Time");
            System.out.println(""); 
            System.out.println("------");
            System.out.println("");      
        }        
    }
    
}