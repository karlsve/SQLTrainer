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
    int max = 100;
    int pause = 100;
    
    public StartScreenProgressBarUpdater(int pause, int max, StartScreenProgressBarUpdateListener listener) {
        this.pause = pause;
        this.max = max;
        this.listener = listener;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            for(int i = 0; i<=max; i++) {
                if(listener!=null) {
                    listener.updateValue(i);
                }
                Thread.sleep(pause);
            }
            if(listener!=null) {
                listener.done();
            }
            Thread.sleep(pause);
        } catch (InterruptedException ex) {
            System.out.println("interrupted");
        }
    }
    
}
