package com.example.faceoff;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SinglePhone extends Activity {
	Button P2_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single_phone);
		
		//Drop Down menu of profiles. Accesses array in strings.xml under values folder
		Spinner spinner = (Spinner) findViewById(R.id.profiles_spinner_p1);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.profiles_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		
		
		//Locate buttons in activity_single_phone.xml
		P2_button = (Button) findViewById(R.id.P2_button);
		
		//Capture button clicks
		P2_button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				
				//Start Player2 class
				Intent intent1 = new Intent(SinglePhone.this, Player2.class);
				startActivity(intent1);
			}
		});
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.single_phone, menu);
		return true;
	}

}
