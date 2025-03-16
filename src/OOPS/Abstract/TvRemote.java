package OOPS.Abstract;

public class TvRemote extends Gg{
    @Override
    void trunOn(){
        System.out.println("Tv is on");
    }

    @Override
    void trunOf() {
        System.out.println("Tv is of");
    }

    public static void main(String[] args) {
        TvRemote tvRemote = new TvRemote();
        tvRemote.trunOn();
        tvRemote.trunOf();
    }
}
