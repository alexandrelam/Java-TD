class Moyenne extends Expr{
    Expr op1;
    Expr op2;
    Moyenne(Expr o1, Expr o2){
        op1 = o1;
        op2 = o2;
    }
    public String toString(){
        return "(" + op1+"+"+op2+")/2";
    }
    public double eval(double x, double y){
        return (op1.eval(x, y) + op2.eval(x, y))/2;
    }
}
