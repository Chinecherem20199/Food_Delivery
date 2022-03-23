package nigeriandailies.com.ng.fooddelivery.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Menu implements Parcelable {
    private String name;
    private Float price;
    private String url;

    protected Menu(Parcel in) {
        name = in.readString();
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readFloat();
        }
        url = in.readString();
    }

    public static final Creator<Menu> CREATOR = new Creator<Menu>() {
        @Override
        public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        if (price == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(price);
        }
        dest.writeString(url);
    }
}
