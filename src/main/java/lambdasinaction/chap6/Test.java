package lambdasinaction.chap6;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pengzhe
 * @date 2019-03-30 21:15
 * @description
 */

public class Test {

    public static void main(String[] args) {

        Map<String, String> stringMap = new HashMap<>();
        stringMap.putIfAbsent("key", "value");
        stringMap.putIfAbsent("key2", "value2");
        stringMap.putIfAbsent("key3", "value3");
        stringMap.putIfAbsent("key4", "value4");
        stringMap.putIfAbsent("key5", "value5");
        stringMap.putIfAbsent("key6", "value6");

        stringMap.forEach((k, v) -> {
            System.out.println(k+"-----"+v);
        });

    }
}
