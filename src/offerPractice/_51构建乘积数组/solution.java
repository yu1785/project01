package offerPractice._51构建乘积数组;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];
 *
 * 思路：不能用除法 将矩阵分为上下三角两部分 分别计算再相乘
 */
public class solution {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if (A.length == 0)
            return null;
        //计算下三角
        B[0] = 1;
        for (int i = 1;i < A.length;i ++){
            B[i] = B[i-1]*A[i-1];
        }
        //计算上三角
        int temp = 1;
        for (int i = A.length-1;i >= 0;i --){
            B[i] *= temp;
            temp *= A[i];
        }
        return B;
    }
}
