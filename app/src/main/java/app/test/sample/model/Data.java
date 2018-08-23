package app.test.sample.model;


public class Data {

    private int image;
    private String name;

    public Data(String name, int image) {
        this.name = name;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

}
