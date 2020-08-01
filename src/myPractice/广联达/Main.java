package myPractice.广联达;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author yu
 * @date 2020/8/1 14:33
 */
public class Main {
    // 1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        sc.nextLine();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(height[i]);
        }
        for (int i = 0; i < m; i++) {
            int min = queue.poll();
            min += x;
            queue.add(min);
        }
        System.out.println(queue.peek());
    }

    // 2
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Map<Integer,int[]> map = new TreeMap<>();

        while(true){
            map.clear();
            int flag = 0;
            int min = Integer.MAX_VALUE;
            int indexMin = 0;
            for (int i = 0; i < list.size(); i++) {
                if (map.get(list.get(i))==null)
                    map.put(list.get(i),new int[]{1,i});
                else if (map.get(list.get(i))[0]==1){
                    flag = 1;
                    map.put(list.get(i),new int[]{map.get(list.get(i))[0]+1,map.get(list.get(i))[1]});
                    if (list.get(i) < min){
                        min = list.get(i);
                        indexMin = i;
                    }
                }
            }
            if (flag == 0)
                break;
            int fisrtIndex = map.get(min)[1];
            list.set(indexMin,2*min);
            list.remove(fisrtIndex);


        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }*/
}
