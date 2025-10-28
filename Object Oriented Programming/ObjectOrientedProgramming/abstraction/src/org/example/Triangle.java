package org.example;

public class Triangle extends Shape {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        if (this.isTriangel(a, b, c)) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else{
            this.a = 0.0F;
            this.b = 0.0F;
            this.c = 0.0F;
            System.out.println("Exception occured triangle cannot be made we use 0,0,0");
        }

    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    private boolean isTriangel(double a, double b, double c) {
        boolean t1 = (a + b > c);
        boolean t2 = (a + c > b);
        boolean t3 = (c + b > a);
        return t1 && t2 && t3;
    }

    @Override
    public double area() {
        double p = (this.a + this.b + this.c) / 2;
        System.out.println("Area of Triangle is " +  Math.sqrt((p - this.a) * (p - this.b) * (p - this.c)));
        return  Math.sqrt(p* (p - this.a) * (p - this.b) * (p - this.c));
    }

    public static void main(String[] args) {
        Triangle a = new Triangle(1, 2, 1);
    }
}
