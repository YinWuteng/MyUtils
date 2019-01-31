package yinwuteng.com.myutils.mvvm;

/**
 * Create By ywt
 * 2019/1/31.
 */
public class Swordsman {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    private String name;
    private String level;
    public Swordsman(String name,String level){
        this.name=name;
        this.level=level;
    }
}
