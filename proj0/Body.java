public class Body{
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;

    Body bc;

    public Body(double xP, double yP, double xV, double yV, double m, String img){
	xxPos = xP;
	yyPos = yP;
	xxVel = xV;
	yyVel = yV;
	mass  = m;
	imgFileName = img;

    }

    public Body(Body b){
	xxPos = b.xxPos;
	yyPos = b.yyPos;
	xxVel = b.xxVel;
	yyVel = b.yyVel;
	mass  = b.mass;
	imgFileName = b.imgFileName;
    }

    public double calcDistance(Body m){
		double distanceX = this.xxPos - m.xxPos;
		double distanceY = this.yyPos - m.yyPos;
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
	}

    public double calcForceExertedBy(Body m){
	    final double constantG = 6.67e-11;
	    double distanceR = this.calcDistance(m);

	    return (constantG * this.mass * m.mass)/(distanceR * distanceR);

	}

  public double calcForceExertedByX(Body m){
	   double deltaX =  m.xxPos - this.xxPos;

	   return  deltaX * this.calcForceExertedBy(m)/this.calcDistance(m);

  }

  public double calcForceExertedByY(Body m){
	   double deltaY =  m.yyPos - this.yyPos;

	   return  deltaY * this.calcForceExertedBy(m)/this.calcDistance(m);
  }

  public boolean equals(Body m){
	    if ((this.xxPos == m.xxPos) && (this.yyPos == m.yyPos) &&
	        (this.xxVel == m.xxVel )   && (this.yyVel == m.yyVel)  &&
	        (this.mass == m.mass)    && (this.imgFileName == m.imgFileName))
	        return true;
	    else
	        return false;
  }

  public double calcNetForceExertedByX(Body[] m){
      double xxNetForceSum = 0;
      int i;

      for (i = 0; i < m.length; i++){
          if ( this.equals(m[i])){
               continue;
	      }
          else{
			    xxNetForceSum += this.calcForceExertedByX(m[i]);
		  }

	  }

     return xxNetForceSum;

  }


  public double calcNetForceExertedByY(Body[] m){
       double yyNetForceSum = 0;
       int i;

       for (i = 0; i < m.length; i++){
           if ( this.equals(m[i])){
                continue;
 	      }
           else{
 			    yyNetForceSum += this.calcForceExertedByY(m[i]);
 		  }

 	  }

      return yyNetForceSum;

   }

   public void update(double dt, double fX, double fY){
	    double anetX = fX/this.mass;
	    double anetY = fY/this.mass;

	    xxVel = xxVel + anetX * dt;
	    yyVel = yyVel + anetY * dt;

	    xxPos = xxPos + xxVel * dt;
	    yyPos = yyPos + yyVel * dt;

	}

   public void draw(){

	    StdDraw.enableDoubleBuffering();
	    String FileName = "images/" + this.imgFileName;

	//   	StdDraw.clear();
		StdDraw.picture(this.xxPos, this.yyPos, FileName);
		StdDraw.show();

   //     StdDraw.pause(2000);

	   }

}
