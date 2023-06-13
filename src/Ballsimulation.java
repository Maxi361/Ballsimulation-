import GLOOP.*;
public class Ballsimulation {
    private GLKamera kamera;
    GLLicht licht;
    GLHimmel himmel;
    GLBoden boden;
    private GLTastatur tastatur;

    private Ball ball;
    private Flummi flummi;
    private Bouncer bouncer;
    private Hindernis[] hindernis;

    public Ballsimulation() {
        kamera = new GLSchwenkkamera(800, 500);
        kamera.setzePosition(0, 500, 2000);
        licht = new GLLicht();
        boden = new GLBoden("src/Boden.jpg");
        himmel = new GLHimmel("src/Himmel.jpg");
        tastatur = new GLTastatur();

        hindernis = new Hindernis[4];
        hindernis[0] = new Hindernis(1000, 200, 0, 50, 400, 1300);
        hindernis[1] = new Hindernis(-1000, 200, 0, 50, 400, 1300);
        hindernis[2] = new Hindernis(0, 400, 0, 2000, 40, 1300);
        hindernis[3] = new Hindernis(0, 0, 0, 2000, 40, 1300);



        ball = new Ball(0, 200, 0, 20);
        ball.werfen(new GLVektor(1, 0, 0));

        flummi = new Flummi(0, 200, 50, 20,);
        flummi.werfen(new GLVektor(20, 0, 0));

        bouncer = new Bouncer(0, 200, 50, 20);
        bouncer.werfen(new GLVektor(5, 5, 0));


        fuehreAus();
    }

    public void fuehreAus() {
        while (!tastatur.esc()) {
            flummi.bewegeDich();
            ball.bewegeDich();
            bouncer.bewegeDich();
            for (int j = 0; j < 4; j++) {
                ball.bearbeiteHindernis(hindernis[j]);
                flummi.bearbeiteHindernis(hindernis[j]);
                bouncer.bearbeiteHindernis(hindernis[j]);

                Sys.warte();
            }
        }
            Sys.beenden();
        }

    }

