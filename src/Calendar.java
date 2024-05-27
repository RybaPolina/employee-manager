import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Calendar {
    static String[] year;
    static String[] month;
    static String[] day;
    static String[] hours = {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"};

    public Calendar() {
    }

    public static String[] getYear() {
        int yearsCount = 3;
        String[] year = new String[yearsCount];
        LocalDate dateTime = LocalDate.now();
        for (int i = 0; i < yearsCount; i++){
            year[i] = dateTime.format(DateTimeFormatter.ofPattern("uuuu"));
            dateTime = dateTime.plusYears(1);
        }
        return year;
    }

    public static String[] getMonth(){
        int monthsCount = 12;
        String[] month = new String[monthsCount];
        LocalDate dateTime = LocalDate.now();
        for (int i = 0; i < monthsCount; i++){
            month[i] = dateTime.format(DateTimeFormatter.ofPattern("MM"));
            dateTime = dateTime.plusMonths(1);
        }
        return month;
    }

    public static String[] getDay() {
        int daysCount = 31;
        String[] day = new String[daysCount];
        LocalDate dateTime = LocalDate.now();
        for (int i = 0; i < daysCount; i++){
            day[i] = dateTime.format(DateTimeFormatter.ofPattern("d"));
            dateTime = dateTime.plusDays(1);
        }
        return day;
    }
    public static String[] getHours() {
        return hours;
    }
}
