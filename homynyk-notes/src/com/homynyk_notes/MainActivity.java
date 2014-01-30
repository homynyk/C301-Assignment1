package com.homynyk_notes;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
//import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
//import android.widget.ArrayAdapter;
import android.widget.Button;

public class MainActivity extends Activity {

	Button new_counter;
	public ListView oldCounterList;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		oldCounterList = (ListView) findViewById(R.id.oldCounterList);
		new_counter = (Button) findViewById(R.id.bNew);
		new_counter.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					Class ourClass = Class
							.forName("com.homynyk_notes.MakeNewCounter");
					Intent openMakeNewCounter = new Intent(MainActivity.this,
							ourClass);
					startActivity(openMakeNewCounter);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		oldCounterList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> l, View v, int position,
					long id) {
				try {
					Class ourClass = Class
							.forName("com.homynyk_notes.CounterView");
					Intent goToCounter = new Intent(MainActivity.this, ourClass);
					goToCounter.putExtra("index", position);
					startActivity(goToCounter);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			}
		});
	}

	protected void onStart() {
		// System.out.println("STARTING ACTIVITY!!!!!!");
		super.onStart();
		// System.out.println("CALL LOAD!!");
		ArrayList<Counter> counter_list = CounterListStorage.loadFromFile(this
				.getApplicationContext());
		if (counter_list == null) {
			Counter err_counter = new Counter("Error", 999);
			counter_list = new ArrayList<Counter>();
			counter_list.add(err_counter);
		}
		// System.out.println("RETURN FROM LOAD!!");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.list_item);

		// System.out.println("NEW ARRAY ADAPTER.");
		for (int i = 0; i < counter_list.size(); i++) {
			adapter.add(counter_list.get(i).getName() + " ->" + counter_list.get(i).getValue());
		}
		// System.out.println("ADD ITEM TO ADAPTER");
		oldCounterList.setAdapter(adapter);
	}
}