package io.github.tanghuibo.onepiecestudyweb.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author tanghuibo
 * @date 2020/12/8上午12:00
 */
public class DateUtils {
    public static Long toTimestamp(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }

        return localDateTime.toEpochSecond(ZoneOffset.of("+8"));
    }
}
