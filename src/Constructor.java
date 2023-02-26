public class Constructor {
    static String str;

    public void Constructor(){
        System.out.println("In Cons");
        str="Hello World";
    }

    public static void main(String[] args) {
        Constructor con = new Constructor();
        System.out.println(str);
    }
}
