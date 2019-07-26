package com.jaem.utilities;
import java.util.Calendar;
import org.mule.api.MuleMessage;
import org.mule.api.routing.filter.Filter;
import java.text.SimpleDateFormat;

public class ScheduleValidation implements Filter {
	
	private static String timeRange;

	public static String getTimeRange() {
		return timeRange;
	}

	public static void setTimeRange(String timeRange) {
		ScheduleValidation.timeRange = timeRange;
	}
	
	public static boolean isHourInterval(String target,String start,String end)
	{
		return ((target.compareTo(start)>= 0)&& (target.compareTo(end)<= 0));
	}

	public boolean accept(final MuleMessage message) {
		System.out.println(new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime()));
		return ScheduleValidation.isHourInterval(new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime()), timeRange.split("-")[0], timeRange.split("-")[1]);
	}
	
	
	

}
