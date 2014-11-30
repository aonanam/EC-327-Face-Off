package com.example.faceoff;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartFaceOff extends Activity {
	Button P1_Offense_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_face_off);
		
		//Locate buttons in activity_start_face_off.xml
		P1_Offense_button = (Button) findViewById(R.id.P1_Offense_button);
						
		//Capture button clicks
		P1_Offense_button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				//Start Player1Offense class
				Intent intent1 = new Intent(StartFaceOff.this, Player1Offense.class);
				startActivity(intent1);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_face_off, menu);
		return true;
	}

}
