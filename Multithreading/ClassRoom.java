package ru.spbstu.labsSpring2020.Multithreading;

import java.util.concurrent.Semaphore;

public class ClassRoom extends Semaphore
{
    public ClassRoom(int numOfPeople, boolean fair)
    {
        super(numOfPeople, fair);
    }
}
