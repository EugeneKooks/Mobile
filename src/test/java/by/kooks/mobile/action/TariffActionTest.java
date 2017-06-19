package by.kooks.mobile.action;

import by.kooks.mobile.comparator.CallsLowestPriceComparator;
import by.kooks.mobile.comparator.TrafficLowestPriceComparator;
import by.kooks.mobile.entity.*;
import com.sun.media.sound.InvalidDataException;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

    public class TariffActionTest {

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
            TariffAction manager = new TariffAction(mobileOperator);
            Assert.assertEquals(15,manager.calculateClients());
        }
        @Rule
        public ExpectedException thrown = ExpectedException.none();
        @Test
        public void searchOptimalTariffNegative() throws InvalidDataException {
            TariffAction manager = new TariffAction(mobileOperator);
            thrown.expect(InvalidDataException.class);
            thrown.expectMessage("Company doesn't have a tariff with such parameters");
            manager.searchOptimalTariff(0,0);
        }
        @Test
        public void sortTariffsTest(){
            List<AbstractMobileTariff> unsortedTariffs = new ArrayList<>(mobileOperator.getAllTariffs());
            TariffAction manager = new TariffAction(mobileOperator);
            CallsLowestPriceComparator callsLowestPrice = new CallsLowestPriceComparator();
            TrafficLowestPriceComparator trafficLowestPrice = new TrafficLowestPriceComparator();
            manager.sortTariffs(callsLowestPrice,trafficLowestPrice);
            System.out.println(mobileOperator.getAllTariffs().toString());

            Assert.assertNotEquals(unsortedTariffs,manager.getMobileOperator().getAllTariffs());
        }
    }

