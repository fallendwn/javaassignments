package b.assignment1.second;

public class as123 {

        public static void main(String[] args) {
            String firstName = "Olga";
            String secondName = "Kipriyanovna";
            String favoriteDish = "Dumplings";
            printPersonInfo(firstName, secondName, favoriteDish);

        }

        public static void printPersonInfo(String name, String surname, String meal){
            System.out.println("Brief Dossier:");
            System.out.println("Name: " + name);
            System.out.println("LastName: " + surname);
            System.out.println("Favorite dish: " + meal);
    }
}

