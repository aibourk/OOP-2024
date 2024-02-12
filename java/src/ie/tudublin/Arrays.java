package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet
{
	String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
	float[] rainfall = {200, 260, 300, 150, 180, 50, 10, 40, 67, 160, 400, 420};

	public void settings()
	{
		size(500, 500);

		String[] m1 = months;
		months[0] = "XXX";
		print(m1[0]);
		for(int i = 0; i < months.length; i++)
		{
			println("Month: " + months[i] + "\t" + rainfall[i]);
		}

		for(String s : m1)
		{
			println(s);
		}


		int minIndex = 0;
		int maxIndex = 0;
		for(int i = 0; i < rainfall.length; i++)
		{
			if (rainfall[i] < rainfall[minIndex])
			{
				minIndex = i;
			}

			if (rainfall[i] > rainfall[minIndex])
			{
				maxIndex = i;
			}
		}

		println("The month with the minimum rainfall was " + months[minIndex] + "with " + rainfall[minIndex] + "rain");
		println("The month with the maximum rainfall was " + months[maxIndex] + "with " + rainfall[maxIndex] + "rain");



	}

	public void setup() {
		colorMode(HSB);
		background(0);

		
		
	}

	
	public void draw()
	{	
	}
}
