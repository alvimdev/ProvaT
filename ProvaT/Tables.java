package ProvaT;

public class Tables {
    private int nTable;
    public Date[] date = new Date[0];
    private float dividedBill;
    public Drink comandaB;
    public Food comandaC;

    public Tables(int nm){
        this.dividedBill = 00;
        this.nTable = nm;
        this.comandaB = new Drink();
        this.comandaC = new Food();
    }

    public int getnTable() {
        return nTable;
    }

    public void addDate(){
        Date data = new Date();
        Date[] dat = new Date[date.length + 1];
        int l = 0;
        for (Date date2 : date) {
            dat[l] = date2;
            l++;
        }
        dat[l] = data;
        this.date = dat;
    }

    public Date getDate(int pos) {
        return date[pos];
    }

    public void verifyReserve(Date data, int j){
        if (this.date[j].equals(data)){
            this.date[j].printData();
            System.out.print(" -- ");
            if (this.date[j].getReserve()){
                System.out.println("Mesa reservada.");
            } else {
                System.out.println("Mesa livre.");
            }
        }
    }

    public void showConsume(){
        comandaB.showConsume();
        comandaC.showConsume();
    }

    public float getDividedBill() {
        return dividedBill;
    }

    public void repartBill(int numP){
        dividedBill = ((comandaB.repartBill(numP)) + (comandaC.repartBill(numP)));
    }

    public float getServiceRate(){
        float rate = comandaB.getBill() + comandaC.getBill();
        return rate/(float)10;
    }
}
