package com.example.faceoff;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class ComparisonLogic 
{
	/*
	 * (x,y) values for the base face, for a total of 68 points
	 * As of now, we only care about 15 - 20 (left eyebrow), 21-26 (right eyebrow),
	 * 27-30 (right eye excluding pupil), 32 - 35 (left eye excluding pupil), 48 - 66 (mouth).
	 * The total number of relevant points is 34 as of now. So each point will be weighted with the 
	 * value of 1/34
	 * 
	 * As of now, the only centering algorithms use the pupils as reference. If we want to streamline the code in the future,
	 * we have access to many points on the nose as well as the outline of the face (ear to ear and along the jaw).
	 * */
	public static ArrayList<Double>  vsBaseFace(profile p, ArrayList<Double> newFace)
	{
		//31 - Right Pupil, 36 Left Pupil, DON'T FORGET THAT INDICIES START AT 0, NOT 1
		
		ArrayList<Double> diffFromBase = new ArrayList<Double>();
		
		//Gets the average change between the two pupils of the two pictures to scale the differences
		double centerX = ((p.baseFace.get(30) - newFace.get(30)) + (p.baseFace.get(35) - newFace.get(35)))/2;
		double centerY = ((p.baseFace.get(66) - newFace.get(66)) + (p.baseFace.get(103) - newFace.get(103)))/2;
		
		/*Loops through the ArrayList of points, formatted as all x values then y values (0-67 x, 68 - 135 y) and compares the differences
		 * between the two points in question. The baseface coordinates are centered to the newface by calculating the differences in 
		 * the location of pupils as done above. The loop appends the differences into an ArrayList called diffFromBase and returns it.
		 * */
		for(int x = 0; x < p.baseFace.size(); x++)
		{
			if(x <= 68)
			{
				diffFromBase.add(p.baseFace.get(x)+centerX - newFace.get(x));
			}
			else
			{
				diffFromBase.add(p.baseFace.get(x)+centerY - newFace.get(x));
			}
		}
		
		System.out.println("Size of diffFromBase: " + diffFromBase.size());
		
		return diffFromBase;
	}

	public static double FaceVsFace(ArrayList<Double> faceOne, ArrayList<Double> faceTwo)
	{
		double points = 0;
			
		/*Calculates the centering distance needed to transpose the pupils of face two onto face one to accurate facial feature change 
		 * detection. */
		double centerX = ((faceOne.get(30) - faceTwo.get(30)) + (faceOne.get(35) - faceTwo.get(35)))/2;
		double centerY = ((faceOne.get(66) - faceTwo.get(66)) + (faceOne.get(103) - faceTwo.get(103)))/2;
		
		for(int x = 0; x < 68; x++)
		{
			faceTwo.set(x,faceTwo.get(x) - centerX);
		}
		for(int x = 68; x < faceOne.size(); x++)
		{
			
		}
			
		/*
		 * This loop adds the differences of differences for both faces and appends them to a list
		 * called comparedPoints. It takes the opposite of one of the points and adds them together.
		 * Therefore, the closer to 0 the value is, the better the faces at that point match. Need
		 * to add an algorithm to take care of only the points we need and add them to points.
		 * (x,y) values for the base face, for a total of 68 points
		 * As of now, we only care about 15 - 20 (left eyebrow), 21-26 (right eyebrow),
		 * 27-30 (right eye excluding pupil), 32 - 35 (left eye excluding pupil), 48 - 66 (mouth).
		 * The total number of relevant points is 34 as of now. So each point will be weighted with the 
		 * value of 1/34*/
		
		
		/*The following are the X values of landmark points being compared. If the are in the general direction of the moved point, the user will
		 * get points for it :)*/
		for(int x = 14; x <= 19; x++)
		{
			if(faceOne.get(x) > 0 && faceTwo.get(x) > 0)
			{
				points += 1/68;
			}
			else if(faceOne.get(x) < 0 && faceTwo.get(x) < 0)
			{
				points+= 1/68;
			}
		}
		
		for(int x = 20; x <= 25; x++)
		{
			if(faceOne.get(x) > 0 && faceTwo.get(x) > 0)
			{
				points += 1/68;
			}
			else if(faceOne.get(x) < 0 && faceTwo.get(x) < 0)
			{
				points+= 1/68;
			}
		}
		
		for(int x = 26; x <= 29; x++)
		{
			if(faceOne.get(x) > 0 && faceTwo.get(x) > 0)
			{
				points += 1/68;
			}
			else if(faceOne.get(x) < 0 && faceTwo.get(x) < 0)
			{
				points+= 1/68;
			}
		}
		
		for(int x = 31; x <= 34; x++)
		{
			if(faceOne.get(x) > 0 && faceTwo.get(x) > 0)
			{
				points += 1/68;
			}
			else if(faceOne.get(x) < 0 && faceTwo.get(x) < 0)
			{
				points+= 1/68;
			}
		}
		
		for(int x = 48; x <= 66; x++)
		{
			if(faceOne.get(x) > 0 && faceTwo.get(x) > 0)
			{
				points += 1/68;
			}
			else if(faceOne.get(x) < 0 && faceTwo.get(x) < 0)
			{
				points+= 1/68;
			}
		}
		
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		/*The following are the y values of landmark points being compared. If the are in the general direction of the moved point, the user will
		 * get points for it :)*/
		
		int yshift = 67;
		
		for(int x = 14; x +yshift <= 19+yshift; x++)
		{
			if(faceOne.get(x) > 0 && faceTwo.get(x) > 0)
			{
				points += 1/68;
			}
			else if(faceOne.get(x) < 0 && faceTwo.get(x) < 0)
			{
				points+= 1/68;
			}
		}
		
		for(int x = 20+yshift; x <= 25+yshift; x++)
		{
			if(faceOne.get(x) > 0 && faceTwo.get(x) > 0)
			{
				points += 1/68;
			}
			else if(faceOne.get(x) < 0 && faceTwo.get(x) < 0)
			{
				points+= 1/68;
			}
		}
		
		for(int x = 26+yshift; x <= 29+yshift; x++)
		{
			if(faceOne.get(x) > 0 && faceTwo.get(x) > 0)
			{
				points += 1/68;
			}
			else if(faceOne.get(x) < 0 && faceTwo.get(x) < 0)
			{
				points+= 1/68;
			}
		}
		
		for(int x = 31+yshift; x <= 34+yshift; x++)
		{
			if(faceOne.get(x) > 0 && faceTwo.get(x) > 0)
			{
				points += 1/68;
			}
			else if(faceOne.get(x) < 0 && faceTwo.get(x) < 0)
			{
				points+= 1/68;
			}
		}
		
		for(int x = 48+yshift; x <= 66+yshift; x++)
		{
			if(faceOne.get(x) > 0 && faceTwo.get(x) > 0)
			{
				points += 1/68;
			}
			else if(faceOne.get(x) < 0 && faceTwo.get(x) < 0)
			{
				points+= 1/68;
			}
		}
		
		return points;
	}
}
