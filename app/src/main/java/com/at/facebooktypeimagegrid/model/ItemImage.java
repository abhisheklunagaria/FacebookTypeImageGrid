package com.at.facebooktypeimagegrid.model;

import android.os.Parcel;

public class ItemImage extends ItemPosition {

	private int ItemImageId;
	private String ImagePath;
	private String Thumb;

	
	public ItemImage(int itemImageId, String imagePath, String thumb) {
		super();
		ItemImageId = itemImageId;
		ImagePath = imagePath;
		Thumb = thumb;

	}

	protected ItemImage(Parcel in) {
		ItemImageId = in.readInt();
		ImagePath = in.readString();
		Thumb = in.readString();

	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(ItemImageId);
		dest.writeString(ImagePath);
		dest.writeString(Thumb);

	}

	@Override
	public String toString() {
		return "ItemImage{" +
				"ItemImageId=" + ItemImageId +
				", ImagePath='" + ImagePath + '\'' +
				", Thumb='" + Thumb + '\'' +
				'}';
	}

	public String getThumb() {
		return Thumb;
	}

	public void setThumb(String thumb) {
		Thumb = thumb;
	}

	public int getItemImageId() {
		return ItemImageId;
	}

	public void setItemImageId(int itemImageId) {
		ItemImageId = itemImageId;
	}

	public String getImagePath() {
		return ImagePath;
	}

	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}



	public static final Creator<ItemImage> CREATOR = new Creator<ItemImage>() {
		@Override
		public ItemImage createFromParcel(Parcel in) {
			return new ItemImage(in);
		}

		@Override
		public ItemImage[] newArray(int size) {
			return new ItemImage[size];
		}
	};

}
