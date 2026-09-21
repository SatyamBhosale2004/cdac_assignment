package A6th;
import common.ConsoleInput;

public class InterfaceAssign{
    public static void main(String args[]){
        // q1();
        // q2();
        q3();
    }



    public static void q1(){
        EquilateralTriangle t = new EquilateralTriangle(2);
        Square s = new Square(10);
        System.out.println("EQUI Triangle no of sides " +t.getNumSide());
        System.out.println("EQUI Trinagle side length " +t.getSideLength());
        System.out.println("Square no of sides " +s.getNumSide());
        System.out.println("Square side length " +s.getSideLength());
    }

    public static void q2(){
        RegularPolygon shape[] = new RegularPolygon[2];
        shape[0] = new EquilateralTriangle();
        shape[1] = new Square();

        int total = RegularPolygon.totalSides(shape);

        System.out.println("Total sides are " +total);
    }

    public static void q3(){
        RegularPolygon shape[] = new RegularPolygon[2];
        shape[0] = new EquilateralTriangle(3);
        shape[1] = new Square(2);
        System.out.println("Perimeter of triangle is : " + shape[0].getPerimeter());
        System.out.println("Perimeter of square is : " + shape[1].getPerimeter());
        System.out.println("Interior angle of triangle is : " + shape[0].getInteriorAngle());
        System.out.println("Interior angle of square is : " + shape[1].getInteriorAngle());
    }
        

}


interface RegularPolygon{
    int getNumSide();
    int getSideLength();

    public static int totalSides(RegularPolygon[] polygons){
        int sum =0 ;
        for(RegularPolygon shape : polygons)
            sum += shape.getNumSide();
        return sum;
    }

    default int getPerimeter(){
        return getNumSide() * getSideLength();
    }

    default double getInteriorAngle(){
        double result = ((getNumSide() - 2) * 3.14) / getNumSide() ;
        return result;
    }


}


class EquilateralTriangle implements RegularPolygon {
    private int length;
    @Override public int getNumSide(){
        return 3;
    }

    @Override public int getSideLength(){
        return length;
    }
    EquilateralTriangle(){};
    EquilateralTriangle(int l){
        length = l;
    }
}


class Square implements RegularPolygon {
    private int side;
    @Override public int getNumSide(){
        return 4;
    }

    @Override public int getSideLength(){
        return side;
    }
    Square(){};
    Square(int s){
        side = s;
    }
}



