package TechInterview;

public class SingletonDesign {
    
    private static final SingletonDesign singleton = new SingletonDesign();
    
    private SingletonDesign() {}
    
    public static SingletonDesign getInstance() {
        return singleton;
    }
    
    public void showMessage() {
        System.out.println("Awesome!");
    }
    
    public static void main(String[] args) {
        SingletonDesign single = getInstance();
        single.showMessage();
    }
}