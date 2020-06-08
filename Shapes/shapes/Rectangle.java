package ru.spbstu.labsSpring2020.Shapes.shapes;

// может представлен центром и длиной шириной

/**
 * Представление о прямоугольнике.
 * <p>
 * Прямоугольник — четырехугольник, у которого все углы
 * прямые (равны 90 градусам).
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%9F%D1%80%D1%8F%D0%BC%D0%BE%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA">Прямоугольник</a>
 */
public class Rectangle implements Shape, Polygon
{
    public Rectangle(Point_t center, double width, double length)
    {
        if (width > 0 && length > 0)
        {
            center_ = center;
            width_ = width;
            length_ = length;
        }
        else
        {
            throw new IllegalArgumentException("Width and length should be positive!\n");
        }
    }
    public Rectangle(Point_t center, double width, double length, int angle)
    {
        if (angle < 0 || angle > 360)
        {
            throw new IllegalArgumentException("The value of given angle should be from 0 to 360 degrees!\n");
        }
        if (width > 0 && length > 0)
        {
            center_ = center;
            width_ = width;
            length_ = length;
        }
        else
        {
            throw new IllegalArgumentException("Width and length should be positive!\n");
        }
    }
    public Rectangle(Rectangle rhs)
    {
        center_ = rhs.getCenter();
        width_ = rhs.getWidth();
        length_ = rhs.getLength();
        angle_ = rhs.getRotation();
    }

    @Override
    public double getArea()
    {
        return width_ * length_;
    }

    @Override
    public int getRotation()
    {
        return angle_;
    }

    @Override
    public void getInformation()
    {
        System.out.println("Rectangle. Area: " + getArea() + ". Perimeter: " + getPerimeter() + ".");
    }

    @Override
    public double getPerimeter()
    {
        return (width_ + length_) * 2;
    }

    public Point_t getCenter()
    {
        return center_;
    }

    public double getWidth()
    {
        return width_;
    }

    public double getLength()
    {
        return length_;
    }

    private Point_t center_;
    private double width_;
    private double length_;
    private int angle_;

    /*
     * TODO: Реализовать класс 'Rectangle'
     * 1. Используйте наследование.
     * 2. Реализуйте все абстрактные методы.
     */
}
