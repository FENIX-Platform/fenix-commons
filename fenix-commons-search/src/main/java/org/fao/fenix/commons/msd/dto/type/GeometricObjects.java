package org.fao.fenix.commons.msd.dto.type;

import java.util.HashMap;
import java.util.Map;

public enum GeometricObjects {
    curve (new String[]{"EN", "Curve"}),
    point (new String[]{"EN", "Point"}),
    solid (new String[]{"EN", "Solid"}),
    surface (new String[]{"EN", "Surface"})

    ;private Map<String,String> label = new HashMap<>();
    private GeometricObjects(String[]... labels) { //EN,FR,ES,PT
        for (String[] l : labels)
            label.put(l[0],l[1]);
    }

    public Map<String,String> getLabel()  {
        return label;
    }

    public String getLabel(String language) {
        return label.get(language);
    }


}
