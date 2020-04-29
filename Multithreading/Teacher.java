package ru.spbstu.labsSpring2020.Multithreading;

import static java.lang.Thread.sleep;

public class Teacher
{
    public Teacher(String subjName)
    {
        subjName_ = subjName;
    }

    public int admitTasks(int numOfTasks)
    {
        try
        {
            sleep(100);
        }
        catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
        }

        return numOfTasks - 5;
    }

    public String getSubjName()
    {
        return subjName_;
    }

    private String subjName_;
}
