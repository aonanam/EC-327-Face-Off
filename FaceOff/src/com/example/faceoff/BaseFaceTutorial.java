package com.example.faceoff;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BaseFaceTutorial extends Activity 
{
	Button baseface_button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base_face_tutorial);
		
		//Locate buttons in activity_base_face_tutorial.xml
		baseface_button = (Button) findViewById(R.id.baseface_button);
				
				//Capture button clicks
				baseface_button.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View arg0) 
					{		
						//Start BaseFace class
						Intent intent1 = new Intent(BaseFaceTutorial.this, BaseFace.class);
						startActivity(intent1);
					}
				});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.base_face_tutorial, menu);
		return true;
	}
}
