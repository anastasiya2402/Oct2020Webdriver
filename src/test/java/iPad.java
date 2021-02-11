import org.testng.annotations.Test;

public class iPad {
    String color;

    public iPad(String color) {
        this.color = color;
    }


    @Test
    public void testName() {

        hasWiFI();
        typeProjects();
        surfTheWeb();
        sendMesssages();
        makeSkypeCalls();
        iPad myiPad = new iPad("red");
        System.out.println("My iPad is " + myiPad.color);


    }

    public void makeSkypeCalls() {
        System.out.println("I can make video calls over Wi-Fi to my Contacts!");
    }

    public void sendMesssages() {
        System.out.println("One can open Messages and send something to My Contacts over Wi-Fi!");
    }

    public void surfTheWeb() {
        System.out.println("One can open Safari and search the web!");
    }

    public void typeProjects() {
        System.out.println("I can open Notes and type something!");
    }

    public void hasWiFI() {
        System.out.println("It has a Wi-Fi connection. I can go online!");


    }
}


