package b.assignment1.second;

public class as127 {
    /*
Welcome! But not everyone.
*/
        public static void main(String[] args) {
            signIn("USER");
        }
        public static void signIn(String username){

            if(username.equalsIgnoreCase("user")){
                return;
            }
            System.out.println("Welcome " + username.toLowerCase());
            System.out.println("Missed you very much, " + username);
        }
    }
