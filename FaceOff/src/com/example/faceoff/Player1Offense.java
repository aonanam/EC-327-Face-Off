package com.example.faceoff;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Player1Offense extends Activity {
	Button P2_Defense_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player1_offense);
		
		//Locate buttons in activity_player1_offense.xml
		P2_Defense_button = (Button) findViewById(R.id.P2_Defense_button);
						
		//Capture button clicks
		P2_Defense_button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				//Start Player2Defense class
				Intent intent1 = new Intent(Player1Offense.this, Player2Defense.class);
				startActivity(intent1);
			}
		});		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.player1_offense, menu);
		return true;
	}

}
