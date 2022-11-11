package ProvaT;
import java.util.Random;

public class Date{
    int dia, mes, ano;
    Random RND = new Random();

    public Date(){
        
        this.dia = RND.nextInt(31 - 1) + 1;
        this.mes = RND.nextInt(12 - 1) + 1;
        this.ano = RND.nextInt(2022 - 1) + 1;
    }
}