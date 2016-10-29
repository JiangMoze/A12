package weikun.fastjson;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/29.
 */
public class A {
    //junit
    @Test
    public void array2json(){
        String [] arr={"A","B","C"};
        System.out.print(JSON.toJSONString(arr,true));

    }
    @Test
    public void array2json1(){
        User [] arr={
                new User("MIKE",10,new Address("哈理工","10")),
                new User("ROSE",11,new Address("哈理工","11")),
                new User("JACK",12,new Address("哈理工","12"))
        };
        System.out.print(JSON.toJSONString(arr,true));
    }

    @Test
    public void json2array(){
        //["","",""]
        String jsonText = "[ " +
                "{\"name\":\"bill\",\"old\":\"10\",\"age\":\"20\"}," +
                "{\"name\":\"jack\",\"old\":\"20\",\"age\":\"30\"}" +
                "]";

        System.out.print(JSON.parseArray(jsonText));

    }
    @Test
    public void list2json(){
        List list=new ArrayList();

        list.add( new User("MIKE",10,new Address("哈理工","10")));
        list.add(new User("ROSE",11,new Address("哈理工","11")));
        list.add(new User("Joe",13,new Address("哈理工","13")));


        System.out.print(JSON.toJSONString(list,false));


    }

    @Test
    public void maplist2Json() {
        Map<String, List<User>> map = new HashMap<String, List<User>>();

        List list=new ArrayList();

        list.add(new User("MIKE",10,new Address("哈理工","10")));
        list.add(new User("ROSE",11,new Address("哈理工","11")));
        list.add(new User("Joe",13,new Address("哈理工","13")));

        map.put("user1", list);


        List list2=new ArrayList();

        list2.add( new User("MIKE1",10,new Address("哈理工1","12")));
        list2.add(new User("ROSE1",11,new Address("哈理工1","13")));
        list2.add(new User("Joe1",13,new Address("哈理工1","14")));



        map.put("user2",list2);

        List list3=new ArrayList();

        list3.add( new User("MIKE2",16,new Address("哈理工2","12")));
        list3.add(new User("ROSE2",17,new Address("哈理工2","13")));
        list3.add(new User("Joe2",18,new Address("哈理工2","14")));





        map.put("user3",list3);
        System.out.print(JSON.toJSONString(map,true));
    }
    @Test
    public void map2Json() {

        Map<String, User> map = new HashMap<String, User>();
        map.put("user1", new User("MIKE",10,new Address("哈理工","10")));
        map.put("user2", new User("ROSE",11,new Address("哈理工","11")));
        map.put("user3", new User("jack",12,new Address("哈理工","13")));
        System.out.print(JSON.toJSONString(map,true));


    }


}
