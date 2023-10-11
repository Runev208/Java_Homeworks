# Репозиторий для сдачи домашних заданий по курсу Java


## HW1 (Домашнее задание по первому семинару)

### 1. (task_1) Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! 
### 2. (task_2) Вывести все простые числа от 1 до 1000 
### 3. (task_3) Реализовать простой калькулятор
### 4. (task_4) Задано уравнение вида q + w = e, q, w, e >= 0.  Некоторые цифры могут быть заменены знаком вопроса, например 1? + ?5 = 69. 
###    Требуется восстановить выражение до верного равенства.  Предложить хотя бы одно решение или сообщить, что его нет.


## HW2 (Домашнее задание по второму семинару) 

### 1. (task_1) В файле содержится строка с исходными данными в такой форме: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
###    Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
###    SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
###    Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос.
### 2. (task_2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл. 
### 3. (task_3) В файле содержится строка с данными:
###    [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, {"фамилия":"Краснов",###    "оценка":"5","предмет":"Физика"}]
###    Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
###    Студент Иванов получил 5 по предмету Математика.
###    Студент Петрова получил 4 по предмету Информатика.
###    Студент Краснов получил 5 по предмету Физика.


## HW3 (Домашнее задание по третьему семинару)

### 1. (task_1) Реализовать алгоритм сортировки слиянием.
### 2. (task_2) Пусть дан произвольный список целых чисел. Удалить из него чётные числа.
### 3. (task_3) Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметичское этого списка.
### 4. (task_4)  (Необязательная задача повышенной сложности)
###    Даны два ArrayList из целых чисел. Написать функции, которые вычисляют разницу коллекций:
###    Разность:
###    A - B = все числа из первой коллекции, которые не содержатся во второй коллекции
###    B - A = все числа из второй коллекции, которые не содержатся в первой
###    Симметрическая разность:
###    A ^ B = числа из первой коллекции, которых нет во второй, А ТАКЖЕ числа из второй, которых нет в первой


## HW4 (Домашнее задание по червертому семинару)

### 1. (task_1) Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
### 2. (task_2) Реализуйте очередь с помощью LinkedList со следующими методами:
###    enqueue() - помещает элемент в конец очереди, dequeue() - возвращает первый элемент из очереди и удаляет его, first() - возвращает первый ###    элемент из очереди, не удаляя.
### 3. (task_3) В калькулятор добавьте возможность отменить последнюю операцию.


## HW5 (Домашнее задание по пятому семинару)

### 1. (task1) Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что один человек может иметь несколько телефонов.
### 2. (task2) Пусть дан список сотрудников: Иван, Пётр, Антон и так далее. Написать программу, которая найдет и выведет повторяющиеся имена с 
###     количеством повторений. Отсортировать по убыванию популярности.
### 3. (task3) Реализовать алгоритм пирамидальной сортировки (HeapSort).
### 4. (task4)  На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.


## HW6 (Домашнее задание по шестому семинару)

### 1. (task1) Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.

### Создать множество ноутбуков.
### Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
### Введите цифру, соответствующую необходимому критерию:
### 1 - ОЗУ
### 2 - Объем ЖД
### 3 - Операционная система
### 4 - Цвет …

### Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.

### Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.