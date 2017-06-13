import java.util.ArrayList;
import java.util.List;

public class MobileOperator {

    private ArrayList<AbstractMobileTariff> tariffs = new ArrayList<>();
    private ArrayList<IndividualPerson> clients = new ArrayList<>();
    private ArrayList<Company> companies = new ArrayList<>();

    public MobileOperator(List<AbstractMobileTariff> tariffs, List<IndividualPerson> clients, List<Company> companies) {
        this.tariffs = new ArrayList<>(tariffs);
        this.clients = new ArrayList<>(clients);
        this.companies = new ArrayList<>(companies);
    }
    public MobileOperator(){}

    public List<AbstractMobileTariff> getTariffs() {
        return tariffs;
    }

    public List<IndividualPerson> getClients() {
        return clients;
    }

    public List<Company> getCompanies() {
        return companies;
    }
    public void addTariff(AbstractMobileTariff tariff){
        tariffs.add(tariff);
    }

    public void removeTariff(AbstractMobileTariff tariff) {
        tariffs.remove(tariff);
    }

    public ArrayList<AbstractMobileTariff> getAllTariffs(){
        return tariffs;
    }

}
