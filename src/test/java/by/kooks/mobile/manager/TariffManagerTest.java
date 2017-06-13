import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

    public class TariffManagerTest {

        private static MobileOperator mobileOperator;

        @BeforeClass
        public static void initData(){
            List<IndividualPerson> clients = new ArrayList<>();
            List<Company> companies = new ArrayList<>();
            List<AbstractMobileTariff> tariffs = new ArrayList<>();
            clients.add(new IndividualPerson());
            clients.add(new IndividualPerson());
            clients.add(new IndividualPerson());
            companies.add(new Company("BPS-SberBank"));
            companies.add(new Company("BelarusBank"));
            companies.add(new Company("PriorBank"));
            companies.add(new Company("BelAgroPromBank"));

            companies.get(0).setWorkers(clients);
            companies.get(1).setWorkers(clients);
            companies.get(2).setWorkers(clients);
            companies.get(3).setWorkers(clients);
            tariffs.add(new IndividualPersonTariff(TariffType.MIXED,7,3,5,5,500,100,600));
            tariffs.add(new IndividualPersonTariff(TariffType.MORE_TRAFFIC,3,5,5,2,200,50,2048));
            tariffs.add(new IndividualPersonTariff(TariffType.MORE_CALLS,20,1,5,2,240,50,500));
            tariffs.add(new CorporateTariff(TariffType.IN_CORPORATION_FREE,4,2,1,1,1,1,900,companies.get(2).toString()));
            tariffs.add(new CorporateTariff(TariffType.SMALL_BUSINESS,7,3,5,5,500,100,700,companies.get(1).toString()));
            tariffs.add(new CorporateTariff(TariffType.INTERNATIONAL_BUSINESS,2,5,6,2,500,100,12675,companies.get(0).toString()));
            mobileOperator = new MobileOperator(tariffs,clients,companies);
        }
        @AfterClass
        public static void clearData(){
            mobileOperator = null;
        }
        @Test
        public void  calculateClientsTest(){
            TariffManager manager = new TariffManager(mobileOperator);
            Assert.assertEquals(15,manager.calculateClients());
        }

        @Test
        public void sortTariffsTest(){
            List<AbstractMobileTariff> unsortedTariffs = new ArrayList<>(mobileOperator.getTariffs());
            TariffManager manager = new TariffManager(mobileOperator);
            CallsLowestPriceComparator callsLowestPrice = new CallsLowestPriceComparator();
            TrafficLowestPriceComparator trafficLowestPrice = new TrafficLowestPriceComparator();
            SubscriptionLowestPriceComparator connectionLowestPrice = new SubscriptionLowestPriceComparator();
            manager.sortTariffs(trafficLowestPrice,callsLowestPrice,connectionLowestPrice);
            Assert.assertNotEquals(unsortedTariffs,manager.getMobileOperator().getTariffs());
        }
    }

