public class Main {
    public static void main(String[] args) {


        double speedmasha=490;
        double speedpetya=speedmasha*0.8;
        double speedvasya=speedmasha*0.5;
        double speedvasya20 = speedmasha;
        double yearplan=1150;
        double kredits=0;
        double dayspeed=(speedmasha+speedpetya+speedvasya)/365;
        double dayspeed20=(speedmasha+speedpetya+speedvasya20)/365;
        boolean done80 =false;

        for (int i = 1; i <=365 ; i++) {

            if(kredits<yearplan*0.8){
                kredits=kredits+dayspeed;
            }
            else if (kredits>=yearplan*0.8){
               if(!done80){
                    System.out.println(i);
                    done80=true;
               }
               kredits=kredits+dayspeed20;

            }
        }
        System.out.println(kredits);








    }
}
