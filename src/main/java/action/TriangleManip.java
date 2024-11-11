package action;

import entity.Point;
import entity.Triangle;
import exception.TriangleNotExistsException;

public class TriangleManip {
    private double getDistance(Point apexA, Point apexB) {
        return Math.sqrt(Math.pow(apexB.getX() - apexA.getX(), 2) + Math.pow(apexB.getY() - apexA.getY(), 2));
    }
    public double calculateArea(Triangle triangle) {
        double a = getDistance(triangle.getApexA(), triangle.getApexB());
        double b = getDistance(triangle.getApexB(), triangle.getApexC());
        double c = getDistance(triangle.getApexC(), triangle.getApexA());
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new TriangleNotExistsException("Треугольник не существует, так как сумма длин двух сторон не превышает длину третьей.");
        }
        double sP = (a + b + c) / 2;
        return Math.sqrt(sP * (sP - a) * (sP - b) * (sP - c));
    }
    public double calculatePerimeter(Triangle triangle) {
        double a = getDistance(triangle.getApexA(), triangle.getApexB());
        double b = getDistance(triangle.getApexB(), triangle.getApexC());
        double c = getDistance(triangle.getApexC(), triangle.getApexA());
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new TriangleNotExistsException("Треугольник не существует, так как сумма длин двух сторон не превышает длину третьей.");
        }
        return a + b + c;
    }
    public String getTriangleType(Triangle triangle) {
        double a = getDistance(triangle.getApexA(), triangle.getApexB());
        double b = getDistance(triangle.getApexB(), triangle.getApexC());
        double c = getDistance(triangle.getApexC(), triangle.getApexA());
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new TriangleNotExistsException("Треугольник не существует, так как сумма длин двух сторон не превышает длину третьей.");
        }
        if (a == b && b == c) {
            return "Равносторонний";
        } else if (a == b || b == c || a == c) {
            return "Равнобедренный";
        }
        double maxDistance = Math.max(a, Math.max(b, c));
        double srDistance = (a+b+c) - Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c));
        double otherDistancesSquaredSum = Math.pow(Math.min(a, Math.min(b, c)),2) + Math.pow(srDistance,2);
        if (Math.abs(Math.pow(maxDistance, 2) - otherDistancesSquaredSum) < 1e-10) {
            return "Прямоугольный";
        } else if (Math.pow(maxDistance, 2) > otherDistancesSquaredSum) {
            return "Тупоугольный";
        } else {
            return "Остроугольный";
        }
    }
    public boolean isTriangleValid(Triangle triangle) {
        double a = getDistance(triangle.getApexA(), triangle.getApexB());
        double b = getDistance(triangle.getApexB(), triangle.getApexC());
        double c = getDistance(triangle.getApexC(), triangle.getApexA());

        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}
