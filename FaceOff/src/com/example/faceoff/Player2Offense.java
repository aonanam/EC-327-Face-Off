package com.example.faceoff;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Player2Offense extends Activity {
	Button P1_Defense_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player2_offense);
		
		//Locate buttons in activity_player2_offense.xml
		P1_Defense_button = (Button) findViewById(R.id.P1_Defense_button);
		
		//Capture button clicks
		P1_Defense_button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				//Start Player1Defense class
				Intent intent1 = new Intent(Player2Offense.this, Player1Defense.class);
				startActivity(intent1);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.player2_offense, menu);
		return true;
	}

}
