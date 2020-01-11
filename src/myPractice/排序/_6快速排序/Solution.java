package myPractice.排序._6快速排序;

/**
 * 快速排序
 *   1.从数列中挑出一个元素，称为 “基准”（pivot）；
 *   2.重新排序数列，所有比基准值小的元素放在基准前面，所有比基准值大的元素放在基准的后面
 *    （相同的数可以到任一边），该基准就处于数列的中间位置。这称为分区（partition）操作；
 *   3.递归地（recursive）对小于基准值元素的子数列和大于基准值元素的子数列进行快速排序
 *
 *  平均时间复杂度为O(nlogn)，最好时间复杂度为O(nlogn)，最坏时间复杂度为O(n^2)
 *  平均空间复杂度为O(logn):
 *      在最好情况下，即partition函数每次恰好能均分序列，空间复杂度为O(logn)；
 *      在最坏情况下，即退化为冒泡排序，空间复杂度为O(n)。
 *  不稳定
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {7,5,6,4,2,3,1};
        quickSort(array,0,array.length-1);
        for (int arr:array)
            System.out.print(arr);
    }
    public static void quickSort(int[] array,int left,int right){
        if (array.length < 2)
            return;
        if (left < right){
            int mid = partition(array,left,right);
            quickSort(array,left,mid-1);
            quickSort(array,mid+1,right);
        }
    }

    /**
     * 方法1：左右指针法
     *    1．将数组的最后一个数 right 作为基准数 key。
     *    2．分区过程：从数组的首元素 begin 开始向后找比 key 大的数（begin 找大）；
     *       end 开始向前找比 key 小的数（end 找小）；
     *       找到后交换两者（swap），直到 begin >= end 终止遍历。
     *       最后将 begin（此时begin == end）和最后一个数交换（ 这个时候 end 不是最后一个位置），
     *       即 key 作为中间数（左区间都是比key小的数，右区间都是比key大的数）
     *    3．再对左右区间重复第二步，直到各区间只有一个数。
     * @param array
     * @param left
     * @param right
     * @return
     */
    /*public static int partition(int[] array,int left,int right){
        int begin = left;
        int end = right;
        int key = right;
        while (begin < end){
            while (begin < end && array[begin] <= array[key])
                begin ++;
            while (begin < end && array[end] >= array[key])
                end --;
            swap(array,begin,end);
        }
        swap(array,begin,right);
        return begin;
    }*/

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

    /**
     * 方法2：挖坑法
     *    1.定义两个指针 left 指向起始位置，right 指向最后一个元素的位置，
     *      然后指定一个基准 key（right），作为坑。
     *    2.left 寻找比基准（key）大的数字，找到后将 left 的数据赋给 right，
     *      left 成为一个坑，然后 right 寻找比基数（key）小的数字，
     *      找到将 right 的数据赋给 left，right 成为一个新坑，循环这个过程，
     *      直到 begin 指针与 end指针相遇，然后将 key 填入那个坑
     *      （最终：key的左边都是比key小的数，key的右边都是比key大的数），然后进行递归操作
     * @param array
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] array,int left,int right){
        int key = array[right];  //初始坑
        while (left < right){
            while (left < right && array[left] <= key)
                left ++;
            array[right] = array[left];  // left作为新坑
            while (left < right && array[right] >= key)
                right --;
            array[left] = array[right];  // right作为新坑
        }
        array[left] = key;
        return left;
    }
}
