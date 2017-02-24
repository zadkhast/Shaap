package com.android.shaap.GetersAndSeters.Hossein;


/**
 * Created by Hossein on 18/02/2017.
 */
public class NearShoppersItems {
    String name, address;
    float stars;
    int imageOfShopper;
    double lat,lng;

   // String name, String address, float stars, Bitmap imageOfShopper
    public NearShoppersItems(String name, String address, float stars ,int imageOfShopper,  double lat,double lng) {
        this.name = name;
        this.lng = lng;
        this.lat = lat;
        this.imageOfShopper = imageOfShopper;
        this.stars = stars;
        this.address = address;
    }

    public NearShoppersItems() {
    }

    public int getImageOfShopper() {
        return imageOfShopper;
    }

    public void setImageOfShopper(int imageOfShopper) {
        this.imageOfShopper = imageOfShopper;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
