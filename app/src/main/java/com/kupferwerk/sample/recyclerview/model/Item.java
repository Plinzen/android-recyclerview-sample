package com.kupferwerk.sample.recyclerview.model;

import java.util.LinkedList;
import java.util.List;

public class Item {

   private String title;
   private String subTitle;

   public static List<Item> buildDemoModel(int count) {
      List<Item> items = new LinkedList<Item>();
      for (int i = 0; i < count; i++) {
         String title = "Title of Item " + i;
         String subtitle = "subTitle of Item " + i;
         items.add(new Item().setTitle(title).setSubTitle(subtitle));
      }
      return items;
   }

   public String getSubTitle() {
      return subTitle;
   }

   public Item setSubTitle(String subTitle) {
      this.subTitle = subTitle;
      return this;
   }

   public String getTitle() {
      return title;
   }

   public Item setTitle(String title) {
      this.title = title;
      return this;
   }
}
