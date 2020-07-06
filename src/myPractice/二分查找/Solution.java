package myPractice.二分查找;

/**
 * @author yu
 * @date 2020/7/6 16:45
 *
 * 时间复杂度为O(log n)，
 * 必须使用在有序序列中。但二分搜索未必仅适用于有序序列。
 */
public class Solution {
    public static void main(String[] args) {

    }

    public static int binarySearch(int[] arr,int key){
        int low = 0;
        int high = arr.length-1;
        int mid = 0;
        // 注意这里的符号 <=
        while (low <= high){
            mid = (low+high)/2;
            if (key > arr[mid]){
                low = mid+1;
            }else if (key < arr[mid]){
                high = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
