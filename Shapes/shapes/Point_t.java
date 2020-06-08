package ru.spbstu.labsSpring2020.Shapes.shapes;

public final class Point_t implements Point
{
    public Point_t(double x, double y)
    {
        x_ = x;
        y_ = y;
    }
    public Point_t(Point_t rhs)
    {
        x_ = rhs.getX();
        y_ = rhs.getY();
    }

    @Override
    public double getX()
    {
        return x_;
    }

    @Override
    public double getY()
    {
        return y_;
    }

    private double x_;
    private double y_;
}
