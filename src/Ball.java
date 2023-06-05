import GLOOP.*;
public class Ball{    
    private GLKugel kugel;    
    private GLVektor bewegung;
    private double radius;

    public Ball(double pX, double pY, double pZ, double pRadius){
        kugel    = new GLKugel(pX,pY,pZ, 20);
        bewegung = new GLVektor(0,0,0);
        radius   = pRadius;
    }

    public void bewegeDich(){
        kugel.verschiebe(bewegung);
    }

    public void bearbeiteHindernis(Hindernis pH){
        double dX = Math.abs(kugel.gibX() - pH.gibPosition().x);
        double dY = Math.abs(kugel.gibY() - pH.gibPosition().y);
        double dZ = Math.abs(kugel.gibZ() - pH.gibPosition().z);

        double b = pH.gibBreite();
        double h = pH.gibHoehe();
        double t = pH.gibTiefe();  

        if((dX < b/2+radius/2)&&(dY < h/2 +radius/2)&&(dZ < t/2 +radius/2)){
            if (2*dX/b> 2*dY/h && 2*dX/b>2*dZ/t)
                bewegung.x = - bewegung.x;
            if (2*dY/h>2*dX/b && 2*dY/h>2*dZ/t)
                bewegung.y = - bewegung.y;
            if (2*dZ>2*dX/b && 2*dZ/t>2*dY/h) 
                bewegung.z = - bewegung.z;
        }     
    }

    public void werfen(GLVektor pI){ 
        bewegung.addiere(pI); 
    } 

}
