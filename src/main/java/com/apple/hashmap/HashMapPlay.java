package com.apple.hashmap;

import com.apple.common.Person;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapPlay {
    @Test
    public void play01() {
        Map<String, Integer> map = new HashMap<>();
        map.put("lss", 18);
        map.put("ly", 16);
        map.put("lxy", 17);
        map.put("lxy", null);
        System.out.println(map);//{lxy=null, lss=18, ly=16}
    }
    /**
     * 不能直接修改key，只能删掉后重新增加
     * 知识点：remove后会返回被删除的值
     */
    @Test
    public void play02() {
        Map<String, Integer> map = new HashMap<>();
        map.put("lss", 18);
        map.put("ly", 16);
        map.put("lxy", 17);
        map.put("qxy", map.remove("lxy"));
        System.out.println(map);//{qxy=17, lss=18, ly=16}
    }
    /**
     * 注意：如果把Person类的equals()和hashcode()去掉，会出现相同的key
     */
    @Test
    public void play03() {
        Map<Person, String> map = new HashMap<>();
        map.put(new Person("ly", 16), "Apple");
        map.put(new Person("ly", 16), "Google");
        System.out.println(map);
    }
    /**
     * 错误的用法：修改key，坚决不允许
     * 如果你注释掉Person类的equals()和hashcode()，还能get到值。一旦加了equals()和hashcode()，就再也拿不回值了！！！
     */
    @Test
    public void play04() {
        Map<Person, String> map = new HashMap<>();
        Person p = new Person("ly", 16);
        map.put(p, "Apple");
        p.setName("lxy");
        System.out.println(map);
        System.out.println(map.get(p));
    }
    @Test
    public void play05() {
        Map<String, Integer> map = new HashMap<>();
        map.put("lss", 18);
        map.put("ly", 16);
        map.put("lxy", 17);
        Collection<Integer> values = map.values();
        for (Integer value : values) {
            System.out.println(value);
        }

        Set<String> strings = map.keySet();
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
