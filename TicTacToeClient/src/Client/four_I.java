/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author luc
 */
public class four_I {
    private point Point1;
    private point Point2;
    private point Point3;
    private point Point4;
    private char znak;

    public four_I(point Point1, point Point2, point Point3, point Point4, char znak) {
        this.Point1 = Point1;
        this.Point2 = Point2;
        this.Point3 = Point3;
        this.Point4 = Point4;
        this.znak = znak;
    }

    public void setPoint1(point Point1) {
        this.Point1 = Point1;
    }

    public void setPoint2(point Point2) {
        this.Point2 = Point2;
    }

    public void setPoint3(point Point3) {
        this.Point3 = Point3;
    }

    public void setPoint4(point Point4) {
        this.Point4 = Point4;
    }

    public void setZnak(char znak) {
        this.znak = znak;
    }

    public point getPoint1() {
        return Point1;
    }

    public point getPoint2() {
        return Point2;
    }

    public point getPoint3() {
        return Point3;
    }

    public point getPoint4() {
        return Point4;
    }

    public char getZnak() {
        return znak;
    }
    
}
