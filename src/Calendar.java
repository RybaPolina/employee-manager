import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Calendar {
    static String[] year = {"2024", "2025", "2026", "2027"};
    static String[] month = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10","11","12"};
    static String[] day = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    static String[] hours = {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"};

    public Calendar() {
    }

    public static String[] getYear() {
        return year;
    }

    public static String[] getMonth(){
        return month;
    }

    public static String[] getDay() {
        return day;
    }
    public static String[] getHours() {
        return hours;
    }
}
