class Cos extends Expr{
    Expr op;
    Cos(Expr o){
        op = o;
    }
    public String toString(){
        return "cos(Pi*"+op+")";
    }
    public double eval(double x, double y){
        return Math.cos(Math.PI * op.eval(x, y));
    }
}
