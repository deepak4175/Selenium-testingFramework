package utility.utils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static String getCurrentDate(String DateFormat, String TimeFormat){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat(DateFormat+"_"+TimeFormat);
        String strDate = dateFormat.format(date);
        return strDate;
    }
    public static String getCurrentDate(){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss");
        String strDate = dateFormat.format(date);
        return strDate;
    }

}
