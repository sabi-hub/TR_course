package data;


public abstract class Section {
    private String namesection;
    private String trainer;
    private int basicprice;

    public Section (String namesection, String trainer, int basicprice){
        this.namesection=namesection;
        this.trainer=trainer;
        this.basicprice=basicprice;
    }

    public String getNamesection() {
        return namesection;
    }

    public String getTrainer() {
        return trainer;
    }
}

