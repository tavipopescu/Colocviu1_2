package ro.pub.cs.systems.eim.Colocviu1_2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Colocviu1_2Service extends Service {
    ProcessingThread processingThread = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int result = intent.getIntExtra(Constants.SEND_RESULT, -1);

        processingThread = new ProcessingThread(this, result);
        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}