package uk.ac.tees.b1196119.vejicious.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import uk.ac.tees.b1196119.vejicious.R;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, RecyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        BottomNavigation();
    }

    private void BottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.home_Btn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartListActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<com.example.project.Domain.CategoryDomain> category = new ArrayList<>();
        category.add((new com.example.project.Domain.CategoryDomain("Pizza", "cat_1")));
        category.add((new com.example.project.Domain.CategoryDomain("Burger", "cat_2")));
        category.add((new com.example.project.Domain.CategoryDomain("Hotdog", "cat_3")));
        category.add((new com.example.project.Domain.CategoryDomain("Drink", "cat_4")));
        category.add((new com.example.project.Domain.CategoryDomain("Dount", "cat_5")));

        adapter = new CatregoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerViewPopularList = findViewById(R.id.recyclerView2);
        RecyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<com.example.project.Domain.FoodDomain> foodList = new ArrayList<>();
        foodList.add(new com.example.project.Domain.FoodDomain("Pepperoni pizza", "pop_1", "slices pepperoni,mozzarella cheese,fresh oregano,ground black pepper,pizza sauce", 9.76));
        foodList.add(new com.example.project.Domain.FoodDomain("Cheese Burger", "pop_2", "beef, Gouda cheese, Special Sauce,Lettuce,tomato", 8.79));
        foodList.add(new com.example.project.Domain.FoodDomain("Vegetable pizza", "pop_3", "olive oil,Vegetable oil,pitted kalamata,cherry tomatoes,fresh oregano,basil", 8.5));

        adapter2 = new PopluarAdaptor(foodList);
        RecyclerViewPopularList.setAdapter(adapter2);


    }
}