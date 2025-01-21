package third.first;

public class sixth {
    public static void main(String[] args){

    }
    interface Updatable{
        public void refresh();
    }

    interface Selectable{
        public void onSelect();
    }

    public class Screen implements Updatable, Selectable{
        public void refresh(){

        }
        public void onSelect(){

        }

    }

}
