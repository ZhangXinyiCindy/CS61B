public class Planet {
    public static double G = 6.67e-11;


    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV,
                double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet b){
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance (Planet b){
        double distance;
        distance = Math.sqrt((this.xxPos-b.xxPos)*(this.xxPos-b.xxPos)+(this.yyPos-b.yyPos)*(this.yyPos-b.yyPos));
        return distance;
    }

    public double calcForceExertedBy(Planet b){
        double force;
        force = G * this.mass * b.mass / (calcDistance(b)*calcDistance(b));
        return force;
    }

    public double calcForceExertedByX(Planet b){
        double force;
        force = calcForceExertedBy(b) * (b.xxPos-(this.xxPos))/calcDistance(b);
        return force;
    }

    public double calcForceExertedByY(Planet b){
        double force;
        force = calcForceExertedBy(b) * (b.yyPos-(this.yyPos))/calcDistance(b);
        return force;
    }

    public double calcNetForceExertedByX(Planet[] allBodys){
        double Netx=0;
        for (Planet i : allBodys){
            if (this.equals(i) != true){
                Netx = Netx + calcForceExertedByX(i);
            }
        }
        return Netx;
    }

    public double calcNetForceExertedByY(Planet[] allBodys){
        double Nety=0;
        for (Planet i : allBodys){
            if (this.equals(i) != true){
                Nety = Nety + calcForceExertedByY(i);
            }
        }
        return Nety;
    }

    public void update(double dt, double fX, double fY){
        double aX = fX /this.mass;
        double aY = fY /this.mass;
        this.xxVel = this.xxVel + dt * aX;
        this.yyVel = this.yyVel + dt * aY;
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + imgFileName);
        StdDraw.show();
    }
}
