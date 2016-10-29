package weikun.fastjson;

/**
 * Created by Administrator on 2016/10/29.
 */
public class User {
    private String name;
    private int old;

    private Address address;

    public User(String name, int old, Address address) {
        this.name = name;
        this.old = old;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
