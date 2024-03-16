package data;

public class PathIO {
    private String pathName;

    public PathIO() {
        this.pathName = null;
    }

    public PathIO(String pathName) {
        this.pathName = pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public String getPathName() {
        return pathName;
    }
}
