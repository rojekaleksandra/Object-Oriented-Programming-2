public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private int weight;
    private int height;

    private Person(){}

    public static final class Builder {
        private String firstName;
        private String lastName;
        private int age;
        private int weight;
        private int height;

        public zad3.Person.Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public zad3.Person.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public zad3.Person.Builder age(int age) {
            this.age = age;
            return this;
        }

        public zad3.Person.Builder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public zad3.Person.Builder height(int height) {
            this.height = height;
            return this;
        }

        public zad3.Person build() {
            if (firstName == null || lastName == null || age == 0 || height == 0 || weight == 0) {
                System.out.println("cannot create");
                return null;
            }
            zad3.Person person = new zad3.Person();
            person.firstName = this.firstName;
            person.lastName = this.lastName;
            person.age = this.age;
            person.height = this.height;
            person.weight = this.weight;
            return person;
        }

    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{firstName='" + firstName + "', lastName='" + lastName + "', age=" + age + ", weight=" + weight + ", height=" + height + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;
        zad3.Person anotherPerson = (zad3.Person) o;
        return firstName.equals(anotherPerson.firstName) && lastName.equals(anotherPerson.lastName) && age == anotherPerson.age && weight == anotherPerson.weight && height == anotherPerson.height;
    }
}