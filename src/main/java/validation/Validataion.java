package validation;

import entity.Point;
import entity.Triangle;
import action.TriangleManip;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Validataion {
    private static final Logger logger = LogManager.getLogger(Validataion.class);

    public List<Triangle> getTriangles(String filePath) {
        List<Triangle> triangles = new ArrayList<>();

        try {
            Files.lines(Path.of(filePath)).forEach(line -> {
                String[] values = line.trim().split("\\s+");

                if (values.length != 6) {
                    logger.warn("Неверное количество символов в строке: " + line);
                    return;
                }

                try {
                    double x1 = Double.parseDouble(values[0]);
                    double y1 = Double.parseDouble(values[1]);
                    double x2 = Double.parseDouble(values[2]);
                    double y2 = Double.parseDouble(values[3]);
                    double x3 = Double.parseDouble(values[4]);
                    double y3 = Double.parseDouble(values[5]);

                    Point apexA = new Point(x1, y1);
                    Point apexB = new Point(x2, y2);
                    Point apexC = new Point(x3, y3);

                    Triangle triangle = new Triangle(apexA, apexB, apexC);

                    TriangleManip manipulator = new TriangleManip();
                    if (manipulator.isTriangleValid(triangle)) {
                        triangles.add(triangle);
                        logger.info("Треугольник добавлен: " + triangle);
                    } else {
                        logger.warn("Невозможно создать треугольник с такими вершинами: " + line);
                    }

                } catch (NumberFormatException e) {
                    logger.error("Ошибка преобразования строки в числа: " + line, e);
                }
            });
        } catch (IOException e) {
            logger.error("Ошибка чтения файла: " + e.getMessage(), e);
        }

        return triangles;
    }
}
