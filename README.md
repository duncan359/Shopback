# Assignment
This Assignment was using MVP Structure and implements by Rxjava, Retrofit and Dagger.
* Loading Picture library - fresco
* UI Injection library - butterknife
* Json parsing library - logansquare

## Environment
* Android Studio 3.0.1
* Support SDK 19 to 26

### Design Structure 
* Provide 2 different list view UI for better user experience.
  * Non-Paginated listview
  * Paginated listview
* Non-Paginated listview
  * Allow user to scroll down to load more data and limit is 100 items.
  * Allow user to swipe refresh data.
![alt text](non_pagar.jpg)
* Paginated listview
  * Allow user to click page to view info and page size is 20.
  * Allow user to swipe refresh data.
![alt text](pagar.jpg)


