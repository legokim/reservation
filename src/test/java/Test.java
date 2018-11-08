import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
        final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

        LocalDateTime start = LocalDateTime.parse("201811061030");
        System.out.println(start);
    }
}
