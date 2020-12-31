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
        Phone myPhoneOne=new Phone("silver");
        Phone myPhoneTwo=new Phone("red");

        myPhoneOne.setMemorySize(64);
        myPhoneTwo.setMemorySize(32);


        boolean isFirstPhoneBetter=myPhoneOne.getMemory()>myPhoneTwo.getMemory();
        Assert.assertTrue(isFirstPhoneBetter);
    }

    @Test
    public void testPhones() {
        Phone myPhoneOne=new Phone((float) 5.8, "iPhone XS", 64, "gold", "Glass front and back");
        Phone myPhoneTwo=new Phone((float) 6.1, "iPhone 11", 128, "Purple", "Glass front and back" );
        Phone myPhoneThree=new Phone((float) 5.4, "iPhone 12", 256, "red", "Ceramic Shield front");

      boolean  isFirstPhoneWorse=myPhoneOne.screenSize()<myPhoneTwo.screenSize();
        Assert.assertTrue(isFirstPhoneWorse);
        System.out.println("iPhone XS screen size= " + myPhoneOne.screenSize + " in");
    }
}
