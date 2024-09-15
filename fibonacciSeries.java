import java.util.ArrayList;
import java.util.List;

class fibonacciSeries{
    public static List<Integer> FibonacciSerie(int n){
        List<Integer> series = new ArrayList<>();

        if (n <= 0) {
            return series; // Return 0 if n is less than or equal to 0
        }
        if (n == 1) {
            return series; // Return 1 if n is 1
        }
        int first_number = 0;
        int second_number = 1;
        int sum = 0;

        for(int i =1;i<n;i++){
            sum=first_number+second_number;
            first_number=second_number;
            second_number=sum;
            series.add(sum);
        }
        return series;
    }
    public static void main(String args[]){
        int n=10;
        List<Integer> answer = FibonacciSerie(n);
        System.out.println(answer);
    }
}