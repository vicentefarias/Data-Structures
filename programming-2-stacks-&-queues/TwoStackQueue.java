public class TwoStackQueue<T> implements TwoStackQueueInterface<T> {
    private MyStack<T> stack1;
    private MyStack<T> stack2;

    public TwoStackQueue() {
        stack1 = new MyStack<>();
        stack2 = new MyStack<>();
    }

    @Override
    public void enqueue(T x) {
        stack1.push(x);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        if (stack2.isEmpty()) {
            transferElements();
        }

        return stack2.pop();
    }

    @Override
    public int size() {
        return stack1.size() + stack2.size();
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void transferElements() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}