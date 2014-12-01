package com.example.faceoff;

import java.io.File;
import java.util.*;
import org.json.*; //May or may not need that

import android.graphics.Bitmap;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
/*
 * This class contains the logic to creating a profile object complete with a name, accrued points, 
 * and a baseface. Once the camera is implemented, we can pass in the image and name into a function call
 * to get the baseface values of the photo via API (should be in jpeg format). After mapping the photo,
 * a new object is instantiated and will be put into an object storage container. (Probably an object array
 * at this point
 * */

public class ProfileCreationLogic 
{	
	//The list of objects (should find out how to store in memory)
	static ArrayList<profile> Profiles = new ArrayList<profile>();
	
	//Method for creating the Profile Object with a name and BaseFace
	public static void CreateProfile(String name, Bitmap picture)
	{	
		//Attempts to ping the server with the photo and receives a JSON object, response, back
		try
		{
		// These code snippets use an open-source library. http://unirest.io/java
			HttpResponse<JsonNode> response = Unirest.post("https://apicloud-facemark.p.mashape.com/process-file.json")
			.header("X-Mashape-Key", "jzKWjgvbrgmshp8BRxWzfgKzmBXBp1GvMeVjsnE2ursJJYsuCe")
			.field("image", new File("<file goes here>"))
			.asJson();
			
			double [] arrayMap = PictureInterpretation.Decode(response);
			
			//Adds a new profile object into the list Profiles
			Profiles.add(new profile(name,arrayMap,Profiles.size()));
			
			//JSONObject object = new JSONObject(response);
		}
		//Catches issues with sending to server, maybe do a retry in the future
		catch(UnirestException e)
		{
			//Need a text view for for the errors
			System.out.println("An error has occured" + e);
			e.printStackTrace();
		}
	}
}

