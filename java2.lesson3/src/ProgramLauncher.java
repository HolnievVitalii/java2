import java.util.*;

/**
 * @author holni
 * @version dated August 22, 2019
 */

public class ProgramLauncher {

    /**
     * Phone book of persons w/ additional numbers
     * @param args
     */
    public static void main(String[] args) {

        /**
         * Task 2
         * creating a phone book
         */

        /**
         * contact information
         */
        PhoneBook firstPerson = new PhoneBook("Gromov", 80976745211L);
        PhoneBook secondPerson = new PhoneBook("Luchev", 80674522212L);
        PhoneBook thirdPerson = new PhoneBook("Balalaev", 80954356341L);

        /**
         * first person additional numbers
         */
        List<Long> firstPersonNumbers = new ArrayList<>();
        firstPersonNumbers.add(80965644325L);
        firstPersonNumbers.add(80947785441L);
        /**
         * second person additional numbers
         */
        List<Long> secondPersonNumbers = new ArrayList<>();
        secondPersonNumbers.add(80556743717L);

        /**
         * third person additional numbers
         */
        List<Long> thirdPersonNumbers = new ArrayList<>();
        thirdPersonNumbers.add(80889878615L);


        /**
         * adding additional numbers to persons
         */
        Map<PhoneBook, List<Long>> personOne = new HashMap<>();
        personOne.put(firstPerson, firstPersonNumbers);

        Map<PhoneBook, List<Long>> personTwo = new HashMap<>();
        personTwo.put(secondPerson,secondPersonNumbers);

        Map<PhoneBook, List<Long>> personTree = new HashMap<>();
        personTree.put(thirdPerson,thirdPersonNumbers);

        /**
         * full person info w/ additional numbers(key = surname)
         */
        Map<String, Map> contactBase = new HashMap<>();
        contactBase.put("Gromov", personOne);
        contactBase.put("Luchev", personTwo);
        contactBase.put("Balalaev", personTree);

        /**
         * person info output
         */
        System.out.println("Second Task: ");
        System.out.println(contactBase.get("Gromov"));
        System.out.println(contactBase.get("Luchev"));
        System.out.println(contactBase.get("Balalaev"));
        System.out.println();
        System.out.println("First Task: ");
        uniqueWords();
        }

    /**
     *method for listing unique words from a list
     * and the number of repetitions of not unique words
     */
    public static void uniqueWords() {
            List<String> words = new ArrayList<>();
            words.add("Cat");
            words.add("Dog");
            words.add("Girl");
            words.add("Girl");
            words.add("Sun");
            words.add("Cat");
            Set<String> tempList = new LinkedHashSet<>();
            for (String s : words) {
                String a  = s.toLowerCase();
                tempList.add(a);
            }
            for (String x : tempList) {
                int count = 0;
                for (String c : words) {
                    String a = c.toLowerCase();
                    if (x.equals(a)) count++;
                    }
                System.out.println("The " + "|" + x + "|" + " appears on the list " + count + " times");

                if (count == 1) {
                    System.out.println("{" + x +"}" + " is unique word");
                }
            }
            System.out.println();
        }
    }

