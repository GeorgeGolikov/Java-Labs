package ru.spbstu.labsSpring2020.Multithreading;

import java.util.concurrent.locks.ReentrantLock;
import java.lang.Math;

public class Main
{
    private static int getLabsCount()
    {
        double a = Math.random();
        if (a < 0.3333)
        {
            return 10;
        }
        else if (a < 0.6666)
        {
            return 20;
        }
        else
        {
            return 100;
        }
    }

    public static void main(String[] args)
    {
        ClassRoom classRoom = new ClassRoom(10, true);

        Teacher mathTeacher = new Teacher("Math");
        ReentrantLock mathLocker = new ReentrantLock();

        Teacher programmingTeacher = new Teacher("Programming");
        ReentrantLock programmingLocker = new ReentrantLock();

        Teacher physicsTeacher = new Teacher("Physics");
        ReentrantLock physicsLocker = new ReentrantLock();

        Generator.setStudentsCount_(0);
        int labsCount = getLabsCount();
        Generator mathStudentsGenerator = new Generator(labsCount, classRoom, mathTeacher, mathLocker);

        labsCount = getLabsCount();
        Generator programmingStudentsGenerator = new Generator(labsCount, classRoom, programmingTeacher, programmingLocker);

        labsCount = getLabsCount();
        Generator physicsStudentsGenerator = new Generator(labsCount, classRoom, physicsTeacher, physicsLocker);

        mathStudentsGenerator.start();
        programmingStudentsGenerator.start();
        physicsStudentsGenerator.start();
    }
}
