package org.example;

import action.TriangleManip;
import entity.Triangle;
import validation.Validataion;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Validataion reader = new Validataion();
        List<Triangle> triangles = reader.getTriangles("C:\\Users\\Дмитрий\\OneDrive\\Рабочий стол\\l3\\src\\main\\java\\validation\\data.txt");

        TriangleManip manipulator = new TriangleManip();
        for (Triangle triangle : triangles) {
            System.out.println("Треугольник с ID " + triangle.getId() + ": " + triangle);

            double area = manipulator.calculateArea(triangle);
            double perimeter = manipulator.calculatePerimeter(triangle);

            String type = manipulator.getTriangleType(triangle);

            System.out.println("Площадь: " + area);
            System.out.println("Периметр: " + perimeter);
            System.out.println("Тип треугольника: " + type);
        }
    }
}