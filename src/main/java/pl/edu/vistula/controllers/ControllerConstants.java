package pl.edu.vistula.controllers;

public interface ControllerConstants{
    String PREFIX="pharmacy/v1";
    interface Category{
        String Controller =PREFIX+"/category";
        String CategoryId="category-id";
    }
    interface SubCategory{
        String Controller=PREFIX+"/sub-category";
        String SubCategoryId ="sub-category-id";
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
    }
}
