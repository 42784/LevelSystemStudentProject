package dczx.axolotl.entity;

import dczx.axolotl.servises.LevelService;
import lombok.Data;

@Data
public class MyLevel {
    private int levelId;
    private String tile;
    private String note;
    private boolean isPassed;

    /**
     * 判断关卡是否被锁定
     *
     * @return 状态
     */
    public boolean isLocked() {
        int requiredLevelId = levelId - 1;
        MyLevel requiredLevel = LevelService.getLevel(requiredLevelId);
        if (requiredLevel == null) {//没有前一关(如第一关，或者跳关的)
            return false;
        }
        return !requiredLevel.isPassed;//前一关没过 锁定
    }

}

