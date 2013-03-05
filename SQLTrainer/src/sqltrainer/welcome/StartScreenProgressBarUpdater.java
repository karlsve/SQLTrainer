/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sqltrainer.welcome;

/**
 *
 * @author karlinsv
 */
public class StartScreenProgressBarUpdater implements Runnable {
    
    StartScreenProgressBarUpdateListener listener = null;
    int step = 0;
    
    public StartScreenProgressBarUpdater(StartScreenProgressBarUpdateListener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        for(int i = 0; i<=100; i++) {
            if(listener!=null) {
                listener.updateValue(i);
            }
            try {
                Thread.sleep(step);
            } catch (InterruptedException ex) {
                System.out.println("interrupted");
            }
        }
        try {
            Thread.sleep(step);
        } catch (InterruptedException ex) {
            System.out.println("interrupted");
        }
        if(listener!=null) {
            listener.done();
        }
    }
    
}
