package se.apa;

import java.util.HashMap;
import java.util.Map;

public class MuppData {
    private Map<String, Object> data = new HashMap<>();

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public void add(String key, Object value) {
        this.data.put(key, value);
    }

}

