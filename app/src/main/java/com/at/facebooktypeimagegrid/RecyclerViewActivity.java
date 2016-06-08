package com.at.facebooktypeimagegrid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.at.facebooktypeimagegrid.Assymetric.AGVRecyclerViewAdapter;
import com.at.facebooktypeimagegrid.Assymetric.AsymmetricItem;
import com.at.facebooktypeimagegrid.Assymetric.AsymmetricRecyclerView;
import com.at.facebooktypeimagegrid.Assymetric.AsymmetricRecyclerViewAdapter;
import com.at.facebooktypeimagegrid.Assymetric.Utils;
import com.at.facebooktypeimagegrid.model.ItemImage;
import com.at.facebooktypeimagegrid.model.ItemList;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RecyclerViewActivity extends AppCompatActivity {

  public String Image1 = "http://qamvc.alliancetek.com/textileduniya/UploadedFiles/ProductImages/Traders Mfgs Suppliers/635993256646471250___temp.jpg";
  public String Image2 = "http://qamvc.alliancetek.com/textileduniya/UploadedFiles/ProductImages/Traders Mfgs Suppliers/635993256658502500_AbuildPlus.png";
  public String Image3 = "http://qamvc.alliancetek.com/textileduniya/UploadedFiles/ProductImages/Traders Mfgs Suppliers/635993256658658750_logo-technigent.png";
  public String Image4 = "http://qamvc.alliancetek.com/textileduniya/UploadedFiles/ProductImages/Traders Mfgs Suppliers/635993256658815000_no-img.jpg";


  ArrayList<ItemList> mItems = new ArrayList<>();
  int currentOffset = 0;
  int mMaxDisplay_Size = 4;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recyclerview);

    AsymmetricRecyclerView recyclerView = (AsymmetricRecyclerView) findViewById(R.id.recyclerView);
    Random r = new Random();
    mMaxDisplay_Size = r.nextInt(7 - 6) + 6;
    setData();

    RecyclerViewAdapter adapter = new RecyclerViewAdapter(mItems);
    recyclerView.setRequestedColumnCount(3);
    recyclerView.setDebugging(true);
    recyclerView.setRequestedHorizontalSpacing(Utils.dpToPx(this, 3));
    recyclerView.addItemDecoration(
            new SpacesItemDecoration(getResources().getDimensionPixelSize(R.dimen.recycler_padding)));
    recyclerView.setAdapter(new AsymmetricRecyclerViewAdapter<>(this, recyclerView, adapter));

  }

  private void setData() {

    ArrayList<ItemImage> Pathitems = new ArrayList<>();
    boolean isCol2Avail = false;

    Pathitems.add(new ItemImage(1,Image1,Image1));
    Pathitems.add(new ItemImage(2,Image2,Image2));
    Pathitems.add(new ItemImage(3,Image3,Image3));
    Pathitems.add(new ItemImage(4,Image4,Image4));
    Pathitems.add(new ItemImage(5,Image1,Image1));
    Pathitems.add(new ItemImage(6,Image3,Image3));
    Pathitems.add(new ItemImage(7,Image2,Image2));
    Pathitems.add(new ItemImage(8,Image4,Image4));
    Pathitems.add(new ItemImage(9,Image4,Image4));
    Pathitems.add(new ItemImage(10,Image3,Image3));
    Pathitems.add(new ItemImage(11,Image2,Image2));
    Pathitems.add(new ItemImage(12,Image1,Image1));
    Pathitems.add(new ItemImage(13,Image1,Image1));
    Pathitems.add(new ItemImage(14,Image4,Image4));

    int mCount = 0;
    if(Pathitems.size() > mMaxDisplay_Size) {
      mCount = mMaxDisplay_Size;
    }
    else {
      mCount = Pathitems.size();
    }
    for(int k = 0; k < mCount;k++)
    {
      int colSpan = Math.random() < 0.2f ? 2 : 1;

      if(colSpan == 2 && !isCol2Avail)
      {
        isCol2Avail = true;
      }
      else if(colSpan == 2 && isCol2Avail)
      {
        colSpan = 1;
      }

      int rowSpan = colSpan;
      ItemList itemList = new ItemList(k,"Item #"+k,Pathitems);
      //itemList.setColumnSpan(colSpan);
      //itemList.setRowSpan(rowSpan);
      //itemList.setPosition( currentOffset + k);
      mItems.add(itemList);
    }
    currentOffset += Pathitems.size();
  }

  public int TotalItems(int pos) {
    return mItems.get(pos).getImages().size();
  }



  class RecyclerViewAdapter extends AGVRecyclerViewAdapter<ViewHolder> {
    private final List<ItemList> items;

    public RecyclerViewAdapter(List<ItemList> items) {
      this.items = items;

    }



    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      Log.d("RecyclerViewActivity", "onCreateView");
      return new ViewHolder(parent, viewType,items);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
      Log.d("RecyclerViewActivity", "onBindView position=" + position);
      holder.bind(items.get(0).getImages().get(position),position);
    }

    @Override public int getItemCount() {
      return items.size();
    }

    @Override public AsymmetricItem getItem(int position) {
      return (AsymmetricItem) items.get(position);
    }

    @Override public int getItemViewType(int position) {
      return position % 2 == 0 ? 1 : 0;
    }
  }


  class ViewHolder extends RecyclerView.ViewHolder {
    private final ImageView mImageView;
    private final TextView textView;

    public ViewHolder(ViewGroup parent, int viewType, List<ItemList> items) {
      super(LayoutInflater.from(parent.getContext()).inflate(
              R.layout.adapter_item, parent, false));

      mImageView = (ImageView) itemView.findViewById(R.id.mImageView);
      textView = (TextView) itemView.findViewById(R.id.tvCount);



    }


    public void bind(ItemImage item, int position) {
      ImageLoader.getInstance().displayImage(String.valueOf(item.getImagePath()), mImageView);
      textView.setText("+"+(TotalItems(position)-mMaxDisplay_Size));
      if(TotalItems(position) > mMaxDisplay_Size)
      {
        if(position  == mMaxDisplay_Size-1) {
          textView.setVisibility(View.VISIBLE);
          mImageView.setAlpha(72);
        }
        else {
          textView.setVisibility(View.INVISIBLE);
          mImageView.setAlpha(255);
        }
      }
      else
      {
        mImageView.setAlpha(255);
        textView.setVisibility(View.INVISIBLE);
      }

      // textView.setText(String.valueOf(item.getPosition()));
    }
  }
}
