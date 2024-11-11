package entity;

import java.util.Objects;

public class Triangle {
    private Point apexA;
    private Point apexB;
    private Point apexC;
    private static int count = 0;
    private int id;

    public Triangle(Point apexA, Point apexB, Point apexC) {
        this.apexA = apexA;
        this.apexB = apexB;
        this.apexC = apexC;
        this.id = ++count;
    }
    public Point getApexA() {
        return apexA;
    }
    public void setApexA(Point apexA) {
        this.apexA = apexA;
    }
    public Point getApexB() {
        return apexB;
    }
    public void setApexB(Point apexB) {
        this.apexB = apexB;
    }
    public Point getApexC() {
        return apexC;
    }
    public void setApexC(Point apexC) {
        this.apexC = apexC;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "apexA=" + apexA +
                ", apexB=" + apexB +
                ", apexC=" + apexC +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return id == triangle.id && Objects.equals(apexA, triangle.apexA) && Objects.equals(apexB, triangle.apexB) && Objects.equals(apexC, triangle.apexC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apexA, apexB, apexC, id);
    }
}
