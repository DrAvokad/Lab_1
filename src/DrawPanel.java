import Vehicles.IMotorvehicles;
import Vehicles.Scania;

import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements IActionListner{

    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage ScaniaImage;

    private CarModel cModel;

    // Just a single image, TODO: Generalize
    // To keep track of a singel cars position
    List <Point> positions = new ArrayList<>();
    List <String> vehicles = new ArrayList<>();

    // TODO: Make this genereal for all cars
    void getPositions(){
        if(positions.size() > 0){
            positions.clear();
        }
        for (IMotorvehicles m : cModel.cars){
          Point carPosition = new Point((int)Math.round(m.getX()), (int)Math.round(m.getY()));
      }
    }

    // Initializes the panel and reads the images
    public DrawPanel(CarModel model, int x, int y) {
        cModel = model;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            saabImage= ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            ScaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        for(IMotorvehicles m : cModel.cars){
            vehicles.add(m.getClass().getSimpleName());
            positions.add(new Point((int) m.getX(),(int) m.getY()));
        }
        setVisible(true);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(imageList, points, null); // see javadoc for more info on the parameters

        for (int i = 0; i < vehicles.size(); i++ ){

            if (vehicles.get(i).equals("Saab95")) {

                g.drawImage(saabImage, positions.get(i).x, positions.get(i).y, null);
            }

            else if (vehicles.get(i).equals("Volvo240")){
                g.drawImage(volvoImage, positions.get(i).x, positions.get(i).y, null);
            }

            else{
                g.drawImage(ScaniaImage, positions.get(i).x, positions.get(i).y, null);
            }
        }
    }


    /*
    @Override
    public void paint(Graphics g){
        for (int i = 0; i < vehicles.size(); i++ ){

            if (vehicles.get(i).equals("Saab95")) {

                g.drawImage(saabImage, positions.get(i).x, positions.get(i).y, null);
            }

            else if (vehicles.get(i).equals("Volvo240")){
                g.drawImage(volvoImage, positions.get(i).x, positions.get(i).y, null);
            }

            else{
                g.drawImage(ScaniaImage, positions.get(i).x, positions.get(i).y, null);
            }
        }
    }

*/
    private void updateVehicles(){
        vehicles.clear();
        for (IMotorvehicles m : cModel.cars){
            vehicles.add(m.getClass().getSimpleName());
        }
    }

    @Override
    public void actOnUpdate() {

        getPositions();
        repaint();
    }
}
