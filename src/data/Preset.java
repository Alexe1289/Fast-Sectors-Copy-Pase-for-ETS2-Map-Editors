package data;

import java.util.ArrayList;
import java.util.List;

public class Preset {
    List<String> sectors = null;

    public Preset() {
        this.sectors = new ArrayList<>();
    }

    public void addSector(String sectorName) {
        this.sectors.add(sectorName);
    }
}
