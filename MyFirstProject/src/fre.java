public class fre {
    public static int[] double_To_Int(double[]a)
    {
        int d[] = new int [a.length];
        for(int i=0;i<a.length;i++)
        {
            d[i] = (int)a[i];
        }
        return d;
    }
    public static void main(String args[])
    {
        double a[]={4.7d,6.3d,9.1d,8.4d,5.7d,6.9d};
        int d[]=double_To_Int(a);
        System.out.print("Array after");
        for (int i=0;i<d.length;i++)
        {
            System.out.print(d[i]+" ");
        }
    }
}
