class Sin extends Expr{
    Expr op;
    Sin(Expr o){
        op = o;
    }
    public String toString(){
        return "sin(Pi*"+op+")";
    }
    public double eval(double x, double y){
        return Math.sin(Math.PI * op.eval(x, y));
    }
}
