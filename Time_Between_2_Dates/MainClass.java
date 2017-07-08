package Time_Between_2_Dates;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainClass 
{
	public static void main(String[] args) 
	{
		Calendar calender1 = new GregorianCalendar(2017, 1,18,15,0, 0);
		Date date1 = calender1.getTime();
		
		Calendar calender2 = new GregorianCalendar(2017, 1,18,18,0 , 0);
		Date date2 = calender2.getTime();
		
		findTimeBetween(date1 , date2);
	}

	private static void findTimeBetween(Date date1, Date date2) 
	{
		Calendar calender = new GregorianCalendar();
		calender.setTime(date1);
		
		while(date1.compareTo(date2) < 0)
		{
			calender.add(Calendar.HOUR_OF_DAY, 1);
			date1 = calender.getTime();
			System.out.println(date1);
		}
	}
}
