package cn.happy;

import java.util.InputMismatchException;
import java.util.Scanner;

class StudentID {
    String[] account;
    String[] password;
}

public class System_test {
    public static void main(String[] args) {
        System.out.println("欢迎来到河南科技大学录取系统");
        System.out.println("请输入您需要的服务(1.学工号注册 2.录取查询 3.登录 4.财务收费系统 5.科大主页 6.退出程序):");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        if (num == 1) {
            StudentID_Register();
        }

        if (num == 2) {
            Admission();
        }
    }
    //实现学工号注册
    public static void StudentID_Register() {
        Scanner input = new Scanner(System.in);

        boolean current = true;
        while (current) {
            boolean hasUpper = false;
            boolean hasLower = false;
            boolean hasNum = false;
            System.out.print("请输入账号: ");
            String accout = input.nextLine();
            //用for循环遍历字符串，确认账号是否符合要求
            for (int i = 0; i < accout.length(); i++) {
                char c = accout.charAt(i);
                if (Character.isUpperCase(c)) {
                    hasUpper = true;
                }

                if (Character.isLowerCase(c)) {
                    hasLower = true;
                }

                if (Character.isDigit(c)) {
                    hasNum = true;
                }

                if (hasNum && hasLower && hasUpper) {
                    current = false;
                    break;
                }
            }
            if (hasNum && hasLower && hasUpper) {
                break;
            }
            System.out.println("输入的账号必须同时包含大小写与数字,请重新输入! ");
        }
        //密码同上
        current = true;
        while (current) {
            boolean hasUpper = false;
            boolean hasLower = false;
            boolean hasNum = false;
            System.out.print("请输入密码: ");
            String password = input.nextLine();

            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                if (Character.isUpperCase(c)) {
                    hasUpper = true;
                }

                if (Character.isLowerCase(c)) {
                    hasLower = true;
                }

                if (Character.isDigit(c)) {
                    hasNum = true;
                }

                if (hasNum && hasLower && hasUpper) {
                    current = false;
                    break;
                }
            }
            if (hasNum && hasLower && hasUpper) {
                break;
            }
            System.out.println("输入的密码必须同时包含大小写与数字,请重新输入! ");
        }
    }

    public static void Admission() {
        Scanner input = new Scanner(System.in);
        int num = 0;
        boolean current = true;

        while (current) {
            try {
                System.out.println("请输入您的分数:");
                num = input.nextInt();

            } catch (InputMismatchException e) {  //错误类型为输入型错误,故使用InputMismatchException错误类型
                System.out.println("请输入正确的分数");
            }

            if (num <= 511) {
                System.out.println("您未被录取");
                current = false;
            }
            else {
                System.out.println("您已被录取");
                current = false;
            }

            input.close();  //关闭创建的输入变量,防止内存泄漏
        }

    }
}
