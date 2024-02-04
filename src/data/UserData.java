package data;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    Preset preset1;
    Preset preset2;
    String pathToFile;

    public UserData(String pathToFile) {
        this.pathToFile = pathToFile;
        this.preset1 = new Preset();
        this.preset2 = new Preset();
    }

    public Preset getPreset1() {
        return preset1;
    }

    public Preset getPreset2() {
        return preset2;
    }

    public String getPathToFile() {
        return pathToFile;
    }
}
