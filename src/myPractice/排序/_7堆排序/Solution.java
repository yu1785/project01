package myPractice.排序._7堆排序;

/**
 * 堆排序
 *     堆：堆是一种完全二叉树，且满足所有父节点的值均大于等于（或小于等于）其子节点的值。
 *     大根堆（最大堆）：满足所有父节点的值均大于等于其子节点的值的堆称为大根堆，堆顶元素是堆中元素的最大值。
 *     小根堆（最小堆）：满足所有父节点的值均小于等于其子节点的值的堆称为小根堆，堆顶元素是堆中元素的最小值。
 *
 *    1.将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
 *    2.将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)
 *      和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
 *    3.由于交换后新的堆顶R[1]可能违反堆的性质，因此需要
 *      对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，
 *      得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。
 *      不断重复此过程直到有序区的元素个数为（n-1），则整个排序过程完成
 *
 *   平均时间复杂度为O(nlogn)，最好时间复杂度为O(nlogn)，最坏时间复杂度为O(nlogn)
 *   空间复杂度为O(1)
 *   不稳定
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {7,5,6,4,2,3,1};
        heapSort(array);
        for (int arr:array)
            System.out.print(arr);
    }
    public static int len;
    /**
     * 堆排序
     * @param array
     */
    public static void heapSort(int[] array){
        len = array.length;
        if (len < 2)
            return;
        //构建大顶堆
        buildMaxHeap(array);
        //循环将堆顶（最大值）与堆尾交换，删除堆尾元素，然后重新调整大根堆
        while (len > 0){
            swap(array,0,len-1);
            //原先的堆尾进入有序区，删除堆尾元素
            len --;
            //重新调整大根堆
            adjustHeap(array,0);
        }
    }

    /**
     * 自底向上构建初始大顶堆
     * @param array
     */
    public static void buildMaxHeap(int[] array){
        //从最后一个非叶子节点开始自底向上构造大根堆
        for (int i = (len - 2) / 2; i >= 0; i--) {
            adjustHeap(array, i);
        }
    }

    /**
     * 自顶向下调整以 i 为根的堆为大根堆
     * @param array
     * @param i
     */
    public static void adjustHeap(int[] array,int i){
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (2 * i + 1 < len && array[2 * i + 1] > array[maxIndex])
            maxIndex = 2 * i + 1;
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (2 * i + 2 < len && array[2 * i + 2] > array[maxIndex])
            maxIndex = 2 * i + 2;
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }

    /**
     * 交换数组内两个元素
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
