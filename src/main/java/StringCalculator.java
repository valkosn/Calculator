import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Valko Serhii on 20-Apr-16.
 */
public class StringCalculator implements Calculator {

    private final String negative = "-";
    private Comparator<String> comparator = new NumberComparator();

    public String append(String a, String b) {

        String big;
        String small;
        if (comparator.compare(getUnsigned(a), getUnsigned(b)) >= 0) {
            big = a;
            small = b;
        } else {
            big = b;
            small = a;
        }
        if (isNegative(a) && isNegative(b)) return negative + internalAppend(getUnsigned(big), getUnsigned(small));
        else if (!isNegative(a) && isNegative(b)) return internalSubtract(big, getUnsigned(small));
        else
            return internalAppend(big, small);
    }

    public String subtract(String a, String b) {

        String big;
        String small;
        if (comparator.compare(getUnsigned(a), getUnsigned(b)) >= 0) {
            big = a;
            small = b;
        } else {
            big = b;
            small = a;
        }
        if ((isNegative(a) && isNegative(b) && comparator.compare(a, b) >= 0) ||
                (!isNegative(a) && !isNegative(b) && comparator.compare(a, b) < 0))
            return negative + internalSubtract(getUnsigned(big), getUnsigned(small));
        else if (isNegative(a) && !isNegative(b)) return negative + internalAppend(getUnsigned(big), small);
        else if (!isNegative(a) && isNegative(b)) return internalAppend(big, getUnsigned(small));
        else
            return internalSubtract(getUnsigned(big), getUnsigned(small));
    }

    public String multiply(String a, String b) {

        String big;
        String small;
        if (comparator.compare(getUnsigned(a), getUnsigned(b)) >= 0) {
            big = a;
            small = b;
        } else {
            big = b;
            small = a;
        }

        if (a.equals("0") || b.equals("0")) return "0";
        else if (isNegative(a) && !isNegative(b) || !isNegative(a) && isNegative(b))
            return negative + internalMultiply(getUnsigned(big), getUnsigned(small));
        else
            return internalMultiply(getUnsigned(big), getUnsigned(small));
    }

    private String internalAppend(String a, String b) {

        List<Integer> firstNList = getReversedListFromString(a);
        List<Integer> secondNList = getReversedListFromString(b);
        StringBuilder result = new StringBuilder();
        List<String> resultList = new ArrayList<>();
        int i = 0;
        while (true) {
            int firstN;
            int secondN;
            if (firstNList.size() > i && secondNList.size() > i) {
                firstN = firstNList.get(i);
                secondN = secondNList.get(i);
            } else if (firstNList.size() > i && secondNList.size() <= i) {
                firstN = firstNList.get(i);
                secondN = 0;
            } else
                break;
            int iterResult = firstN + secondN;
            if (iterResult >= 10 && !(firstNList.size() - 1 == i)) {
                resultList.add(Integer.toString(iterResult - 10));
                firstNList.set(i + 1, firstNList.get(i + 1) + 1);
            } else
                resultList.add(Integer.toString(iterResult));
            i++;
        }
        for (int j = resultList.size() - 1; j >= 0; j--) {

            result.append(resultList.get(j));
        }
        return !result.toString().isEmpty() ? result.toString() : "0";
    }

    private String internalSubtract(String a, String b) {
        List<Integer> firstNList = getReversedListFromString(a);
        List<Integer> secondNList = getReversedListFromString(b);

        StringBuilder result = new StringBuilder();
        List<String> resultList = new ArrayList<>();
        int i = 0;

        while (true) {
            int firstN;
            int secondN;
            if (firstNList.size() > i && secondNList.size() > i) {
                firstN = firstNList.get(i);
                secondN = secondNList.get(i);
                if (secondN > firstN) {
                    firstN += 10;
                    int newFirstN = (firstNList.get(i + 1)) - 1;
                    firstNList.set(i + 1, newFirstN);
                }
            } else if (firstNList.size() > i && secondNList.size() <= i) {
                firstN = firstNList.get(i);
                secondN = 0;
            } else
                break;
            resultList.add(Integer.toString(firstN - secondN));
            i++;
        }
        boolean onBegin = true;

        for (int j = resultList.size() - 1; j >= 0; j--) {
            if (onBegin && resultList.get(j).equals("0")) {

            } else {
                result.append(resultList.get(j));
                onBegin = false;
            }

        }

        return !result.toString().isEmpty() ? result.toString() : "0";
    }

    private String internalSimpleMultiply(String a, String b) {

        int i = 0;
        String result = "0";
        while (!(subtract(b, Integer.toString(i))).equals("0")) {
            result = append(a, result);
            i++;
        }

        return result;
    }

    private String internalMultiply(String a, String b) {

        List<Integer> secondNList = getReversedListFromString(b);
        List<String> resultList = new ArrayList<>();
        String result = "0";
        String zeros = "";

        for (int i = 0; i < secondNList.size(); i++) {
            String tempResult = internalSimpleMultiply(a, secondNList.get(i).toString());
            resultList.add(tempResult + zeros);
            zeros = zeros + "0";
        }

        for (String iterResult : resultList) {
            result = append(result, iterResult);
        }


        return result;
    }

    private boolean isNegative(String str) {
        return str.startsWith(negative);
    }

    private List<Integer> getReversedListFromString(String str) {
        List<Integer> result = new ArrayList<>();
        char[] temp = str.toCharArray();
        for (int i = temp.length - 1; i >= 0; i--) {
            result.add(Character.getNumericValue(temp[i]));
        }
        return result;
    }

    private String getUnsigned(String str) {
        return isNegative(str) ? str.substring(1) : str;
    }
}
