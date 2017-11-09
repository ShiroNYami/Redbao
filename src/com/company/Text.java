package com.company;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Text {
    public static void main(String[] args) {
        // write your code here
        String name[] = new String[100];
        Scanner sc = new Scanner(System.in);
        System.out.println("输入红包总额和个数：");
        double total = sc.nextDouble();
        int number = sc.nextInt();
        System.out.println("请输入" + number + "个抢红包人姓名");
        for (int i = 0; i < number; i++) {
            name[i] = sc.next();
        }
        System.out.println("抢红包方式：(normal/lucky/say)");
        String choose = sc.next();
        if (choose.equals("normal")) {
            normal Money = new normal(total, number);
            Money.getter(total, number, name);
            Money.get(name);
        } else if (choose.equals("lucky")) {
            lucky Money = new lucky(total, number);
            Money.getter(total, number, name);
            Money.get(name);
        } else if (choose.equals("say")) {
            int j = 0;
            String nameC[] = new String[100];
            System.out.println("请输入口令：");
            String origin = sc.next();
            for (int i = 0; i < number; i++) {
                System.out.println(name[i] + ":");
                String speak = sc.next();
                if (speak.equals(origin)) {
                    nameC[j] = name[i];
                    j++;
                }
            }
            number = j;
            say Money = new say(total, number);
            Money.getter(total, number, nameC);
            Money.get(nameC);
        } else {
            System.out.println("输入错误！！！");
        }
    }
}

class normal {
    String name[] = new String[100];
    double total;
    int number;
    DecimalFormat d2 = new DecimalFormat("0.00");

    public normal(final double x, final int y) {

    }

    public void get(String[] name) {
        if (total / number < 0.01) {
            System.out.println("钱不够！！");
        } else {
            for (int i = 0; i < number; i++) {
                System.out.println(name[i] + ":" + d2.format(total / number) + "元");
            }
        }
    }

    public void getter(double total, int number, String[] name) {
        this.total = total;
        this.number = number;
        for (int i = 0; i < number; i++) {
            this.name[i] = name[i];
        }
    }
}

class lucky {
    String name[] = new String[100];
    double total;
    int number;
    double p;
    DecimalFormat d2 = new DecimalFormat("0.00");

    public lucky(final double x, final int y) {

    }

    public void get(String[] name) {
        if (total / number < 0.01) {
            System.out.println("钱不够！！");
        } else {
            double m = 0;
            int j = 0;
            for (int i = 0; i < number - 1; i++) {
                double Q = (Math.random() * (total / number));
                System.out.println(name[i] + ":" + d2.format(Q) + "元");
                p -= Q;
                while (i == 0) {
                    m = Q;
                    break;
                }
                if (m == Math.max(Q, m)) {
                    j = i;
                } else {
                    m = Math.max(Q, m);
                }
            }
            System.out.println(name[number - 1] + ":" + d2.format(p) + "元");
            if (p < m) {
                System.out.println("运气王为" + name[j] + " " + d2.format(m) + "元");
            } else {
                System.out.println("运气王为" + name[number - 1] + " " + d2.format(p) + "元");
            }
        }
    }

    public void getter(double total, int number, String[] name) {
        this.total = total;
        this.number = number;
        for (int i = 0; i < number; i++) {
            this.name[i] = name[i];
        }
        p = total;
    }
}

class say {
    String name[] = new String[100];
    double total;
    int number;
    double p;
    DecimalFormat d2 = new DecimalFormat("0.00");

    public say(final double x, final int y) {

    }

    public void get(String[] name) {
        if (total / number < 0.01) {
            System.out.println("钱不够！！");
        } else {
            double m = 0;
            int j = 0;
            for (int i = 0; i < number - 1; i++) {
                double Q = (Math.random() * (total / number));
                System.out.println(name[i] + ":" + d2.format(Q) + "元");
                p -= Q;
                while (i == 0) {
                    m = Q;
                    break;
                }
                if (m == Math.max(Q, m)) {
                    j = i;
                } else {
                    m = Math.max(Q, m);
                }
            }
            System.out.println(name[number - 1] + ":" + d2.format(p) + "元");
            if (p < m) {
                System.out.println("运气王为" + name[j] + " " + d2.format(m) + "元");
            } else {
                System.out.println("运气王为" + name[number - 1] + " " + d2.format(p) + "元");
            }
        }
    }

    public void getter(double total, int number, String[] name) {
        this.total = total;
        this.number = number;
        for (int i = 0; i < number; i++) {
            this.name[i] = name[i];
        }
        p = total;
    }
}