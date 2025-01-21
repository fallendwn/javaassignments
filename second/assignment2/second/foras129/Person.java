package b.assignment1.second.foras129;

public class Person {
        public String firstName;
        public String lastName;
        public Person(String firstName, String
                lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public String getFirstName() {
            return firstName;
        }
        String getLastName() {
            return lastName;
        }
        public String getFullName(){
            return firstName + " " + lastName;
        }
}
