package ljl;

public class TestSpecialChar {
    public static void main(String[] args) {
        String s =">\uE609<\uE60A";
        for(int i=0;i<s.length();i++){
            System.out.println((int)s.charAt(i));
        }
        System.out.println(System.currentTimeMillis()/1000);
    }
}
