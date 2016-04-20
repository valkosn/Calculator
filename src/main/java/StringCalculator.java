import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valko Serhii on 20-Apr-16.
 */
public class StringCalculator implements Calculator {

    private final int amountDigit = 9;
    private final String negative = "-";

    private boolean isNegative(String str){
        return str.startsWith(negative);
    }

    private List<String> getListFromString(String a) {
        List<String> result = new ArrayList<>();
        while (a.length() > 0) {

            result.add(a.substring(a.length() > amountDigit ? a.length() - amountDigit : 0));
            a = a.length() > amountDigit ? a.substring(0, a.length() - amountDigit) : "";
        }
        return result;
    }

    private String internalAppend(String a, String b) {
        List<String> partsOfNumberA = getListFromString(a);
        List<String> partsOfNumberB = getListFromString(b);
        List<String> resultList = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        int overRank = 0;
        int i = 0;

        while (true) {
            String temp;

            if (partsOfNumberA.size() > i && partsOfNumberB.size() > i) {
                temp = Integer.toString(Integer.parseInt(partsOfNumberA.get(i)) + Integer.parseInt(partsOfNumberB.get(i)) + overRank);
            } else if (partsOfNumberA.size() > i && partsOfNumberB.size() <= i) {
                temp = Integer.toString(Integer.parseInt(partsOfNumberA.get(i)) + overRank);
            } else if (partsOfNumberA.size() <= i && partsOfNumberB.size() > i) {
                temp = Integer.toString(Integer.parseInt(partsOfNumberB.get(i)) + overRank);
            } else
                break;

            if (temp.length() > amountDigit) {
                overRank = 1;
                resultList.add(temp.substring(1));
            } else {
                overRank = 0;
                resultList.add(temp);
            }
            i++;
        }
        for (int j = resultList.size() - 1; j >= 0 ; j--) {
            result.append(resultList.get(j));
        }
        return result.toString();
    }

    public String append(String a, String b) {

        return isNegative(a) && isNegative(b) ? negative + internalAppend(a.substring(1), b.substring(1)) : internalAppend(a, b);
    }

    public String subtract(String a, String b) {
        return Integer.toString(Integer.parseInt(a) - Integer.parseInt(b));
    }

    public String multiply(String a, String b) {
        return Integer.toString(Integer.parseInt(a) * Integer.parseInt(b));
    }
}
