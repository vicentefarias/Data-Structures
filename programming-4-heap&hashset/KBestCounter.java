import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KBestCounter<T extends Comparable<? super T>> implements KBest<T> {
    private int k;
    private PriorityQueue<T> pq;

    public KBestCounter(int k) {
        this.k = k;
        this.pq = new PriorityQueue<>(k, Comparator.reverseOrder());
    }

    @Override
    public void count(T x) {
        if (pq.size() < k) {
            pq.offer(x);
        } else {
            if (pq.peek().compareTo(x) > 0) {
                pq.poll();
                pq.offer(x);
            }
        }
    }

    @Override
    public List<T> kbest() {
        List<T> kBestList = new ArrayList<>(pq);
        kBestList.sort(null);
        return kBestList;
    }
}