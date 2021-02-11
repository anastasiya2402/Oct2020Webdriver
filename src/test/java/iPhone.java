import org.testng.annotations.Test;

public class iPhone extends iPad {

    public iPhone(String color) {
        super(color);

    }


    @Test
    public void testName() {
        iPad myiPhone = new iPhone("red");
        System.out.println("My iPhone is " + myiPhone.color + " as well!");

        callSomeone();
        canUseCellularDataForWeb();
        hasWiFI();
        typeProjects();
        surfTheWeb();
        sendMesssages();
        makeSkypeCalls();


    }

    private void canUseCellularDataForWeb() {
        System.out.println("I can use cellular data to go online!");
    }

    private void callSomeone() {
        System.out.println("I can call anyone as long as the number I dial exists!");
    }
}
