import java.util.*;

public class PersonArray {
    private Person[] people;

    public PersonArray() {
        people = new Person[0];
    }

    public PersonArray(zad3.PersonArray personArray) {
        people = personArray.people.clone();
    }

    public void addPerson(Person person) {
        if (person != null && !Arrays.asList(people).contains(person)) {
            people = Arrays.copyOf(people, people.length + 1);
            people[people.length - 1] = person;
        }
    }

    public void removePerson(Person person) {
        if (person != null && Arrays.asList(people).contains(person)) {
            Person[] people1 = new Person[people.length - 1];
            int index = Arrays.asList(people).indexOf(person);
            System.arraycopy(people, 0, people1, 0, index);
            System.arraycopy(people, index + 1, people1, index, people.length - index - 1);
            people = people1;
        }else{
            System.out.println("Cannot remove !");
        }
    }

    public void sortByAge() {
        Arrays.sort(people, Comparator.comparingInt(Person::getAge));
    }

    @Override
    public String toString() {
        return Arrays.toString(people);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;
        zad3.PersonArray anotherA = (zad3.PersonArray) o;
        return Arrays.equals(this.people, anotherA.people);
    }
}