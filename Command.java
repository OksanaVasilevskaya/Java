// Домашнее задание № 1 Показать набор команд для превращения числа а в число b

public class Command
 { 
    // На вход подаётся два числа (a, b). Есть две команды
    // - команда 1 (к1): увеличить в с раза, а умножается на c
    // - команда 2 (к2): увеличить на d, к a прибавляется d
    // написать программу, которая выдаёт набор команд, позволяющий число a
    // превратить в число b
    // или сообщить, что это невозможно
    // Пример 1: а = 3, b = 9, c = 2, d = 1
    // Показать набор команд для превращения числа а в число b
    // Показать хотя бы один набор

    public static void main(String[] args) {
        int a = 3;
        int b = 9;
        int c = 2;
        int d = 1;
        if (a >= b) {
            System.out.printf("Ошибка");
        } else {
            int[] mas = new int[b + 1];
            mas[a] = 1;
            int[] res = recWay(mas, a + 1, b + 1, c, d);
            printArr(res);
            String resWay = wayArr(a, b, c, d);
            System.out.println("\n" + resWay);
        }
    }

    static int[] recWay(int[] mas, int a, int b, int c, int d) {
        if (a == b)
            return mas;
        if (a % 2 == 0) {
            mas[a] = mas[a - d] + mas[a / c];
            return recWay(mas, a + d, b, c, d);
        } else {
            mas[a] = mas[a - d];
            return recWay(mas, a + d, b, c, d);
        }
    }

    static String wayArr(int a, int b, int c, int d) {
        String result = "Путь: ";
        while (a < b) {
            if (a % 2 == 0 & a * b <= b & a > 0) {
                a *= c;
                result += "k1 ";
            } else {
                a += d;
                result += "k2 ";
            }
        }
        return result;
    }

    static void printArr(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            if (i == mas.length - 1) {
                System.out.printf("\nКоличество вариантов для %d = %d", i, mas[i]);
            } else
                System.out.printf("%d=%d ", i, mas[i]);
        }
    }
}