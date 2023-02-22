import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> v1 = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toList();
        List<Integer> v2 = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toList();

        double up = v1.get(0) * v2.get(0) + v1.get(1) * v2.get(1);
        double down = Math.sqrt(Math.pow(v1.get(0), 2) + Math.pow(v1.get(1), 2)) * Math.sqrt(Math.pow(v2.get(0), 2) + Math.pow(v2.get(1), 2));
        System.out.println(Math.toDegrees(Math.acos(up / down)));
    }
}