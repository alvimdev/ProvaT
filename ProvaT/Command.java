package ProvaT;

public class Command {
    private String[] consume = new String[0];
    private double bill = 0;

    public double getBill() {
        return bill;
    }

    public void showConsume() {
        for (int i = 0; i < consume.length; i++) {
            System.out.println(consume[i]);
        }
    }

    public void Ordering(String order, double value){
        String[] consumo = new String[consume.length + 1];
        consumo[consumo.length] = order;
        this.consume = consumo;
        this.bill += value;
    }

    public double repartBill(int numP){
        return (bill/(float)numP);
    }

    public double getServiceRate(){
        return ((float)(10/100) * bill);
    }
}
