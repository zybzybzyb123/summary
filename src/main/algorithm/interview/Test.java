package main.algorithm.interview;

//大写字母移动到小写字母后面

/**
 *
 */
public class Test {
    private static void bubbleSolve(char[] array){
        int len = array.length;
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len - 1 -i; j++){
                if (array[j] < 'a' && array[j + 1] > 'Z'){
                    char temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    private static void moveSolve(){

    }
    public static void main(String[] args) {
        String str = "AkleBiCeilD";
        char[] array = str.toCharArray();
        System.out.println(new String(array));
        bubbleSolve(array);
        System.out.println(new String(array));
    }
}
