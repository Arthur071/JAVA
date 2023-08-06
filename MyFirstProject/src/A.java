// public class A {
//     int x;
//     public void get(int y)
//     {
//         int x;
//         x = y;
//         this.x=20;
//         System.out.println(x);


//     }
//     public void display(int k)
//     {
//         this.get(12);
//     }
//     public static void main(String[] args) {
//         A ob1 = new A ();
//         ob1.display(10);
//         A ob2 = new A();
//         ob2.display(7);
//     }
// }
public class A {
    A ()
    {
        this(7);
        System.out.println("Helllo");

    }
    A(int x){
        this(10,"goli");
        
    }
}

