package com.at.facebooktypeimagegrid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.at.facebooktypeimagegrid.model.ItemImage;
import com.at.facebooktypeimagegrid.model.ItemList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public String Image1 = "https://wellcome.ac.uk/sites/default/files/styles/news_lead/public/G3520217_SPL_LeanGenes_200606_600x600.jpg?itok=3G_cT3lu";
    public String Image2 = "http://rs1054.pbsrc.com/albums/s499/vadimzbanok/1327.jpg~c200";
    public String Image3 = "http://www.pnas.org/site/misc/images/15-02545.500.jpg";
    public String Image4 = "https://s-media-cache-ak0.pinimg.com/736x/7f/47/e4/7f47e4e3f9f3755fcd6012dfe6a7dc12.jpg";

    int currentOffset = 0;
    int mMaxDisplay_Size = 6;
    int mTotal_Size = 0;

    ArrayList<ItemImage> Pathitems = new ArrayList<>();
    private List<ItemList> mItemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ParentAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_view);
       /* Random r = new Random();
        mMaxDisplay_Size = r.nextInt(7 - 6) + 6;*/
        for(int k = 0; k < 10;k++) {
            prepareMovieData(k);
        }
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mTotal_Size = Pathitems.size();
        mAdapter = new ParentAdapter(this,mItemList,mMaxDisplay_Size,mTotal_Size);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
 

    }
 
    private void prepareMovieData(int k) {


        ArrayList<ItemImage> mPathitems = new ArrayList<>();
        boolean isCol2Avail = false;

        ItemImage i1 = new ItemImage(1,Image1,Image1);
        int colSpan1 = Math.random() < 0.2f ? 2 : 1;
        int rowSpan1 = colSpan1;
        if(colSpan1 == 2 && !isCol2Avail)
            isCol2Avail = true;
        else if(colSpan1 == 2 && isCol2Avail)
            colSpan1 = 1;

        i1.setColumnSpan(colSpan1);
        i1.setRowSpan(rowSpan1);
        i1.setPosition( currentOffset + 0);

        ItemImage i2 = new ItemImage(2,Image2,Image2);
        int colSpan2 = Math.random() < 0.2f ? 2 : 1;
        if(colSpan2 == 2 && !isCol2Avail)
            isCol2Avail = true;
        else if(colSpan2 == 2 && isCol2Avail)
            colSpan2 = 1;

        int rowSpan2 = colSpan2;
        i2.setColumnSpan(colSpan2);
        i2.setRowSpan(rowSpan2);
        i2.setPosition( currentOffset + 1);


        ItemImage i3 = new ItemImage(3,Image3,Image3);
        int colSpan3 = Math.random() < 0.2f ? 2 : 1;
        if(colSpan3 == 2 && !isCol2Avail)
            isCol2Avail = true;
        else if(colSpan3 == 2 && isCol2Avail)
            colSpan3 = 1;

        int rowSpan3 = colSpan3;
        i3.setColumnSpan(colSpan3);
        i3.setRowSpan(rowSpan3);
        i3.setPosition( currentOffset + 2);

        ItemImage i4 = new ItemImage(4,Image4,Image4);
        int colSpan4 = Math.random() < 0.2f ? 2 : 1;
        if(colSpan4 == 2 && !isCol2Avail)
            isCol2Avail = true;
        else if(colSpan4 == 2 && isCol2Avail)
            colSpan4 = 1;

        int rowSpan4 = colSpan4;
        i4.setColumnSpan(colSpan4);
        i4.setRowSpan(rowSpan4);
        i4.setPosition( currentOffset + 3);

        ItemImage i5 = new ItemImage(5,Image1,Image1);
        int colSpan5 = Math.random() < 0.2f ? 2 : 1;
        if(colSpan5 == 2 && !isCol2Avail)
            isCol2Avail = true;
        else if(colSpan5 == 2 && isCol2Avail)
            colSpan5 = 1;

        int rowSpan5 = colSpan5;
        i5.setColumnSpan(colSpan5);
        i5.setRowSpan(rowSpan5);
        i5.setPosition( currentOffset + 4);

        ItemImage i6 = new ItemImage(6,Image2,Image2);
        int colSpan6 = Math.random() < 0.2f ? 2 : 1;

        if(colSpan6 == 2 && !isCol2Avail)
            isCol2Avail = true;
        else if(colSpan6 == 2 && isCol2Avail)
            colSpan6 = 1;

        int rowSpan6 = colSpan6;
        i6.setColumnSpan(colSpan6);
        i6.setRowSpan(rowSpan6);
        i6.setPosition( currentOffset + 5);

        ItemImage i7 = new ItemImage(7,Image3,Image3);
        int colSpan7 = Math.random() < 0.2f ? 2 : 1;
        if(colSpan7 == 2 && !isCol2Avail)
            isCol2Avail = true;
        else if(colSpan7 == 2 && isCol2Avail)
            colSpan7 = 1;

        int rowSpan7 = colSpan7;
        i7.setColumnSpan(colSpan7);
        i7.setRowSpan(rowSpan7);
        i7.setPosition( currentOffset + 6);

        ItemImage i8 = new ItemImage(8,Image4,Image4);
        int colSpan8 = Math.random() < 0.2f ? 2 : 1;
        if(colSpan8 == 2 && !isCol2Avail)
            isCol2Avail = true;
        else if(colSpan8 == 2 && isCol2Avail)
            colSpan8 = 1;

        int rowSpan8 = colSpan8;
        i8.setColumnSpan(colSpan8);
        i8.setRowSpan(rowSpan8);
        i8.setPosition( currentOffset + 7);

        ItemImage i9 = new ItemImage(9,Image2,Image2);
        int colSpan9 = Math.random() < 0.2f ? 2 : 1;
        if(colSpan9 == 2 && !isCol2Avail)
            isCol2Avail = true;
        else if(colSpan9 == 2 && isCol2Avail)
            colSpan9 = 1;

        int rowSpan9 = colSpan9;
        i9.setColumnSpan(colSpan9);
        i9.setRowSpan(rowSpan9);
        i9.setPosition( currentOffset + 8);


        Pathitems.clear();

        Pathitems.add(i1);
        Pathitems.add(i2);
        Pathitems.add(i3);
        Pathitems.add(i4);
        Pathitems.add(i5);
        Pathitems.add(i6);
        Pathitems.add(i7);
        Pathitems.add(i8);
        Pathitems.add(i9);

        for(int i = 0; i < mMaxDisplay_Size;i++)
        {

            mPathitems.add(Pathitems.get(i));
        }

        ItemList itemList = new ItemList(k,"User "+(k+1),mPathitems);
        mItemList.add(itemList);
        currentOffset += mPathitems.size();

    }


}