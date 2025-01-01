/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/31 下午11:30
 */
public class Year {
    private String everyThing;
    private boolean succeed;
    private  int year;

    public Year(int year) {
        this.year = year;
    }

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }



    public void setEveryThing(String everyThing) {
        this.everyThing = everyThing;
    }

    public String getEveryThing() {
        return this.everyThing;
    }


}
