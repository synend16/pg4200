package ex05;

import org.junit.Test;
import org.pg4200.datastructure.map.MyMap;
import org.pg4200.datastructure.map.MyMapTestTemplate;

import static org.junit.Assert.*;

public class TernaryTreeMapTest extends MyMapTestTemplate {


    @Override
    protected <K extends Comparable<K>, V> MyMap<K, V> getInstance() {
        return new TernaryTreeMap<>();
    }
}