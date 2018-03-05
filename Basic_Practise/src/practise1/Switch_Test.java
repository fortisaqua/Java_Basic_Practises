package practise1;

public class Switch_Test {
    public static void main(String[] args){
        //char grade = args[0].charAt(0);
        char grade = 'C';
//        Java中switch-case结构下的case分支不用大括号括起来
        switch(grade)
        {
            case 'A' :
                System.out.println("优秀");
                System.out.println("great");
                break;
            case 'B' :
            case 'C' :
                System.out.println("良好");
                System.out.println("good");
                break;
            case 'D' :
                System.out.println("及格");
                System.out.println("fine");
            case 'F' :
                System.out.println("你需要再努力努力");
                break;
            default :
                System.out.println("未知等级");
        }
        System.out.println("你的等级是 " + grade);
    }
}
