import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class WaiterService {
    private Integer currentPrimeNumber = 2;

    protected Stack<Integer> stackA = new Stack<>();
    protected Stack<Integer> stackB = new Stack<>();
    protected List<Integer> answers = new ArrayList<>();

    public List<Integer> pileNumbers(List<Integer> numbers, Integer q) {
        Collections.reverse(numbers);
        for(int i = 1; i <= q; i++) {
            for(int j = numbers.size() - 1; j >= 0; j--) {
                pile(numbers.get(j));
            }
            iteract();
            numbers.clear();
            numbers.addAll(stackA);
            stackA.clear();
        }

        answers.addAll(numbers);

        return answers;
    }

    public void pile(Integer number) {
        if(number % getCurrentPrimeNumber() == 0) {
            stackB.add(number);
        } else {
            stackA.add(number);
        }
    }

    public Integer getCurrentPrimeNumber() {
        return currentPrimeNumber;
    }

    public void iteract() {
        currentPrimeNumber++;
        for(int i = 2; i < currentPrimeNumber; i++) {
            if(currentPrimeNumber % i == 0) {
                i = 2;
                currentPrimeNumber++;
            }
        }
        answers.addAll(stackB);
        stackB.clear();
    }

}
