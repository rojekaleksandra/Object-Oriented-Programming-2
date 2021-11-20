import java.util.*;

public class Complex {    
    private final double re;
    private final double im;

    public Complex(){
        this(0.,0.);
    }

    public Complex(double re){
        this(re,0.);
    }

    public Complex(double re, double im){
        this.re=re;
        this.im=im;
    }

    public double getRe(){
        return re;
    }

    public double getIm(){
        return im;
    }

    @Override
    public String toString(){
        if(im ==0) return ""  + re;
        if(re ==0) return im + "i";
        return re + (im>=0 ? " + " : " - ") + Math.abs(im) + "i";
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o==null || o.getClass() != getClass()) return false;
        Complex complex = (Complex) o;
        return re == complex.re && im == complex.im;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.re, this.im);
    }

}