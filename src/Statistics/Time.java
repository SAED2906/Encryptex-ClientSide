package Statistics;

import java.io.IOException;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import CLIENT.ThreadClient;
import GUI.MainGui;


public class Time {
	
	
	
	public static String getTimeHMS() {
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   return dtf.format(now);
	}
	
	public static String getTime() {
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   return dtf.format(now);
	}
	
	public static void ThreadStart_Alive() {
		Alive thread = new Alive();
		thread.start();
	}
	
}

	
	
   class Alive extends Thread {
	   public static boolean online = false;
    @Override
    public void run() {

    	while (true) {

            try {
            for (int i = 1; i < 6; i++) {
            Thread.sleep(1000); 
            MainGui.lblTimer.setText(i + "");
            }
            if (!online) {
            ThreadClient.isAlive(MainGui.textmyUUID.getText());
            online = true;
            }
            MainGui.appendTextOnline(ThreadClient.getOnline());
            	
            	} catch(InterruptedException | IOException e) {
            		System.out.println(e);
            	}

        }
    }
}
