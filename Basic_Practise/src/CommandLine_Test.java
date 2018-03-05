public class CommandLine_Test {
    public static void main(String args[]){
        int i=0;
        for(String elem:args){
            System.out.println("args[" + (i++) + "]: " + elem);
            String temp = elem+100;
//            int strlen = elem.length;
        }
    }
}
