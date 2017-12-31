//    Copyright (c) The League of Amazing Programmers 2013-2017
//    Level 0

package extra;

import javax.print.attribute.standard.PrinterLocation;
import javax.swing.JOptionPane;

/* NASA wants to shoot a rocket into orbit. 
  * Somebody has to do the countdown – or the rocket won’t launch.
 * 
 * The ground control chief will tell you where to start – then count down to 0. 
 * 
 * (example for ’11’: 11 10 9 8 7 6 5 4 3 2 1 0)
 * 
 **/

public class NasaCountdown {
	public static void main(String[] args) {
		// 2. Use a pop-up to ask the user where to start counting from
String start = JOptionPane.showInputDialog(null,"Where would you like to start counting from?");
		// 3. Change the countdown to use the new starting point
		int t = Integer.parseInt(start);
		// 1. Print a countdown from 10 to 0 on the console
for (int i = t; i > 0; i-=1) {
	System.out.println(i);
	String countdown = String.valueOf(i);
speak(countdown);
}
speak("Blastoff!");
		// 4. Use the speak method to hear the countdown.
		
		// 5. when the counting is done, speak "blastoff!"
	}

static void speak(String words) {
   	 try {
   		 Runtime.getRuntime().exec("say " + words).waitFor();
   	 } catch (Exception e) {
   		 e.printStackTrace();
   	 }
  }
}


