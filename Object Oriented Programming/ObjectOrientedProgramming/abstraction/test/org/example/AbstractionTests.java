package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
import java.util.LinkedList;

public class AbstractionTests {

    @Test
    @DisplayName("Shape should be abstract")
    public void testShapeIsAbstract() {
        Assertions.assertTrue(Modifier.isAbstract(Shape.class.getModifiers()), "Shape is not abstract");
    }

    @Test
    @DisplayName("Shape should have an abstract method area")
    public void testShapeHaveAbstractAreaMethod() {
        var method = Assertions.assertDoesNotThrow(() -> Shape.class.getMethod("area"), "Shape does not have method: area");
        Assertions.assertTrue(Modifier.isAbstract(method.getModifiers()), "Shape method: area is not final");
        Assertions.assertEquals(0, method.getParameterTypes().length, "Shape method: area is not parameterless");
    }

    @Test
    @DisplayName("Create Rectangle instance")
    public void testRectangleConstructor() {
        Assertions.assertDoesNotThrow(() -> new Rectangle(1.0, 2.0), "Exception thrown when constructor Rectangle(1.0, 2.0)");
    }

    @Test
    @DisplayName("Rectangle should extend Shape")
    public void testRectangleShape() {
        Assertions.assertTrue(Shape.class.isAssignableFrom(Rectangle.class), "Rectangle does not extend Shape");
    }

    @Test
    @DisplayName("Calculate Rectangle area")
    public void testRectangleArea() {
        var rectangle = Assertions.assertDoesNotThrow(() -> new Rectangle(3.0, 2.0), "Exception thrown when constructor Rectangle(1.0, 2.0)");
        Assertions.assertEquals(6.0, rectangle.area(), "Rectangle area calculated incorrectly");
    }

    @Test
    @DisplayName("Triangle should be a subclass of Shape class")
    public void testTriangleIsSubclassOfShape() {
        Assertions.assertTrue(Shape.class.isAssignableFrom(Triangle.class), "Triangle is not Shape subclass");
    }

    @Test
    @DisplayName("Create Triangle instance")
    public void testTriangleConstructor() {
        Assertions.assertDoesNotThrow(() -> new Triangle(1.0F, 3.0F,3.0F), "Exception thrown when constructor Triangle(1.0F, 3.0F,3.0F)");
    }

    @Test
    @DisplayName("Create Triangle instance")
    public void testTriangleConstructorFail() {
        Triangle my = new Triangle(1.0F, 2.0F, 3.0F);
        float[] expected = new float[3];
        expected[0] = 0.0F;
        expected[1] = 0.0F;
        expected[2] = 0.0F;
        float[] result = new float[3];
        result[0] = my.getA();
        result[1] = my.getB();
        result[2] = my.getC();
        Assertions.assertArrayEquals(result,expected);
    }
    @Test
    @DisplayName("Calculate Triangle area")
    public void testTriangleArea() {
        var triangle = Assertions.assertDoesNotThrow(() -> new Triangle(3.0F, 4.0F,5.0F), "Exception thrown when constructor Triangle(3.0F, 4.0F, 5.0F)");
        Assertions.assertEquals(6.0, triangle.area(), "Rectangle area calculated incorrectly");
    }

    @Test
    @DisplayName("Circle should be final")
    public void testCircleIsFinal() {
        Assertions.assertTrue(Modifier.isFinal(Circle.class.getModifiers()), "Circle class is not final");
    }

    @Test
    @DisplayName("Calculate Circle area")
    public void testCircleArea() {
        var circle = Assertions.assertDoesNotThrow(() -> new Circle(3.0F), "Exception thrown when constructor  Circle(3.0F)");
        Assertions.assertEquals(Math.PI*3.0F*3.0F, circle.area(), "Circle area calculated incorrectly");
    }


}