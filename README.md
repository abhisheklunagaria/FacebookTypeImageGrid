# FacebookTypeImageGrid

**FacebookTypeImageGrid** is for displaying multiple image like facebook using  [AsymmetricGridView](https://github.com/felipecsl/AsymmetricGridView) Library for support items with colspan and rowspan

[AsymmetricGridView](https://github.com/felipecsl/AsymmetricGridView) is a custom view that implements multiple columns and variable size elements

  Radomized ColSpan and RowSpan for making Grid
 
   <p align="center">
    <img src="https://github.com/abhisheklunagaria/FacebookTypeImageGrid/blob/master/1.png" width="350"/>
    <img src="https://github.com/abhisheklunagaria/FacebookTypeImageGrid/blob/master/2.png" width="350"/>
  </p>

There are common logic for manage colspan and rowspan

        ItemImage i = new ItemImage(4,Image4,Image4);
        int colSpan = Math.random() < 0.2f ? 2 : 1;
        int rowSpan = colSpan;
        i.setColumnSpan(colSpan);
        i.setRowSpan(rowSpan);
        i.setPosition( currentOffset + 3);
