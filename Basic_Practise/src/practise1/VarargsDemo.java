package practise1;

//可变参数：可以改变数量的参数，它的输入必须是和省略号前面的类型一致的，0个或多个参数，或者一个一维数组

public class VarargsDemo {
    public static void main(String args[]) {
        // 调用可变参数的方法
        printMax(34, 3, 3, 2, 56.5);
        printMax(new double[]{1, 2, 3});
        printMax();
        int sub_len = (int)(Math.random()*20);
        double[] new_array = new double[sub_len];
        for(int i=0 ; i<sub_len ; i++)
        {
            new_array[i] = Math.random()*100;
        }
        printMax(new_array);
        printMax(new_array[0],new_array[1],new_array[2],new_array[3],new_array[4],new_array[5]);
        printMax(new_array[5]);
//        double[][][] multi_axis = new double[2][3][];
//        for(double[][] elem1 : multi_axis){
//            for(double[] elem2 : elem1)
//            {
//                int sub_len = (int)(Math.random()*20);
//                for(int i=0 ; i<sub_len ; i++){
//                    elem2[i] = Math.random()*100;
//                }
//            }
//        }
//        printMax(multi_axis)d
    }

    public static void printMax( double... numbers) {
        if (numbers.length == 0) {
            System.out.println("No argument passed");
            return;
        }

        double result = numbers[0];

        for (int i = 1; i <  numbers.length; i++){
            if (numbers[i] >  result) {
                result = numbers[i];
            }
        }
        System.out.println("The max value is " + result);
    }
}
