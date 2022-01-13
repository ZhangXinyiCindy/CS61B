public class NBody {

    public static double readRadius(String s) {
        In in = new In(s);
        double radius = in.readDouble();
        radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String s) {
        In in = new In(s);
        int N = in.readInt();
        double radius = in.readDouble();
        Planet[] Bodies = new Planet[N];

        for (int i = 0; i < N; i = i + 1) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            Bodies[i] = new Planet(xP, yP, xV, yV, m, img);
        }

        return Bodies;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] Bodies = readPlanets(filename);

        /**draw background*/
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        StdDraw.show();

        /**draw planets*/
        for (Planet i : Bodies){
            i.draw();
            }

        int N = Bodies.length;
        StdDraw.enableDoubleBuffering();

        /** Animation */
        for (double t = 0; t < T; t = t + dt) {
            double[] xForces = new double[N];
            double[] yForces = new double[N];

            for (int i = 0; i < N; i = i + 1) {
                xForces[i] = Bodies[i].calcNetForceExertedByX(Bodies);
                yForces[i] = Bodies[i].calcNetForceExertedByY(Bodies);
            }
            for (int i = 0; i < N; i = i + 1) {
                Bodies[i].update(dt,xForces[i],yForces[i]);
            }
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (Planet i : Bodies){
            i.draw();
        }
        StdDraw.show();
        StdDraw.pause(5);
        }

        /** Final State */
        StdOut.printf("%d\n", Bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < Bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    Bodies[i].xxPos, Bodies[i].yyPos, Bodies[i].xxVel,
                    Bodies[i].yyVel, Bodies[i].mass, Bodies[i].imgFileName);
        }

        StdDraw.pause(500);
        StdDraw.clear();


    }

}