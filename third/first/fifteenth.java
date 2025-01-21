package third.first;

public class fifteenth {
    public static void main(String[] args) throws Exception {
    }
    interface Selectable {
        public void onSelect();
    }
    interface Updatable extends Selectable {
        public void refresh();
    }
    static class Screen implements Updatable {
        public void refresh(){

        }
        public void onSelect(){

        }
    }
}
