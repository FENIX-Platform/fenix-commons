package org.fao.fenix.commons.msd.dto.type;

import java.util.HashMap;
import java.util.Map;

public enum CodeListType {
    list (new String[]{"EN", "List"}),
    tree (new String[]{"EN", "Tree"}),
    balancedTree (new String[]{"EN", "Balanced tree"}),
    orientedGraph (new String[]{"EN", "Oriented graph"});

    private Map<String,String> label = new HashMap<>();
    private CodeListType(String[] ... labels) { //EN,FR,ES,PT
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
