import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Test {
    public static void main(String[] args) {
        final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

        LocalDateTime start =  LocalDateTime.parse("201811161930", dateFormat);


        System.out.println(ChronoUnit.MINUTES.between(LocalDateTime.now(), start));


//        System.out.println(dateFormat.parse("20181005"));

    }
}
