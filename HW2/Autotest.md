// Задача№1.Дана строка sql-запроса:

// select * from students where "
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Пример данных для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.

// Пример:

// {"name": "Ivanov", "country": "Russia", "city": "Moscow", "age": "null"}
// Напишите свой код в методе answer класса Answer. Метод answer принимает на вход два параметра:

// String QUERY - начало SQL-запроса
// String PARAMS - JSON с параметрами

// решение 1й задачи.

class Answer {

  public static StringBuilder answer(String QUERY, String PARAMS) {
    // Напишите свое решение ниже
    String line1 = PARAMS.replace("{", "");
    String line2 = line1.replace("}", "");
    String line3 = line2.replaceAll("\"", "");
    StringBuilder result = new StringBuilder("select * from students where ");

    String[] arrayData = line3.split(", ");
    for (int i = 0; i < arrayData.length; i++) {
      String[] arrData = arrayData[i].split(":");
      if (arrData[1].equals("null") == false) {
        if (i != 0) {
          result.append(" and ");
          result.append(arrData[0]);
          result.append("=");
          result.append("'");
          result.append(arrData[1]);
          result.append("'");
        } else {
          result.append(arrData[0]);
          result.append("=");
          result.append("'");
          result.append(arrData[1]);
          result.append("'");
        }
      }
    }
    return result;
  }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer {

  public static void main(String[] args) {
    String QUERY = "";
    String PARAMS = "";

    if (args.length == 0) {
      // При отправке кода на Выполнение, вы можете варьировать эти параметры
      QUERY = "select * from students where ";
      PARAMS =
        "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
    } else {
      QUERY = args[0];
      PARAMS = args[1];
    }

    Answer ans = new Answer();
    System.out.println(ans.answer(QUERY, PARAMS));
  }
}



// Эталонное решение от автора

class Answer {  
    public static StringBuilder answer(String QUERY, String PARAMS){
        String paramsNew = PARAMS.replace('{',' ').replace('}', ' ');
        String[] params = paramsNew.split(",");
        StringBuilder stringBuilder = new StringBuilder(QUERY);

        for (int i = 0; i < params.length; i++){
            String[] elements = params[i].replace('"', ' ').split(":");
            if(!"null".equals(elements[1].trim())){       
              stringBuilder.append(elements[0].trim()).append("=").append("'").append(elements[1].trim()).append("'");
                if (i < params.length - 2) stringBuilder.append(" and ");
            }
        }
        return stringBuilder;
    }
}


public class Printer{ 
    public static void main(String[] args) { 
      String QUERY = "";
      String PARAMS = "";

      if (args.length == 0) {
        QUERY = "select * from students where ";
        PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
      }
      else{
        QUERY = args[0];
        PARAMS = args[1];
      }     

      Answer ans = new Answer();      
      System.out.println(ans.answer(QUERY, PARAMS));
    }
}



// Задача№2.Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

// Напишите свой код в методе sort класса BubbleSort. Метод sort принимает на вход один параметр:

// int[] arr - числовой массив

// После каждой итерации, 
// ваш код должен делать запись в лог-файл 'log.txt' в формате год-месяц-день час:минуты {массив на данной итерации}.

// Пример

// arr = new int[]{9, 4, 8, 3, 1};
// sort(arr)

// // При чтении лог-файла получим:
// 2023-05-19 07:53 [4, 8, 3, 1, 9]
// 2023-05-19 07:53 [4, 3, 1, 8, 9]
// 2023-05-19 07:53 [3, 1, 4, 8, 9]
// 2023-05-19 07:53 [1, 3, 4, 8, 9]
// 2023-05-19 07:53 [1, 3, 4, 8, 9]

// Моё решение

        import java.io.File;
        import java.io.FileWriter;
        import java.io.FileReader;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.util.Arrays;
        import java.text.SimpleDateFormat;
        import java.util.Date;

class BubbleSort {
    private static File log;
    private static FileWriter fileWriter;

    public static void sort(int[] mas) {
        int n = mas.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; i++)
                if (mas[j] > mas[j + 1]) {
                    int temp = mas[j];
                    mas[j] = mas[j+1];
                    mas[j+1] = temp;
                }
    }
}


class Printer{
    public static void main(String[] args) {
        int[] arr = {};

        if (args.length == 0) {
            
            arr = new int[]{9, 4, 8, 3, 1};
        }
        else{
            arr = Arrays.stream(args[0].split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        BubbleSort ans = new BubbleSort();
        ans.sort(arr);

        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



// Эталонное решение от автора

import java.io.File;
        import java.io.FileWriter;
        import java.io.FileReader;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.util.Arrays;
        import java.text.SimpleDateFormat;
        import java.util.Date;

class BubbleSort {
        private static File log;
        private static FileWriter fileWriter;

        public static void sort(int[] mas) {
                try {
                        log = new File("log.txt");
                        log.createNewFile();
                        fileWriter = new FileWriter(log);
                        bubbleSort(mas);

                } catch (IOException e) {
                        e.printStackTrace();
                } finally {
                        try {
                                fileWriter.close();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
        }

        private static int[] bubbleSort(int[] mas) {
                boolean isSorted = false;
                int buffer;

                while (!isSorted) {
                        isSorted = true;
                        for (int i = 0; i < mas.length - 1; i++) {
                                if (mas[i] > mas[i + 1]) {
                                        isSorted = false;

                                        buffer = mas[i];
                                        mas[i] = mas[i + 1];
                                        mas[i + 1] = buffer;
                                }
                        }
                        logStep(Arrays.toString(mas));
                }
                return mas;
        }

        public static void logStep(String note){
                try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        String timestamp = dateFormat.format(new Date());
                        fileWriter.write(timestamp + " " + note + "\n");
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

}

class Printer{
        public static void main(String[] args) {
                int[] arr = {};

                if (args.length == 0) {
                        arr = new int[]{9, 4, 8, 3, 1};
                }
                else{
                        arr = Arrays.stream(args[0].split(", "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
                }

                BubbleSort ans = new BubbleSort();
                ans.sort(arr);

                try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                                System.out.println(line);
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
}







// Внутри класса Answer напишите метод answer, который распарсит json и, используя StringBuilder, создаст строки вида:

// Студент [фамилия] получил [оценка] по предмету [предмет].
// На вход метода answer подаются аргументы:

// String JSON
// String ELEMENT1
// String ELEMENT2
// String ELEMENT3
// Пример:


// JSON = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
//     "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
//     "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
// ELEMENT1 = "Студент ";
// ELEMENT2 = " получил ";
// ELEMENT3 = " по предмету ";

// Студент Иванов получил 5 по предмету Математика
// Студент Петрова получил 4 по предмету Информатика
// Студент Краснов получил 5 по предмету Физика



class Answer {
    public static void answer(String JSON, String ELEMENT1, String ELEMENT2, String ELEMENT3) {

            String jsonString = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},"

                    + "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},"

                    + "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

            StringBuilder sb = new StringBuilder();

            String[] splitString = jsonString.split("\\{");

            for (int i = 1; i < splitString.length; i++) {
                    String[] studentInfo = splitString[i].replace("}]", "").split("\",\"");

                    sb.append("Студент " + studentInfo[0].split(":")[1].replace("\"", "") + " получил " + studentInfo[1].split(":")[1].replace("\"", "") + " по предмету " + studentInfo[2].split(":")[1].replace("\"", "").replace("},", "") + ".\n");

            }
            System.out.println(sb.toString());

    }

}

class Printer{
    public static void main(String[] args) {
            String JSON = "";
            String ELEMENT1 = "";
            String ELEMENT2 = "";
            String ELEMENT3 = "";

            if (args.length == 0) {
                    
                    JSON = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                            "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                            "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
                    ELEMENT1 = "Студент ";
                    ELEMENT2 = " получил ";
                    ELEMENT3 = " по предмету ";
            }
            else{
                    JSON = args[0];
                    ELEMENT1 = args[1];
                    ELEMENT2 = args[2];
                    ELEMENT3 = args[3];
            }

            Answer ans = new Answer();
            ans.answer(JSON, ELEMENT1, ELEMENT2, ELEMENT3);
    }
}



// Эталонное решение от автора

class Answer {
    public static void answer(String JSON, String ELEMENT1, String ELEMENT2, String ELEMENT3) {

            String jsonString = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},"

                    + "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},"

                    + "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

            StringBuilder sb = new StringBuilder();

            String[] splitString = jsonString.split("\\{");

            for (int i = 1; i < splitString.length; i++) {
                    String[] studentInfo = splitString[i].replace("}]", "").split("\",\"");

                    sb.append("Студент " + studentInfo[0].split(":")[1].replace("\"", "") + " получил " + studentInfo[1].split(":")[1].replace("\"", "") + " по предмету " + studentInfo[2].split(":")[1].replace("\"", "").replace("},", "") + "\n");

            }
            System.out.println(sb.toString());

    }

}
// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
class Printer{
    public static void main(String[] args) {
            String JSON = "";
            String ELEMENT1 = "";
            String ELEMENT2 = "";
            String ELEMENT3 = "";

            if (args.length == 0) {
                    // При отправке кода на Выполнение, вы можете варьировать эти параметры
                    JSON = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                            "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                            "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
                    ELEMENT1 = "Студент ";
                    ELEMENT2 = " получил ";
                    ELEMENT3 = " по предмету ";
            }
            else{
                    JSON = args[0];
                    ELEMENT1 = args[1];
                    ELEMENT2 = args[2];
                    ELEMENT3 = args[3];
            }

            Answer ans = new Answer();
            ans.answer(JSON, ELEMENT1, ELEMENT2, ELEMENT3);
    }
}




// Задача№4. Возьмите код от калькулятора с прошлого урока.

// К этому калькулятору нужно добавить логирование.

// Логи запишите в файл log.txt в формате:

// "гггг-мм-дд чч:мм User entered the first operand = {первое число}"
// "гггг-мм-дд чч:мм User entered the operation = {оператор}"
// "гггг-мм-дд чч:мм User entered the second operand = {второе число}"
// "гггг-мм-дд чч:мм Result is {результат}"



import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.io.BufferedReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Calculator {
    /**
     * @apiNote Напишите класс Calculator, который будет выполнять математические операции (+, -, *, /) над двумя числами и возвращать результат. В классе должен быть метод calculate, который принимает оператор и значения аргументов и возвращает результат вычислений.
     *
     * При неверно переданном операторе, программа должна вывести сообщение об ошибке "Некорректный оператор: 'оператор'".
     * @param op математическиий оператор
     * @param a первый параметр
     * @param b второй параметр
     * @return результат вычисления
     */

    /**
     * @apiNote Делает запись текущего состояния массива в лог файл
     * @param mas массив
     */
    private static void writeToLog(String message) {
        Timestamp date = new Timestamp(System.currentTimeMillis());
        LocalDateTime localDateTime = date.toLocalDateTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        try {
            FileWriter fileWriter = new FileWriter("log.txt", true);

            fileWriter.append(dateTimeFormatter.format(localDateTime) + " " + message + "\n");
            fileWriter.flush();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public int calculate(char op, int a, int b) {
        // Введите свое решение ниже

        int result = 0;
        if (op == '+')
            result = a + b;
        else if (op == '-')
            result =  a - b;
        else if (op == '*')
            result =  a * b;
        else if (op == '/')
            result =  a / b;

        writeToLog("User entered the first operand = " + a);
        writeToLog("User entered the operation = " + op);
        writeToLog("User entered the second operand = " + b);
        writeToLog("Result is " + result);
        return result;
    }
}

class Printer {
    private static final String LOG_FILE_PATH = "log.txt";

    public static void main(String[] args) {
        int a = 0;
        char op = ' ';
        int b = 0;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 3;
            op = '+';
            b = 7;
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
        }

        clearLogFile();
        Calculator calculator = new Calculator();
        int result = calculator.calculate(op, a, b);
        System.out.println(result);

        try (BufferedReader br = new BufferedReader(new FileReader(LOG_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void clearLogFile() {
        File logFile = new File(LOG_FILE_PATH);
        if (logFile.exists()) {
            try {
                FileWriter fileWriter = new FileWriter(logFile, false);
                fileWriter.write("");
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}



// Эталонное решение от автора

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.io.BufferedReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


class Calculator {
    public int calculate(char op, int a, int b) {
       try (FileWriter fileWriter = new FileWriter(new File("log.txt"), true)) {
            logStep(fileWriter, "Пользователь ввел первый операнд = " + a);
            logStep(fileWriter, "Пользователь ввел операцию = " + op);
            logStep(fileWriter, "Пользователь ввел второй операнд = " + b);

      switch (op) {
                case '+':
                    int sum = add(a, b);
                    logStep(fileWriter, "Результат = " + sum);
                    return sum;
                case '-':
                    int diff = minus(a, b);
                    logStep(fileWriter, "Результат = " + diff);
                    return diff;
                case '*':
                    int prod = mult(a, b);
                    logStep(fileWriter, "Результат = " + prod);
                    return prod;
                case '/':
                    int quotient = divide(a, b);
                    logStep(fileWriter, "Результат = " + quotient);
                    return quotient;
                default:
                    throw new IllegalArgumentException("Некорректный оператор: " + op);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private int divide(int a, int b) {
        if (b != 0) return a / b;
        throw new ArithmeticException("Деление на 0 недопустимо");
    }

    private int mult(int a, int b) {
        return a * b;
    }

    private int minus(int a, int b) {
        return a - b;
    }

    private int add(int a, int b) {
        return a + b;
    }

    private void logStep(FileWriter fileWriter, String note) throws IOException {
      LocalDateTime currentTime = LocalDateTime.now();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
      String formattedTime = currentTime.format(formatter);
      fileWriter.write(formattedTime + " " + note + "\n");
  }

}

public class Printer {

    private static final String LOG_FILE_PATH = "log.txt";

    public static void main(String[] args) {
        int a = 0;
        char op = ' ';
        int b = 0;

        if (args.length == 0) {
            a = 3;
            op = '+';
            b = 7;
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
        }

        clearLogFile();
        Calculator calculator = new Calculator();
        int result = calculator.calculate(op, a, b);
        System.out.println(result);

        try (BufferedReader br = new BufferedReader(new FileReader(LOG_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void clearLogFile() {
        File logFile = new File(LOG_FILE_PATH);
        if (logFile.exists()) {
            try {
                FileWriter fileWriter = new FileWriter(logFile, false);
                fileWriter.write("");
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}