import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
    }

    public static void dfs(ArrayList<Integer> list){
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n && j != i ; j++) {
                list1.add(list.get(i));
                list2.add(list.get(j));
            }
        }
    }
}
