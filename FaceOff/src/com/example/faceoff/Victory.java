package com.example.faceoff;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Victory extends Activity
{
	ImageButton main_menu_button;
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
  		setContentView(R.layout.activity_victory);
  		
  		//Locate buttons in victory.xml
		main_menu_button = (ImageButton) findViewById(R.id.main_menu);
		
		//Capture button clicks
		main_menu_button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				
				//Start player 1 offense class
				Intent intent1 = new Intent(Victory.this, MainActivity.class);
				startActivity(intent1);
			}
		});
	}
}
