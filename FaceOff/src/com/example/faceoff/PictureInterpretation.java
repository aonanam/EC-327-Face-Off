package com.example.faceoff;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.graphics.Bitmap;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.json.*;

public class PictureInterpretation {

	public static ArrayList<Double> Decode(Bitmap picture)
	{
		/*This will be the completed ArrayList with X and Y values stored. Formatting is x 0-67, and y 68 - 135*/
		ArrayList<Double> interpretedVals = new ArrayList<Double>();
		
		/*These arrays serve as a necessary intermediate step into converting a JSON object into an array. Other advances data structures
		 * are scary at this point. Maybe replace array architecture with maps/trees in the future*/
		ArrayList<Double> Xlist = new ArrayList<Double>();
		ArrayList<Double> Ylist = new ArrayList<Double>();
		
		/*Code to convert bmp image to jpg goes here. The API does not support bmp formatting ): */
		
		try
		{
			/*Attempts to ping the server with the image. If successful, the server should send us back a formatted object
			 * (in this case, a HttpResponse<JsonNode>. Will want some type of error checking to see if everything was sent well 
			 * in the future.
			 * */
			
			HttpResponse<JsonNode> response = Unirest.post("https://apicloud-facemark.p.mashape.com/process-file.json")
				.header("X-Mashape-Key", "jzKWjgvbrgmshp8BRxWzfgKzmBXBp1GvMeVjsnE2ursJJYsuCe")
				.field("image", new File("<file goes here>"))
				.asJson();
			
			/*Checks the http return status, 200 = OK*/
			if(response.getStatus() != 200)
			{
				System.out.println("Ah... Looks like something went wrong");
			}
			
			/*.getBody() parses the HttpResponse<JsonNode> into a JsonNode object. The JsonNode is converted into a JSONObject via casting
			 * into Map format*/
			JSONObject obj = new JSONObject((Map) response.getBody());

			/*Parses the JSONObjects into JSON arrays by looking for the "x" and "y" keys, returning their respective values*/
			JSONArray arrayX = obj.getJSONArray("x");
			JSONArray arrayY = obj.getJSONArray("y");
		
			for(int i = 0; i < arrayX.length(); i++)
			{
				Xlist.add(arrayX.getDouble(i));
				interpretedVals.add(Xlist.get(i));
			}
			for(int j = 0; j < arrayY.length(); j++)
			{
				Ylist.add(arrayY.getDouble(j));
				interpretedVals.add(Ylist.get(j));
			}
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
		
		return interpretedVals;

	}

}
