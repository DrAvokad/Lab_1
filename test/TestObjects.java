import Abstracts.IDirection;
import Buildings.Workshop;
import Other.Ekollon;
import Vehicles.ICar;
import Vehicles.Saab95;
import Vehicles.Scania;
import Vehicles.Volvo240;
import org.junit.Test;

import java.util.ArrayList;

public class TestObjects {

    @Test
    public void testWorkshopStatic(){
        Workshop workshop = new Workshop<>(0, 0, 8, new ArrayList(8), "Workshoppe");
        workshop.openWorkshop();
        Saab95 saab95 = new Saab95(0, 0 , IDirection.Direction.NORTH);
        workshop.load(saab95);
        Ekollon ekollon = new Ekollon(1, 1);
       // workshop.load(ekollon);
        Scania scania = new Scania(1, 1, IDirection.Direction.NORTH);
       // workshop.load(scania);
        Volvo240 volvo240 = new Volvo240(0, 0, IDirection.Direction.NORTH);
        workshop.load(volvo240);
    }

    


}
