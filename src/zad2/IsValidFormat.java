package zad2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IsValidFormat {

//  public static boolean isValidFormat(String value, Locale locale) {
//    LocalDateTime ldt = null;
//    DateTimeFormatter fomatter = DateTimeFormatter.ofPattern(locale);
//
//    try {
//      ldt = LocalDateTime.parse(value, fomatter);
//      String result = ldt.format(fomatter);
//      return result.equals(value);
//    } catch (DateTimeParseException e) {
//      try {
//        LocalDate ld = LocalDate.parse(value, fomatter);
//        String result = ld.format(fomatter);
//        return result.equals(value);
//      } catch (DateTimeParseException exp) {
//        try {
//          LocalTime lt = LocalTime.parse(value, fomatter);
//          String result = lt.format(fomatter);
//          return result.equals(value);
//        } catch (DateTimeParseException e2) {
//        }
//      }
//    }
//
//    return false;
//  }

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
