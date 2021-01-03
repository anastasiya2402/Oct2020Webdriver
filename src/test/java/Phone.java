import java.sql.SQLOutput;

public class Phone {
    float screenSize;
    String model;
    int memorySize;
    String color;
    String material;
    public Phone(String colorParameter) {
        color=colorParameter;
    }

    public Phone(float screenSize, String model, int memorySize, String color, String material) {
        this.screenSize = screenSize;
        this.model = model;
        this.memorySize = memorySize;
        this.color = color;
        this.material = material;
    }

 public Phone(String model, String color){
        this.model=model;
        this.color=color;
 }

  public Phone() {
    }

    public void ring(){
        System.out.println("Ring!");
    }
    public void sendMessage(){
        System.out.println("Message sent!");
    }

    public void receiveCall(){
        System.out.println("Call received!");
    }

    public void vibrationMode() {
        System.out.println("Phone vibrates!");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMemorySize(int memoryValue) {
        memorySize=memoryValue;
    }

    public int getMemory() {
        return memorySize;
    }

    public void setScreenSize(float screenHeight) {screenSize=screenHeight;}
    public float getScreenSize() {return screenSize;}


}
