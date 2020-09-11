package navloganalyzer.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class MyStringUtils {
    public static void sortListItems(List<String> list) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Pattern pattern =  Pattern.compile("^student(\\d+)?$");
                Matcher matcher1 = pattern.matcher(o1);
                matcher1.matches();
                Matcher matcher2 = pattern.matcher(o2);
                matcher2.matches();
                int o1Number = Integer.parseInt(matcher1.group(1));
                int o2Number = Integer.parseInt(matcher2.group(1));
                if(o1Number < o2Number) return -1;
                else if(o1Number > o2Number) return 1;
                else return 0;
            }
        };
        Collections.sort(list, comparator);
    }
}
