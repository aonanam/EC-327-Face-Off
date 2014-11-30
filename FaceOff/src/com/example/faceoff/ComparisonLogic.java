package com.example.faceoff;

import java.util.ArrayList;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class ComparisonLogic 
{
	/*
	 * (x,y) values for the base face, for a total of 68 points
	 * As of now, we only care about 15 - 20 (left eyebrow), 21-26 (right eyebrow),
	 * 27-30 (right eye excluding pupil), 32 - 35 (left eye excluding pupil), 48 - 66 (mouth).
	 * */
	
	public double []  VsBaseFace(profile p, HttpResponse<JsonNode> picture) //Params = profile name/num, picture
	{
		double [] diffFromBase = {}; //Format will be: all x then all y
		
		//logic for extracting x y coordinates from the picture here, should probably make a function
		
		/*
		 * Comparison logic here.
		 * This function will calculate the differences between the baseface and the new face
		 * that the user just took, using the pupils and nose as a center
		 */
		
		return diffFromBase;
	}

	public double FaceVsFace(double [] picOne, double [] picTwo)
	{
		double points = 0;
		
		if(picOne.length == picTwo.length)
		{
			int length = picOne.length;
			
			for(int x = 0; x < length; x++)
			{
				if(picOne[x] < 0 && picTwo[x] < 0)
				{
					/*
					 * Add points for moving facial features in the same general 
					 * direction. Will put more if statements inside to check for more
					 * meticulous things
					 */
				}
				
				if(picOne[x] > 0 && picTwo[x] > 0)
				{
					/*
					 * Add points for moving facial features in the same general 
					 * direction. Will put more if statements inside to check for more
					 * meticulous things
					 */
				}
				else
				{
					/*
					 * If the faces do not move things in the same general direction, do stuff here
					 */
				}
			}
		}
		
		return points;
	}
}
