public class NBody{

public static void main (String[] args){
    double T = Double.parseDouble(args[0]);
    double dt = Double.parseDouble(args[1]);
    String filename = args[2];
    String imageToDraw = "images/starfield.jpg";
    int i;
    double timer = 0;

    double radius = NBody.readRadius(filename);
    Body[] bodies = NBody.readBodies(filename);

    int bodyCount = bodies.length;
    double[] xForces = new double[bodyCount];
    double[] yForces = new double[bodyCount];

    StdDraw.enableDoubleBuffering();
    StdDraw.setScale(-2*radius, 2*radius);

    while (timer < T){
		for (i = 0; i < bodies.length; i++){
			xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
			yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
			bodies[i].update(dt, xForces[i], yForces[i]);
			}

		//StdDraw.enableDoubleBuffering();

			/** Sets up the universe so it goes from
			* -100, -100 up to 100, 100 */
	    //StdDraw.setScale(-radius, radius);

			/* Clears the drawing window. */
		StdDraw.clear();

			/* Stamps three copies of advice.png in a triangular pattern. */
        StdDraw.picture(0, 0.75*radius, imageToDraw);

        for (i = 0; i < bodies.length; i++){
			bodies[i].draw();
		    }

		StdDraw.show();
		StdDraw.pause(10);

		timer += dt;
		}

	StdOut.printf("%d\n", bodies.length);
	StdOut.printf("%.2e\n", radius);

	for (i = 0; i < bodies.length; i++){
		StdOut.printf("%11.4e %11.4e %11.4e %11.4e  %12s\n",
		bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel, bodies[i].yyVel, bodies[i].imgFileName);

		}

    //StdDraw.enableDoubleBuffering();

	/** Sets up the universe so it goes from
	* -100, -100 up to 100, 100 */
	//StdDraw.setScale(-radius, radius);

	/* Clears the drawing window. */
	//StdDraw.clear();

	/* Stamps three copies of advice.png in a triangular pattern. */
   //StdDraw.picture(0, 0.75*radius, imageToDraw);

	/* Shows the drawing to the screen, and waits 2000 milliseconds. *
	StdDraw.show();
//	StdDraw.pause(8000);

	for (i = 0; i < bodies.length; i++){
		bodies[i].draw();

		}
    */
	}

public static double readRadius(String fileName){
	In in = new In(fileName);

	int firstItemInFile = in.readInt();
	double secondItemInFile = in.readDouble();

	return secondItemInFile;
    }

public static Body[] readBodies(String FileName){
	In in = new In(FileName);
	Body[] array = new Body[5];
	int i = 0;
	    double xPos;
	    double yPos;
	    double xVel;
	    double yVel;
	    double mas;
    String imgFileName;

	int firstItemInFile = in.readInt();
	double secondItemInFile = in.readDouble();
    System.out.println("first:" + firstItemInFile);
    System.out.println("second:" + secondItemInFile);

	while(i < 5) {
       /*
		array[i].xxPos = in.readDouble();
		array[i].yyPos = in.readDouble();
		array[i].xxVel = in.readDouble();
		array[i].yyVel = in.readDouble();
		array[i].mass = in.readDouble();
		array[i].imgFileName = in.readString();
		*/
		System.out.println("Begin to read array: ");
		xPos = in.readDouble();
		System.out.println("xxPos: " + xPos);
		yPos = in.readDouble();
		xVel = in.readDouble();
		yVel = in.readDouble();
		mas = in.readDouble();
		imgFileName = in.readString();


        array[i] = new Body(xPos, yPos, xVel, yVel, mas, imgFileName );

		i++;
	}

    return array;
}

}