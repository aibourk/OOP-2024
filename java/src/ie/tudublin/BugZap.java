package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet {
	float playerX;
	float playerY;
	float playerWidth;

	float bugX;
	float bugY;
	float bugWidth;

	int score;

	public void settings() {
		size(800, 800);
	}

	public void setup() {

		playerX = 400f;
		playerY = 750.0f;
		playerWidth = 30.0f;
		
		bugX = 400;
		bugY = 50f;
		bugWidth = 20f;
	}
	

	void drawPlayer(float x, float y, float w)
	{
		background(32, 42, 68);
		stroke(255, 209, 220);
		fill(255, 209, 220);
		rect(x, y, w, 20);
		rect(x+w/3, y-10, 10, 10);
	}

	void drawBug(float x, float y, float w)
	{
		stroke(167, 199, 231);
		fill(167, 199, 231);
		ellipse(x, y, w, 15);
		stroke(0, 0, 0);
		line(x-5, y+3, x+5, y+3);
		ellipse(x-3, y-3, 2, 2);
		ellipse(x+3, y-3, 2, 2);
	}

	public void keyPressed()
	{
		if (keyCode == LEFT)
		{
			System.out.println("Left arrow pressed");
			if (playerX > 0) 
			{
				playerX = playerX - 15;
			}
		}
		if (keyCode == RIGHT)
		{
			System.out.println("Right arrow pressed");
			if (playerX + playerWidth < 800) 
			{
				playerX = playerX + 15;
			}

		}
		if (key == ' ')
		{
			System.out.println("SPACE key pressed");
			stroke(253, 253, 150);
			line(playerX + playerWidth/2, 750, playerX + playerWidth/2 , 50);
			
		}
	}

	int gameMode = 0;

	public void draw() 
	{
		textSize(32);
		fill(255,255,255);
		text("Score: " + score, 100, 100);
		

		drawPlayer(playerX, playerY, playerWidth);
		drawBug(bugX, bugY, bugWidth);

		if ((frameCount % 60) == 0)
		{
			if(bugX < bugWidth + 30)
			{
				bugX += random(150);
			}
			else if(bugX + 30 > 800)
			{
				bugX -= random(-150);
			}
			else
			{
				bugX += random(-100,100);
				bugY += random(25);
			}
			
			// if((playerX + playerWidth/2 <= bugX) && (playerX + playerWidth/2 >= bugX + bugWidth))
			if((bugX >= playerX + playerWidth/2) && (bugX <= playerX + playerWidth))
			{
				score += 1;
			}
			
		}
	}
}
