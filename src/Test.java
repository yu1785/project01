import java.util.*;

/**
 * @author yu
 * @date 2020/7/2 9:49
 */
public class Test {
    private int age;
    private int id;
    private int money;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        if (age != test.age) return false;
        if (id != test.id) return false;
        return money == test.money;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + id;
        result = 31 * result + money;
        return result;
    }

    public static void main(String[] args) {

        Set set = new HashSet();
        List<Integer> list = new ArrayList();
        List<Integer> list2 = new LinkedList<>();
        HashMap<Integer,Integer> map = new HashMap();

    }
}
