package uk.ac.tees.b1196119.vejicious.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import uk.ac.tees.b1196119.vejicious.Adaptor.IngredientsAdapter;
import uk.ac.tees.b1196119.vejicious.Helper.RequestManager;
import uk.ac.tees.b1196119.vejicious.Adaptor.SimilarRecipeAdapter;
import uk.ac.tees.b1196119.vejicious.Interface.RecipeClickListner;
import uk.ac.tees.b1196119.vejicious.Models.RecipeDetailsResponse;
import uk.ac.tees.b1196119.vejicious.Models.SimilarRecipeResponse;
import uk.ac.tees.b1196119.vejicious.Interface.RecipeDetailsListener;
import uk.ac.tees.b1196119.vejicious.Interface.SimilarRecipesListener;
import uk.ac.tees.b1196119.vejicious.R;

import java.util.List;

public class RecipeDetailsActivity extends AppCompatActivity {
    int id;
    TextView textview_meal_name,textview_meal_source,textview_meal_summery;
    ImageView Imageview_meal_image;
    RecyclerView recycler_meal_ingredients,recycler_meal_similar;
    RequestManager manager;
    ProgressDialog dialog;
    IngredientsAdapter ingredientsAdapter;
    SimilarRecipeAdapter similarRecipeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        findViews();

        id =Integer.parseInt(getIntent().getStringExtra("id")) ;
        manager = new RequestManager(this);
        manager.getRecipeDetails(recipeDetailsListener,id);
        manager.getSimilarRecipes(similarRecipesListener,id);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading Details....");
        dialog.show();

    }

    private void BottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout supportBtn = findViewById(R.id.Support_Btn);
        LinearLayout homeBtn = findViewById(R.id.home_Btn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipeDetailsActivity.this, MainActivity.class));
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipeDetailsActivity.this, CartListActivity.class));
            }
        });

        supportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipeDetailsActivity.this, RecipeMainActivity.class));
            }
        });
    }

    private void findViews() {
        textview_meal_name = findViewById(R.id.textview_meal_name);
        textview_meal_source = findViewById(R.id.textview_meal_source);
        textview_meal_summery = findViewById(R.id.textview_meal_summery);
        Imageview_meal_image = findViewById(R.id.Imageview_meal_image);
        recycler_meal_ingredients = findViewById(R.id. recycler_meal_ingredients);
        recycler_meal_similar = findViewById(R.id.recycler_meal_similar);
    }

    private final RecipeDetailsListener recipeDetailsListener = new RecipeDetailsListener() {
        @Override
        public void didFetch(RecipeDetailsResponse response, String message) {
            dialog.dismiss();
            textview_meal_name.setText(response.title);
            textview_meal_source.setText(response.sourceName);
            textview_meal_summery.setText(response.summary);
            Picasso.get().load(response.image).into( Imageview_meal_image);

            recycler_meal_ingredients.setHasFixedSize(true);
            recycler_meal_ingredients.setLayoutManager(new LinearLayoutManager(RecipeDetailsActivity.this,LinearLayoutManager.HORIZONTAL,false));
            ingredientsAdapter = new IngredientsAdapter(RecipeDetailsActivity.this,response.extendedIngredients);
            recycler_meal_ingredients.setAdapter(ingredientsAdapter);
        }

        @Override
        public void didError(String message) {
            Toast.makeText(RecipeDetailsActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private final SimilarRecipesListener similarRecipesListener = new SimilarRecipesListener() {
        @Override
        public void didFetch(List<SimilarRecipeResponse> responses, String message) {
            recycler_meal_similar.setHasFixedSize(true);
            recycler_meal_similar.setLayoutManager(new LinearLayoutManager(RecipeDetailsActivity.this,LinearLayoutManager.HORIZONTAL,false));
            similarRecipeAdapter =new SimilarRecipeAdapter(RecipeDetailsActivity.this,responses,recipeClickListner);
            recycler_meal_similar.setAdapter( similarRecipeAdapter);
        }

        @Override
        public void didError(String message) {
            Toast.makeText(RecipeDetailsActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private final RecipeClickListner recipeClickListner = new RecipeClickListner() {
        @Override
        public void onRecipeClicked(String id) {
            startActivity(new Intent(RecipeDetailsActivity.this,RecipeDetailsActivity.class)
                    .putExtra("id",id));

        }
    };
}