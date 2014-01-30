package com.homynyk_notes;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MakeNewCounter extends Activity {

	private EditText nameText;
	public ListView oldCounterList;
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_new_counter);      
        nameText = (EditText)findViewById(R.id.body);
        Button saveButton = (Button)findViewById(R.id.save);
        oldCounterList=(ListView)findViewById(R.id.oldCounterList);
        saveButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = nameText.getText().toString();
				Counter new_counter = new Counter(text, 0);
				//System.out.println("CALL SAVE FUNC!!");
				//CounterListStorage.saveInFile(this.getApplicationContext,text, 0);
				ArrayList<Counter> oldListCounters = CounterListStorage.loadFromFile(getApplicationContext());
				oldListCounters.add(new_counter);
				CounterListStorage.saveInFile(getApplicationContext(), oldListCounters);
				//System.out.println("RETURN FROM SAVE");
				nameText.setText(null);
				finish();
				//System.out.println("RETURN FROM MAKING NEW COUNTER");
			}
		});
    }
}
