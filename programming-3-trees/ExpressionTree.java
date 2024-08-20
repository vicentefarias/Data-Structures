import java.util.Stack;

public class ExpressionTree implements ExpressionTreeInterface {
    private ExpressionNode root;

    public ExpressionTree(String expression) {
        root = buildExpressionTree(expression);
    }

    private ExpressionNode buildExpressionTree(String expression) {
        String[] tokens = expression.split(" ");
        Stack<ExpressionNode> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                ExpressionNode right = stack.pop();
                ExpressionNode left = stack.pop();
                ExpressionNode operatorNode = new ExpressionNode(token, left, right);
                stack.push(operatorNode);
            } else {
                ExpressionNode operandNode = new ExpressionNode(token);
                stack.push(operandNode);
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    @Override
    public int eval() {
        return evalExpressionTree(root);
    }

    private int evalExpressionTree(ExpressionNode node) {
        if (node.isOperator()) {
            int leftValue = evalExpressionTree(node.left);
            int rightValue = evalExpressionTree(node.right);
            return performOperation(leftValue, rightValue, node.data);
        } else {
            return Integer.parseInt(node.data);
        }
    }

    private int performOperation(int left, int right, String operator) {
        switch (operator) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    @Override
    public String postfix() {
        StringBuilder sb = new StringBuilder();
        postfixTraversal(root, sb);
        return sb.toString().trim();
    }

    private void postfixTraversal(ExpressionNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        postfixTraversal(node.left, sb);
        postfixTraversal(node.right, sb);
        sb.append(node.data).append(" ");
    }

    @Override
    public String prefix() {
        StringBuilder sb = new StringBuilder();
        prefixTraversal(root, sb);
        return sb.toString().trim();
    }

    private void prefixTraversal(ExpressionNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        sb.append(node.data).append(" ");
        prefixTraversal(node.left, sb);
        prefixTraversal(node.right, sb);
    }

    @Override
    public String infix() {
        StringBuilder sb = new StringBuilder();
        infixTraversal(root, sb);
        return sb.toString().trim();
    }

    private void infixTraversal(ExpressionNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        if (node.isOperator()) {
            sb.append("(");
        }

        infixTraversal(node.left, sb);
        sb.append(node.data).append(" ");
        infixTraversal(node.right, sb);

        if (node.isOperator()) {
            sb.append(")");
        }
    }

    private class ExpressionNode {
        private String data;
        private ExpressionNode left;
        private ExpressionNode right;

        public ExpressionNode(String data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public ExpressionNode(String data, ExpressionNode left, ExpressionNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public boolean isOperator() {
            return isOperator(data);
        }