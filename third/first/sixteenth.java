package third.first;

public class sixteenth {
    public static void main(String[] args) throws Exception {
    }
    public interface Animal {
        String getColor();
        Integer getAge();
    }
    public static abstract class Fox implements Animal {
        public String getName() {
            return "Fox.";
        }
    }
}
