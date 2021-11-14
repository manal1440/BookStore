package com.example.bookapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapp.DataClass.DataClass_CategoryList
import com.example.bookapp.Database.BookDao
import com.example.bookapp.Database.BookDatabase
import com.example.bookapp.Database.entities.Category
import com.example.bookapp.adapters.Category_list
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Book_List : AppCompatActivity() {

    private lateinit var recyclerviewCategory: RecyclerView
    lateinit var list_category: ArrayList<DataClass_CategoryList>
     var listid : List<Category> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        // category list
        val dao: BookDao = BookDatabase.getInstance(this).bookDao
       /* listid= arrayOf("Science","History","Business","Biography",
        "Travel","Art")*/


            recyclerviewCategory=findViewById(R.id.category)
        recyclerviewCategory.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        recyclerviewCategory.setHasFixedSize(true)

        list_category= arrayListOf<DataClass_CategoryList>()


        GlobalScope.launch{
            listid = dao.getCategory()
        }
        Log.d("list", listid.toString())
        recyclerviewCategory.adapter= Category_list(listid)
    }

   /* private fun getlist() {
        for(i in listid.indices){
            val cat= DataClass_CategoryList(listid[i])
            list_category.add(cat)
        }*/

}