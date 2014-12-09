package com.example.faceoff;

import java.io.File;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Player1Defense extends Activity {
	Button compare2_button;
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	private Uri fileUri;
	public static final int MEDIA_TYPE_IMAGE = 1;
	
	/** Create a file Uri for saving an image */
	private static Uri getOutputMediaFileUri(int type)
	{
	      return Uri.fromFile(getOutputMediaFile(type));
	}
	/** Create a File for saving an image */
	private static File getOutputMediaFile(int type)
	{
		// To be safe, you should check that the SDCard is mounted
	    // using Environment.getExternalStorageState() before doing this.
		
		//System.out.println(Environment.getExternalStorageState());
		
		File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "FaceOff");
		//System.out.println(mediaStorageDir.getPath());
		// This location works best if you want the created images to be shared
	    // between applications and persist after your app has been uninstalled.

		// Create the storage directory if it does not exist
	    if (! mediaStorageDir.exists())
	    {
	        if (! mediaStorageDir.mkdirs())
	        {
	        	System.out.println("FaceOff" + "failed to create directory");
	        	return null;
	        }
	    }
	    // Create a media file name, names it Player1Offense.jpg
	    File mediaFile;
	    
	    if (type == MEDIA_TYPE_IMAGE)
	    {
	        mediaFile = new File(mediaStorageDir.getPath() + File.separator + "Player1Defense.jpg");
	    } 
	    else 
	    {
	        return null;
	    }
	    return mediaFile;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player1_defense);

		//create Intent to take a picture and return control to the calling application
	    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	    
	    fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE); // create a file to save the image
	    
	    intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name
	    
	    //start the image capture Intent
	    startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK)
		{
			PictureInterpretation.Decode(fileUri,MainActivity.activePlayers.get(0),"face");
			MainActivity.activePlayers.get(0).setNewPath(fileUri.getPath());
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
	    setContentView(R.layout.activity_player1_defense);
		
		//Displays image of previously taken picture.
		String path = Environment.getExternalStorageDirectory()+ "/Pictures/FaceOff/Player1Defense.jpg";
		ImageView jpgview = (ImageView)findViewById(R.id.jpgview_p1_defense);
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inSampleSize = 2;
		Bitmap bm = BitmapFactory.decodeFile(path, options);
		jpgview.setImageBitmap(bm);
		
		//System.out.println(MainActivity.activePlayers.get(1).baseFace); @@@@@@@@@@@@@@@@@@@@@@@@

		  
		//double difference = ComparisonLogic.FaceVsFace(MainActivity.activePlayers.get(0).baseFace,MainActivity.activePlayers.get(1).baseFace);

		System.out.println(MainActivity.activePlayers.get(1).baseFace);

		 //System.out.println(MainActivity.activePlayers.get(1).baseFace); @@@@@@@@@@@@@@@@@@@@@@@@

		 /* double difference = ComparisonLogic.FaceVsFace(MainActivity.activePlayers.get(0).baseFace,MainActivity.activePlayers.get(1).baseFace);*/


		System.out.println(MainActivity.activePlayers.get(1).baseFace);

		//Locate buttons in activity_player1_defense.xml
		compare2_button = (Button) findViewById(R.id.compare2_button);
						
		//Capture button clicks
		compare2_button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				//Start Player1Offense class
				Intent intent1 = new Intent(Player1Defense.this, FaceCompare2.class);
				startActivity(intent1);
			}
		});	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.player1_defense, menu);
		return true;
	}

}
