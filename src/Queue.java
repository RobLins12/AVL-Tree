package src;

import java.util.ArrayList;

public class Queue{
    
    private ArrayList<Node> queue;

    public Queue() {
        this.queue = new ArrayList<>();
    }

    public void enqueue(Node x) {
        queue.add(x);
    }
        
    public Node dequeue() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        Node saved = queue.get(0);
        queue.remove(queue.get(0));
        return saved;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}