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
<<<<<<< HEAD

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

=======
		reset();
	}

	float playerX, playerY;
	float playerSpeed = 5;
	float playerWidth = 40;
	float halfPlayerWidth = playerWidth / 2;

	float bugX, bugY, bugWidth = 100;
	float halfBugWidth = bugWidth / 2;

	int score = 0;

	void reset() {
		resetBug();
		playerX = width / 2;
		playerY = height - 50;
	}

	void resetBug() {
		bugX = random(halfBugWidth, width - halfBugWidth);
		bugY = 50;
	}

	void drawBug(float x, float y) {
		// Draw the bug
		stroke(255);
		float saucerHeight = bugWidth * 0.7f;
		line(x, y - saucerHeight, x - halfBugWidth, y);
		line(x, y - saucerHeight, x + halfBugWidth, y);
		// line(x - halfBugWidth, y, x - halfBugWidth, y);
		line(x - halfBugWidth, y, x + halfBugWidth, y);
		float feet = bugWidth * 0.1f;
		line(x - feet, y, x - halfBugWidth, y + halfBugWidth);
		line(x + feet, y, x + halfBugWidth, y + halfBugWidth);

		feet = bugWidth * 0.3f;
		line(x - feet, y, x - halfBugWidth, y + halfBugWidth);
		line(x + feet, y, x + halfBugWidth, y + halfBugWidth);

		float eyes = bugWidth * 0.1f;
		line(x - eyes, y - eyes, x - eyes, y - eyes * 2f);
		line(x + eyes, y - eyes, x + eyes, y - eyes * 2f);

	}

	void drawPlayer(float x, float y, float w) {
		stroke(255);
		float playerHeight = w / 2;
		line(x - halfPlayerWidth, y + playerHeight, x + halfPlayerWidth, y + playerHeight);
		line(x - halfPlayerWidth, y + playerHeight, x - halfPlayerWidth, y + playerHeight * 0.5f);
		line(x + halfPlayerWidth, y + playerHeight, x + halfPlayerWidth, y + playerHeight * 0.5f);

		line(x - halfPlayerWidth, y + playerHeight * 0.5f, x - (halfPlayerWidth * 0.8f), y + playerHeight * 0.3f);
		line(x + halfPlayerWidth, y + playerHeight * 0.5f, x + (halfPlayerWidth * 0.8f), y + playerHeight * 0.3f);

		line(x - (halfPlayerWidth * 0.8f), y + playerHeight * 0.3f, x + (halfPlayerWidth * 0.8f),
				y + playerHeight * 0.3f);

		line(x, y, x, y + playerHeight * 0.3f);

	}

	public void keyPressed() {
		
		if (keyCode == LEFT) {
			if (playerX > halfPlayerWidth) {
				playerX -= playerSpeed;
			}
		}
		if (keyCode == RIGHT) {
			if (playerX < width - halfPlayerWidth) {
				playerX += playerSpeed;
			}
>>>>>>> 14c4d0f8aeb8b663ad2736610875865c79c6b4e1
		}
		if (keyCode == ' ')
		{
<<<<<<< HEAD
			System.out.println("SPACE key pressed");
			stroke(253, 253, 150);
			line(playerX + playerWidth/2, 750, playerX + playerWidth/2 , 50);
			
=======
			if (playerX > bugX - halfBugWidth && playerX < bugX + halfBugWidth)
			{
				line(playerX, playerY, playerX, bugY);
				score ++;
				resetBug();
			}
			else
			{
				line(playerX, playerY, playerX, 0);
			}
		}
	}

	void moveBug() {
		if ((frameCount % 30) == 0) {
			bugX += random(-5, 5);
			if (bugX < halfBugWidth) {
				bugX = halfBugWidth;
			}
			if (bugX > width - halfBugWidth) {
				bugX = width - halfBugWidth;
			}
			bugY += 2;
>>>>>>> 14c4d0f8aeb8b663ad2736610875865c79c6b4e1
		}
	}

	int gameMode = 0;

<<<<<<< HEAD
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
=======
	public void draw() {
		background(0);
		fill(255);
		text("Score: " + score, 50, 100);
		if (gameMode == 0)
		{
			fill(255);
			drawPlayer(playerX, playerY, playerWidth);
			drawBug(bugX, bugY);
			moveBug();

			text("Score: " + score, 20, 20);
		}
		else
		{
			textAlign(CENTER, CENTER);
			text("GAME OVER!!!", width / 2, height / 2);
		}

		if (bugY > height - 50)
		{
			gameMode = 1;
		}

>>>>>>> 14c4d0f8aeb8b663ad2736610875865c79c6b4e1
	}
}
