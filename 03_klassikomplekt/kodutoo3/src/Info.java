public class Info {
    String nimi;
    int ram;
    String graafikakaart;

    public Info(String nimi, int ram, String graafikakaart) {
        this.nimi = nimi;
        this.ram = ram;
        this.graafikakaart = graafikakaart;
    }
    public void muudaNimetus(String uusNimetus){
        nimi = uusNimetus;
    }
}
