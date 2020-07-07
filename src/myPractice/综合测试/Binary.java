package myPractice.综合测试;

/**
 * @author yu
 * @date 2020/7/7 10:08
 */
public class Binary {

    public static void main(String[] args) {
        int[] arr = {1,2,4,5,7,9};
        System.out.println(binarySearch(arr,7));
        System.out.println(binarySearchRecur(arr,0,arr.length-1,4));
    }

    // 非递归的二分查找
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

    // 递归的二分查找
    public static int binarySearchRecur(int[] arr,int low,int high,int key){
        if (low > high)
            return -1;
        int mid = (low+high)/2;
        if (key > arr[mid]){
            return binarySearchRecur(arr,mid+1,high,key);
        }
        else if (key < arr[mid]){
            return binarySearchRecur(arr,low,mid-1,key);
        }else {
            return mid;
        }
    }

}
