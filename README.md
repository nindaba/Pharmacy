[//]: # (There are many variations of passages of Lorem Ipsum available,
but the majority have suffered alteration in some form, by 
injected humour, or randomised words which don't look even 
slightly believable. If you are going to use a passage of 
Lorem Ipsum, you need to be sure there isn't anything embarrassing 
hidden in the middle of text. All the Lorem Ipsum generators on the 
Internet tend to repeat predefined chunks as necessary, 
making this the first true generator on the Internet. It uses 
a dictionary of over 200 Latin words, combined with a handful of 
model sentence structures, to generate Lorem Ipsum which looks reasonable. 
The generated Lorem Ipsum 
is therefore always free from repetition, injected humour, or non-characteristic words etc)
# PHARMACY.pl


This is a simple REST api with main features of CRUD operations and interaction with database mysql. the base URL http://pharmacy.pl:9000/api/v1/ of cause if your host is not http://pharmacy.pl you are free to use http://localhost 
This pharmacy Rest focuses on of medications. where medicine will be categorised into categories

<br>
<br>

### Medication Category Hierarchy

Category → Subcategory → Medicine

Allergy
<ul>
    <li>Eyes
        <ul>
            <li>DOZ PRODUCT Oviso, eye drops, soothing irritation</li>
            <li>Starazolin, (0.5 mg / ml), eye drops, 2 x 5 ml</li>
        </ul>
    </li>
</ul>
Pain 
<ul>
    <li>Headeche
        <ul>
            <li>Paracetamol DOZ, 500 mg, tablets, 20 pcs.</li>
            <li>Apap, 500 mg, film-coated tablets, 50 pcs.</li>
        </ul>
    </li>
    <li>Pain in muscles and joints
        <ul>
            <li>DOZ PRODUCT, warming patch, analgesic, 1 pc.</li>
            <li>Voltaren Max, 23.2 mg / g, gel, 180 g</li>
        </ul>
    </li>
</ul>

<br>
<br>

### It will Contain Models and Data Object such as:
* Category Model and Data
* SubCategory Model and Data
* Medicine Model and MedicineDetails

  <br>
  <br>

### We will also have the following end points:
* http://pharmacy.pl:9000/api/v1/category/ For Categories with following methods
  * GET & GET /id
  * POST & PUT 
    ```   
    {
        "name": "Pain",
        "image": "https://azcdn.doz.pl/image/d/product/ed7deb3c-scale-180x180.webp",
        "description": "tionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem"
    }
  * DELETE /ids where no id will delete everything

    
* http://pharmacy.pl:9000/api/v1/subcategory/  For Categories with following methods
  * GET & GET /id
  * POST & PUT 
    ```   
    {
        "name": "Pain in muscles and joints",
        "image": "https://azcdn.doz.pl/image/d/product/12a14d57-scale-180x180.webp",
        "description": "Internet tend to repeat predefined chunks as necessary,making this the first true generator o"
    }
  * DELETE /ids where no id will delete everything

<br>
<br>

* http://pharmacy.pl:9000/api/v1/medicine/  For Categories with following methods
    * GET & GET /id & GET /expired
    * POST & PUT
    ```
    {
          "name": "DOZ PRODUCT, warming patch, analgesic, 1 pc.",
          "description":"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et",
          "size":100,
          "count":300,
          "weight":200,
          "price":300,
          "image":"https://azcdn.doz.pl/image/d/product/847a9dc2-scale-180x180.webp",
          "barcode":"68798298548",
          "subCategory":"pain",
          "manufacturer":"Lorem ipsum dolor sit amet,",
          "created":"2022-03-05",
          "expires":"2022-03-12"
    }
    ```
    * DELETE /ids where no id will delete everything
  





