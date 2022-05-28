package car;

import Helper.XFile;
import java.io.File;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ListCar {

    ArrayList<Car> list = new ArrayList<>();
    private String path = "listCar.dat";

    public void add(Car car) {
        list.add(car);
    }

    public Car findById(String id) {
        for (Car car : list) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    public void deleteById(String id) {
        for (Car car : list) {
            if (car.getId().equals(id)) {
                list.remove(car);
            }
        }
    }

    public boolean replace(String id, Car car) {
        int i=0;
        for (Car cars : list) {
            if (cars.getId().equals(id)) {
                list.set(i, car);
                return true;
            }
            i++;
        }
        return false;
    }
    
    public void print(){
        for (Car car : list) {
            System.out.println(car);
        }
    }

    public void loadFile() throws Exception {
        File file = new File(path);
        if (file.exists()) {
            list = (ArrayList<Car>) XFile.readFile(path);
        }
    }

    public void writeToFile() throws Exception {
        XFile.writeFile(path, list);
    }

    public void renderToTable(DefaultTableModel table) {
        table.setRowCount(0);

        int i = 1;
        for (Car car : list) {
            Object[] row = new Object[]{
                i, car.getId(), car.getName(), car.getBrand(), car.getYear(), car.getAmount(), car.getCost(), " "
            };
            table.addRow(row);
            i++;
        }
        table.fireTableStructureChanged();
    }
}
