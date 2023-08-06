 class brain {
    public static void main(String args[]){
        int n=5;
        outer: for(int a=1;a<5;a++){
            int i=0,j=0; System.out.println();
             space: while(true){
                System.out.print(" ");    i++;
                if(i==n-a)  break space; 
             }
             star: while(true){
                System.out.print("*");  j++;
                if(j==a) continue outer;
             }
        }
    
}
}