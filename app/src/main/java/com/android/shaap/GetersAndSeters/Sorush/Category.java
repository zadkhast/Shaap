package com.android.shaap.GetersAndSeters.Sorush;

// created by sorush
public class Category {

    private String cat;
    private int image, my_percent, myFriend_percent, all_percent;

    public Category() {
    }

    public Category(String cat, int image, int my_percent, int myFriend_percent, int all_percent) {
        this.cat = cat;
        this.image = image;
        this.my_percent = my_percent;
        this.myFriend_percent = myFriend_percent;
        this.all_percent = all_percent;
    }

    public String getCat() {
        return cat;
    }

    public int getImage() {
        return image;
    }

    public int getMy_percent() {
        return my_percent;
    }

    public int getMyFriend_percent() {
        return myFriend_percent;
    }

    public int getAll_percent() {
        return all_percent;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setMy_percent(int my_percent) {
        this.my_percent = my_percent;
    }

    public void setMyFriend_percent(int myFriend_percent) {
        this.myFriend_percent = myFriend_percent;
    }

    public void setAll_percent(int all_percent) {
        this.all_percent = all_percent;
    }
}