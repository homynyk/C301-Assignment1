package ca.ualberta.homynyk_notes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
//import ca.ualberta.homynyk_notes.Main;



public class CounterList extends ListActivity {
	
	private ArrayList<String> counters;
	private static final String FILENAME = "file.sav";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		loadFromFile();
	    setListAdapter(new ArrayAdapter<String>(CounterList.this, android.R.layout.simple_list_item_1, counters));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String cheese = counters.get(position);
		try{
		Class ourClass = Class.forName("ca.ualberta.homynyk_notes" + cheese);
		Intent ourIntent = new Intent(CounterList.this, ourClass);
		startActivity(ourIntent);
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	private void loadFromFile() {
		counters = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				counters.add(line);
				line = in.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
