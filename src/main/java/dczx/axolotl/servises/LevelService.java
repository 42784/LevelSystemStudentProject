package dczx.axolotl.servises;

import dczx.axolotl.entity.MyLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class LevelService {
    private static final HashMap<Integer, MyLevel> hashMap = new HashMap<>();

    public static void addLevel(MyLevel level) {
        hashMap.put(level.getLevelId(), level);
    }

    public static MyLevel getLevel(int levelId) {
        return hashMap.get(levelId);
    }

    public static ArrayList<MyLevel> getAllLevels() {
        return new ArrayList<>(hashMap.values());
    }

    public static void removeLevel(int levelId) {
        hashMap.remove(levelId);
    }



}
