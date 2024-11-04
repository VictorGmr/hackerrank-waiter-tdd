import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WaiterServiceTest {

    private WaiterService service;

    @Before
    public void init() {
        service = new WaiterService();
    }

    @Test
    public void shouldCreateWaiterServiceIntance() {
        WaiterService service = new WaiterService();
    }

    @Test
    public void shouldCreateEmptyAnswersArray_whenCallingCreateAnswersArray() {
        List<Integer> answersArray = service.answers;
        assertTrue(answersArray.isEmpty());
    }

    @Test
    public void shouldReturn2_whenCallingGetCurrentPrimeNumber() {
        Integer currentPrime = service.getCurrentPrimeNumber();
        assertEquals(Integer.valueOf(2), currentPrime);
    }

    @Test
    public void shouldReturnAPrimeNumber_whenCallingGetCurrentPrimeNumber() {
        Integer primeNumber = service.getCurrentPrimeNumber();
        assertEquals(0, service.getCurrentPrimeNumber() % 2);
    }

    @Test
    public void shouldGetNextPrimeNumber_whenCallingIteractThenCallingGetCurrentPrimeNumber() {
        assertEquals(Integer.valueOf(2), service.getCurrentPrimeNumber());
        service.iteract();
        assertEquals(Integer.valueOf(3), service.getCurrentPrimeNumber());
        service.iteract();
        assertEquals(Integer.valueOf(5), service.getCurrentPrimeNumber());
        service.iteract();
        assertEquals(Integer.valueOf(7), service.getCurrentPrimeNumber());
    }

    @Test
    public void shouldReturnTrue_whenCallingStackAIsEmpty() {
        assertTrue(service.stackA.isEmpty());
    }

    @Test
    public void shouldReturnTrue_whenCallingStackBIsEmpty() {
        assertTrue(service.stackB.isEmpty());
    }

    @Test
    public void shouldCallPilePassingANumber() {
        Integer number = 0;
        service.pile(number);
    }

    @Test
    public void shouldStackB_whenCallingPileAndNumberIsDivisibleByCurrentPrime() {
        Integer number = 2;
        service.pile(number);
        assertEquals(number, service.stackB.peek());
    }

    @Test
    public void shouldStackA_whenCallingPileAndLastNumberInNumberListIsNotDivisibleByCurrentPrime() {
        Integer number = 3;
        service.pile(number);
        assertEquals(number, service.stackA.peek());
    }

    @Test
    public void shouldStackAllValuesInNumbersToStacksAAndB_whenCallingPileNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(List.of(1, 2, 3));
        service.pileNumbers(numbers, 2);
        assertEquals(3, service.answers.size());
    }

    @Test
    public void shouldIncreaseCurrentPrimeNumber_whenPileIsCalled() {
        List<Integer> numbers = new ArrayList<>();
        Integer initialPrime = service.getCurrentPrimeNumber();
        Integer desiredIterations = 2;
        service.pileNumbers(numbers, desiredIterations);
        assertTrue(initialPrime < service.getCurrentPrimeNumber());
    }

    @Test
    public void shouldReturnArrayAnswers_whenCallingPileNumbers() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> answers = new ArrayList<>();
        Integer desiredIterations = 2;
        answers = service.pileNumbers(numbers, desiredIterations);
    }

    @Test
    public void atEndOfIteration_shouldStackBBeEmptyAndAnswersBeOriginalSizeOfB() {
        service.stackB.add(1);
        service.stackB.add(2);
        service.stackB.add(3);
        service.stackB.add(4);

        int originalBSize = service.stackB.size();

        service.iteract();

        assertTrue(service.stackB.isEmpty());
        assertEquals(originalBSize, service.answers.size());

    }

    @Test
    public void atEndOfPileNumbers_shouldStackABeEmptyAndAnswersBeOriginalSizeOfAPlusB() {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(List.of(1, 2, 3));
        service.pileNumbers(numbers, 1);

        assertTrue(service.stackA.isEmpty());
        assertEquals(3, service.answers.size());
    }

}