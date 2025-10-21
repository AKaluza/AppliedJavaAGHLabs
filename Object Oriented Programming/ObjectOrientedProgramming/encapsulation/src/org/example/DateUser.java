package org.example;

public class DateUser
{
    public static void main(String[] args)
    {
        MyDate leayYear =  new MyDate();
        leayYear.setDay(29);
        leayYear.setMonth(02);
        leayYear.setYear(2017);

        System.out.println(leayYear.getDay());
        System.out.println(leayYear.getMonth());
        System.out.println(leayYear.getYear());
    }
}
