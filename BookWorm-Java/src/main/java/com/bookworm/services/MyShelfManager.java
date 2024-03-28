package com.bookworm.services;

import java.util.List;
import java.util.Optional;

import com.bookworm.entities.MyShelf;

public interface MyShelfManager {

	public List<MyShelf> findallby();

    public List<MyShelf> getByCustomerId(long id);
    
   public MyShelf addToShelf(MyShelf shelf);
   public List<MyShelf> geTransType(String tranType);

   public List<MyShelf> deleteProduct(long id);

}
