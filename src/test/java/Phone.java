public class Phone {
    float screenSize;
    String model;
    int memorySize;
    String color;
    String material;
    int sizeOfimage;

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

    public void callRejected(){
        System.out.println("Call is rejected!"); }

        public void ableToConnectToNetwork(){ System.out.println("Phone gets connected to Network!"); }

        public void savesContactNumber(){
            System.out.println("Contact is saved successfully!");
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

    public void setScreenSize(float screenDiagonal) {screenSize=screenDiagonal;}
    public float getScreenSize() {return screenSize;}


    public void setSizeOfimage(int sizeOfPhoto) {
       sizeOfimage=sizeOfPhoto; }
        public int getSizeOfimage(){return sizeOfimage;}
}
