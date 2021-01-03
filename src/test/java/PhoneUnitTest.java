import org.testng.Assert;
import org.testng.annotations.Test;

public class PhoneUnitTest {
    @Test
    public void testPhone001() {
        Phone myPhone=new Phone("gold");
        myPhone.ring();
        String actualColor = myPhone.getColor();
        Assert.assertTrue(actualColor.equals("gold"));
    }

    @Test
    public void testPhone002() {
        Phone myPhone = new Phone();
        myPhone.setColor("red");
        boolean IsColorRed = myPhone.getColor() == "red";
        if (IsColorRed) {
            System.out.println("Yes, the color is red!");
        } else {
            System.out.println("No, the color is not red!");
        }
    }

    @Test
    public void testPhone003() {
        Phone myPhone=new Phone();
        myPhone.sendMessage();
        myPhone.ring();
        myPhone.receiveCall();
        myPhone.vibrationMode();
    }

    @Test
    public void testPhones001() {
        Phone myPhoneOne=new Phone("silver");
        Phone myPhoneTwo=new Phone("red");

        myPhoneOne.setMemorySize(64);
        myPhoneTwo.setMemorySize(32);


        boolean isFirstPhoneBetter=myPhoneOne.getMemory()>myPhoneTwo.getMemory();
        Assert.assertTrue(isFirstPhoneBetter);
    }

    @Test
    public void testPhones002() {
        Phone myPhoneOne=new Phone("red");
        Phone myPhoneTwo=new Phone("silver");
        myPhoneOne.setMemorySize(128);
        myPhoneTwo.setMemorySize(64);
       boolean BetterBasedOnMemory=myPhoneOne.getMemory()<myPhoneTwo.getMemory();
       if (BetterBasedOnMemory) {
           System.out.println("Second phone is better because of the larger memory!");
       }else {System.out.println("First phone is better because of the larger memory!");}
    }


    @Test
    public void testPhones003() {
        Phone myPhoneOne=new Phone((float) 5.8, "iPhone XS", 64, "gold", "Glass front and back");
        Phone myPhoneTwo=new Phone((float) 6.1, "iPhone 11", 128, "Purple", "Glass front and back" );
        Phone myPhoneThree=new Phone((float) 5.4, "iPhone 12", 256, "red", "Ceramic Shield front");
      boolean  BetterBasedOnScreenSize=myPhoneOne.screenSize>myPhoneTwo.screenSize;
        if (BetterBasedOnScreenSize) {
            System.out.println("Phone one has a bigger screen!");
        }else{
            System.out.println("Phone two has a bigger screen!");
        }

    }

    @Test
    public void testPhones004() {
        Phone myPhoneOne=new Phone("iPhone XS", "gold");
        Phone myPhoneTwo=new Phone("iPhone 11", "purple");
        myPhoneOne.setScreenSize((float) 5.8);
        myPhoneTwo.setScreenSize((float) 6.1);
       boolean BiggerScreen=myPhoneOne.getScreenSize()<myPhoneTwo.getScreenSize();
       if (BiggerScreen) {
           System.out.println("iPhone 11 has a bigger screen!");
       }else{
           System.out.println("iPhone XS has a bigger screen!");
       }
    }


}
