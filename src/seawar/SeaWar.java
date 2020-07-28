package seawar;

import java.util.Scanner;

public class SeaWar {
    public static void main(String[] args) {
        short[][] field = {
                {0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        };
        short raw, column, count = 0;
        Scanner sc = new Scanner(System.in);
        boolean isEnd = false;
        while (!isEnd) {
            System.out.println("Введите номер строки");
            while (!sc.hasNextByte()) {
                System.out.println("Некорректные данные, попробуйте ещё раз");
                sc.next();
            }
            raw = sc.nextByte();
            System.out.println("Введите номер столбца");
            while (!sc.hasNextByte()) {
                System.out.println("Некорректные данные, попробуйте ещё раз");
                sc.next();
            }
            column = sc.nextByte();
            if (raw >= 0 && raw < 10) {
                if (column >= 0 && column < 10) {
                    short currentPoint = field[raw][column];
                    if (currentPoint == 1) {
                        System.out.println("Попадание");
                        field[raw][column] = 0;
                    } else {
                        System.out.println("Промазал, в следующий раз повезёт");
                    }
                } else {
                    System.out.println("Некорректный номер столбца");
                }
            } else {
                System.out.println("Некорректный номер строки");
            }
            count = 0;
            for (int i = 0; i < 10; ++i) {
                for (int j = 0; j < 10; ++j) {
                    if (field[i][j] == 0) {
                        count++;
                    }
                }
            }
            if (count == 100) {
                isEnd = true;
            }

        }
        sc.close();
    }
}