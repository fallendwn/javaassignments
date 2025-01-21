package third.second.ninth;

public class Iphone {
    private String model;
    private String color;
    private int price;
    public Iphone(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;

    }
    @Override public boolean equals(Object obj) {
        Iphone newIphone = (Iphone) obj;
        if (obj == null){
            return false;
        }
        if(this.model == newIphone.model && this.color == newIphone.color && this.price == newIphone.price) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Iphone iphone1 = new Iphone("X", "Black", 999);
        Iphone iphone2 = new Iphone("X", "Black", 999);
        System.out.println(iphone1.equals(iphone2));
    }

}