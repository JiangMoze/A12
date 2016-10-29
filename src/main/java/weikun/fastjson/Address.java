package weikun.fastjson;

/**
 * Created by Administrator on 2016/10/29.
 */
public class Address {
    private String jiedao;
    private String no;

    public Address(String jiedao, String no) {
        this.jiedao = jiedao;
        this.no = no;
    }

    public String getJiedao() {
        return jiedao;
    }

    public void setJiedao(String jiedao) {
        this.jiedao = jiedao;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
