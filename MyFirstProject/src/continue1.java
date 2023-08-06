class ContinueLabel{
    public static void main(String[]rk){
        outer: for(int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if(j>i){
                    System.out.println("Hii");
                    continue outer;
                }
                System.out.println(""+(i*j));

            }
        }
        System.out.println("Demo");
    }
} 
    

