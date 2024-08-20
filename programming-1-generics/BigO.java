public class BigO implements BigOInterface{
    
    public void cubic(int n){
        long startTime = System.nanoTime(); 
        int x = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++)
                    x+=1;
            }
        }
        long endTime = System.nanoTime(); 
        long difference = endTime - startTime;
        System.out.println("Start: "+ startTime +"");
        System.out.println("End: "+ endTime +"");
        System.out.println("Elapsed: "+ difference +"");
    }     
    
	public void exp(int n) {
        expHelper(n);
    }

    private int expHelper(int n) {
        if (n <= 0) {
            return 1;
        }
        return expHelper(n - 1) + expHelper(n - 1);
    }
    
	public void constant(int n){
        long startTime = System.nanoTime();
        int x;
        x = n;
        long endTime = System.nanoTime(); 
        long difference = endTime - startTime;
        System.out.println("Start: "+ startTime +"");
        System.out.println("End: "+ endTime +"");
        System.out.println("Elapsed: "+ difference +"");
    }
    
}