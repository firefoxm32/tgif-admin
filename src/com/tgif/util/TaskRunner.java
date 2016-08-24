/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.util;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;

/**
 *
 * @author Mon
 */
public class TaskRunner {

    private Task task;
    private int delay;
    private TaskManager taskManager;
    private boolean isRunning;

    private class TaskManager extends SwingWorker<Void, Void> {
        @Override
        protected Void doInBackground() throws Exception {
            Task tmTask = getTask();
            int tmDelay = getDelay();
            while (isRunning) {
                tmTask.queTask();
                Thread.sleep(tmDelay);
            }
            return null;
        }
    }

    public Task getTask() {
        return this.task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public int getDelay() {
        return this.delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void destroy() {
        if (this.taskManager != null) {
            this.taskManager.cancel(true);
            this.isRunning = false;
            this.taskManager = null;
        } else {
            try {
                throw new Exception("Can't destroy object taskManager. Check the object if it's instantiated");
            } catch (Exception ex) {
                Logger.getLogger(TaskRunner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void run() {
        this.isRunning = true;
        this.taskManager = new TaskManager();
        this.taskManager.execute();
    }
}
