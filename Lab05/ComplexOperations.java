public class ComplexOperations {

    public static Complex add(Complex c1, Complex c2) {
        class Adding implements ComplexFunction{
            public Complex calculate(Complex c1, Complex c2){
                return new Complex(c1.getRe()+c2.getRe(), c1.getIm()+c2.getIm());
            }
        }
        Adding add = new Adding();
        return calculate(c1, c2, add);
    }

    public static Complex subtract(Complex c1, Complex c2) {
        ComplexFunction subtract = new ComplexFunction(){
            public Complex calculate(Complex c1, Complex c2){
                return new Complex(c1.getRe()-c2.getRe(), c1.getIm()-c2.getIm());
            }
        };
        return calculate(c1, c2, subtract);
    }

    public static Complex multiply(Complex c1, Complex c2) {
        ComplexFunction multiply = (x, y) -> {
            double re = c1.getRe()*c2.getRe()-c1.getIm()*c2.getIm();
            double im = c1.getRe()*c2.getIm()+c2.getRe()*c1.getIm();
            return new Complex(re, im);
        };
        return calculate(c1, c2, multiply);
    }

    public static Complex divide(Complex c1, Complex c2) {
        class Divide implements ComplexFunction{
            public Complex calculate(Complex c1, Complex c2){
                double m = c2.getRe()*c2.getRe()+c2.getIm()*c2.getIm();
                double re = (c1.getRe()*c2.getRe()+c1.getIm()*c2.getIm())/m;
                double im = (c1.getIm()*c2.getRe()-c1.getRe()*c2.getIm())/m;
                return new Complex(re, im);
            }
        }
        Divide divide = new Divide();
        return calculate(c1, c2, divide);
    }

    private static Complex calculate(Complex c1, Complex c2, ComplexFunction function) {
        return function.calculate(c1, c2);
    }
}
