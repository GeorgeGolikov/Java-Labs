package ru.spbstu.labsSpring2020.Multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class Generator extends Thread
{
    @Override
    public void run()
    {
        while (studentsCount_ < 10)
        {
            Thread thread = new Student(labsCount_, classRoom_, targetTeacher_, locker_);
            synchronized (studentsCount_)
            {
                ++studentsCount_;
                thread.setName("Student" + Integer.toString(studentsCount_));
            }
            thread.start();
        }
    }

    public Generator(int labsCount, ClassRoom classRoom, Teacher teacher, ReentrantLock locker)
    {
        labsCount_ = labsCount;
        classRoom_ = classRoom;
        targetTeacher_ = teacher;
        locker_ = locker;
    }

    public static void setStudentsCount_(int count)
    {
        studentsCount_ = count;
    }

    private int labsCount_;
    private ClassRoom classRoom_;
    private Teacher targetTeacher_;
    private ReentrantLock locker_;

    private static volatile Integer studentsCount_;
}
