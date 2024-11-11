import entity.Point;
import entity.Triangle;
import action.TriangleManip;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleTest {
    @Test
    public void testArea() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 3);
        Point p3 = new Point(4, 0);

        Triangle triangle = new Triangle(p1, p2, p3);
        TriangleManip manipulator = new TriangleManip();
        // Площадь треугольника с заданными вершинами должна быть 6
        double expectedArea = 6.0;
        double area = manipulator.calculateArea(triangle);
        Assert.assertEquals(area, expectedArea);
    }
    // Тест на проверку периметра треугольника
    @Test
    public void testPerimeter() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 3);
        Point p3 = new Point(4, 0);

        Triangle triangle = new Triangle(p1, p2, p3);
        TriangleManip manipulator = new TriangleManip();
        // Периметр треугольника с заданными вершинами должен быть 12
        double expectedPerimeter = 12.0;
        double perimeter = manipulator.calculatePerimeter(triangle);

        Assert.assertEquals(perimeter, expectedPerimeter);
    }
    //  тип
    //  треугольника
    @Test
    public void testTriangleType() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 3);
        Point p3 = new Point(4, 0);

        Triangle triangle = new Triangle(p1, p2, p3);
        TriangleManip manipulator = new TriangleManip();

        String expectedType = "Прямоугольный";
        String type = manipulator.getTriangleType(triangle);

        Assert.assertEquals(type, expectedType);
    }
}
