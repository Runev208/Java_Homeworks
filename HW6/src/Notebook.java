import java.util.ArrayList;
import java.util.List;
import java.util.Map;
// 1) Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// 2) Создать коллекцию ноутбуков.
// 3) Написать Maps, которая будет содержать критерий (или критерии) фильтрации и выведет
//      ноутбуки, отвечающие фильтру.
//      Пример: ОЗУ - Значение, Объем ЖД - Значение, Операционная система - Значение, Цвет - Значение
// 4) Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

public class Notebook {
    record notebook(String brand, int memory, int storage, String operatingSystem, String color) {
    }

    public static void main(String[] args) {
        List<notebook> notebooks = initListNotebooks();
        Map<String, String> params = Map.of("Memory", "8", "Storage", "256", "Operating System", "Windows");
        List<notebook> filteredNotebooks = filter(params, notebooks);
        System.out.println("Filtered notebooks: " + filteredNotebooks);

    }

    public static List<notebook> initListNotebooks() {
        List<notebook> notebooks = new ArrayList<>();
        notebooks.add(new notebook("Acer", 8, 256, "Windows", "Black"));
        notebooks.add(new notebook("HP", 8, 128, "MacOS", "Silver"));
        notebooks.add(new notebook("Lenovo", 16, 512, "Windows", "Black"));
        notebooks.add(new notebook("Asus", 16, 256, "Windows", "Silver"));
        return notebooks;
    }

    public static List<notebook> filter(Map<String, String> params, List<notebook> notebooks) {
        List<notebook> filteredNotebooks = new ArrayList<>();
        for (Notebook.notebook notebook : notebooks) {
            boolean isValid = true;
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                switch (key) {
                    case "Memory" -> {
                        if (notebook.memory() != Integer.parseInt(value)) {
                            isValid = false;
                        }
                    }
                    case "Storage" -> {
                        if (notebook.storage() != Integer.parseInt(value)) {
                            isValid = false;
                        }
                    }
                    case "Operating System" -> {
                        if (!notebook.operatingSystem().equals(value)) {
                            isValid = false;
                        }
                    }
                    case "Color" -> {
                        if (!notebook.color().equals(value)) {
                            isValid = false;
                        }
                    }
                    case "Brand" -> {
                        if (notebook.brand().equals(value)) {
                            isValid = false;
                        }
                    }
                }
            }
            if (isValid) {
                filteredNotebooks.add(notebook);
            }
        }
        return filteredNotebooks;}
}