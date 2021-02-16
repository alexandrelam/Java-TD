public class Main{
    public static void main(String[] args){
        Expr monExp = new Moyenne(new X(), new Sin(new Mult(new Y(), new Cos(new X()))));
        System.out.println(monExp);
    }
}
