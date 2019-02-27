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


    // Just a single image, TODO: Generalize
    // To keep track of a singel cars position
    List <Point> points = new ArrayList<>();
    List <String> imageList = new ArrayList<>();

    // TODO: Make this genereal for all cars
    void moveit(ArrayList<Point> points, ArrayList<String> imageList){
      this.points = points;
      this.imageList = imageList;

    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
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



    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(imageList, points, null); // see javadoc for more info on the parameters

        for (int i = 0; i < imageList.size(); i++ ){

            if (imageList.get(i).equals("Saab95")) {

                g.drawImage(saabImage, points.get(i).x, points.get(i).y, null);
            }

            else if (imageList.get(i).equals("Volvo240")){
                g.drawImage(volvoImage, points.get(i).x, points.get(i).y, null);
            }

            else{
                g.drawImage(ScaniaImage, points.get(i).x, points.get(i).y, null);
            }
        }
    }

    @Override
    public void actOnUpdate() {

        moveit(points, imageList);
    }
}
