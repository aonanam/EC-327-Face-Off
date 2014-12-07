package com.example.faceoff;

import java.util.ArrayList;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class profile 
{		
		//Name of the profile
		String profileName;
		
		//Amount of points this profile is carrying
		int points;
		
		/* ArrayList of specified points on the face, 68 (x,y) coordinates packed into a 135 element array with the format of:
		 * X coordinates first (0-67) followed by the y coordinates (68-135)
		 * */ 
		ArrayList<Double> baseFace;
		
		//The element of the current profile. assuming many will be stored
		int profileNum;
		
		//The string path to the picture
		String path;
		
		//Constructor for a profile
		public profile(String name, ArrayList<Double> arrayMap, int index)
		{
			profileName = name;
			points = 0;
			profileNum = index;
			baseFace = arrayMap;
		}
		
		public profile(String name, int index)
		{
			profileName = name;
			points = 0;
			profileNum = index;
		}
		
		public void addBaseFace(ArrayList<Double> arrayMap)
		{
			baseFace = arrayMap;
		}
		
		public int getPoints()
		{
			return this.points;
		}
		
		public String getProfileName()
		{
			return this.profileName;
		}
		
		public int getIndex()
		{
			return this.profileNum;
		}
		
		public void setProfileName(String newName)
		{
			this.profileName = newName;
		}
		
		public void setPath(String path)
		{
			this.path = path;
		}
		
}
