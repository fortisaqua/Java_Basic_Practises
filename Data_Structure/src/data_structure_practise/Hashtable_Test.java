package data_structure_practise;

import java.util.*;
import java.text.*;

class Date_Info{
    private String day;
    protected Date date;
    public Date_Info(){
        date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat(" G E yyyy.MM.dd 'at' hh:mm:ss a zzz S");
        this.day = sf.format(this.date);
    }
    protected String getDay()
    {
        return this.day;
    }
    protected void setDay(String day_str){
        this.day=day_str;
    }
}

public class Hashtable_Test {

//   long型计时数字和date类之间的互换

    public static String convert2String(long time, String format) {
        if (time > 0l) {
            SimpleDateFormat sf = new SimpleDateFormat(format);
            Date date = new Date(time);
            return sf.format(date);
        }
        return "";
    }

    public static long convert2long(String date, String format) {
        try {
                SimpleDateFormat sf = new SimpleDateFormat(format);
                return sf.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0l;
    }

    public static void main(String args[]) {
        // Create a hash map
        Hashtable balance = new Hashtable();
        Enumeration names;
        String str;
        double bal;
        Date_Info date_info = new Date_Info();
        try {
            balance.put("Zara", new Double(3434.34));
            balance.put("Mahnaz", new Double(123.22));
            balance.put("Ayan", new Double(3434.34));
            balance.put("Daisy", new Double(99.22));
            balance.put("Qadir", new Double(-19.08));
            balance.put("pay day",date_info.getDay());
            balance.put("Oliver",new Integer(15000));
            balance.put("save time",convert2String(System.currentTimeMillis( ),"yyyy-MM-dd HH:mm:ss"));
            // Show all balances in hash table.
            names = balance.keys();
//            Enumeration 对象使用hasMoreElement方法判断是否便利到最后
            while (names.hasMoreElements()) {
                str = (String) names.nextElement();
                System.out.println(str + ": " +
                        balance.get(str));
            }
            System.out.println();
            // Deposit 1,000 into Zara's account
            bal = ((Double) balance.get("Zara")).doubleValue();

//           Hashtable可以判断是否含有一个特定的关键字
            if(balance.containsKey("Zara")){
            balance.put("Zara", new Double(bal + 1000));
            System.out.println("Zara's new balance: " +
                    balance.get("Zara"));
            }
            if(balance.containsValue(-19.08)){
                Iterator itr = balance.keySet().iterator();
                while(itr.hasNext()){
                    str = (String)itr.next();
                    if(balance.get(str).equals(-19.08)){
                        System.out.println(str+" has strange salary: "+-19.08);
                    }
                }
                System.out.println();
            }
            System.out.write('\n');

//            Hashtable 中的elements方法返回的是值的枚举（不重复的返回）
            Enumeration em = balance.elements();
            while(em.hasMoreElements()){
                System.out.println(em.nextElement());
            }

        } catch (Exception e){
            e.getMessage();
            e.getCause();

        }
    }

}
