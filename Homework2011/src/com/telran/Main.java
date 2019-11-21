package com.telran;

public class Main {

    public static void main(String[] args) {

        System.out.println("*******************************************");
        System.out.println("Вывести на экран 100,90,....10.");
        {
            int a = 110;
            while (a != 10) {
                a = a - 10;
                System.out.println(a);
            }
        }

        System.out.println();
        System.out.println("*******************************************");
        System.out.println("Посчитать сумму арифметической прогрессии с шагом 1 (1-87)");
        {
            int i = 1;
            int b = 0;
            while (i <= 87) {
                b = b + i;
                i++;
            }
            System.out.println(b);
        }

        System.out.println();
        System.out.println("*******************************************");
        System.out.println("Посчитать сумму арифметической прогрессии с шагом 3 (5-86)");
        {
            int sum = 0;
            for (int i = 5; i <= 86; i = i + 3) {
                sum = sum + i;
            }
            System.out.println(sum);
        }

        System.out.println();
        System.out.println("*******************************************");
        System.out.println("Развернуть элементы массива");
        {
            int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

            for (int i = 0; i < a.length / 2; i++) {
                int b;
                b = a[a.length - i - 1];
                a[a.length - i - 1] = a[i];
                a[i] = b;
            }
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i]);
            }

        }

        System.out.println();
        System.out.println();
        System.out.println("*******************************************");
        System.out.println("Маша: Сколько месяцев надо, чтобы выдать 2100 кредитов");
        {
            double MASHA_VEL = 50;
            double PETR_VEL = 0.8 * MASHA_VEL;
            double LAZY_VASYA_VEL = 0.5 * MASHA_VEL;
            double MOTIVATED_VASYA_VEL = MASHA_VEL;
            int VASYA_MOTIVASHION_BORDER = 1370;

            int totalCredits = 2100;
            double monthCreditsWithLazyVasya = (MASHA_VEL + PETR_VEL + LAZY_VASYA_VEL);
            double monthCreditWithMotivatedVasya = (MASHA_VEL + PETR_VEL + MOTIVATED_VASYA_VEL);
            double monthWithLazyVasya = VASYA_MOTIVASHION_BORDER / monthCreditsWithLazyVasya;
            double restCredits = totalCredits - VASYA_MOTIVASHION_BORDER;
            double monthWithMotivatedVasya = restCredits / monthCreditWithMotivatedVasya;
            double totalMonth = monthWithLazyVasya + monthWithMotivatedVasya;

            System.out.println("*** " + totalMonth + " месяцев необходимо, чтобы выдать 2100 кредитов");
        }

        System.out.println();
        System.out.println("*******************************************");
        System.out.println("Маша: Сколько кредитов будет выдано за 1.5 года?");
        {
            //count sum of credits of Masha for 18 months (18 months =18 additional credits(1/mon))
            double totalMashaCredits18Mon=0;
            for (int i = 50; i <=68 ; i++) {
                totalMashaCredits18Mon=totalMashaCredits18Mon+i;
            }
            //System.out.println(totalMashaCredits18Mon);

            //count sum of credits of Petr for 18 months (18 months =9 additional credits(2/mon))
            double totalPetrCredits18Mon=0;
            for (int i = 40; i <=49 ; i=i+2) {
                totalPetrCredits18Mon=totalPetrCredits18Mon+i;
            }
            //System.out.println(totalPetrCredits18Mon);

            //count sum of credits of Vasya for 10 months (first 10 months = -10 credits(1/mon))
            double totalVasyaCredits10Months=0;
            for (int i = 50; i >= 40; i--) {
                totalVasyaCredits10Months=totalVasyaCredits10Months+i;
            }
            //System.out.println(totalVasyaCredits10Months);

            //count sum of rest credits of Vasya for 8 months (50/mon))
            double restVasyaCredits=50*8;
            //System.out.println(restVasyaCredits);

            double totalCreditsIn18Mon = totalMashaCredits18Mon+totalPetrCredits18Mon+totalVasyaCredits10Months+restVasyaCredits;
            System.out.println(totalCreditsIn18Mon+ " кредитов выдадут товарищи за 1,5 года.");
        }

    }
}
