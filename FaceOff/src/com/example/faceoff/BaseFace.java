package com.example.faceoff;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BaseFace extends Activity 
{
	//What's up?
	Button camera_button;
	//Hey
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	private Uri fileUri;
	public static final int MEDIA_TYPE_IMAGE = 1;
	
	/** Create a file Uri for saving an image */
	private static Uri getOutputMediaFileUri(int type)
	{
		try
		{
			System.out.println(Uri.fromFile(getOutputMediaFile(type)));
		}
		catch(RuntimeException e)
		{
			System.out.println("Hit 1");
			e.printStackTrace();
		}
		
	      return Uri.fromFile(getOutputMediaFile(type));
	}
	/** Create a File for saving an image */
	private static File getOutputMediaFile(int type)
	{
		// To be safe, you should check that the SDCard is mounted
	    // using Environment.getExternalStorageState() before doing this.
		
		System.out.println(Environment.getExternalStorageState());
		
		File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "FaceOff");
		System.out.println(mediaStorageDir.getPath());
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
	    // Create a media file name
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    File mediaFile;
	    
	    if (type == MEDIA_TYPE_IMAGE)
	    {
	        mediaFile = new File(mediaStorageDir.getPath() + File.separator +
	        "IMG_"+ timeStamp + ".jpg");
	    } 
	    else 
	    {
	        return null;
	    }
	    return mediaFile;
	}

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base_face);
		
		// create Intent to take a picture and return control to the calling application
	    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		
	    try
	    {
	    	fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE); // create a file to save the image
	    }
	    catch(Exception e)
	    {
	    	System.out.println("Hit 2");
	    	e.printStackTrace();
	    }
	    intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name
	    
	  //start the image capture Intent
	    startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
	  //PictureInterpretation.Decode(fileUri);
	    
	  //Locate buttons in activity_base_face.xml
	  		camera_button = (Button) findViewById(R.id.camera_button);
	  				
	  				//Capture button clicks
	  				camera_button.setOnClickListener(new OnClickListener() 
	  				{
	  					public void onClick(View arg0)
	  					{
	  						//Start BaseFace class
	  						Intent intent1 = new Intent(BaseFace.this, BaseFace.class);
	  						startActivity(intent1);
	  					}
	  				});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.base_face, menu);
		return true;
	}
}