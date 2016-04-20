/**
 * Created by Valko Serhii on 20-Apr-16.
 */
public class StringCalculator implements Calculator {
    public String append(String a, String b) {

        return Integer.toString(Integer.parseInt(a) + Integer.parseInt(b));
    }

    public String subtract(String a, String b) {
        return Integer.toString(Integer.parseInt(a) - Integer.parseInt(b));
    }

    public String multiply(String a, String b) {
        return Integer.toString(Integer.parseInt(a) * Integer.parseInt(b));
    }
}
