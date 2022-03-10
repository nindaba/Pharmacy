package pl.edu.vistula.controllers;

public interface ControllerConstants{
    String PREFIX="api/v1";
    interface Category{
        String Controller =PREFIX+"/category";
        String CategoryId="category-id";
        String SubCategory ="/sub-category";
    }
    interface SubCategory{
        String Controller=PREFIX+Category.SubCategory;
        String SubCategoryId ="sub-category-id";
        String SubCategoryName="sub-category-name";
    }
    interface Medicine{
        String Controller=PREFIX+"/medicine";
        String MedicineId="medicine-id";
        String Expired="/expired";
    }
    interface Manufacturer{
        String Controller="manufacturer";
        String ManufacturerId="manufacturer-id";
    }
    interface Client{
        String Controller="client";
        String ClientId="client";
    }
    interface Checkout{
        String Controller=PREFIX+"/checkout";
        String Purchase="/purchase";
    }
    interface Order{
        String Controller="order";
        String TrackOrder="/track/{tracker}";
    }
}
