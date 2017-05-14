package Resources;

import java.util.Arrays;

/**
 * Created by eee on 14.05.2017.
 */
public class Extensions {
    public static String[] getNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }
}
