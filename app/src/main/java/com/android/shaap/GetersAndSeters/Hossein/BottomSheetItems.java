package com.android.shaap.GetersAndSeters.Hossein;

// created by hossein

public class BottomSheetItems {
    int image;
    String name;

    public BottomSheetItems(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public BottomSheetItems() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
