// Напишите программу, представляющую телефонную книгу. Программа должна иметь следующие функции:

// *add(String name, Integer phoneNum): Добавляет запись в телефонную книгу.
// Если запись с именем name уже существует, добавляет новый номер телефона в существующую запись.
// Если запись с именем name не существует, создает новую запись с этим именем и номером телефона phoneNum.

// *find(String name): Поиск номеров телефона по имени в телефонной книге.
// Если запись с именем name существует, возвращает список номеров телефона для этой записи.
// Если запись с именем name не существует, возвращает пустой список.

// *getPhoneBook(): Возвращает всю телефонную книгу в виде HashMap, где ключи - это имена, а значения - списки номеров телефона.

import java.util.ArrayList;
import java.util.HashMap;a

class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {

if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNum);
        } else {
            ArrayList<Integer> values = new ArrayList<>();
            values.add(phoneNum);
            phoneBook.put(name, values);

}

    public ArrayList<Integer> find(String name) {
if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        }
        return new ArrayList<Integer>();

}

    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
        return phoneBook;
    }
}

public class Printer {
    public static void main(String[] args) {
        String name1;
        String name2;
        int phone1;
        int phone2;

        if (args.length == 0) {
            name1 = "Ivanov";
            name2 = "Petrov";
            phone1 = 123456;
            phone2 = 654321;
        } else {
            name1 = args[0];
            name2 = args[1];
            phone1 = Integer.parseInt(args[2]);
            phone2 = Integer.parseInt(args[3]);
        }

        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name1, phone2);
        myPhoneBook.add(name2, phone2);

        System.out.println(myPhoneBook.find(name1));
        System.out.println(PhoneBook.getPhoneBook());
        System.out.println(myPhoneBook.find("Me"));
    }
}



// Вы работаете с приложением для учета имен пользователей. Ваша задача - разработать программу, которая принимает на вход пять имен пользователей 
// (или использует имена по умолчанию, ..если аргументы не предоставлены) и подсчитывает, сколько раз каждое имя встречается.
// Программа должна использовать HashMap для хранения имен и их количества вхождений.
// По завершении, программа выводит результат в виде пар "имя - количество".

import java.util.HashMap;

class NamesCounter {
    private HashMap<String, Integer> names = new HashMap<>();

    // Метод для добавления имени в HashMap
    public void addName(String name) {
        if (names.containsKey(name)) {

            names.put(name, names.get(name) + 1);

        } else {

            names.put(name, 1);

        }

    }


    // Метод для вывода содержимого HashMap
    public void showNamesOccurrences() {
      System.out.println(names);
    }
}

public class Printer {
    public static void main(String[] args) {
        String name1;
        String name2;
        String name3;
        String name4;
        String name5;
      
        if (args.length == 0) {
            name1 = "Elena";
            name2 = "Elena";
            name3 = "Elena";
            name4 = "Iva";
            name5 = "Ivan";
        } else {
            name1 = args[0];
            name2 = args[1];
            name3 = args[2];
            name4 = args[3];
            name5 = args[4];
        }      
        NamesCounter namesCounter = new NamesCounter();

        namesCounter.addName(name1);
        namesCounter.addName(name2);
        namesCounter.addName(name3);
        namesCounter.addName(name4);

        namesCounter.addName(name5);

        namesCounter.showNamesOccurrences();
    }
}


// * Эталонное решение автора 
 import java.util.HashMap;

class NamesCounter {
    private HashMap<String, Integer> names = new HashMap<>();

    // Метод для добавления имени в HashMap
    public void addName(String name) {
        if (names.containsKey(name)) {
            names.put(name, names.get(name) + 1);
        } else {
            names.put(name, 1);
        }
    }

    // Метод для вывода содержимого HashMap
    public void showNamesOccurrences() {
        System.out.println(names);
    }
}

public class Printer {
    public static void main(String[] args) {
        String name1;
        String name2;
        String name3;
        String name4;
        String name5;

        if (args.length == 0) {
            name1 = "Elena";
            name2 = "Elena";
            name3 = "Elena";
            name4 = "Elena";
            name5 = "Ivan";
        } else {
            name1 = args[0];
            name2 = args[1];
            name3 = args[2];
            name4 = args[3];
            name5 = args[4];
        }      
        NamesCounter namesCounter = new NamesCounter();

        namesCounter.addName(name1);
        namesCounter.addName(name2);
        namesCounter.addName(name3);
        namesCounter.addName(name4);

        namesCounter.addName(name5);

        namesCounter.showNamesOccurrences();
    }
}


// Необходимо разработать программу для сортировки массива целых чисел с использованием сортировки кучей (Heap Sort). Программа должна работать следующим образом:

// Принимать на вход массив целых чисел для сортировки. Если массив не предоставлен, программа использует массив по умолчанию.

// Сначала выводить исходный массив на экран.

// Затем применять сортировку кучей (Heap Sort) для сортировки элементов массива в порядке возрастания.

// Выводить отсортированный массив на экран.

// Ваше решение должно содержать два основных метода: 
// * buildTree, который строит сортирующее дерево на основе массива 
// * heapSort, который выполняет собственно сортировку кучей.
// Основная часть кода предоставлена вам.
// Программа должна быть способной сортировать массив, даже если он состоит из отрицательных чисел и имеет дубликаты.

// На входе:
// '5 8 12 3 6 9'
// На выходе:
// Initial array:
// [5, 8, 12, 3, 6, 9]
// Sorted array:
// [3, 5, 6, 8, 9, 12]

import java.util.Arrays;

class HeapSort {
    public static void buildTree(int[] tree, int sortLength) {
                // Для всех вершин дерева начиная с середины сортируемой части массива
        // (движемся влево до нулевого индекса)
        for (int i = sortLength / 2 - 1; i >= 0; i--) {
            int maxIndex;
            // Если у вершины два листа, выбираем больший
            if (i * 2 + 2 <= sortLength - 1) {
                if (tree[i * 2 + 2] > tree[i * 2 + 1]) maxIndex = i * 2 + 2;
                else maxIndex = i * 2 + 1;
            // Иначе один лист
            } else maxIndex = i * 2 + 1;
            // Сравниваем лист с максимальным значением с вершиной, при большем значении
            // дочернего элемента меняем его местами с вершиной
            if (tree[i] < tree[maxIndex]) {
                int temp = tree[i];
                tree[i] = tree[maxIndex];
                tree[maxIndex] = temp;
            }
        }
    }


    public static void heapSort(int[] sortArray, int sortLength) {
              // Выход из рекурсии: длина сортируемой части равна 0
        if (sortLength == 0) return;
        // Выстраивание элементов части массива в виде сортирующего дерева
        buildTree(sortArray, sortLength);
        // Замена местами первого и последнего элемента в сортируемой части
        int temp = sortArray[0];
        sortArray[0] = sortArray[sortLength - 1];
        sortArray[sortLength - 1] = temp;
        // Рекурсивно построение дерева и замена элементов для n - 1 элементов массива
        heapSort(sortArray, sortLength - 1);


    }
}
public class Printer {
    public static void main(String[] args) {
        int[] initArray;

        if (args.length == 0) {
            initArray = new int[]{17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1};
        } else {
            initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}


// * Эталонное решение автора 
