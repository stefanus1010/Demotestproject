package com.example.demo.utils;


import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class DateTimeUtils {

    private static final ZoneId DEFAULT_ZONE_ID = ZoneId.systemDefault();

    private DateTimeUtils() {
        //hide default public constructor
        throw new AssertionError("No DateTimeUtils instances for you!");
    }

    public static ZonedDateTime withJakartaTime(ZonedDateTime zonedDateTime) {
        return Objects.requireNonNull(zonedDateTime).withZoneSameInstant(ZoneId.of("Asia/Jakarta"));
    }

    /**
     * Truncates time part making it 00:00:00.000 with same timezone
     * @param zonedDateTime the date time to truncate
     * @return date with time set to 00:00:00.000
     */
    public static ZonedDateTime truncateTime(ZonedDateTime zonedDateTime) {
        return Objects.requireNonNull(zonedDateTime).truncatedTo(ChronoUnit.DAYS);
    }

    public static ZonedDateTime beginningOfDayAtJakartaTimeZone(ZonedDateTime zonedDateTime) {
        return truncateTime(Objects.requireNonNull(zonedDateTime).withZoneSameInstant(ZoneId.of("Asia/Jakarta")));
    }

    public  static long zonzonedDateTimeDifference (ZonedDateTime d1, ZonedDateTime d2, ChronoUnit unit){
        return unit.between(d1,d2);
    }

    public static boolean isBetween(ChronoZonedDateTime<?> chronoZonedDateTime, ChronoZonedDateTime<?> min, ChronoZonedDateTime<?> max) {
        Objects.requireNonNull(chronoZonedDateTime);

        if (Objects.nonNull(min) && chronoZonedDateTime.isBefore(min)) {
            return false;
        }

        return Objects.isNull(max) || chronoZonedDateTime.compareTo(max) <= 0;
    }

    public static long dayDifference(Temporal date1, Temporal date2) {
        return Math.abs(ChronoUnit.DAYS.between(date1, date2));
    }

    public static ZonedDateTime min(ZonedDateTime... zonedDateTimes) {
        return Collections.min(Arrays.asList(zonedDateTimes), Comparator.nullsLast(Comparator.naturalOrder()));
    }
}
