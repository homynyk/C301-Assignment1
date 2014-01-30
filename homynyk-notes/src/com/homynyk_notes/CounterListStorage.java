package com.homynyk_notes;

import java.io.*;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class CounterListStorage extends Activity {
	private static final String FILENAME = "file.ser";
	public static ArrayList<Counter> counters = new ArrayList<Counter>();

	public static ArrayList<Counter> loadFromFile(Context context) {
		try {
			//System.out.println("Starting file LOAD");
			FileInputStream fis = context.openFileInput(FILENAME);
			//System.out.println("OPENED FILE");
			ObjectInputStream in = new ObjectInputStream(fis);
			//System.out.println("OBJECT INPUT STREAM!!");
			counters = (ArrayList<Counter>) in.readObject();
			//System.out.println("READ OBJECTS!!!");
			in.close();
			return counters;
			//System.out.println("Done loading.");
			// Closing fis causes "SPAN_EXCLUSIVE_EXCLUSIVE spans cannot have a zero length"
			//fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		return null;
	}

	public static void saveInFile(Context context, ArrayList<Counter> counters) {
		try {
			// Serialize data object to a file
			//System.out.println("Started Saving file....");
			//System.out.println("START SAVE FUNC!!");
			//System.out.println("CREATE NEW COUNTER");
			
			//counters.add(counter);
			
			//System.out.println("ADD COUNTER TO LIST!!");
			FileOutputStream fos = context.openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream out = new ObjectOutputStream(bos);
			out.flush();
			out.writeObject(counters);
			out.close();
			//System.out.println("Done saving.");
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
