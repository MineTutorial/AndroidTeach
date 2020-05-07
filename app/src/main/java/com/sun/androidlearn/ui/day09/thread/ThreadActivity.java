package com.sun.androidlearn.ui.day09.thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.sun.androidlearn.R;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import bolts.Task;

/**
 * 进程，线程，协程
 * 一个进程 就是一个 app.
 * 线程：就是任务；一个进程里会有多个任务。现在App会有几百个，不超过500.1个主线程
 * cpu..处理器。8核心。每个cpu一个时刻只能执行1个任务,但是可以交替执行。
 * <p>
 * 保证顺序的过程：线程安全的处理：原子性，有序性，可见性
 * 1.系统提供的join,优先执行。最高级别
 * 2. synchronized 同步代码块。代码块内的代码在获取这个阻塞对象（"锁"）的时候要执行完成
 * 3. lock 锁
 * 4. volatile 可见性,禁止指令重排
 * 线程池。以上4中原理。
 */
public class ThreadActivity extends AppCompatActivity {
    volatile int i = 100;
    private Lock lock = new ReentrantLock();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        //异步线程，子线程
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                synchronized (ThreadActivity.class) {
                    //线程要做的事情
                    //... Request，io
//                lock.lock();
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
//                    Log.d("ThreadActivity", "thread1: " + i++);
////                }
//                lock.unlock();
                i = i -100;
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                i = i -100;
                //线程要做的事情
                //... Request，io
                //线程要做的事情
                //... Request，io
//                lock.lock();
////                synchronized (ThreadActivity.class) {
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
//                    Log.d("ThreadActivity", "thread2: " + i++);
////                }
//                lock.unlock();
            }
        });
//        try {
//
//            thread1.start();
//            thread1.join();//优先执行完成
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        thread1.start();
        thread2.start();

        //系统。cpu执行权，就会执行run
    }

}
