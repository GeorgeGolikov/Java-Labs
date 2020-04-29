package ru.spbstu.labsSpring2020.Multithreading;

import java.util.concurrent.locks.ReentrantLock;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student extends Thread
{
    @Override
    public void run()
    {
        if (labsCount_ > 0)
        {
            try
            {
                classRoom_.acquire();
                System.out.println(printDate() + " " + Thread.currentThread().getName() +
                                   " попадает в кабинет из 10 человек");

                locker_.lock();
                System.out.println (printDate() + " " + Thread.currentThread().getName() +
                                    " садится к преподавателю по " +
                                    targetTeacher_.getSubjName());

                classRoom_.release();
                while (labsCount_ != 0)
                {
                    labsCount_ = targetTeacher_.admitTasks(labsCount_);
                    System.out.println(Thread.currentThread().getName() + ": осталось лаб.работ "
                                        + labsCount_ + " "+ targetTeacher_.getSubjName());
                }
                System.out.println (printDate() + " " + Thread.currentThread().getName() +
                                    " встаёт от преподавателю по " +
                                    targetTeacher_.getSubjName());
            }
            catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
                classRoom_.release();
            }
            finally
            {
                locker_.unlock();
            }
        }
    }

    public Student(int labsCount, ClassRoom classRoom, Teacher teacher, ReentrantLock locker)
    {
        labsCount_ = labsCount;
        classRoom_ = classRoom;
        targetTeacher_ = teacher;
        locker_ = locker;

        sdf_ = new SimpleDateFormat("HH:mm:ss  ");
    }

    String printDate()
    {
        return sdf_.format(new Date());
    }

    private int labsCount_;
    private ClassRoom classRoom_;
    private Teacher targetTeacher_;
    private ReentrantLock locker_;

    private SimpleDateFormat sdf_;
}
