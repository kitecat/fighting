package ru.vav.fighting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaterialManager {
    private static MaterialManager inst = new MaterialManager();

    private ArrayList<Material> materials = new ArrayList<Material>();
    private Map<String, Integer> keys = new HashMap<String, Integer>();

    public MaterialManager() {
    }

    public Integer addMaterial(String materialName, Material material) {
        if (keys.containsKey(materialName))
            return 0;
        else {
            int index = materials.size();
            keys.put(materialName, index);
            materials.add(material);
            return index;
        }
    }
    public Integer addStaticMaterialByName(String materialName, String textureName) {
        return addMaterial(materialName, new StaticMaterial(textureName));
    }
    public Integer addStaticMaterialByID(String materialName, int textureID) {
        return addMaterial(materialName, new StaticMaterial(textureID));
    }
    public Integer addAnimatedMaterialByNames(String materialName, ArrayList<String> texturesNames, Timeline timeline, Boolean repeat) {
        return addMaterial(materialName, AnimatedMaterial.FromStringArray(texturesNames, timeline, repeat));
    }
    public Integer addAnimatedMaterialByIDs(String materialName, ArrayList<Integer> texturesIDs, Timeline timeline, Boolean repeat) {
        return addMaterial(materialName, AnimatedMaterial.FromIDsArray(texturesIDs, timeline, repeat));
    }

    public Material getMaterial(Integer ID) {
        if ((ID >= materials.size()) || (ID < 0))
            return new StaticMaterial();
        return materials.get(ID);
    }
    public Material getMaterial(String name) {
        return getMaterial(getID(name));
    }
    public Integer getID(String name) {
        if (keys.containsKey(name))
            return keys.get(name);
        else
            return 0;
    }

    public static MaterialManager getInst() {
        return inst;
    }
}
