import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.mustache.Value;

import java.awt.*;
import java.util.Arrays;

public class JavaEX01 {
    @Test
    public static void test00001() {
        System.out.println("Hello, World!");
    }

    @Test
    public void test00002() {
   String message01="Hello, World!";
        System.out.println(message01);
    }

    @Test
    public void test00003() {
        int myNumber=7;
        int expectedValue=4;

        int actualNumber=SubtractThree(7);
        System.out.println(actualNumber);

        Assert.assertEquals(actualNumber,expectedValue);
    }

    public int SubtractThree(int parameter){
      int  result=parameter - 3;
      return result;

    }


    @Test
    public void test00004() {
        int myNumber=5;
        int diffNumber=addTwo(myNumber);
        System.out.println(diffNumber);
        Assert.assertEquals(diffNumber,7);
    }

    public int addTwo(int parameter){
        int result=parameter + 2;
        return result;
    }

    @Test
    public void test00005() {
        // Create a string with a constructor
        String s1 = new String("Who let the dog out?");        // String object stored in heap memory
// Just using "" creates a string, so no need to write it the previous way.
        String s2 = " Who who who who!";                         // String literal stored in String pool
// Java defined the operator + on strings to concatenate:
        String s3 = s1 + s2;
        System.out.println(s3);
    }

    @Test
    public void test00006() {
        String prefix="Sentence: ";
        String sentence="Who who who?";
        String result=CombineAndPrint(prefix, sentence);


        Assert.assertEquals(result, "Sentence: Who who who?");
    }

    public String CombineAndPrint(String StringOne, String StringTwo){
       String result=StringOne + StringTwo;
        System.out.println(result);
       return result;

    }

    @Test
    public void test00007() {
        int myNumber=8;
        int divider=2;
        int resultAfterDivision=4;
        int remainder=8%2;

        Assert.assertEquals(remainder, 0);

        if (remainder==0){
            System.out.println("It's true!");
        }else {System.out.println("Remainder is not ZERO!");}
    }

    @Test
    public void TestIfEven() {
        int a=7;
        if (a%2==1){
            System.out.println("The number is odd!");
        }                                          else {
            System.out.println("The number is even!");
        }
    }

    @Test
    public void ChangeCarLight() {
        boolean LeftLight=true;
        boolean RightLight=true;
        boolean NeedToChange=LeftLight && RightLight;
        if (NeedToChange){
            System.out.println("Do not need to change!");
             }    else{
            System.out.println("At least one of the lights has to be changed!");
        }
    }

    @Test
    public void TestingVisibleElements() {
        boolean FirstButton=true;
        int NumberOfSeconds= 4;
        boolean FastEnough= NumberOfSeconds <5;

        if(FirstButton && FastEnough){
            System.out.println("Button is visible!");
            }else {
            System.out.println("Button is invisible!");
        }
    }

    @Test
    public void test00008() {
        boolean isVisible=true;

        if (isVisible){
            System.out.println("element is visible");
        }else {System.out.println("element is not visible");}
        }

        @Test
        public void test00009() {
        int el=4;
        if (el%2==0)
            System.out.println("It is even");
        else System.out.println("It is odd");

        }

    @Test
    public void test00010() {
        int i;
        int j;
        for (i = 0; i < 5; i++) {
            if (i >= 2) {
                j=i+2;
                System.out.println(j);
            }else { System.out.println("Yuhu");}

        }
     System.out.println("Casper");

    }

    @Test
    public static void test00011() {
        int i=0;
        int[] arr=new int[11];
        arr[0]=2;
        while(i<10) {
            arr[i+1]=arr[i]+2;
            System.out.println(arr[i+1]);
            i++;
        }
    }

    @Test
    public void testArrays() {
        int[] ArrayOfNumbers={1,2,3,4};
        String[] ArrayOfStrings={"string01","string02","string03","string04"};
        int ArrayOfStringsLength=ArrayOfStrings.length;
        System.out.println(ArrayOfStringsLength);
            System.out.println(ArrayOfStrings[3]);
        String ConvertedArray1= Arrays.toString(ArrayOfStrings);
        String ConvertedArray2=Arrays.toString(ArrayOfNumbers);
        System.out.println(ConvertedArray1);
        System.out.println(ConvertedArray2);
         PrintStringArray(ArrayOfStrings);
         PrintIntArray(ArrayOfNumbers);
    }

    public void PrintStringArray(String[] ArrayOfStrings){
        int i;
        for (i=0; i<ArrayOfStrings.length; i++){
            System.out.println(ArrayOfStrings[i]);

        }
    }
        public void PrintIntArray(int[] ArrayOfNumbers){
         for (int i=0; i<ArrayOfNumbers.length; i=i+1){
                System.out.println(ArrayOfNumbers[i]);
            }
        }

    @Test
    public void testFindElement() {
        int[] InputArray={1,2,3,4,5,6,8,9,22343,4,6,7,8};
        int ValueToFind=223434;
        ElementToFind(InputArray, ValueToFind);
    }

    public void ElementToFind(int[] InputArray, int ValueToFind){
        for(int i=0; i<InputArray.length;i++){
            if (InputArray[i]==ValueToFind){
                System.out.println("Element " + ValueToFind + " is found!");
            }
        }
        
    }

    @Test
    public void testPoint() {
        Point myNewPoint = new Point(3, 4);
        Point anotherPoint= new Point(5,6);
        int valueFromNewPoint= myNewPoint.getX();
        System.out.println(valueFromNewPoint);
        System.out.println(anotherPoint.getY());
    }
    public class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    @Test
    public void testSwapValues() {
        int a=10;
        int b=20;
        swap(a,b);
    }
    private void swap(int a, int b){
        System.out.println("Before Swap");
        System.out.println("a=" + a);
        System.out.println("b=" + b);
            a=a+b;
        b=a-b;
         
      a=a-b;
        System.out.println("After Swap");
              System.out.println("a=" + a);
             System.out.println("b="+ b);    }


             static void myMethod(){
                 System.out.println("I just got executed!");
             }


    @Test
    public static void main(){
        myMethod();
        myMethod();
             }
}
