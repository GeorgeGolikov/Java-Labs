package ru.spbstu.labsSpring2020.Shapes;

import ru.spbstu.labsSpring2020.Shapes.shapes.*;

public class Main
{
    public static void main(String[] args)
    {
        Point_t[] vertices1 = {new Point_t(1,1), new Point_t(3,5), new Point_t(-2,6)};
        Point_t[] vertices2 = {new Point_t(-8,10), new Point_t(-10,5), new Point_t(25,3)};
        Point_t[] vertices3 = {new Point_t(3,4), new Point_t(0,3), new Point_t(7,-6)};

        Shape[] shapes = {new Circle(new Point_t(5, 5), 10),
                          new Rectangle(new Point_t(-2, 3), 5, 6),
                          new Triangle(vertices1),
                          new Circle(new Point_t(-1, 2), 4),
                          new Rectangle(new Point_t(10, 20), 10, 6),
                          new Triangle(vertices2),
                          new Circle(new Point_t(4, -7), 8),
                          new Rectangle(new Point_t(2, 2), 20, 3),
                          new Triangle(vertices3),
                          new Rectangle(new Point_t(4, 3), 9, 7)};

        System.out.println("Areas in array:");
        for (Shape i : shapes)
        {
            System.out.print(i.getArea() + ", ");
        }
        System.out.println("");

        int index = indexOfMaxElement(shapes);

        System.out.println("Shape with max area in array: ");
        shapes[index].getInformation();


        /*
         * TODO: Выполнить действия над массивом 'shapes'
         *
         * 1. Проинициализировать переменную 'shapes' массивом
         *    содержащим 10 произвольных фигур. Массив должен
         *    содержать экземпляры классов Circle, Rectangle
         *    и Triangle.
         *
         * 2. Найти в массиве 'shapes' фигуру с максимальной
         *    площадью. Для поиска фигуры необходимо создать
         *    статический метод в текущем классе (Main).
         */
    }

    public static int indexOfMaxElement(Shape[] shapes)
    {
        if (shapes != null)
        {
            double maxArea = shapes[0].getArea();
            int index = 0;
            for (int i = 1; i < shapes.length; ++i)
            {
                double area = shapes[i].getArea();
                if (area > maxArea)
                {
                    maxArea = area;
                    index = i;
                }
            }
            return index;
        }
        else
        {
            throw new IllegalArgumentException("Given argument is null!\n");
        }
    }
}
