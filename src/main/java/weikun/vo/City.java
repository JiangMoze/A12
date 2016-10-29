package weikun.vo;

/**
 * Created by Administrator on 2016/10/29.
 */
public class City {
    private String name;
    private String vol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City(String name, String vol) {
        this.name = name;
        this.vol = vol;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }
}
