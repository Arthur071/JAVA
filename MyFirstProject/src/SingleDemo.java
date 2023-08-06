class SingleDemo {
    public static SingleDemo ob;

    private SingleDemo()

    public static SingleDemo getInstance() {
        if (ob == null) {
            ob = new SingleDemo();
            return ob;

        }
        return ob;
    }
}

class TestSingle {

    public static void main(String args[]) {
        SingleDemo ob1 = SingleDemo.getInstance();
    }
}
