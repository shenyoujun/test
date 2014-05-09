import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 14-2-25.
 */
public class Utils {
    @Test
    public void toLowerCase() {
        String s = "76D98044-0C3B-43D3-A3C7-C13AAC6F68CC";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                stringBuilder.append(Character.toLowerCase(c));
            } else {
                stringBuilder.append(c);
            }
        }
        System.out.println(stringBuilder);
    }
}
