package zad2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IsValidDateFormat {

    public boolean isValidFormat(String format, String value) {
        if (!value.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")) {
            return false;
        }

        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }
}
