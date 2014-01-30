package ca.ualberta.homynyk_notes;

import java.io.BufferedReader;
import ca.ualberta.homynyk_notes.CounterList;
import ca.ualberta.homynyk_notes.Counter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import ca.ualberta.homynyk_notes.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Main extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText nameText;
	private ListView oldCounterList;
	private ArrayList<String> counters;
	private ArrayAdapter<String> adapter;
	
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main); 
	        nameText = (EditText)findViewById(R.id.body);
	        Button saveButton = (Button)findViewById(R.id.save);
	        oldCounterList=(ListView)findViewById(R.id.oldCounterList);
	        saveButton.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					setResult(RESULT_OK);
					String text = nameText.getText().toString();
					saveInFile(text, 0);
					loadFromFile();
					adapter = new ArrayAdapter<String>(Main.this, 
							R.layout.list_item, counters);
					oldCounterList.setAdapter(adapter);
					adapter.notifyDataSetChanged();
					nameText.setText(null);
				}
			});

	        
	 }
	    protected void onStart() {
	    	super.onStart();
	    	loadFromFile();
	    	adapter = new ArrayAdapter<String>(this,R.layout.list_item, counters);
	    	oldCounterList.setAdapter(adapter);
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
	    
	    private void saveInFile(String text, Integer count){
	    	try{
	    		FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_APPEND);
	    		fos.write(new String(text + " -> " + count.toString()+ "\n").getBytes());
	    		fos.close();
	    	}catch(FileNotFoundException e){
	    		e.printStackTrace();
	    	}catch(IOException e){
	    		e.printStackTrace();
	    	}
	    }
	    
	}
