package ru.spbstu.labsSpring2020.Shapes.shapes;

import java.lang.Math;

/**
 * Представление о треугольнике.
 * <p>
 * Треуго́льник (в евклидовом пространстве) — геометрическая
 * фигура, образованная тремя отрезками, которые соединяют
 * три точки, не лежащие на одной прямой. Указанные три
 * точки называются вершинами треугольника, а отрезки —
 * сторонами треугольника. Часть плоскости, ограниченная
 * сторонами, называется внутренностью треугольника: нередко
 * треугольник рассматривается вместе со своей внутренностью
 * (например, для определения понятия площади).
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%A2%D1%80%D0%B5%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA">Треугольник</a>
 */
public class Triangle implements Shape, Polygon
{
    // координаты точек задаются с учётом угла поворота - то есть координаты вершин треугольника в повернутом состоянии
    public Triangle(Point_t[] vertices)
    {
        if (vertices.length == 3)
        {
            vertices_ = new Point_t[3];
            System.arraycopy(vertices, 0, vertices_, 0, 3);
            angle_ = 0;
        }
        else
        {
            throw new IllegalArgumentException("The argument array should be of 3 elements!" +
                                               "The given one is " + Integer.toString(vertices.length) + ".");
        }
    }
    public Triangle(Point_t[] vertices, int angle)
    {
        if (angle < 0 || angle > 360)
        {
            throw new IllegalArgumentException("The value of given angle should be from 0 to 360 degrees!\n");
        }
        if (vertices.length == 3)
        {
            vertices_ = new Point_t[3];
            System.arraycopy(vertices, 0, vertices_, 0, 3);
            angle_ = angle;
        }
        else
        {
            throw new IllegalArgumentException("The argument array should be of 3 elements!" +
                                               "The given one is " + Integer.toString(vertices.length) + ".");
        }
    }
    public Triangle(Triangle rhs)
    {
        vertices_ = new Point_t[3];
        System.arraycopy(rhs.getVertices(), 0, vertices_, 0, 3);
        angle_ = rhs.getRotation();
    }

    @Override
    public double getArea()
    {
        // https://en.wikipedia.org/wiki/Triangle#Using_coordinates
        return Math.abs((vertices_[0].getX() - vertices_[2].getX()) * (vertices_[1].getY() - vertices_[0].getY()) -
                        (vertices_[0].getX() - vertices_[1].getX()) * (vertices_[2].getY() - vertices_[0].getY()))
                / 2;
    }

    @Override
    public int getRotation()
    {
        return angle_;
    }

    @Override
    public void getInformation()
    {
        System.out.println("Triangle. Area: " + getArea() + ". Perimeter: " + getPerimeter() + ".");
    }

    @Override
    public double getPerimeter()
    {
        // hypot - возвращает квадратный корень из суммы квадратов аргументов
        double a = Math.sqrt(Math.hypot(vertices_[1].getX() - vertices_[0].getX(),
                                        vertices_[1].getY() - vertices_[0].getY()));

        double b = Math.sqrt(Math.hypot(vertices_[2].getX() - vertices_[1].getX(),
                                        vertices_[2].getY() - vertices_[1].getY()));

        double c = Math.sqrt(Math.hypot(vertices_[2].getX() - vertices_[0].getX(),
                                        vertices_[2].getY() - vertices_[0].getY()));

        return a + b + c;
    }

    public Point_t[] getVertices()
    {
        return vertices_;
    }

    public Point_t getVertices(int i)
    {
        if (i >= 0 && i < 3)
        {
            return vertices_[i];
        }
        else
        {
            throw new IndexOutOfBoundsException("Argument is out of bounds! Value: " + Integer.toString(i));
        }
    }

    private Point_t[] vertices_;
    private int angle_;

    /*
     * TODO: Реализовать класс 'Triangle'
     * 1. Используйте наследование.
     * 2. Реализуйте все абстрактные методы.
     */
}
