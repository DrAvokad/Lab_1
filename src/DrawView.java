import Vehicles.IMotorvehicles;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DrawView extends JFrame implements IActionListner{

    CarPanel cPanel;

    public DrawView(CarModel carModel, String title, int x, int y){
        this.cPanel = new CarPanel(carModel, x, y);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(cPanel);
        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setVisible(true);
        this.setTitle(title);
    }

    public class CarPanel extends JPanel{

        BufferedImage volvoImage;
        BufferedImage saabImage;
        BufferedImage ScaniaImage;

        private CarModel cModel;

        // Just a single image, TODO: Generalize
        // To keep track of a singel cars position
        java.util.List<Point> positions = new ArrayList<>();
        List<String> vehicles = new ArrayList<>();

        // TODO: Make this genereal for all cars
        void getPositions(){
            if(positions.size() > 0){
                positions.clear();
            }
            for (IMotorvehicles m : cModel.cars){
                Point carPosition = new Point((int)Math.round(m.getX()), (int)Math.round(m.getY()));
                positions.add(carPosition);
            }
        }

        // Initializes the panel and reads the images
        public CarPanel(CarModel model, int x, int y) {
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

    }

    @Override
    public void actOnUpdate() {

        cPanel.updateVehicles();
        cPanel.getPositions();
        repaint();
    }
}
