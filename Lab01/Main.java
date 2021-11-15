
public class Main{
    public static void main(String [] args){
        int p=397, q=103, n=p*q, e=3;
        int fi=(p-1)*(q-1);

        System.out.println("n = " +n);
        while(EuclidAlgorithm(e, fi) !=1){
            e+=2;
        }
        System.out.println("e = " + e);
        int d=ExtendedEuclidAlgorithm(e,fi);
        System.out.println("d = " +d);

        int size=args[0].length();
        int []tab =new int[size];
        for(int i=0;i<size;i++){
            tab[i]=args[0].charAt(i);
            tab[i]=PowMod(tab[i],e,n);
        }

        System.out.print("Encoded message = [");
        for(int i=0;i<size-1;i++) System.out.print(tab[i] +", ");
        System.out.println(tab[size-1] +"]");

        StringBuilder answer= new StringBuilder();
        for(int i=0;i<size;i++){
            tab[i]=PowMod(tab[i],d,n);
            answer.append((char) tab[i]);
        }
        System.out.println("Decoded message = " + answer);

    }

    public static int EuclidAlgorithm(int a, int b){
        int temp;
        while(b !=0){
            temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    } 

    public static int ExtendedEuclidAlgorithm(int a, int b){
        int x0=1, x=0, b0=b, q, temp;
        while(b !=0){
            q=Math.abs(a/b);
            temp=x;
            x=x0-q*x;
            x0=temp;
            temp=a%b;
            a=b;
            b=temp;
        }
        if(x0<0) x0=x0+b0;
        return x0;
    }

    public static int PowMod(int x, int y, int p){
        int res=1;
        x=x%p;
        if(x==0) return 0;
        while(y>0){
            if(y%2!=0) res=(res*x)%p;
            y=y/2;
            x=(x*x)%p;
        }
        return res;
    }
}
