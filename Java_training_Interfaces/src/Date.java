import java.util.*;
import java.time.LocalDate;
public class Date implements dateInt{
    public LocalDate addDate(LocalDate d1){
        return d1.plusDays(10);
    }
    public LocalDate findYear(LocalDate d1) {
        return d1;
    }
    public LocalDate setBirthDate(LocalDate d1) {
        return d1;
    }
}
