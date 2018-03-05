package data_structure_practise;
import java.util.Vector;
import java.util.Enumeration;

class Day{
    private String day;
    public Day(String day_str){
        this.day=day_str;
    }
    protected String getDay()
    {
        return this.day;
    }
    protected void setDay(String day_str){
        this.day=day_str;
    }
}

// Enumeration接口中定义了一些方法，通过这些方法可以枚举（一次获得一个）对象集合中的元素

public class Enumeration_Test {
    public static void main(String[] args){
        Enumeration<Day> days;
        Vector<Day> dayNames = new Vector<Day>();
        dayNames.add(new Day("Sunday"));
        dayNames.add(new Day("Monday"));
        dayNames.add(new Day("Tuesday"));
        dayNames.add(new Day("Wednesday"));
        dayNames.add(new Day("Thursday"));
        dayNames.add(new Day("Saturday"));
        dayNames.add(new Day("Friday"));
        days = dayNames.elements();
        while (days.hasMoreElements()){
            Day temp_day = days.nextElement();
            System.out.println(temp_day+" : "+temp_day.getDay());
        }
    }
}
