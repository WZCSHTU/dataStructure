/*** 中国象棋程序的日志管理系统
 * @author WZCSHTU
 * @version 1.0
 */
package Logging;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;

public class LoggingImageViewer {
    public static void main(String[] args) {
        if (System.getProperty("java.util.logging.config.class") == null
                && System.getProperty("java.util.logging.config.file") == null) {
            try {
                Logger.getLogger("Logging").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                Handler handler = new FileHandler("%hLoggingImageViewer%u.log", 0, LOG_ROTATION_COUNT);
                Logger.getLogger("Logging").addHandler(handler);
            } catch (IOException e) {
                Logger.getLogger("Logging").log(Level.SEVERE, "Can't create log file handler", e);
            }
        }
        EventQueue.invokeLater(()->{
            Handler windowHandler = new WindowHandler();
            windowHandler.setLevel(Level.ALL);
            Logger.getLogger("Logging").addHandler(windowHandler);

            JFrame frame = new ImageViewerFrame();
            frame.setTitle("中国象棋");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Logger.getLogger("Logging").fine("Showing frame");
            frame.setVisible(true);
        });
    }
}

class ImageViewerFrame extends JFrame{

}

class WindowHandler extends StreamHandler{

}
