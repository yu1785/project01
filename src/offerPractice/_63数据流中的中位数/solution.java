package offerPractice._63数据流中的中位数;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 * 思路：小顶堆 大顶堆
 *       小顶堆存大数据部分 大顶堆存小数据部分
 */
public class solution {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    private int N;
    public void Insert(Integer num) {
        //当数据总数为偶数时，新加入的元素，应当进入小根堆
        //（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
        if (N%2 == 0){
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        //当数据总数为奇数时，新加入的元素，应当进入大根堆
        //（注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
        else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        N ++;
    }

    public Double GetMedian() {
        if (N%2 == 0)
            return Double.valueOf((minHeap.peek()+maxHeap.peek())/2.0);
        else
            return Double.valueOf(minHeap.peek());
    }
}
