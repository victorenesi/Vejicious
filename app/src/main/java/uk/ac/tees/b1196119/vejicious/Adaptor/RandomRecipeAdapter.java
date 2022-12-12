package uk.ac.tees.b1196119.vejicious.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import uk.ac.tees.b1196119.vejicious.Interface.RecipeClickListner;
import uk.ac.tees.b1196119.vejicious.Models.Recipe;
import uk.ac.tees.b1196119.vejicious.R;

import java.util.List;

public class RandomRecipeAdapter extends RecyclerView.Adapter<RandomRecipeViewHolder>{
Context context;
List<Recipe>list;
RecipeClickListner listner;


    public RandomRecipeAdapter(Context context, List<Recipe> list, RecipeClickListner listner) {
        this.context = context;
        this.list = list;
        this.listner = listner;
    }

    public RandomRecipeAdapter(Context context, List<Recipe> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RandomRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RandomRecipeViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.list_random_recipe,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RandomRecipeViewHolder holder, int position) {
        holder.textview_title.setText(list.get(position).getTitle());
        holder.textview_title.setSelected(true);
        holder.textView_likes.setText(list.get(position).getAggregateLikes()+"Likes");
        holder.textView_servings.setText(list.get(position).getServings()+"Servings");
        holder.textView_time.setText(list.get(position).getCookingMinutes()+"Minutes");
        Picasso.get().load(list.get(position).getImage()).into(holder.imageView_food);

        holder.random_list_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.onRecipeClicked(String.valueOf(list.get(holder.getAdapterPosition()).getId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class RandomRecipeViewHolder extends RecyclerView.ViewHolder{

        CardView random_list_container;
        TextView textview_title,textView_servings,textView_likes,textView_time;
        ImageView imageView_food;
    public RandomRecipeViewHolder(@NonNull View itemView) {
        super(itemView);
        random_list_container = itemView.findViewById(R.id.random_list_container);
        textview_title = itemView.findViewById(R.id.textview_title);
        textView_servings = itemView.findViewById(R.id.textView_servings);
        textView_likes = itemView.findViewById(R.id.textView_likes);
        textView_time = itemView.findViewById(R.id.textView_time);
        imageView_food = itemView.findViewById(R.id.imageView_food);

    }
}
