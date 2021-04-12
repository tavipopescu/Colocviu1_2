package ro.pub.cs.systems.eim.Colocviu1_2;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

public class ProcessingThread extends Thread {
    private Context context = null;
    private int result;

    public ProcessingThread(Context context, int result) {
        this.context = context;
        this.result = result;
    }

    @Override
    public void run() {
        Log.d("TAG", "Thread has started!");
        sleep();
        sendMessage();
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.setAction(Constants.ACTION);
        intent.putExtra(Constants.BROADCAST_EXTRA,
                new Date(System.currentTimeMillis()) + " " + result);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
