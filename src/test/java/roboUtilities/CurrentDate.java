package test.java.roboUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by JShearen7 on 4/5/2016.
 */

public class CurrentDate {
    public Date currentDate;

    public CurrentDate(){
        currentDate = new Date();
    }
    public void createCurrentDateInstance(){
        currentDate = new Date();
    }

    public String returnCurrentDateUsingFormat(){
        //MonthDayHourMilli-Seconds
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dmsS");
        String formattedCurrentDate = simpleDateFormat.format(currentDate);
        return formattedCurrentDate;
    }

    public String returnCurrentDateUsingFormat(String dateFormat){
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat(dateFormat);
        String formattedCurrentDate = simpleDateFormat.format(currentDate);
        return formattedCurrentDate;
    }

}
