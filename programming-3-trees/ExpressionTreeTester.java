public class ExpressionTreeTester{
    public static void main(String[] args) {
        ExpressionTree tree = new ExpressionTree("7 2 - 5 /");
        int eval = tree.eval();
        String prefix = tree.prefix();
        String postfix = tree.postfix();
        String infix = tree.infix();
        System.out.println(eval);
        System.out.println(prefix);
        System.out.println(postfix);
        System.out.println(infix);
    } 
}