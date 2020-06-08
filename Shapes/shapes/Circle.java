package ru.spbstu.labsSpring2020.Shapes.shapes;

import java.lang.Math;

/**
 * Представление об окружности.
 * <p>
 * Окру́жность — замкнутая плоская кривая, которая состоит из
 * всех точек на плоскости, равноудалённых от заданной точки.
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%9E%D0%BA%D1%80%D1%83%D0%B6%D0%BD%D0%BE%D1%81%D1%82%D1%8C">Окружность</a>
 */
public class Circle implements Shape, Ellipse
{
    public Circle(Point_t center, double radius)
    {
        if (radius > 0)
        {
            center_ = center;
            radius_ = radius;
        }
        else
        {
            throw new IllegalArgumentException("Radius should be positive!\n");
        }
    }
    public Circle(Circle rhs)
    {
        center_ = rhs.getCenter();
        radius_ = rhs.getRadius();
    }

    @Override
    public double getArea()
    {
        return Math.PI * radius_ * radius_;
    }

    @Override
    public void getInformation()
    {
        System.out.println("Circle. Area: " + getArea() + ". Length: " + getLength() + ".");
    }

    @Override
    public double getLength()
    {
        return 2 * Math.PI * radius_;
    }

    public Point_t getCenter()
    {
        return center_;
    }

    public double getRadius()
    {
        return radius_;
    }

    private Point_t center_;
    private double radius_;
    /*
     * TODO: Реализовать класс 'Circle'
     * 1. Используйте наследование.
     * 2. Реализуйте все абстрактные методы.
     */
}
