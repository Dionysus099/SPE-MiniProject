import org.example.Main;
import static org.junit.Assert.*;
import org.junit.Test;

public class MainTest {
    private static final double DELTA = 1e-15;
    Main calculator = new Main();

    @Test
    public void additionTruePositive() {
        assertEquals("Adding two numbers for True Positive", 6.9, calculator.add(2.34, 4.56), DELTA);
        assertEquals("Adding two numbers for True Positive", 12.45672, calculator.add(9, 3.45672), DELTA);
    }

    @Test
    public void additionFalsePositive() {
        assertNotEquals("Adding two numbers for False Positive", 69, calculator.add(2.3221, 4), DELTA);
        assertNotEquals("Adding two numbers for False Positive", 1245.672, calculator.add(9, 3), DELTA);
    }

    @Test
    public void subtractionTruePositive() {
        assertEquals("Subtracting two numbers for True Positive", 1.662, calculator.sub(2.34, 0.678), DELTA);
        assertEquals("Subtracting two numbers for True Positive", 5.54328, calculator.sub(9, 3.45672), DELTA);
    }

    @Test
    public void subtractionFalsePositive() {
        assertNotEquals("Subtracting two numbers for False Positive", 69, calculator.sub(78.3221, 4), DELTA);
        assertNotEquals("Subtracting two numbers for False Positive", 7.99972, calculator.sub(9, 1), DELTA);
    }

    @Test
    public void multiplicationTruePositive() {
        assertEquals("Multiplying two numbers for True Positive", 1.58652, calculator.mul(2.34, 0.678), DELTA);
        assertEquals("Multiplying two numbers for True Positive", 0.0000, calculator.mul(9.87, 0), DELTA);
    }

    @Test
    public void multiplicationFalsePositive() {
        assertNotEquals("Multiplying two numbers for False Positive", 69, calculator.mul(78.3221, 4), DELTA);
        assertNotEquals("Multiplying two numbers for False Positive", 7.99972, calculator.mul(9, 1), DELTA);
    }

    @Test
    public void divisionTruePositive() {
        assertEquals("Dividing two numbers for True Positive", 3.451327433628318, calculator.div(2.34, 0.678), DELTA);
        assertEquals("Dividing two numbers for True Positive", 9.87, calculator.div(9.87, 1), DELTA);
    }

    @Test
    public void divisionFalsePositive() {
        assertNotEquals("Dividing two numbers for False Positive", 69, calculator.div(78.3221, 4), DELTA);
        assertNotEquals("Dividing two numbers for False Positive", 7.99972, calculator.div(9, 1), DELTA);
    }

    @Test
    public void squareRootTruePositive(){
        assertEquals("Finding square root for True Positive", 4, calculator.sqroot(16), DELTA);
        assertEquals("Finding square root for True Positive", 1, calculator.sqroot(1), DELTA);
        assertEquals("Finding square root for True Positive", 9, calculator.sqroot(81), DELTA);
        assertEquals("Finding square root for True Positive", 6, calculator.sqroot(36), DELTA);
    }

    @Test
    public void squareRootFalsePositive(){
        assertNotEquals("Finding square root for False Positive", 1, calculator.sqroot(3), DELTA);
        assertNotEquals("Finding square root for False Positive", 3, calculator.sqroot(4), DELTA);
        assertNotEquals("Finding square root for False Positive", 4, calculator.sqroot(81), DELTA);
        assertNotEquals("Finding square root for False Positive", 2, calculator.sqroot(36), DELTA);

    }

    @Test
    public void factorialTruePositive() {
        assertEquals("Finding factorial of a number for True Positive", 720, calculator.fact(6), DELTA);
        assertEquals("Finding factorial of a number for True Positive", 1, calculator.fact(1), DELTA);
        assertEquals("Finding factorial of a number for True Positive", 6, calculator.fact(3), DELTA);
        assertEquals("Finding factorial of a number for True Positive", 24, calculator.fact(4), DELTA);
        assertEquals("Finding factorial of a number for True Positive", 1, calculator.fact(0), DELTA);
    }

    @Test
    public void factorialFalsePositive() {
        assertNotEquals("Finding factorial of a number for False Positive", 113, calculator.fact(5), DELTA);
        assertNotEquals("Finding factorial of a number for False Positive", 10, calculator.fact(6), DELTA);
        assertNotEquals("Finding factorial of a number for False Positive", 42, calculator.fact(4), DELTA);
        assertNotEquals("Finding factorial of a number for False Positive", 9, calculator.fact(2), DELTA);
        assertNotEquals("Finding factorial of a number for False Positive", 0, calculator.fact(0), DELTA);
    }

    @Test
    public void logTruePositive(){
        assertEquals("Finding natural log for True Positive", 0, calculator.naturalLog(1), DELTA);

    }

    @Test
    public void logFalsePositive(){
        assertNotEquals("Finding natural log for False Positive", 60, calculator.naturalLog(2.4), DELTA);
        assertNotEquals("Finding natural log for False Positive", 4.7, calculator.naturalLog(2.1), DELTA);
    }

    @Test
    public void powerTruePositive(){
        assertEquals("Finding power for True Positive", 8, calculator.power(2, 3), DELTA);
        assertEquals("Finding power for True Positive", 1, calculator.power(1, 3), DELTA);
        assertEquals("Finding power for True Positive", 81, calculator.power(3, 4), DELTA);
        assertEquals("Finding power for True Positive", 64, calculator.power(4, 3), DELTA);
        assertEquals("Finding power for True Positive", 25, calculator.power(5, 2), DELTA);
    }

    @Test
    public void powerFalsePositive(){
        assertNotEquals("Finding power for False Positive", 6, calculator.power(2, 3), DELTA);
        assertNotEquals("Finding power for False Positive", -7, calculator.power(3, 3), DELTA);
        assertNotEquals("Finding power for False Positive", 99, calculator.power(4, 3), DELTA);
        assertNotEquals("Finding power for False Positive", -12, calculator.power(5, 3), DELTA);
    }
}