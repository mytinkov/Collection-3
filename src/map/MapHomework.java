package map;

import map.phonebook.FullName;
import map.phonebook.PhoneBook;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class MapHomework {
    private final static Random RANDOM = new Random();
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
//        phoneBook.addPhone(new FullName("Ivan", "Ivanov"), getPhoneNumber());
        while (phoneBook.getEntries().size() < 20) {
            phoneBook.addPhone(getRandomName(), getPhoneNumber());
        }
        for (Map.Entry<FullName, String> entry : phoneBook.getEntries()) {
            System.out.printf("%s - %s%n",entry.getKey(), entry.getValue() );
        }
        //Task ListMap2
        Map<Integer, String> orederedMap = new LinkedHashMap<>();
        orederedMap.put(9, "test9");
        orederedMap.put(4, "test4");
        orederedMap.put(8, "test8");
        orederedMap.put(2, "test2");
        orederedMap.put(5, "test5");
        orederedMap.put(6, "test6");
        orederedMap.put(7, "test7");
        orederedMap.put(3, "test3");
        orederedMap.put(1, "test1");
        orederedMap.put(10, "test10");


        for (Map.Entry<Integer, String> entry : orederedMap.entrySet()) {
            System.out.printf("%d:%s%n", entry.getKey(), entry.getValue());
        }
    }

    public static String getPhoneNumber() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 11; i++) {
            stringBuilder.append(RANDOM.nextInt(1, 10));
        }
        return stringBuilder.toString();
    }

    public static FullName getRandomName() {
        String name = "Ivan" + RANDOM.nextInt(1, 100);
        String surname = "Ivanov" + RANDOM.nextInt(1, 100);
        return new FullName(name, surname);
    }


}
