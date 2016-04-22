import java.util.Comparator;

/**
 * Created by Valko Serhii on 22-Apr-16.
 */
public class NumberComparator implements Comparator<String> {

    @Override
    public int compare(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 == len2) {
            int lim = Math.min(len1, len2);
            char v1[] = str1.toCharArray();
            char v2[] = str2.toCharArray();
            int k = 0;
            while (k < lim) {
                char c1 = v1[k];
                char c2 = v2[k];
                if (c1 != c2) {
                    return c1 - c2;
                }
                k++;
            }
        }
        return len1 - len2;
    }
}
