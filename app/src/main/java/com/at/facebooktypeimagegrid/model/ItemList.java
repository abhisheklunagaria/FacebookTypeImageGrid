package com.at.facebooktypeimagegrid.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ItemList implements Parcelable {



	private int ItemID;
	private String ItemName;
	private ArrayList<ItemImage> Images;





	public ItemList(int itemID, String itemName,
					ArrayList<ItemImage> itemImages) {
		super();
		ItemID = itemID;
		ItemName = itemName;
		Images = itemImages;


	}


	public int getProductID() {
		return ItemID;
	}

	public void setProductID(int productID) {
		ItemID = productID;
	}


	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}


	public ArrayList<ItemImage> getImages() {
		return Images;
	}

	public void setImages(ArrayList<ItemImage> images) {
		Images = images;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected ItemList(Parcel in) {
		ItemID = in.readInt();
		ItemName = in.readString();
		Images = (ArrayList) in.readValue(ArrayList.class.getClassLoader());

	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(ItemID);
		dest.writeString(ItemName);
		dest.writeValue(Images);

	}

	public static final Creator<ItemList> CREATOR = new Creator<ItemList>() {
		@Override
		public ItemList createFromParcel(Parcel in) {
			return new ItemList(in);
		}

		@Override
		public ItemList[] newArray(int size) {
			return new ItemList[size];
		}
	};

	@Override
	public String toString() {
		return "ItemList{" +
				"IID=" + ItemID +
				", ItemName='" + ItemName + '\'' +
				", Images=" + Images +
				'}';
	}
}