import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private List<IndividualPerson> workers;

    public Company(String name) {
        this.name = name;
        this.workers = new ArrayList<>();
    }

    public List<IndividualPerson> getWorkers() {
        return workers;
    }

    public void setWorkers(List<IndividualPerson> workers) {
        this.workers = workers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company that = (Company) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return workers != null ? workers.equals(that.workers) : that.workers == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (workers != null ? workers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Company: %s", name);
    }
}
